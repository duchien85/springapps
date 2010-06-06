/**
 * Copyright (c) 2008-2010 The Open Source Geospatial Foundation
 *
 * Published under the BSD license.
 * See http://svn.geoext.org/core/trunk/geoext/license.txt for the full text
 * of the license.
 */

/** api: example[toolbar]
 *  Toolbar with Actions
 *  --------------------
 *  Create a toolbar with GeoExt Actions.
 */

var jsonStore;
var grid;
var geoSearchMap = null;

Ext.onReady(function () {
    Ext.get('show_map').on("click", function () {
        if (!geoSearchMap) {
            console.log("Creating new GeoSearchMap Object");
            geoSearchMap = new GeoSearchMap("The Title");
        }
        geoSearchMap.clearAoi();
        geoSearchMap.win.show();

    });

    jsonStore = new Ext.data.JsonStore({
        // load using HTTP
        autoDestroy: true,
        proxy : new Ext.data.HttpProxy({
            method: 'GET',
            url: '/app/geosearch/wkt.json',
            headers: { 'Accept' : 'application/json' }
        }),
        storeId: 'guidStore',
        root: 'rows',
        idProperty: 'batGuid',
        totalProperty: 'results',
        messageProperty: 'msg',
        successProperty: 'success',
        fields: ['batGuid']
    });


    grid = new Ext.grid.GridPanel({
        store: jsonStore,
        columns: [
                  {header: "Id", width: 300, dataIndex: 'batGuid', sortable: true}
                 ],
        renderTo:'gridpanel',
        width:300,
        height:300
    });


});


function sendSearch(geometry){
    Ext.Msg.alert('Status', geometry.toString());
    jsonStore.load({
        params: {shape: geometry.toString()}
    });
}



function GeoSearchMap(title, width, height) {
    Ext.QuickTips.init();
    var that = this;
    this.title = title;
    this.width = width;
    this.height = height;
    if (isNaN(width)) {
        this.width = 500;
    }
    if (isNaN(height)) {
        this.height = 300;
    }
    this.map = new OpenLayers.Map();
    this.baseLayer = new OpenLayers.Layer.WMS("rf-vm-img", "http://192.168.23.195:8080/geoserver/ows", {
        layers: 'bluemarble-large'
    });
    this.drawLayer = new OpenLayers.Layer.Vector("vector");
    this.map.addLayers([this.baseLayer, this.drawLayer]);
    this.currentGeometry = null;

    this.clearAoi = function(){
        this.drawLayer.destroyFeatures();
        Ext.getCmp('geoSearchMap_submitBtn').disable();
    };

    this.aoiRemoved = function(feature){
        if(this.drawLayer.features.length == 0){
            Ext.getCmp('geoSearchMap_submitBtn').disable();
        }
    }

    this.aoiAdded = function(feature){
        Ext.getCmp('geoSearchMap_submitBtn').enable();
    }

    var action;
    this.actions = {};
    this.toolbarItems = [];
    // ZoomToMaxExtent control, a "button" control
    action = new GeoExt.Action({
        control: new OpenLayers.Control.ZoomToMaxExtent(),
        map: this.map,
        text: "max extent",
        tooltip: "zoom to max extent"
    });
    this.actions["max_extent"] = action;
    this.toolbarItems.push(action);
    this.toolbarItems.push("-");

    // Navigation control and DrawFeature controls
    // in the same toggle group
    action = new GeoExt.Action({
        text: "nav",
        control: new OpenLayers.Control.Navigation(),
        map: this.map,
        // button options
        toggleGroup: "draw",
        allowDepress: false,
        pressed: true,
        tooltip: "navigate",
        // check item options
        group: "draw",
        checked: true
    });
    this.actions["nav"] = action;
    this.toolbarItems.push(action);

    action = new GeoExt.Action({
        text: "draw poly",
        control: new OpenLayers.Control.DrawFeature(
        this.drawLayer, OpenLayers.Handler.Polygon),
        map: this.map,
        // button options
        toggleGroup: "draw",
        allowDepress: false,
        tooltip: "draw polygon",
        // check item options
        group: "draw"
    });
    action.control.featureAdded =  this.aoiAdded;
    action.control.featureRemoved = this.aoiRemoved;
    this.actions["draw_poly"] = action;
    this.toolbarItems.push(action);

    action = new GeoExt.Action({
        text: "clear aoi",
        control: new OpenLayers.Control.Button({
            trigger: function(){that.clearAoi();}
        }),
        map: this.map,
        // button options
        allowDepress: false,
        tooltip: "clear all AOIs"
        // check item options
    });
    this.actions["clear_aoi"] = action;
    this.toolbarItems.push(action);


    // SelectFeature control, a "toggle" control
    action = new GeoExt.Action({
        text: "select",
        control: new OpenLayers.Control.SelectFeature(that.drawLayer, {
            type: OpenLayers.Control.TYPE_TOGGLE,
            hover: true
        }),
        map: that.map,
        // button options
        enableToggle: true,
        tooltip: "select feature"
    });
    this.actions["select"] = action;
    this.toolbarItems.push(action);
    this.toolbarItems.push("-");

    this.mapPanel = new GeoExt.MapPanel({
        map: this.map,
        center: new OpenLayers.LonLat(0, 0),
        zoom: 1,
        tbar: this.toolbarItems
    });

    // create the window on the first click and reuse on subsequent clicks
    this.win = new Ext.Window({
        applyTo:'mappanel',
        modal: true,
        layout: 'fit',
        width: this.width,
        height: this.height,
        closable: false,
        plain: true,
        items: [this.mapPanel],
        buttons: [{
            text: 'Submit',
            id: 'geoSearchMap_submitBtn',
            disabled: true,
            handler: function () {
                var polygons = [];
                Ext.each(that.drawLayer.features, function(item, index){
                    polygons[index] = item.geometry;
                });
                that.currentGeometry = new OpenLayers.Geometry.MultiPolygon(polygons);
                sendSearch(that.currentGeometry);
                that.win.hide();
            }
        },
        {
            text: 'Cancel',
            handler: function () {
                that.clearAoi();
                that.win.hide();
            }
        }]
    });

    return true;
}
