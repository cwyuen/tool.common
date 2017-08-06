package com.primecredit.tool.common.wsobject;

public class BaseWsObject {
	private String clientMachineId;
	private long millisecond;
	private boolean success;
	
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
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
