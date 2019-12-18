package com.neuedu.demo.domain;

public class ActivityFile {
	private long id;
	private String fileName;
	private String url;
	private long activityId;
	private String type;
	private long workId;
	
	public ActivityFile(long id, String fileName, String url, long activityId, String type, long workId) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.url = url;
		this.activityId = activityId;
		this.type = type;
		this.workId = workId;
	}
	
	public ActivityFile(long id, String fileName, String url, long activityId, String type) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.url = url;
		this.activityId = activityId;
		this.type = type;
	}

	public long getId() {
		return id;
	}
	public String getFileName() {
		return fileName;
	}
	public String getUrl() {
		return url;
	}
	public long getActivityId() {
		return activityId;
	}
	public String getType() {
		return type;
	}
	public long getWorkId() {
		return workId;
	}
	@Override
	public String toString() {
		return "ActiivtyFile [id=" + id + ", fileName=" + fileName + ", url=" + url + ", activitiId=" + activityId
				+ ", type=" + type + ", workId=" + workId + "]";
	}
	
}
