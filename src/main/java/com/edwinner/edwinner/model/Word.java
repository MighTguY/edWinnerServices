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
@Table(name="WORD")
public class Word {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  int id;

  @Column(name="ROLE")
  int role;

  @Column(name="WORD")
  String word;

  @Column(name="MEANING")
  String meaning;

  @Column(name="EXAMPLE_BASIC")
  String example_basic;

  @Column(name="EXAMPLE_REVISION")
  String example_revision;

  @Column(name="CREATED")
  Date createdOn;

}
