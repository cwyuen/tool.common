package com.primecredit.tool.common.wsobject.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.primecredit.tool.common.domain.NaturaLangEntry;
import com.primecredit.tool.common.wsobject.BaseWsObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NaturalLangRequest extends BaseWsObject{
	private String input;
	private String sourceFile; 
	private int line; 
	private NaturaLangEntry entry;

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
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

	public NaturaLangEntry getEntry() {
		return entry;
	}

	public void setEntry(NaturaLangEntry entry) {
		this.entry = entry;
	}
}
