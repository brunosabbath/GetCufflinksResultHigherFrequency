package com.sbbi.manager.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sbbi.manager.parser.EnsemblParser;
import com.sbbi.model.BosTaurus;
import com.sbbi.model.GeneReads;

public class ReaderBosTaurus {

	public static HashMap<String, BosTaurus> read(String input) {
		FileReader fileReader;
		HashMap<String, BosTaurus> hash = new HashMap<String, BosTaurus>();

		try {
			fileReader = new FileReader(input);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";

			while ((line = bufferedReader.readLine()) != null) {

				if(line.split(";").length > 8 ){//otherwise skip, doesnt have transcript_biotype
					
					String query[] = line.split(";");
					
					String geneId = EnsemblParser.getGeneId(line);
					String transcriptId = EnsemblParser.getTranscriptId(line);
					String geneName = EnsemblParser.getGeneName(line);
					
					hash.put(transcriptId, new BosTaurus(geneId, transcriptId, geneName));
				}

			}

			bufferedReader.close();
			fileReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return hash;
	}

	public static HashMap<String, GeneReads> readGetGene(String input) {
		FileReader fileReader;
		HashMap<String, GeneReads> hash = new HashMap<String, GeneReads>();

		try {
			fileReader = new FileReader(input);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";

			while ((line = bufferedReader.readLine()) != null) {

				if(line.split(";").length > 8 ){//otherwise skip, doesnt have transcript_biotype
					
					String query[] = line.split(";");
					
					String geneId = EnsemblParser.getGeneId(line);
					String transcriptId = EnsemblParser.getTranscriptId(line);
					String geneName = EnsemblParser.getGeneName(line);
					
					if(hash.containsKey(geneName)){
						GeneReads geneReads = hash.get(geneName);
						List<String> reads = geneReads.getReads();
						reads.add(transcriptId);
						
						hash.put(geneName, new GeneReads(geneName, reads));
					}
					else{
						List<String> reads = new ArrayList<String>();
						reads.add(transcriptId);
						hash.put(geneName, new GeneReads(geneName, reads));
					}
					
				}

			}

			bufferedReader.close();
			fileReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return hash;
	}

}
