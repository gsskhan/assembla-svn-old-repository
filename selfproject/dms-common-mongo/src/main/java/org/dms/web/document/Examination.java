package org.dms.web.document;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection="examination")
public class Examination {
	
	@Id
	private String id;

	@DBRef
	private PaperStores paperStores;
	
	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Field(value="starttime")
	private Date startTime;

	@DateTimeFormat(iso=ISO.DATE_TIME)
	@Field(value="endtime")
	private Date endtime;

	@Field(value="examowner")
	private long examowner;

	public Examination() {
		super();
	}

	@PersistenceConstructor
	public Examination(PaperStores paperStores, Date startTime,
			Date endtime, long examowner) {
		super();
		this.paperStores = paperStores;
		this.startTime = startTime;
		this.endtime = endtime;
		this.examowner = examowner;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PaperStores getPaperStores() {
		return paperStores;
	}

	public void setPaperStores(PaperStores paperStores) {
		this.paperStores = paperStores;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public long getExamowner() {
		return examowner;
	}

	public void setExamowner(long examowner) {
		this.examowner = examowner;
	}

	@Override
	public String toString() {
		return "Examination [id=" + id + ", paperStores=" + paperStores
				+ ", startTime=" + startTime + ", endtime=" + endtime
				+ ", examowner=" + examowner + "]";
	}
	

}
