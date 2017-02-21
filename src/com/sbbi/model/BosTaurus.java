package com.sbbi.model;

public class BosTaurus {

	private String geneId;
	private String transcriptId;
	private String geneName;

	public BosTaurus(String geneId, String transcriptId, String geneName) {
		this.geneId = geneId;
		this.transcriptId = transcriptId;
		this.geneName = geneName;
	}

	public String getGeneId() {
		return geneId;
	}
	public void setGeneId(String geneId) {
		this.geneId = geneId;
	}
	public String getTranscriptId() {
		return transcriptId;
	}
	public void setTranscriptId(String transcriptId) {
		this.transcriptId = transcriptId;
	}
	public String getGeneName() {
		return geneName;
	}
	public void setGeneName(String geneName) {
		this.geneName = geneName;
	}
	
}
