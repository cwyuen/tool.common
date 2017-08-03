package com.primecredit.tool.common.wsobject.response;

import java.util.ArrayList;
import java.util.List;

import com.primecredit.tool.common.domain.DiarizationSpeech;

public class DiarizationResponse {
	private String clientMachineId;
	private long millisecond;
	private List<DiarizationSpeech> dsList = new ArrayList<>();
	
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
	public List<DiarizationSpeech> getDsList() {
		return dsList;
	}
	public void setDsList(List<DiarizationSpeech> dsList) {
		this.dsList = dsList;
	}
}
