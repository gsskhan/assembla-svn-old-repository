Ext.onReady(function() {
	var requestParam = Ext.Object.fromQueryString(window.location.search.substring(1));
	var columns1=null;
	var historyData=null;
	var columns2=null;
	var headerPanel=Ext.create('Ext.panel.Panel', {
	    width: "99%",
	    hidden: true,
	    bodyStyle: {
		    border:'0px'
		    
		},
	    renderTo: 'bodyDiv',
	    layout: {
	        type: 'hbox',
	        align: 'left'
	    },
	    items: [
	      {
	        xtype: 'label',
	        id:'pageHead'
	    }]
	});
	var summaryPanel=Ext.create('Ext.panel.Panel', {
		hidden: true,
		bodyBorder:false,
		width: "99%",
		data:historyData,
		bodyStyle: {
		    border:'0px'
		},
	    layout: {
	        type: 'table',
	        columns: 6
	    },
	    defaults: {
	    	bodyCls: 'boderpanel'
	    },
	    tableAttrs: {
            style: {
            	
            }
        },
	    items: [{
	    	id: 'CSI_ID',
	        html: '',
	        cellCls: 'MainRow',
	        colspan: 2
	    },{
	    	id: 'acronym',
	        html: '',
	        cellCls: 'MainRow',
	        colspan: 2
	    },{
	    	id: 'sector',
	        html: '',
	        cellCls: 'SecondRow',
	        colspan: 2
	    },{
	    	id: 'appMgr',
	        html: '',
	        cellCls: 'SecondRow',
	        colspan: 3
	    },{
	    	id: 'suppMgr',
	        html: '',
	        cellCls: 'SecondRow',
	        colspan: 3
	    },{
	    	id: 'level3Org',
	        html: '',
	        cellCls: 'SecondRow',
	        colspan: 3
	    },{
	    	id: 'level5Org',
	        html: '',
	        colspan: 3
	    }
	    ],
	    renderTo: 'bodyDiv',
	    listeners: {
	    	afterrender: function(){
	    		
	    	}
	    }
	});
var historyGrid = Ext.create('Ext.grid.Panel', {
	title: '',
	titleAlign: 'left',
    width: "99%",
    columns:[],
    style: {
        marginTop: '20px'
    },
    listeners:{
    	afterrender:function(){
    		var me = this;
    		Ext.Ajax.request({
    	 		//url:  'dashboardServlet?'+'eventType=historyEvent&kpiCategoryName='+requestParam.kpiCategoryName+'&'+'kpiCategory='+requestParam.kpiCategory+'&'+'applicationName='+requestParam.applicationName,
    			url:  'dashboardServlet',
    	 		   method : 'POST',
    	 		  params: requestParam,
    	 		   success: function(response){
    	 			  console.log("response=="+response);
    	 			   var text = response.responseText;   
    	 			   console.log("text=="+text);
    	 			   historyData = Ext.JSON.decode(text);		
    	 			   console.log("historyData="+historyData);
    	 			   columns2 = historyData.columns;
    	 			   columns1 = Ext.JSON.encode(historyData.columns);
    	 			   console.log("col="+columns1);
    	 			   console.log("col="+columns2);
    	 			   var historyFields=new Array();
    	 			   for (var i=0;i<columns2.length;i++){
    	 				  console.log('f.dataIndex:'+columns2[i].dataIndex);
    	 				  historyFields.push(columns2[i].dataIndex);
    	 			   }
    	 			   console.log('historyFields: '+historyFields);
    	 			  var historyStore = Ext.create('Ext.data.Store', {
    	 				    storeId:'simpsonsStore',
    	 				    fields:historyFields,
    	 				    data: historyData.items,
    	 				    proxy: {
    	 				        type: 'memory',
    	 				        reader: {
    	 				            type: 'json',
    	 				            root: 'items'
    	 				        }
    	 				    }
    	 				});
    	 			   me.reconfigure(historyStore, columns2);
    	 			   me.setTitle(historyData.historyTableHeader);
    	 			   Ext.getCmp('pageHead').update('Application Name: '+historyData.historyContactDetails.ApplicationName);
    	 			   Ext.getCmp('CSI_ID').update('CSI_ID: '+historyData.historyContactDetails.CSI_ID);
    	 			   Ext.getCmp('acronym').update('Acronym: '+historyData.historyContactDetails.acronym);
    	 			   Ext.getCmp('sector').update('Sector: '+historyData.historyContactDetails.sector);
    	 			   Ext.getCmp('appMgr').update('App Mgr: '+historyData.historyContactDetails.appMgr);
    	 			   Ext.getCmp('suppMgr').update('Supp Mgr: '+historyData.historyContactDetails.suppMgr);
    	 			   Ext.getCmp('level3Org').update('Level 3 Org: '+historyData.historyContactDetails.level3Org);
    	 			   Ext.getCmp('level5Org').update('Level 5 Org: '+historyData.historyContactDetails.level5Org);
    	 			   headerPanel.show();
    	 			   summaryPanel.show();
    	 		   },
    	 		   failure : function(){

    	 		   }
    	 	   });
    	}
    },
    renderTo: 'bodyDiv',
});
});