package com.sbbi.manager.parser;

public class EnsemblParser {

	private static final int GENE_ID = 0;
	private static final int TRANSCRIPT_ID = 2;
	private static final int GENE_NAME = 4;
	
	public static String getGeneId(String line) {
		String query[] = line.split(";");
		String result[] = query[GENE_ID].trim().split(" ");
		String finalResult = result[1].replaceAll("\"", "").trim();
		
		return finalResult;
	}

	public static String getTranscriptId(String line) {
		String query[] = line.split(";");
		String result[] = query[TRANSCRIPT_ID].trim().split(" ");
		String finalResult = result[1].replaceAll("\"", "").trim();
		
		return finalResult;
	}

	public static String getGeneName(String line) {
		String query[] = line.split(";");
		String result[] = query[GENE_NAME].trim().split(" ");
		String finalResult = result[1].replaceAll("\"", "").trim();
		
		return finalResult;
	}

}
