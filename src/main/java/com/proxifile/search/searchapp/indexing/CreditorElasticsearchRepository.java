package com.proxifile.search.searchapp.indexing;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.proxifile.search.searchapp.dao.IRepository;
import com.proxifile.search.searchapp.entity.Creditor;

public interface CreditorElasticsearchRepository extends ElasticsearchRepository<Creditor, String>, IRepository<Creditor> {

}
