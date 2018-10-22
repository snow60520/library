package com.snow.model;

public class SessionUser {
	//当前用户的session id
	private String sessionId;
	private String sessionUserName;

	//当前用户的ip地址
	private String sessionIP;
	//当前用户第一次访问的时间
	private String sessionFirstTime;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getSessionUserName() {
		return sessionUserName;
	}

	public void setSessionUserName(String sessionUserName) {
		this.sessionUserName = sessionUserName;
	}

	public String getSessionIP() {
		return sessionIP;
	}

	public void setSessionIP(String sessionIP) {
		this.sessionIP = sessionIP;
	}

	public String getSessionFirstTime() {
		return sessionFirstTime;
	}

	public void setSessionFirstTime(String sessionFirstTime) {
		this.sessionFirstTime = sessionFirstTime;
	}

	public SessionUser() {
		super();
	}

	public SessionUser(String sessionId, String sessionUserName, String sessionIP, String sessionFirstTime) {
		this.sessionId = sessionId;
		this.sessionUserName = sessionUserName;
		this.sessionIP = sessionIP;
		this.sessionFirstTime = sessionFirstTime;
	}

	@Override
	public String toString() {
		return "SessionUser{" +
				"sessionId='" + sessionId + '\'' +
				", sessionUserName='" + sessionUserName + '\'' +
				", sessionIP='" + sessionIP + '\'' +
				", sessionFirstTime='" + sessionFirstTime + '\'' +
				'}';
	}
}