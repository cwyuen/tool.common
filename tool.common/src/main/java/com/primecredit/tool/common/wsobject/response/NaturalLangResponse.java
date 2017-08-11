package com.primecredit.tool.common.wsobject.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.primecredit.tool.common.domain.NaturaLangEntry;
import com.primecredit.tool.common.wsobject.BaseWsObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NaturalLangResponse extends BaseWsObject{
	List<NaturaLangEntry> entites;

	public List<NaturaLangEntry> getEntites() {
		return entites;
	}

	public void setEntites(List<NaturaLangEntry> entites) {
		this.entites = entites;
	}
}
