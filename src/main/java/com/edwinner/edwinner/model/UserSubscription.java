package com.edwinner.edwinner.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="USER_SUBSCRIBED")
public class UserSubscription {

  @Id
  @Column(name="id")
  int id;

  @Column(name="EMAIL_CONFIRM")
  int emailConfirmation;

  @Column(name="PAYMENT_CONFIRM")
  int paymentConfirmation;

  @Column(name="ACTIVE")
  int active;

  @Column(name="user_id")
  int userId;
}
