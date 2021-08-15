package com.proxifile.search.searchapp.service;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;

@Service
public class AWSS3ServiceImpl implements AWSS3Service {

	@Autowired
    private AmazonS3 amazonS3;
    @Value("${aws.s3.bucket}")
    private String bucketName;
	
	@Override
	public InputStream downloadFile(String keyName) {
		
		S3Object s3object = amazonS3.getObject(bucketName, keyName);
		S3ObjectInputStream inputStream = s3object.getObjectContent();
		
		return inputStream;
	}

}
