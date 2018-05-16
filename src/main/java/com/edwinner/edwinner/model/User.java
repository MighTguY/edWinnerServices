package com.edwinner.edwinner.model;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;

import javax.persistence.Entity;

@Data

public class User {
  UserData userData;
  UserInfo userInfo;
  UserSubscription userSubscription;


}
