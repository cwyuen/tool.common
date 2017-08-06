package com.primecredit.tool.common.wsobject.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.primecredit.tool.common.wsobject.BaseWsObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpeechStatisticsResponse extends BaseWsObject{
	
	private String sourceFileName;

	public String getSourceFileName() {
		return sourceFileName;
	}
	public void setSourceFileName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}

}
