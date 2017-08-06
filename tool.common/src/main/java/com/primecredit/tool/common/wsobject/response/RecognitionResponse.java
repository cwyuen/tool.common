package com.primecredit.tool.common.wsobject.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.primecredit.tool.common.wsobject.BaseWsObject;
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecognitionResponse extends BaseWsObject{
	
	List<String> speechTextList;
	
	public List<String> getSpeechTextList() {
		return speechTextList;
	}
	public void setSpeechTextList(List<String> speechTextList) {
		this.speechTextList = speechTextList;
	}
	
}
