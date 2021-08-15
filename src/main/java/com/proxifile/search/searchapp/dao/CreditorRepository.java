package com.proxifile.search.searchapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proxifile.search.searchapp.entity.Creditor;

public interface CreditorRepository extends JpaRepository<Creditor, Integer>, IRepository<Creditor> {

}
