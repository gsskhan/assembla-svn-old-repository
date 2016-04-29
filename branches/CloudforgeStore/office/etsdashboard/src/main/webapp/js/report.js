Ext.require([
    'Ext.data.*',
    'Ext.grid.*',
    'Ext.tree.*'
]);

Ext.onReady(function() {
	// The data store containing the list of cars
	var FieldValue="";
	var FieldValueTemp="";
	var appcsi_id="";
	var appcsi_name="";
	var freq="";	
	var appName = "";
	var StartDate = "";
	var EndDate= "";
	var MonthNumber= "";
	var WeekNumber = "";
	Ext.define('Ext.form.field.Month', {
        extend: 'Ext.form.field.Date',
        alias: 'widget.monthfield',
        requires: ['Ext.picker.Month'],
        alternateClassName: ['Ext.form.MonthField', 'Ext.form.Month'],
        //selectMonth: null,
        createPicker: function () {
            var me = this,
                format = Ext.String.format;
            return Ext.create('Ext.picker.Month', {
                pickerField: me,
                ownerCt: me.ownerCt,
                renderTo: document.body,
                floating: true,
                hidden: true,
                focusOnShow: true,
                minDate: me.minValue,
                maxDate: me.maxValue,
                disabledDatesRE: me.disabledDatesRE,
                disabledDatesText: me.disabledDatesText,
                disabledDays: me.disabledDays,
                disabledDaysText: me.disabledDaysText,
                format: me.format,
                showToday: me.showToday,
                startDay: me.startDay,
                minText: format(me.minText, me.formatDate(me.minValue)),
                maxText: format(me.maxText, me.formatDate(me.maxValue)),
                listeners: {
                    select: { scope: me, fn: me.onSelect },
                    monthdblclick: { scope: me, fn: me.onOKClick },
                    yeardblclick: { scope: me, fn: me.onOKClick },
                    OkClick: { scope: me, fn: me.onOKClick },
                    CancelClick: { scope: me, fn: me.onCancelClick }
                },
                keyNavConfig: {
                    esc: function () {
                        me.collapse();
                    }
                }
            });
        },
        onCancelClick: function () {
            var me = this;
            me.selectMonth = null;
            me.collapse();
        },
        onOKClick: function () {
            var me = this;
            if (me.selectMonth) {
                me.setValue(me.selectMonth);
                me.fireEvent('select', me, me.selectMonth);
            }
            me.collapse();
        },
        onSelect: function (m, d) {
            var me = this;
            me.selectMonth = new Date((d[0] + 1) + '/1/' + d[1]);
        }
    });

	Ext.define("appModel", {
		extend: "Ext.data.Model",
		fields: [
		{ name: "text", type: "string" }
		]
		});
	Ext.define("gridModel", {
		extend: "Ext.data.Model",
		fields: [
		{ name: "component", type: "string" },
		{ name: "timestamp", type: "string" },
		{ name: "status", type: "string" }
		]
		});
	var appid = Ext.create('Ext.data.Store', {
		model: "appModel",
		autoDestroy: true,
		proxy: {
		url: "dashboardServlet?eventType=reportEvent", 
		//url: "JSON/appid.json", 
		type: "ajax"
		}
		,autoLoad: true
	});
	function loadStoreDataforAppName(){
		console.log("in store");
		appName = Ext.create('Ext.data.Store', {
		model: "appModel",
		autoDestroy: true,
		proxy: {
		url: "dashboardServlet?eventType=reportEvent&appcsi="+appcsi_id, 
		//url: "JSON/appname.json", 
		type: "ajax"
		}
		,autoLoad: true
	});
	}
	var frequency = Ext.create('Ext.data.Store', {
	    fields: ['freq'],
	    data: [{
	        "freq": "Monthly"
	    }, {
	        "freq": "Weekly"
	    }, {
	        "freq": "Daily"
	    }
	    ]
	});

	Ext.create('Ext.form.ComboBox', {
	    fieldLabel: 'Application ID',
	    id : 'csi_id',
	    queryMode: 'local',
	    cls : 'appid',
	    store: appid,
	    displayField: 'text',
	    valueField: 'text',
	    forceSelection:true,
		emptyText:'APP CSI ID',
		renderTo: Ext.getBody(),
	    listeners: {
	    	change: function(field, newValue, oldValue)
	        {
	            if(newValue != "APP CSI ID")
	            {
	            	 if(Ext.getCmp('app_name')===undefined){
	            		 appcsi_id=newValue;
		            	 showAppName();
		            }else if(Ext.getCmp("app_name").isVisible()){
	            		 Ext.getCmp('app_name').destroy();
	            		 if(typeof Ext.getCmp('frequency')!= "undefined"){
	            		 Ext.getCmp("frequency").destroy();}
	            		 destroyAll();
	            		 appcsi_id=newValue;
		            	 showAppName();
		            }
	            }
	        },
	    	scope: this,
            afterRender: function(me){
            },
	        beforequery: function (record) {
	        	record.query = new RegExp(record.query, 'i');
	            record.forceAll = true;
	        }
	    }

	});
	function showAppName(){
	loadStoreDataforAppName();
	Ext.create('Ext.form.ComboBox', {
    fieldLabel: 'Application Name',
    store: appName,
    id : 'app_name',
    cls : 'appname',
    queryMode: 'local',
    displayField: 'text',
    valueField: 'text',
    forceSelection:true,
	emptyText:'Application Name',
	autoRender: true,
    renderTo: Ext.getBody(),
    listeners: {
    	change: function(field, newValue, oldValue)
        {
            if(newValue != "Application Name" && newValue != "" )
            {
            	 if(typeof Ext.getCmp('frequency')== "undefined"){
            		 freq=newValue;
            		 showFrequency();
	             }else if(Ext.getCmp("frequency").isVisible()){
            		 Ext.getCmp('frequency').destroy();
            		 destroyAll();
            		 freq=newValue;
            		 showFrequency();
	             } 
            }
        },
    	scope: this,
        afterRender: function(me){
        },
        beforequery: function (record) {
        	record.query = new RegExp(record.query, 'i');
            record.forceAll = true;
        }
    }
	});
	}
	function showFrequency(){
	Ext.create('Ext.form.ComboBox', {
		fieldLabel: 'Frequency',
	    store: frequency,
	    id : 'frequency',
	    cls : 'frequency',
	    queryMode: 'local',
	    displayField: 'freq',
	    valueField: 'freq',
	    emptyText:'Frequency',
	    renderTo: Ext.getBody(),
	    listeners: {
	    	change: function(field, newValue, oldValue)
	        {
	            if(newValue == "Daily"){
	            	console.log(newValue+" has been selected.");
	            	FieldValue="";
	            	FieldValueTemp="";
	            	showDaily();
	            	freq=newValue;
	            }
	            else if(newValue == "Monthly"){
	            	console.log(newValue+" has been selected.");
	            	FieldValue="";
	            	FieldValueTemp="";
	            	showMonthly();
	            	freq=newValue;
	            }
	            else if(newValue == "Weekly"){
	            	console.log(newValue+" has been selected.");
	            	FieldValue="";
	            	FieldValueTemp="";
	            	showWeekly();	
	            	freq=newValue;
	            }
	        },
	    	scope: this,
	        afterRender: function(me){
	        //    me.setValue('Frequency');   
	        },
	        beforequery: function (record) {
	        	record.query = new RegExp(record.query, 'i');
	            record.forceAll = true;
	        }
	    }

	});
	}
	function showMonth(){	
		Ext.create('Ext.form.Panel', {
		id : 'month',
	    border : 0,
	    cls : 'month',
    	items: [
            {
                xtype: 'monthfield',
                submitFormat: 'Y-m-d',
                name: 'month',
                format: 'F, Y',
                border : 0,
        	    listeners: { 
                    afterrender: function(c) {
                        c.inputEl.on('blur', function(){
                        	FieldValue="";
                            FieldValue=c.getSubmitValue();
                            console.log(FieldValue);
                            MonthNumber = FieldValue.substring(0, 7);
                            console.log(MonthNumber);
                        });
                    }
                }
            }
        ],
        renderTo: Ext.getBody()
    });
    showButton();
    }
	function showWeek(){
	MonthNumber = "";
    StartDate = "";
    EndDate = "";
	Ext.create('Ext.form.Panel', {
	    id : 'week',
	    border : 0,
	    cls : 'week',
	    renderTo: Ext.getBody(),
	    items: [{
	        xtype: 'datefield',
	        format : 'Y-W',
	        alt : 'Y-W',
	        listeners: { 
                afterrender: function(c) {
                    c.inputEl.on('blur', function(){
                    	FieldValue="";
                        FieldValue="W"+c.getSubmitValue();
                        WeekNumber = c.getSubmitValue();
                    });
                }
            }
	    }]
	});
	showButton();
	}
	function showCalender(){
	Ext.apply(Ext.form.VTypes, {
		daterange : function(val, field) {
			var date = field.parseDate(val);

			if(!date){
				return;
			}
			if (field.startDateField && (!this.dateRangeMax || (date.getTime() != this.dateRangeMax.getTime()))) {
				var start = Ext.getCmp(field.startDateField);
				start.setMaxValue(date);
				start.validate();
				this.dateRangeMax = date;
			} 
			else if (field.endDateField && (!this.dateRangeMin || (date.getTime() != this.dateRangeMin.getTime()))) {
				var end = Ext.getCmp(field.endDateField);
				end.setMinValue(date);
				end.validate();
				this.dateRangeMin = date;
			}
			return true;
		}
	});
	dateRangeFunc();
	function dateRangeFunc()
		{
	        WeekNumber = "";
            MonthNumber = "";
    		var fromdate = new Ext.form.DateField({
				format: 'Y-m-d', //YYYY-MMM-DD
				fieldLabel: '',
				id: 'startdt',
				name: 'startdt',
				width:140,
				allowBlank:false,
				vtype: 'daterange',
	            endDateField: 'enddt',// id of the 'To' date field
	            listeners: { 
	                afterrender: function(c) {
	                    c.inputEl.on('blur', function(){
	                    	FieldValue="";
	                    	FieldValueTemp="";
	                        FieldValueTemp=c.getSubmitValue();
	                        //console.log(FieldValueTemp);
	                        StartDate = c.getSubmitValue();
	                    });
	                }
	            }
			});
			
			var todate = new Ext.form.DateField({
				format: 'Y-m-d', //YYYY-MMM-DD
				fieldLabel: '',
				id: 'enddt',
				name: 'enddt',
				width:140,
				allowBlank:false,
				vtype: 'daterange',
	            startDateField: 'startdt',
	            listeners: { 
	                afterrender: function(c) {
	                    c.inputEl.on('blur', function(){
	                    	FieldValue="";
	                    	FieldValue=FieldValueTemp+" "+c.getSubmitValue();
	                        //console.log(FieldValue);
	                    	EndDate = c.getSubmitValue();
	                    });
	                }
	            }
			});
			
			fromdate.render('fromdate');
			todate.render('todate');
	} 
	showButton();
	}
	function showButton(){
	Ext.create('Ext.Button', {
        text: 'Generate Report',
        cls : 'ReportButton',
        id : 'ReportBtn',
        renderTo: Ext.getBody(),
        listeners: {
            click: function() {
            	if(StartDate != "" && EndDate !=""){
            		console.log(StartDate);
                	console.log(EndDate);
                	fetchTableDataDaily(StartDate, EndDate);
            	}
            	else if(MonthNumber != ""){
            		fetchTableData(MonthNumber ,"MONTHLY");
            		console.log(MonthNumber);
            	}
            	else if(WeekNumber != ""){
            		console.log(WeekNumber);
            		fetchTableData(WeekNumber ,"WEEKLY");
            	}
            	else{
            		alert("please enter valid Date");
            	}	
            },
        }
    });
	}
	 function fetchTableData(date,type){
	 var dateRange=date;
	 var DateFrequency =type;
	 Ext.create('Ext.data.Store', {
	        storeId: 'reportStore',
	        model: "gridModel",
			proxy: {
			//url: "JSON/reportgrid.json", 
			url: "dashboardServlet?eventType=reportEvent&appcsi="+appcsi_id+"&frequency="+DateFrequency+"&date="+dateRange,
			type: "ajax",
			    reader: {
	                type: 'json',
	                root: 'items'
	            }
	        }
	 		,autoLoad: true
        });
	     createTable();
	}
	function fetchTableDataDaily(start_date,end_date){
		var from=start_date;
		var to=end_date;		
		var event="DAILY";
		Ext.create('Ext.data.Store', {
		        storeId: 'reportStore',
		        model: "gridModel",
				proxy: {
				//url: "JSON/reportgrid.json", 
				url: "dashboardServlet?eventType=reportEvent&appcsi="+appcsi_id+"&frequency="+event+"&startDate="+from+"&endDate="+to,
				type: "ajax",
				    reader: {
		                type: 'json',
		                root: 'items'
		            }
		        }
		 		,autoLoad: true
	        });
		createTable();
	}
	function createTable(){
		Ext.create('Ext.grid.Panel', {
			viewConfig: {
		        emptyText: 'No records found'
		    },
	        store: Ext.data.StoreManager.lookup('reportStore'),
	        columns: [{
	            text: 'Component',
	            dataIndex: 'component',
	            flex : 1,
	            cls:'columnStyle'
	        }, {
	            text: 'Timestamp',
	            dataIndex: 'timestamp',
	            flex : 1,
	            cls:'columnStyle'
	        }, {
	            text: 'Status',
	            dataIndex: 'status',
	            cls:'columnStyle',
	            flex : 1,
	            renderer: function(value, metadata, record, rowIndex, colIndex, store) {
	            	switch (value) {
	                default :
	                	metadata.css = 'cellDiv';
	                break;
	                }
	            	return '<div style="background-color:'+value+';font-weight:bold;height:15px;text-align:center;margin-top: 2px;"></div>';
	            	}
	        }],
	        height: "70%",
	        border:0,
	        cls : 'reportPanel',	
	        width: 600,
	        id : 'Report',
	        renderTo: Ext.getBody()
	    });
		console.log(Ext.getStore("reportStore").getCount());
	}
	function showDaily(){
		if(typeof Ext.getCmp('month')!= "undefined"){
		Ext.getCmp("month").destroy();}
		if(typeof Ext.getCmp('week')!= "undefined"){
		Ext.getCmp("week").destroy();}
		if(typeof Ext.getCmp('ReportBtn')!= "undefined"){
		Ext.getCmp("ReportBtn").destroy();}
		if(typeof Ext.getCmp('Report')!= "undefined"){
		Ext.getCmp("Report").destroy();}
		showCalender();
   }
	function showMonthly(){
		if(typeof Ext.getCmp('startdt')!= "undefined"){
		Ext.getCmp("startdt").destroy();}
		if(typeof Ext.getCmp('enddt')!= "undefined"){
		Ext.getCmp("enddt").destroy();}
		if(typeof Ext.getCmp('week')!= "undefined"){
		Ext.getCmp("week").destroy();}
		if(typeof Ext.getCmp('ReportBtn')!= "undefined"){
		Ext.getCmp("ReportBtn").destroy();}
		if(typeof Ext.getCmp('Report')!= "undefined"){
			Ext.getCmp("Report").destroy();}
		showMonth();
   }
	function showWeekly(){
		if(typeof Ext.getCmp('startdt')!= "undefined"){
			Ext.getCmp("startdt").destroy();}
		 if(typeof Ext.getCmp('enddt')!= "undefined"){
			Ext.getCmp("enddt").destroy();}
			if(typeof Ext.getCmp('month')!= "undefined"){
			Ext.getCmp("month").destroy();}
			if(typeof Ext.getCmp('ReportBtn')!= "undefined"){
			Ext.getCmp("ReportBtn").destroy();}
			if(typeof Ext.getCmp('Report')!= "undefined"){
				Ext.getCmp("Report").destroy();}
			showWeek();
   }
	function destroyAll(){
		   if(typeof Ext.getCmp('startdt')!= "undefined"){
			Ext.getCmp("startdt").destroy();}
			if(typeof Ext.getCmp('enddt')!= "undefined"){
			Ext.getCmp("enddt").destroy();}
			if(typeof Ext.getCmp('week')!= "undefined"){
			Ext.getCmp("week").destroy();}
			if(typeof Ext.getCmp('ReportBtn')!= "undefined"){
			Ext.getCmp("ReportBtn").destroy();}
			if(typeof Ext.getCmp('month')!= "undefined"){
			Ext.getCmp("month").destroy();}
			if(typeof Ext.getCmp('Report')!= "undefined"){
			Ext.getCmp("Report").destroy();}
	}
});