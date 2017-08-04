package com.primecredit.tool.common.wsobject.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpeechStatisticsRequest {
	private String clientMachineId;
	private long millisecond;
	private String sourceFileName;
	private List<String> speechTexts;
	
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
	public List<String> getSpeechTexts() {
		return speechTexts;
	}
	public void setSpeechTexts(List<String> speechTexts) {
		this.speechTexts = speechTexts;
	}
	public String getSourceFileName() {
		return sourceFileName;
	}
	public void setSourceFileName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}

}
