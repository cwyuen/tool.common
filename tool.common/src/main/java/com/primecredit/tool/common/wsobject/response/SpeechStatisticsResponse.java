package com.primecredit.tool.common.wsobject.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpeechStatisticsResponse {
	private String clientMachineId;
	private long millisecond;
	private String sourceFileName;
	private String returnCode;
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
	public String getSourceFileName() {
		return sourceFileName;
	}
	public void setSourceFileName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
}
