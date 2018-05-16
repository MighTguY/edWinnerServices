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
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="USER_DATA")
public class UserData {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  int id;

  @Column(name="USERID")
  int userId;

  @Column(name="ROLE")
  int role;

  @Column(name="CHECKPOINT")
  int checkPoint;

  @Column(name="SUBSCRIPTION_TYPE")
  String subscriptionType;

  @Column(name="END_DATE")
  Date endDate;

  @Column(name="START_DATE")
  Date startDate;

  @Column(name="DAYS_TO_SEND")
  int daysToSend;

  @Column(name="DAYS_LEFT")
  int daysLeft;

  @Column(name="month_checkpoint")
  int monthlyCheckpoint;

}
