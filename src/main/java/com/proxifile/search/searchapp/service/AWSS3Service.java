package com.proxifile.search.searchapp.service;

import java.io.InputStream;

public interface AWSS3Service {

	public InputStream downloadFile(final String keyName);
}
