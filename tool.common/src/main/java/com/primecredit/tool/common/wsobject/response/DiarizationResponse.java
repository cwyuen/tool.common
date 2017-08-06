package com.primecredit.tool.common.wsobject.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.primecredit.tool.common.domain.DiarizationSpeech;
import com.primecredit.tool.common.wsobject.BaseWsObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DiarizationResponse extends BaseWsObject {

	private List<DiarizationSpeech> dsList = new ArrayList<>();
	
	public List<DiarizationSpeech> getDsList() {
		return dsList;
	}
	public void setDsList(List<DiarizationSpeech> dsList) {
		this.dsList = dsList;
	}
	
}
