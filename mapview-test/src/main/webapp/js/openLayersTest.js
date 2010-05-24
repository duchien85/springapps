var map;
var aoiLayer;
var aoiControl;

function aoiCreated(feature){
    console.dir(feature.geometry);
    alert(feature.geometry);
}

function showMap(){
    map = new OpenLayers.Map( 'theMap' );
    var baseLayer = new OpenLayers.Layer.WMS( "rf-vm-img","http://192.168.23.195:8080/geoserver/wms", {layers: 'bluemarble-large'} );
    aoiLayer = new OpenLayers.Layer.Vector("Area of Interest");
    map.addLayers([baseLayer, aoiLayer]);
    //pan = new OpenLayers.Control.PanZoomBar();
    //map.addControl(pan);
    map.setCenter(new OpenLayers.LonLat(0, 0), 2);
    aoiControl = new OpenLayers.Control.DrawFeature(aoiLayer, OpenLayers.Handler.Polygon);
    aoiControl.featureAdded =  aoiCreated;
    map.addControl(aoiControl);
    aoiControl.activate();
    console.dir(aoiControl);
    //map.zoomToMaxExtent();


}

document.observe("dom:loaded", function() {
  showMap();
});


