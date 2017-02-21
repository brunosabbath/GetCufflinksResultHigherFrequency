package com.sbbi;

import java.util.HashMap;

import com.sbbi.manager.Manager;
import com.sbbi.model.BosTaurus;
import com.sbbi.model.GeneFpkm;
import com.sbbi.model.GeneReads;
import com.sbbi.model.MappedReads;

public class App {

	public static void main(String[] args) {
		
		String file = "s3";
		
		/*String input = "/home/bsilva/Desktop/gene_result/less35/"+ file +"/mapped_reads.txt";
		String reference = "/home/bsilva/Desktop/gene_result/less35/Bos_taurus.UMD3.1.87.txt";
		String output = "/home/bsilva/Desktop/gene_result/less35/"+ file +"/support"+ file +".csv";*/
		
		String genesFpkmPath = "/home/bsilva/Desktop/gene_result/less35/"+ file +"/genes.fpkm_tracking";
		String bosTaurusPath = "/home/bsilva/Desktop/gene_result/less35/Bos_taurus.UMD3.1.87.txt";
		String mappedReadsPath = "/home/bsilva/Desktop/gene_result/less35/"+ file +"/mapped_reads_new.txt";
		String output = "/home/bsilva/Desktop/gene_result/less35/"+ file +"/report"+ file +".csv";
		
		Manager m = new Manager();
		
		HashMap<String, GeneFpkm> hashGeneFpkm = m.readGenesFpkmTracking(genesFpkmPath);
		HashMap<String, BosTaurus> hashBosTaurus = m.readBosTaurus(bosTaurusPath);
		HashMap<String, GeneReads> hashBosTaurusGene = m.readBosTaurusGenes(bosTaurusPath);
		HashMap<String, MappedReads> hashMappedReads = m.readMappedReads(mappedReadsPath);
		
		//System.out.println(hashBosTaurus.size());
		m.write(hashGeneFpkm, hashBosTaurus, hashBosTaurusGene, hashMappedReads,output);
		
	}
	
}
