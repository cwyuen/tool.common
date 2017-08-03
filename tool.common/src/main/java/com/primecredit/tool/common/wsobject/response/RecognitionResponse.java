package com.primecredit.tool.common.wsobject.response;

import java.util.List;

public class RecognitionResponse {
	private String clientMachineId;
	private long millisecond;
	List<String> speechTextList;
	public String getClientMachineId() {
		return clientMachineId;
	}
	public void setClientMachineId(String clientMachineId) {
		this.clientMachineId = clientMachineId;
	}
	public long getMillisecond() {
		return millisecond;
	}
	public void setMillisecond(long millisecond) {
		this.millisecond = millisecond;
	}
	public List<String> getSpeechTextList() {
		return speechTextList;
	}
	public void setSpeechTextList(List<String> speechTextList) {
		this.speechTextList = speechTextList;
	}
	
}
