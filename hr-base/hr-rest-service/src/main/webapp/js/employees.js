/*
 * ! Ext JS Library 3.1.0 Copyright(c) 2006-2009 Ext JS, LLC licensing@extjs.com
 * http://www.extjs.com/license
 */
Ext.onReady(function(){
    // Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
    var employeeStore = new Ext.data.XmlStore({
    // store configs
        autoDestroy: true,
        storeId: 'employeesXmlStore',
        url: 'rest/employees', // automatically configures a HttpProxy
        // reader configs
        record: 'employee', // records will have an employee tag
        idPath: '@id',
        autoLoad: true,
        fields: [
            {name: 'id', mapping: '@id', allowBlank: false},
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
        ],
        sortInfo: {
            field: 'id',
            direction: 'ASC'
        }
    });


    // create the Grid
    var grid = new Ext.grid.GridPanel({
        store: employeeStore,
        columns: [
            {id: 'id', header: 'Id', width: 70, sortable: true,  dataIndex: 'id'},
            {header: 'First', width: 70, sortable: true,  dataIndex: 'firstName'},
            {header: 'Last', width: 70, sortable: true,  dataIndex: 'lastName'},
            {header: 'Email', width: 70, sortable: true,  dataIndex: 'email'},
            {header: 'Hire Date', width: 70, sortable: true,  renderer: Ext.util.Format.dateRenderer('Y-m-d'), dataIndex: 'hireDate'},
            {header: 'phoneNumber', width: 70, sortable: true,  dataIndex: 'phoneNumber'},
            {header: 'Salary', width: 70, sortable: true, dataIndex: 'salary'},
            {header: 'Job', width: 70, sortable: true, dataIndex: 'jobId'},
            {header: 'Manager', width: 70, sortable: true, dataIndex: 'managerId'},
            {header: 'Department', width: 70, sortable: true, dataIndex: 'departmentId'},
            {header: 'Commission', width: 70, sortable: true, dataIndex: 'commissionPct'}
        ],
        bbar: new Ext.PagingToolbar({
            pageSize: 20,
            store: employeeStore,
            displayInfo: true,
            displayMsg: 'Displaying Employees {0} - {1} of {2}',
            emptyMsg: 'No Employees Found'
        }),
        autoExpandColumn: 1,
        height: 500,
        width: 800,
        title: 'Employees',
        loadMask: true,
        columnLines: true,
        shadow: true,
        stripeRows: true,
        renderTo: Ext.get('employees_grid')
    });

    employeeStore.load();
});
