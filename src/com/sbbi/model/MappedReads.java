package com.sbbi.model;

import java.util.List;

public class MappedReads {

	private List<String> reads;
	private String transcriptId;

	public MappedReads(List<String> reads, String transcriptId) {
		this.reads = reads;
		this.transcriptId = transcriptId;
	}

	public List<String> getRead() {
		return reads;
	}

	public void setRead(List<String> reads) {
		this.reads = reads;
	}

	public String getTranscriptId() {
		return transcriptId;
	}

	public void setTranscriptId(String transcriptId) {
		this.transcriptId = transcriptId;
	}
	
}
