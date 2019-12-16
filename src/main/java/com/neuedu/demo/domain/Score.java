package com.neuedu.demo.domain;

public class Score {
	private long id;
	private long numberAll;
	private long numberRight;
	private long numberWrong;
	private long numberUnfinished;
	public Score(long id, long numberAll, long numberRight, long numberWrong, long numberUnfinished) {
		super();
		this.id = id;
		this.numberAll = numberAll;
		this.numberRight = numberRight;
		this.numberWrong = numberWrong;
		this.numberUnfinished = numberUnfinished;
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
	
	
}
