package com.citi.gpa.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="etsDataInterface")
public class EtsDataInterface {
	
	@Id
	private String id;

	@Indexed(unique=true,name="dataIntIdIndx")
	@Field(value="dataIntId")
	private long dataIntId;
	
	@Field(value="dataIntCategory")
	private String dataIntCategory;
	
	@Field(value="dataIntName")
	private String dataIntName;
	
	@Field(value="dataIntDesc")
	private String dataIntDesc;
	
	@Field(value="dataGenSys")
	private String dataGenSys;
	
	public EtsDataInterface() {
		super();
	}

	public EtsDataInterface(long dataIntId, String dataIntCategory,
			String dataIntName, String dataIntDesc, String dataGenSys) {
		super();
		this.dataIntId = dataIntId;
		this.dataIntCategory = dataIntCategory;
		this.dataIntName = dataIntName;
		this.dataIntDesc = dataIntDesc;
		this.dataGenSys = dataGenSys;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getDataIntId() {
		return dataIntId;
	}

	public void setDataIntId(long dataIntId) {
		this.dataIntId = dataIntId;
	}

	public String getDataIntCategory() {
		return dataIntCategory;
	}

	public void setDataIntCategory(String dataIntCategory) {
		this.dataIntCategory = dataIntCategory;
	}

	public String getDataIntName() {
		return dataIntName;
	}

	public void setDataIntName(String dataIntName) {
		this.dataIntName = dataIntName;
	}

	public String getDataIntDesc() {
		return dataIntDesc;
	}

	public void setDataIntDesc(String dataIntDesc) {
		this.dataIntDesc = dataIntDesc;
	}

	public String getDataGenSys() {
		return dataGenSys;
	}

	public void setDataGenSys(String dataGenSys) {
		this.dataGenSys = dataGenSys;
	}

	@Override
	public String toString() {
		return "EtsDataInterface [id=" + id + ", dataIntId=" + dataIntId
				+ ", dataIntCategory=" + dataIntCategory + ", dataIntName="
				+ dataIntName + ", dataIntDesc=" + dataIntDesc
				+ ", dataGenSys=" + dataGenSys + "]";
	}

}
