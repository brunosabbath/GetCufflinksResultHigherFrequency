package com.sbbi.model;

import java.util.List;

public class GeneReads {

	private String gene;
	private List<String> reads;

	public GeneReads(String gene, List<String> reads) {
		this.gene = gene;
		this.reads = reads;
	}

	public String getGene() {
		return gene;
	}

	public void setGene(String gene) {
		this.gene = gene;
	}

	public List<String> getReads() {
		return reads;
	}

	public void setReads(List<String> reads) {
		this.reads = reads;
	}
	
}
