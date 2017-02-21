package com.sbbi.manager.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sbbi.model.GeneFpkm;
import com.sbbi.model.MappedReads;

public class ReaderMappedReads {

	public static HashMap<String, MappedReads> read(String input) {
		
		FileReader fileReader;
		HashMap<String, MappedReads> hash = new HashMap<String, MappedReads>();

		try {
			fileReader = new FileReader(input);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";

			line = bufferedReader.readLine();// remove header for genes.fpkm_tracking

			while ((line = bufferedReader.readLine()) != null) {
				
				String query[] = line.split("\t");
				String read = query[0];
				String transcriptIdQuery = query[1];
				String transcriptId = transcriptIdQuery.split("\\.")[0];
				
				if(hash.containsKey(transcriptId)){
					MappedReads mappedReads = hash.get(transcriptId);
					List<String> list = mappedReads.getRead();
					list.add(read);
					
					mappedReads.setRead(list);
					
					hash.put(transcriptId, mappedReads);
				}
				else{
					List<String> list = new ArrayList<String>();
					list.add(read);
					MappedReads mappedReads = new MappedReads(list, transcriptId);
					hash.put(transcriptId, mappedReads);
					
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
