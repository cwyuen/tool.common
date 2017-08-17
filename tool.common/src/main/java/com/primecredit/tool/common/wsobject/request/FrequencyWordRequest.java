package com.primecredit.tool.common.wsobject.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.primecredit.tool.common.wsobject.BaseWsObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FrequencyWordRequest extends BaseWsObject {
	private String text;
	private String sourceFile; 
	private int line;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSourceFile() {
		return sourceFile;
	}
	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	} 
}
