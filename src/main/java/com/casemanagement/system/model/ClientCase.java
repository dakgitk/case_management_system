package com.casemanagement.system.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;

@Entity
public class ClientCase {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long caseId;

  private String caseNumber;
  private String title;
  private String description;
  private LocalDate courtDate;

  // have to add client to here .
  @ManyToMany
  @JoinTable(name = "client_case_link", joinColumns = @JoinColumn(name = "caseId"), inverseJoinColumns = @JoinColumn(name = "clientId"))
  private Set<client> clients = new HashSet<client>();

  public Set<client> getClients() {
    return clients;
  }

  public void setClients(Set<client> clients) {
    this.clients = clients;
  }
//added type here
  @ManyToOne
  @JoinColumn(name = "typeid")
  private CaseType type;

  public CaseType getType() {
    return type;
  }

  public void setType(CaseType type) {
    this.type = type;
  }

  public ClientCase(String caseNumber, String title, String description, CaseType type) {
    this.caseNumber = caseNumber;
    this.title = title;
    this.description = description;
    this.type = type;
  }

  public ClientCase() {

  }

  public Long getCaseId() {
    return caseId;
  }

  public void setCaseId(Long id) {
    this.caseId = id;
  }

  public String getCaseNumber() {
    return caseNumber;
  }

  public void setCaseNumber(String caseNumber) {
    this.caseNumber = caseNumber;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getCourtDate() {
    return courtDate;
  }

  public void setCourtDate(LocalDate courtDate) {
    this.courtDate = courtDate;
  }

}
