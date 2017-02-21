package com.sbbi.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.sbbi.manager.reader.ReaderBosTaurus;
import com.sbbi.manager.reader.ReaderGeneFpkm;
import com.sbbi.manager.reader.ReaderMappedReads;
import com.sbbi.model.BosTaurus;
import com.sbbi.model.GeneFpkm;
import com.sbbi.model.GeneReads;
import com.sbbi.model.MappedReads;

public class Manager {

	public HashMap<String, GeneFpkm> readGenesFpkmTracking(String genesFpkm) {
		return ReaderGeneFpkm.read(genesFpkm);
	}

	public HashMap<String, BosTaurus> readBosTaurus(String bosTaurusPath) {
		return ReaderBosTaurus.read(bosTaurusPath);
	}

	public HashMap<String, MappedReads> readMappedReads(String mappedReadsPath) {
		return ReaderMappedReads.read(mappedReadsPath);
	}

	public HashMap<String, GeneReads> readBosTaurusGenes(String bosTaurusPath) {
		return ReaderBosTaurus.readGetGene(bosTaurusPath);
	}
	
	
	
	
	public void write(HashMap<String, GeneFpkm> hashGeneFpkm, HashMap<String, BosTaurus> hashBosTaurus, HashMap<String, GeneReads> hashBosTaurusGene, HashMap<String, MappedReads> hashMappedReads2, String output) {

		try{
		    PrintWriter writer = new PrintWriter(output);
		    
		    writer.println("ID;Reads;Frequency;Mean;Count");
		    
		    HashMap<String, Integer> hashCount = new HashMap<String, Integer>();
		    
		    for(GeneFpkm gene : hashGeneFpkm.values()){
		    	
		    	String id = gene.getIdSimple();
		    	String frequency = gene.getFrequency();
		    	BosTaurus bosTaurus = hashBosTaurus.get(id);
		    	
		    	if(bosTaurus != null){
		    		
		    		String geneName = bosTaurus.getGeneName();
		    		
		    		if(hashCount.containsKey(geneName)){//if already have this records
		    			int counterGene = hashCount.get(geneName);
		    			counterGene++;
		    			hashCount.put(geneName, counterGene);
		    		}
		    		else{//first time seeing it
		    			hashCount.put(geneName, 1);
		    		}
		    		
		    		
		    		GeneReads geneReads = hashBosTaurusGene.get(geneName);
		    		
		    		String allTransciptsIds = "";
		    		String allFrequencies = "";
		    		
		    		int countReads = 0;
		    		Double sum = new Double(0), mean = new Double(0);
		    		
		    		for(String s : geneReads.getReads()){//check and get frequencies from hashGeneFpkm
		    			
		    			if(hashGeneFpkm.containsKey(s)){//if I have this read, get frequency
		    				GeneFpkm geneFpkm = hashGeneFpkm.get(s);
		    				//System.out.println(geneFpkm.getFrequency());
		    				allTransciptsIds = allTransciptsIds + geneFpkm.getId() + "|";
		    				allFrequencies = allFrequencies + geneFpkm.getFrequency() + "|";
		    				countReads++;
		    				
		    				double d = Double.parseDouble(geneFpkm.getFrequency());
		    				NumberFormat formatter = new DecimalFormat("###.#####");
		    				
		    				String formattedScientific = formatter.format(d);
		    				Double formattedScientificDouble = Double.parseDouble(formattedScientific);
		    				
		    				sum += formattedScientificDouble;
		    			}
		    			
		    			
		    		}
		    		
		    		mean = sum/countReads;
		    		
		    		writer.println(bosTaurus.getGeneName() + ";" + allTransciptsIds + ";" + allFrequencies + ";" + mean + ";" + hashCount.get(geneName));
		    	}
		    	else{//not found on Bos_taurus
		    		//System.out.println("not found: " + id);
		    	}
		    	
		    }
		    
		    writer.close();
		    
		} catch (IOException e) {
		   System.out.println(e.getMessage());
		}
		
	}

}
