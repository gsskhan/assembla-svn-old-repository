package org.dms.web.document;


import java.util.Arrays;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="paperstores")
public class PaperStores {

	@Id
	private String id;
	
	@Field(value="number")
	@Indexed(name="numberIdx",dropDups=true)
	private long number;
	
	@Field(value="title")
	private String title;

	@Field(value="data")
	private byte[] data;
	
	@Field(value="originalfilename")
	private String originalFilename;

	@DBRef
	private Users createdByUser;

	@Field(value="creationtime")
	private Date creationTime;
	
	public PaperStores() {
		super();
	}

	public PaperStores(long number, String title, byte[] data, String originalFilename,
			Users createdByUser, Date creationTime) {
		super();
		this.number = number;
		this.title = title;
		this.data = data;
		this.originalFilename = originalFilename;
		this.createdByUser = createdByUser;
		this.creationTime = creationTime;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public Users getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(Users createdByUser) {
		this.createdByUser = createdByUser;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public String toString() {
		return "PaperStores [id=" + id + ", number=" + number + ", title=" + title + ", data record byte length="
				+ Arrays.toString(data).length() + ", createdByUser="
				+ createdByUser + ", creationTime=" + creationTime + "]";
	}		
	
	
}
