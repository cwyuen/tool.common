package com.primecredit.tool.common.wsobject.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.primecredit.tool.common.wsobject.BaseWsObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpeechStatisticsRequest extends BaseWsObject{
	
	private String sourceFileName;
	private List<String> speechTexts;
	
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
