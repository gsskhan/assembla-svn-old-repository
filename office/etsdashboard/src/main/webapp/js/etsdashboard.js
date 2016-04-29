Ext.require([
    'Ext.data.*',
    'Ext.grid.*',
    'Ext.tree.*'
]);
Ext.tip.QuickTipManager.init();
Ext.onReady(function() {
	// adding a expand count to control columns
	var expandCount=0;
	//var dashboardEvent = "dashboardEvent";
	// we want to setup a model and store instead of using dataUrl
    Ext.define('Application Name', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'appname',     type: 'string'},
            {name: 'overall',     type: 'string'},
            {name: 'infra', type: 'string'},
            {name: 'feedsin', type: 'string'},
            {name: 'feedsout', type: 'string'}
        ]
    });
    var store = Ext.create('Ext.data.TreeStore', {
        model: 'Application Name',
        proxy: {
            type: 'ajax', 
            method : 'POST',
        	url :'dashboardServlet?eventType=dashboardEvent'        	
        },
        folderSort: true
    });
    var tree = Ext.create('Ext.tree.Panel', {
        width: 320,
        height : "70%",
        id:'MainPanel',
        border:0,
        renderTo: Ext.getBody(),
        collapsible: false,
        useArrows: false,
        rootVisible: false,
        store: store,
        cls: 'x-padding-cell',
        multiSelect: true,
        singleExpand: false,
        columns: [{
            xtype: 'treecolumn', // this is so we know which column will show
			id : 	'abc',					// the tree
            text: 'Application Name',
            minWidth: 220,
            maxWidth : 220,
            sortable: false,
            menuDisabled:true,
            dataIndex: 'appname',
            resizable: false,  
            sortable: true, 
            cls:'columnStyle',
            renderer: function(value, metaData, record, rowIndex, colIndex, store) {
                switch (value) {
                    default :
                    	 metaData.css = 'text';
                    break;
                }
                return value;
            }
        },
        {
            text: 'Overall',
            minWidth: 100,
            maxWidth : 100,
            dataIndex: 'overall',
            menuDisabled:true,
            sortable: false,
            resizable: false,  
            sortable: true, 
            cls:'columnStyle',
            renderer: function(value, metadata, record, rowIndex, colIndex, store) {
            	switch (value) {
                default :
                	metadata.css = 'cellDiv';
                break;
                }
            	var cellvalue=value.split('||');
            	if(cellvalue.length > 1){
            	return '<div style="background-color:'+cellvalue[0]+';font-weight:bold;height:15px;text-align:center;margin-top: 2px;">'+cellvalue[1]+'</div>';
            	}else
            	{
            		return '<div style="background-color:'+cellvalue+';font-weight:bold;height:15px;text-align:center;margin-top: 2px;"></div>'	;
            	}
            	}
        },
        {
        	text: 'Infrastructure',
            hidden: true,
            minWidth: 100,
            maxWidth : 100,
            dataIndex: 'infra',
            menuDisabled:true,
            sortable: false,
            resizable: false,  
            sortable: true, 
            cls:'columnStyle',
            renderer: function(value, metadata, record, rowIndex, colIndex, store) {
            	switch (value) {
                default :
                	metadata.css = 'cellDiv';
                break;
                }
            	var cellvalue=value.split('||');
            	if(cellvalue.length > 1){
                	return '<div style="background-color:'+cellvalue[0]+';font-weight:bold;height:15px;text-align:center;margin-top: 2px;">'+cellvalue[1]+'</div>';
                	}else
                	{
                		return '<div style="background-color:'+cellvalue+';font-weight:bold;height:15px;text-align:center;margin-top: 2px;"></div>'	;
                	}
            }
        },
        {
            text: 'Feeds In',
            hidden: true,
            minWidth: 100,
            maxWidth : 100,
            dataIndex: 'feedsin',
            menuDisabled:true,
            sortable: false,
            resizable: false,  
            sortable: true, 
            cls:'columnStyle',
            renderer: function(value, metadata, record, rowIndex, colIndex, store) {
            	switch (value) {
                default :
                	metadata.css = 'cellDiv';
                break;
                }
            	var cellvalue=value.split('||');
            	if(cellvalue.length > 1){
                	return '<div style="background-color:'+cellvalue[0]+';font-weight:bold;height:15px;text-align:center;margin-top: 2px;">'+cellvalue[1]+'</div>';
                	}else
                	{
                		return '<div style="background-color:'+cellvalue+';font-weight:bold;height:15px;text-align:center;margin-top: 2px;"></div>'	;
                	}
            }
        },
        {
            text: "Feeds Out",
            hidden: true,
            minWidth: 100,
            maxWidth : 100,
            dataIndex: 'feedsout',
            menuDisabled:true,
            sortable: false,
            resizable: false,  
            sortable: true, 
            cls:'columnStyle',
            renderer: function(value, metadata, record, rowIndex, colIndex, store) {switch (value) {
            default :
            	metadata.css = 'cellDiv';
            break;
            }
        	var cellvalue=value.split('||');
        	if(cellvalue.length > 1){
            	return '<div style="background-color:'+cellvalue[0]+';font-weight:bold;height:15px;text-align:center;margin-top: 2px;">'+cellvalue[1]+'</div>';
            	}else
            	{
            		return '<div style="background-color:'+cellvalue+';font-weight:bold;height:15px;text-align:center;margin-top: 2px;"></div>'	;
            	}
        }
        }],
        listeners: {
        	afteritemcollapse: function(node, index, item, eOpts){ 
				if( !node.isLeaf() ) {
					for(var i = 0; i < node.childNodes.length; i++ ) {
						node.collapse(deep=true);
					}
				}
				console.log('nodeDepth: '+node.getDepth());
				if(node.getDepth()==1){
					expandCount--;
					
				}
				if(node.getDepth()==1 && expandCount==0){
					this.width=320;
					var colLen=this.columns.length;
					for(var i=2;i<colLen;i++){
						this.columns[i].hide();
					}
				}
			},
			afteritemexpand:  function(node, index, item, eOpts){ 
				this.width=640;
				var colLen=this.columns.length;
				if(node.getDepth()==1){
					expandCount++;
				}
				for(var i=2;i<colLen;i++){
					this.columns[i].show();
				}
			},
			itemmouseenter: function(view, record, item, index, e, options)
            {
            	var toolTipData;
               if (typeof(view.tip) == 'undefined' && view.tip == null){

            	   view.tip = Ext.create('Ext.tip.ToolTip', {
            	    target: view.el,
                    delegate: view.cellSelector,
                    trackMouse: false,
                    autoHide : false,
                    mouseOffset : [-153, -15],
//                    closable : true,
                    renderTo: Ext.getBody(),
                    listeners: {
                       beforeshow: function updateTipBody(tip) {
                    	   var gridColums = view.getGridColumns();
                    	   console.log(gridColums);
                    	   console.log(index);
                    	   
                    	   console.log(gridColums[1]);
                    	   /*var header = gridColums[index]['text'];
                    	   alert(header);*/
                           var column = gridColums[e.getTarget(view.cellSelector).cellIndex];
                           console.log('column = '+column.dataIndex) ;//header
                           var header = column.dataIndex;
                           
                           console.log('record === '+view.getRecord(tip.triggerElement.parentNode).get('appname'));//first column
                           var subAppName = view.getRecord(tip.triggerElement.parentNode).get('appname');
                           
                         
                          // console.log('record1 == '+(((view.getRecord(tip.triggerElement.parentNode)).parentNode)).parentNode.get('appname'));
                           
                           var toolTipCellEl = (view.getRecord(tip.triggerElement.parentNode)).parentNode;
                           console.log("depth of cel === "+toolTipCellEl.getDepth());
                           
                           while(toolTipCellEl.getDepth()>2){
                        	   
                        	   console.log('inside loop checking depth == '+toolTipCellEl.getDepth());
                        	   console.log('application == '+toolTipCellEl.get('appname'));
                        	   toolTipCellEl=toolTipCellEl.parentNode;
                           }
                           var applicationName = toolTipCellEl.get('appname');
                           console.log('after loop checking depth == '+toolTipCellEl.getDepth());
                           console.log('application name = '+applicationName); //application name of current node
                           
                           
                           
                           
                          // console.log('record = '+Ext.encode(record.parentNode.getData())) 
                           
                           
                           var val=view.getRecord(tip.triggerElement.parentNode).get(column.dataIndex);
                           var cellvalue=val.split('||');
                           toolTipData = cellvalue[2];
                           if(cellvalue.length > 1){
                           var myToolTipText ='';	   
                           myToolTipText = '<div class="popover fade bottom in"><div class="arrow"></div><div class="popover-inner"><div class="popover-content"><h3 class="popover-title"></h3>';
                           myToolTipText =  myToolTipText+"<p>"+cellvalue[2];
                           myToolTipText = myToolTipText + '<a class="tooltip_link" href="javascript:openHistory(\''+header+'\',\''+subAppName+'\',\''+applicationName+'\')" target="_blank">More &gt;</a></p></div></div></div>';
                           tip.update(myToolTipText);
                           }
                           else{
                        	   tip.close();
                           }
                       },
                       afterlayout: function validate(tip){
							if(toolTipData==null ||typeof(toolTipData) === 'undefined'|| toolTipData==''){
								tip.hide();
							}
						}
                   }
               });
               }
            },
            itemmouseleave: function(view, record, item, index, e, options)
            {
            },
            itemclick: function(){
            	if(node.isLeaf()){
            		//alert('Leaf Node');
            	}else{
            		//alert('Non Leaf');
            	}
            }
           
        }
    });
    Ext.EventManager.onWindowResize(function(w, h){
    	var height = h-140;
    	Ext.getCmp("MainPanel").setHeight(height);
    });
});


function openHistory(header,subAppName,applicationName){	
	window.open('history.html?'+'eventType=historyEvent&kpiCategoryName='+header+'&'+'kpiCategory='+subAppName+'&'+'applicationName='+applicationName);	
}