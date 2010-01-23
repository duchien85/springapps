/*
 * ! Ext JS Library 3.1.0 Copyright(c) 2006-2009 Ext JS, LLC licensing@extjs.com
 * http://www.extjs.com/license
 */
Ext.onReady(function(){
	Ext.Ajax.on('beforerequest', this.showSpinner, this);
	Ext.Ajax.on('requestcomplete', this.hideSpinner, this);
	Ext.Ajax.on('requestexception', this.hideSpinner, this);
    // NOTE: This is an example showing simple state management. During
	// development,
    // it is generally best to disable state management as dynamically-generated
	// ids
    // can change across page loads, leading to unpredictable results. The
	// developer
    // should ensure that stable state ids are set for stateful components in
	// real apps.
    // Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
    var store = new Ext.data.XmlStore({
    // store configs
    autoDestroy: true,
    storeId: 'employeesXmlStore',
    url: 'rest/employees', // automatically configures a HttpProxy
    // reader configs
    record: 'employee', // records will have an "Item" tag
    idPath: '@id',
    fields: [
        // set up the fields mapping into the xml doc
        // The first needs mapping, the others are very basic

        {name: 'Author', mapping: 'ItemAttributes > Author'},
        'Title', 'Manufacturer', 'ProductGroup'
    ]
});
        
    /**
	 * Custom function used for column renderer
	 * 
	 * @param {Object}
	 *            val
	 */
    function change(val){
        if(val > 0){
            return '<span style="color:green;">' + val + '</span>';
        }else if(val < 0){
            return '<span style="color:red;">' + val + '</span>';
        }
        return val;
    }

    /**
	 * Custom function used for column renderer
	 * 
	 * @param {Object}
	 *            val
	 */
    function pctChange(val){
        if(val > 0){
            return '<span style="color:green;">' + val + '%</span>';
        }else if(val < 0){
            return '<span style="color:red;">' + val + '%</span>';
        }
        return val;
    }

    // create the data store
    var store = new Ext.data.ArrayStore({
        fields: [
           {name: 'company'},
           {name: 'price', type: 'float'},
           {name: 'change', type: 'float'},
           {name: 'pctChange', type: 'float'},
           {name: 'lastChange', type: 'date', dateFormat: 'n/j h:ia'}
        ]
    });

    // manually load local data
    store.loadData(myData);

    // create the Grid
    var grid = new Ext.grid.GridPanel({
        store: store,
        columns: [
            {id:'company',header: 'Company', width: 160, sortable: true, dataIndex: 'company'},
            {header: 'Price', width: 75, sortable: true, renderer: 'usMoney', dataIndex: 'price'},
            {header: 'Change', width: 75, sortable: true, renderer: change, dataIndex: 'change'},
            {header: '% Change', width: 75, sortable: true, renderer: pctChange, dataIndex: 'pctChange'},
            {header: 'Last Updated', width: 85, sortable: true, renderer: Ext.util.Format.dateRenderer('m/d/Y'), dataIndex: 'lastChange'}
        ],
        stripeRows: true,
        autoExpandColumn: 'company',
        height: 350,
        width: 600,
        title: 'Array Grid',
        // config options for stateful behavior
        stateful: true,
        stateId: 'grid'        
    });
    
    // render the grid to the specified div in the page
    grid.render('employees_grid');
    Ext.Msg.alert('got here');    
});