package com.proxifile.search.searchapp.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.proxifile.search.searchapp.entity.Creditor;

public class CSVHelper {
	
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "CREDITOR NAME",
			                    "ATTENTION(OPTIONAL)",
			                    "ADDRESS 1",
			                    "ADDRESS 2",
			                    "CITY",
			                    "STATE",
			                    "POSTAL ZIP" };

	public static boolean hasCSVFormat(MultipartFile file) {
	
		if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }
	
		return true;
	}
	
	public static List<Creditor> csvToCreditors(InputStream is) {
		try (
				BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

				List<Creditor> creditors = new ArrayList<Creditor>();
				Iterable<CSVRecord> csvRecords = csvParser.getRecords();
				for(CSVRecord csvRecord : csvRecords) {
					Creditor creditor = new Creditor(csvRecord.get("CREDITOR NAME"), 
	    			  						   		 csvRecord.get("ATTENTION(OPTIONAL)"), 
	    			  						   		 csvRecord.get("ADDRESS 1"), 
	    			  						   		 csvRecord.get("ADDRESS 2"), 
	    			  						   		 csvRecord.get("CITY"), 
	    			  						   		 csvRecord.get("STATE"),
	    			  						   		 csvRecord.get("POSTAL ZIP"));  

					creditors.add(creditor);
				}

				return creditors;
	    } catch (IOException e) {
	    	throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	}
}
