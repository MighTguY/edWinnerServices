package com.edwinner.edwinner.controller;

import com.edwinner.edwinner.model.ExtraData;
import com.edwinner.edwinner.model.Word;
import com.edwinner.edwinner.service.WordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1")
public class WordController {

  @Autowired
  WordService wordService;
  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  //GET ALL WORDS LIMTI OFFSET
  @GetMapping("/get/words")
  public List<Word> getAllWords(
      @RequestParam(value = "to", defaultValue = "10") String to,
      @RequestParam(value = "from", defaultValue = "0") String from) {
    return wordService.getWords(to, from);
  }

  //GET WORD FOR ID
  @GetMapping("/get/word/{id}")
  public Word getUser(@PathVariable("id") String id) {
    return wordService.getWordByID(id);
  }

  //GET EXTRA DETAILS FOR TODAYS DATE
  @GetMapping("/get/extraword/{id}")
  public ExtraData getExtraWord(@PathVariable("id") String id) {
    return wordService.getExtraData(id);
  }

  @GetMapping("/get/extrawords")
  public List<ExtraData> getUser(
      @RequestParam(value = "to", defaultValue = "10") String to,
      @RequestParam(value = "from", defaultValue = "0") String from) {
    return wordService.getExtraDatas(to, from);
  }

  // ADD WORD
  @PostMapping("/add/word")
  public void addWord(@RequestBody  Word newWord) {
    wordService.addWord(newWord);
  }

  // ADD EXTRA DETAILS
  @PostMapping("/add/extraword")
  public void addExtraDetails(@RequestBody ExtraData newWord) {
    wordService.addExtraData(newWord);
  }

  //UPDATE EXTRA DETAILS BY ID
  @PostMapping("/update/word")
  public void updateExtraDetails(@RequestBody Word newWord) {
    wordService.addWord(newWord);
  }

  //UPDATE WORD BY ID
  @PostMapping("/update/extraword")
  public void updateWord(@RequestBody ExtraData newWord) {
    wordService.addExtraData(newWord);
  }


  // DELETE WORD BY ID
  @DeleteMapping("/delete/word/{id}")
  public void deleteWord(@PathVariable("id") String wordId) {
    wordService.deleteWordById(wordId);
  }


  // DELETE EXTRA WORD
  @DeleteMapping("/delete/extraword/{id}")
  public void deleteExtraWprd(@PathVariable("id") String extraId) {
    wordService.deleteExtraDataById(extraId);
  }

  //GET revision
  @GetMapping("/get/revisionWords/{id}")
  public List<Word> getRevisonWords(@PathVariable("id") String extraId, @RequestParam("role") String role) {
    return wordService.getWordByLessIDlast3(extraId,role);
  }

  //GET revision
  @GetMapping("/get/revisionMonthWords/{id}")
  public List<Word> getRevisonMonthWords(@PathVariable("id") String extraId, @RequestParam("role") String role, @RequestParam
      (value= "from", defaultValue = "0") String from) {
    return wordService.getLastMonthWordByLessIDlast2(extraId,role,from);
  }


  //GET CHECKPOINT
  @GetMapping("/get/word/checkpoint/{id}")
  public Word getWordForCheckPoint(@PathVariable("id") String id, @RequestParam("role") String role) {
    return wordService.getWordByCheckPoint(id,role);
  }
}
