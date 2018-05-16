package com.edwinner.edwinner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="USER_INFO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  int id;

  @Column(name="ROLE")
  int role;

  @Column(name="ISVALID")
  int isValid;

  @Column(name="NAME")
  String name;

  @Column(name="EMAIL")
  String email;

  @Column(name="MOBILE")
  String mobile;

  @Column(name="PASSWORD")
  String password;

  @Column(name="CREATED")
  Date createdDate;
}
