package com.edwinner.edwinner.service;


import com.edwinner.edwinner.model.User;
import com.edwinner.edwinner.model.UserData;
import com.edwinner.edwinner.model.UserInfo;
import com.edwinner.edwinner.model.UserSubscription;
import com.edwinner.edwinner.repository.UserDataRepository;
import com.edwinner.edwinner.repository.UserInfoRepository;
import com.edwinner.edwinner.repository.UserSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Component
public class UserService {

  @Autowired
  private UserInfoRepository userInfoRepository;

  @Autowired
  private UserDataRepository userDataRepository;

  @Autowired
  private UserSubscriptionRepository userSubscriptionRepository;

  public User getUserById(String id) {
    User user = new User();
    user.setUserInfo(userInfoRepository.findById(Integer.parseInt(id)).get());
    user.setUserData(userDataRepository.findByuserId(Integer.parseInt(id)));
    user.setUserSubscription(userSubscriptionRepository.findByuserId(Integer.parseInt(id)));
    return  user;
  }

  public long getUserCount() {
    return userDataRepository.count();
  }

  public List<User> getUsers(String to, String from) {
    List<User> user = new ArrayList<>();

    List<UserInfo> userInfos = userInfoRepository.findAll();
    userInfos.stream().forEach(userInfo -> {
      User us = new User();
      us.setUserInfo(userInfo);
      us.setUserData(userDataRepository.findByuserId(userInfo.getId()));
      us.setUserSubscription(userSubscriptionRepository.findByuserId(userInfo.getId()));
      user.add(us);
    });
    return  user;
  }

  public void update(UserSubscription userSubscription) {
    userSubscriptionRepository.save(userSubscription);
  }

  public void update(UserData userData) {
    userDataRepository.save(userData);
  }

  public void update(UserInfo userInfo) {
    userInfoRepository.save(userInfo);
  }

  public User getUserByEmail(String email) {
    User user = new User();
    Optional<UserInfo> info = userInfoRepository.findUserByEmail(email);
    if(!info.isPresent()) {
      return null;
    }
    user.setUserInfo(info.get());
    user.setUserData(userDataRepository.findByuserId(user.getUserInfo().getId()));
    user.setUserSubscription(userSubscriptionRepository.findByuserId(user.getUserInfo().getId()));
    return  user;
  }

  @Transactional
  public void delete(String id) {
    userInfoRepository.deleteById(Integer.parseInt(id));
    userDataRepository.deleteByuserId(Integer.parseInt(id));
    userSubscriptionRepository.deleteByuserId(Integer.parseInt(id));
  }

  public User add(User user) {
    UserInfo userInfo = userInfoRepository.save(user.getUserInfo());
    user.getUserData().setUserId(userInfo.getId());
    user.getUserSubscription().setUserId(userInfo.getId());
    userDataRepository.save(user.getUserData());
    userSubscriptionRepository.save(user.getUserSubscription());
    return user;
  }

  public List<User> getUserByRole(String role) {
    List<UserData> userData = userDataRepository.findByRoleAnddaysLeft(Integer.parseInt(role),1);
    List<User> users = new ArrayList<>();
    userData.stream().forEach(userData1 -> {
      User user = new User();
      user.setUserInfo(userInfoRepository.findById(userData1.getUserId()).get());
      user.setUserData(userData1);
      user.setUserSubscription(userSubscriptionRepository.findByuserId(userData1.getUserId()));
      userData1.setDaysLeft(userData1.getDaysLeft()-1);
      userDataRepository.save(userData1);
      users.add(user);
    });
    return users;
  }

  public boolean updatePassword(String userId, String pass) {
    UserInfo userInfo = userInfoRepository.findById(Integer.parseInt(userId)).get();
    userInfo.setPassword(pass);
    userInfoRepository.save(userInfo);
    return true;
  }

  @Transactional
  public boolean updateRole(String userId, String role) {
    UserInfo userInfo = userInfoRepository.findById(Integer.parseInt(userId)).get();
    userInfo.setRole(Integer.valueOf(role));
    userInfoRepository.save(userInfo);
    UserData userData = userDataRepository.findByuserId(Integer.parseInt(userId));
    userData.setRole(Integer.valueOf(role));
    userDataRepository.save(userData);
    return true;
  }
}
