package com.edwinner.edwinner.service;

import com.edwinner.edwinner.model.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatService {

  @Autowired
  private  UserService userService;

  @Autowired
  private  WordService wordService;

  public Stats getStats() {
    Stats stat = new Stats();
    stat.setMembers(userService.getUserCount());
    stat.setNoOfWords(wordService.getWordsCount());
    stat.setMailSent(0);
    return stat;
  }
}
