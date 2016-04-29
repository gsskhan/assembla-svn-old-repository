package com.citi.gpa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="ETS_POC_DATA_INTERFACE")
public class DataInterface implements Serializable {	

	private static final long serialVersionUID = 5457671153987347784L;
	
	@Id
	@Column(name="DATA_INT_ID",nullable=false,unique=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long dataIntId;
	
	@Column(name="DATA_INT_CATEGORY")
	private String dataIntCategory;
	
	@Column(name="DATA_INT_NAME")
	private String dataIntName;
	
	@Column(name="DATA_INT_DESC")
	private String dataIntDesc;
	
	@Column(name="DATA_GEN_SYS")
	private String dataGenSys;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="dataInterface")
	private Set<AppDatIntXref> appDatIntXrefs = new HashSet<AppDatIntXref>();

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
			

}
