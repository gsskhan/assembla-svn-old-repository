package com.citi.gpa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="ETS_POC_INFRASTRUCTURE")
public class Infrastructure implements Serializable{
	
	private static final long serialVersionUID = 8403673157272282588L;

	@Id
	@Column(name="IF_ID",nullable=false,unique=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ifId;
	
	@Column(name="IF_NAME")
	private String ifName;
	
	@Column(name="IF_CATEGORY")
	private String ifCategory;
	
	@Column(name="IF_TYPE")
	private String ifType;
	
	@Column(name="LOCATION")
	private String location;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="infrastructure")
	private Set<AppIfXref> appIfXrefs  = new HashSet<AppIfXref>();

	public long getIfId() {
		return ifId;
	}
	public void setIfId(long ifId) {
		this.ifId = ifId;
	}
	public String getIfName() {
		return ifName;
	}
	public void setIfName(String ifName) {
		this.ifName = ifName;
	}
	public String getIfCategory() {
		return ifCategory;
	}
	public void setIfCategory(String ifCategory) {
		this.ifCategory = ifCategory;
	}
	public String getIfType() {
		return ifType;
	}
	public void setIfType(String ifType) {
		this.ifType = ifType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}


}
