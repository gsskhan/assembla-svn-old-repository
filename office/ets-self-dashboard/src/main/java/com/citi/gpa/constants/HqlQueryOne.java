package com.citi.gpa.constants;

public enum HqlQueryOne {

	MAX_RESULTSET_LIMIT(10000000),

	ALL_APP_HIEARCHY(
			" select distinct a.appName "
					+ " , a.appId "
					+ " , (select d.appName from App d where d.appId = ah.dependentApp_id )"
					+ " , ah.dependentApp_id "
					+ " , ah.streamFlag "
					+ " from App a , AppHierarchy ah "
					+ " where a.appId = ah.app.appId"
					+ " and a.appStatus = 'I' "
					+ " and ah.dependentApp_id in (select distinct appId from App where appStatus = 'I' ) "),

	ALL_APP_NO_HIEARCHY(
			" select distinct a.appId from App a "
					+ " where a.appId not in (select distinct ah.app.appId from AppHierarchy ah) "
					+ " and a.appId not in (select distinct dependentApp_id from AppHierarchy) "),

	APP_HIEARCHY(
			" select distinct a.appName "
					+ " , a.appId "
					+ " , (select d.appName from App d where d.appId = ah.dependentApp_id )"
					+ " , ah.dependentApp_id "
					+ " , ah.streamFlag "
					+ " , (select d.appStatus from App d where d.appId = ah.dependentApp_id ) "
					+ " from App a , AppHierarchy ah "
					+ " where a.appId = ah.app.appId"
					+ " and (a.appId = :vappId or ah.dependentApp_id = :vappId ) "),

	ALL_APP_NAME_AND_ID_LIST(
			" select distinct appName, appId from App where appStatus = 'I' "),

	LIST_OF_DATA_INTERFACE_FOR_APP(
			" select ax.app.appId, ax.dataInterface.dataIntId, di.dataIntCategory, di.dataIntName, ax.DataIntType, di.dataIntDesc "
					+ " from AppDatIntXref ax, DataInterface di "
					+ " where di.dataIntId =  ax.dataInterface.dataIntId "
					+ " and ax.app.appId = :vappId "),

	LIST_OF_INFRASTRUCTURE_FOR_APP(
			" select ai.app.appId, ai.infrastructure.ifId, i.ifCategory, i.ifName, i.ifType , i.location "
					+ " from AppIfXref ai, Infrastructure i "
					+ " where i.ifId =  ai.infrastructure.ifId "
					+ " and ai.app.appId = :vappId ");

	private String query;
	private int value;

	private HqlQueryOne(String query) {
		this.query = query;
	}

	private HqlQueryOne(int value) {
		this.value = value;
	}

	public String getQuery() {
		return this.query;
	}

	public int getValue() {
		return this.value;
	}

}
