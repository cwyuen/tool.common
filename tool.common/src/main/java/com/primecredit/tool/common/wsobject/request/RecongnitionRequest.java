package com.primecredit.tool.common.wsobject.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.primecredit.tool.common.wsobject.BaseWsObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecongnitionRequest extends BaseWsObject{
	
	private byte[] fileData;
	
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	
	
}
