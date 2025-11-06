package com.casemanagement.system.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class CaseType {         // this class is to show what type of a leagl matter is i.e criminal or civil.

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long typeid;
  private String caseType;  

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
  private List<ClientCase> clientcases;


   public CaseType(String caseType) {
    this.caseType = caseType;
  }
  
  public CaseType() {
  }


  public List<ClientCase> getClientcases() {
    return clientcases;
  }

  public void setClientcases(List<ClientCase> clientcases) {
    this.clientcases = clientcases;
  }

 

  public String getCaseType() {
    return caseType;
  }

  public void setCaseType(String caseType) {
    this.caseType = caseType;
  }

  public Long getTypeid() {
    return typeid;
  }

  public void setTypeid(Long typeid) {
    this.typeid = typeid;
  }

}
