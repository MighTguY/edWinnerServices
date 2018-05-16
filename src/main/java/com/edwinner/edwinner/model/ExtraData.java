package com.edwinner.edwinner.model;

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
@Table(name = "WORD_EXTRA")
public class ExtraData {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  int id;
  @Column(name="ROLE")
  int role;
  @Column(name="DATA")
  String data;
  @Column(name="MESSAGE")
  String message;
  @Column(name="TYPE")
  String type;
  @Column(name="SEND_DATE")
  Date sendDate;
  @Column(name="CREATED")
  Date createdDate;

}
