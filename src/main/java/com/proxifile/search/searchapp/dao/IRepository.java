package com.proxifile.search.searchapp.dao;

import java.util.List;

public interface IRepository<A> {

	List<A> findByCreditorName(String creditorName);
	
	List<A> findByCreditorNameContainingOrderByCreditorNameAsc(String creditorName);
	
	List<A> findByCreditorNameContainingOrderByCreditorNameDesc(String creditorName);
}
