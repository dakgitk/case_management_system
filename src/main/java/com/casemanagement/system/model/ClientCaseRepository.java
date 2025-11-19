package com.casemanagement.system.model;

import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;



public interface  ClientCaseRepository  extends CrudRepository<ClientCase,Long>{

  @Transactional //added due to custom method
  void deleteByCaseNumber(String caseNumber); //cases are deleted using the case number than the case ID.

  @Transactional 
  ClientCase findByCaseNumber(String caseNumber);


}
