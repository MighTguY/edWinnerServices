package com.edwinner.edwinner.controller;


import com.edwinner.edwinner.model.User;
import com.edwinner.edwinner.model.UserData;
import com.edwinner.edwinner.model.UserInfo;
import com.edwinner.edwinner.model.UserSubscription;
import com.edwinner.edwinner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

  @Autowired
  UserService userService;
  private final AtomicLong counter = new AtomicLong();

  //Get user By ID
  @GetMapping("/get/user/{id}")
  public User getUser(@PathVariable("id") String userId) {
    return userService.getUserById(userId);
  }

  //GET ALL USERS BY LIMIT OFFSET
  @GetMapping("/get/users")
  public List<User> getAllUsers(
      @RequestParam(value = "to", defaultValue = "10") String to,
      @RequestParam(value = "from", defaultValue = "0") String from,
      @RequestParam(value = "role", defaultValue = "0") String role) {
    return userService.getUsers(to, from);
  }

  @GetMapping("/get/roleUsers")
  public List<User> getAllUsersByRole(
      @RequestParam(value = "role") String role) {
    return userService.getUserByRole(role);
  }

  //Add USER
  @RequestMapping(value = "/add/user", method = RequestMethod.POST)
  public User addUserSubscription(@RequestBody User user) {
    User userData = userService.add(user);
    return userData;
  }

  //UPDATE USER SUBSCRIPTION
  @PostMapping("/update/userSubscription")
  public String updateUserSubscription(@RequestBody UserSubscription userSubscription) {
    userService.update(userSubscription);
    return "success";
  }

  @GetMapping("/unsub/{id}")
  public String unsubscribeUser(@PathVariable("id") String id) {
    User user = userService.getUserById(id);
    user.getUserSubscription().setActive(0);
    user.getUserSubscription().setEmailConfirmation(0);
    userService.update(user.getUserSubscription());
    return "success";
  }

  @GetMapping("/sub/{id}")
  public String unsubscribeUser(@PathVariable("id") String id, @RequestParam(value = "hash") String hash) {
    User user = userService.getUserById(id);
    user.getUserSubscription().setActive(1);
    user.getUserSubscription().setEmailConfirmation(1);
    userService.update(user.getUserSubscription());
    return "success";
  }

  @GetMapping("/payment_sub/{id}")
  public String subscribePaymentUser(@PathVariable("id") String id) {
    User user = userService.getUserById(id);
    user.getUserSubscription().setActive(1);
    user.getUserSubscription().setPaymentConfirmation(1);
    userService.update(user.getUserSubscription());
    return "success";
  }


  @GetMapping("/payment_unsub/{id}")
  public String unsubscribePaymentUser(@PathVariable("id") String id) {
    User user = userService.getUserById(id);
    user.getUserSubscription().setActive(0);
    user.getUserSubscription().setPaymentConfirmation(0);
    userService.update(user.getUserSubscription());
    return "success";
  }



  //UPDATE USER INFO
  @PostMapping("/update/userInfo")
  public String updateUserSubscription(@RequestBody UserInfo userInfo) {
    userService.update(userInfo);
    return "success";
  }

  //UPDATE USER DATA
  @PostMapping("/update/userData")
  public String updateUserSubscription(@RequestBody UserData userData) {
    userService.update(userData);
    return "success";
  }

  //DELETE USER
  @DeleteMapping("/delete/user/{id}")
  public String deleteUserId(@PathVariable("id") String userId) {
    userService.delete(userId);
    return "success";
  }

  @GetMapping("/updateCheckpoint/{id}")
  public String checkPoint(@PathVariable("id") String id,
                           @RequestParam("cpoint") String cpoint) {
    User user = userService.getUserById(id);
    user.getUserData().setCheckPoint(Integer.parseInt(cpoint));
    user.getUserData().setDaysLeft(user.getUserData().getDaysLeft()-1);
    userService.update(user.getUserData());
    return "success";
  }
}
