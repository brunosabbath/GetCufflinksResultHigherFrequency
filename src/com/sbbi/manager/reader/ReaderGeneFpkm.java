package com.sbbi.manager.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sbbi.model.GeneFpkm;

public class ReaderGeneFpkm {

	public static HashMap<String, GeneFpkm> read(String input) {
		
		FileReader fileReader;
		HashMap<String, GeneFpkm> hash = new HashMap<String, GeneFpkm>();

		try {
			fileReader = new FileReader(input);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";

			line = bufferedReader.readLine();// remove header for genes.fpkm_tracking

			while ((line = bufferedReader.readLine()) != null) {
				
				String query[] = line.split("\t");
				String transctiptId = query[6];
				String frequency = query[9];
				
				if(frequency.charAt(0) != '0'){
					GeneFpkm g = new GeneFpkm(transctiptId, frequency);
					hash.put(g.getIdSimple(), g);
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
