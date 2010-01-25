/*
 * ! Ext JS Library 3.1.0 Copyright(c) 2006-2009 Ext JS, LLC licensing@extjs.com
 * http://www.extjs.com/license
 */
Ext.onReady(function(){
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
        {name: 'firstName', mapping: 'first_name', allowBlank: true},
        {name: 'lastName', mapping: 'last_name', allowBlank: false},
        {name: 'email', mapping: 'email', allowBlank: false},                        
        {name: 'phoneNumber', mapping: 'phone_number', allowBlank: true},
        {name: 'hireDate', mapping: 'hire_date', type: 'date', allowBlank: false},
        {name: 'jobId', mapping: 'job_id', allowBlank: false},
        {name: 'salary', mapping: 'salary', type: 'int', allowBlank: true},                
        {name: 'commissionPct', mapping: 'commission_pct', type: 'float', allowBlank: true},                        
        {name: 'managerId', mapping: 'manager_id', type: 'int', allowBlank: true},                                
        {name: 'departmentId', mapping: 'department_id', type: 'int', allowBlank: true}                                        
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

    // manually load local data
    store.loadData();
    
    // create the Grid
    var grid = new Ext.grid.GridPanel({
        store: store,
        columns: [
            {id:'id',header: 'Company', width: 160, sortable: true, dataIndex: 'company'},
            {header: 'First', width: 75, sortable: true,  dataIndex: 'firstName'},
            {header: 'Last', width: 75, sortable: true,  dataIndex: 'lastName'},            
            {header: 'Email', width: 75, sortable: true,  dataIndex: 'email'},
            {header: 'Hire Date', width: 75, sortable: true,  dataIndex: 'hireDate'},
            {header: 'Hire Date', width: 75, sortable: true,  dataIndex: 'hireDate'},                        
            {header: 'phoneNumber', width: 75, sortable: true,  dataIndex: 'phoneNumber'},            
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