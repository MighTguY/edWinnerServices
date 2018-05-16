package com.edwinner.edwinner.controller;

import com.edwinner.edwinner.model.Stats;
import com.edwinner.edwinner.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1")
public class GreetingController {

  @Autowired
  private StatService statsService;
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/stats")
  public Stats getStats() {
    return statsService.getStats();
  }
}
