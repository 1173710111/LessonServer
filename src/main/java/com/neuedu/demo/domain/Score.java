package com.neuedu.demo.domain;

public class Score {
	private long id;
	private long numberAll;
	private long numberWrong;
	private long numberRight;
	private long numberUnfinished;
	private long exampaperId;
	
	public Score(long id, long numberAll, long numberWrong, long numberRight, long numberUnfinished, long exampaperId) {
		super();
		this.id = id;
		this.numberAll = numberAll;
		this.numberWrong = numberWrong;
		this.numberRight = numberRight;
		this.numberUnfinished = numberUnfinished;
		this.exampaperId = exampaperId;
	}
	public long getId() {
		return id;
	}
	public long getNumberAll() {
		return numberAll;
	}
	public long getNumberRight() {
		return numberRight;
	}
	public long getNumberWrong() {
		return numberWrong;
	}
	public long getNumberUnfinished() {
		return numberUnfinished;
	}
	public long getExampaperId() {
		return exampaperId;
	}
	@Override
	public String toString() {
		return "Score [id=" + id + ", numberAll=" + numberAll + ", numberWrong=" + numberWrong + ", numberRight="
				+ numberRight + ", numberUnfinished=" + numberUnfinished + ", exampaperId=" + exampaperId + "]";
	}
	
}
