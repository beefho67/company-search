package com.proxifile.search.searchapp.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.proxifile.search.searchapp.dao.CreditorRepository;
import com.proxifile.search.searchapp.entity.Creditor;
import com.proxifile.search.searchapp.helper.CSVHelper;

@Service
public class CreditorServiceImpl implements CreditorService {

	@Autowired
	private AWSS3Service awsS3Service;
	@Autowired
	private CreditorRepository creditorRepository;
	@Value("${aws.s3.bucket.keyname}")
	private String keyName; 
	
	@Override
	public void massInsert() {
		
		try {
			InputStream inputStream = awsS3Service.downloadFile(keyName);
			List<Creditor> creditors = CSVHelper.csvToCreditors(inputStream);
			creditorRepository.saveAll(creditors);
		} catch (Exception e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
		
	}

}
