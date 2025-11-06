package com.casemanagement.system.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class client {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long clientId;

  private String firstName;
  private String lastName;
  private String email;
  private String Address;

  // clientcase should be here
  @ManyToMany(mappedBy = "clients", cascade = CascadeType.ALL)
  private Set<ClientCase> ClientCases = new HashSet<ClientCase>();

  public Set<ClientCase> getClientCases() {
    return ClientCases;
  }

  public void setClientCases(Set<ClientCase> clientCases) {
    ClientCases = clientCases;
  }

  public client(String firstName, String lastName, String email, String address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    Address = address;
  }

  public client() {

  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long id) {
    this.clientId = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return Address;
  }

  public void setAddress(String address) {
    Address = address;
  }

}
