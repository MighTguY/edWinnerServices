package com.edwinner.edwinner.service;


import com.edwinner.edwinner.model.ExtraData;
import com.edwinner.edwinner.model.Word;
import com.edwinner.edwinner.repository.ExtraDataRepository;
import com.edwinner.edwinner.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class WordService {

  @Autowired
  WordRepository wordRepository;
  @Autowired
  ExtraDataRepository extraDataRepository;

  public Word getWordByID(String id) {
    Word word = wordRepository.findById(Integer.parseInt(id)).get();
    return word;
  }

  public Word getWordByCheckPoint(String id) {
    Word word = wordRepository.findTopByIdGreaterThanOrderByidAsc(Integer.parseInt(id));
    return word;
  }


  public List<Word> getWordByLessIDlast3(String id) {
    List<Word> words = wordRepository.findByLessId(Integer.parseInt(id));
    return words;
  }

  public long getWordsCount() {
    return wordRepository.count();
  }

  public List<Word> getWords(String to, String from) {
    List<Word> words = wordRepository.findAll();
    return words;
  }

  public List<Word> getWordsByRole(String to, String from, String role) {
    List<Word> words = wordRepository.findByRole(Integer.parseInt(role));
    return words;
  }

  public List<ExtraData> getExtraDatas(String to, String from) {
    List<ExtraData> words = extraDataRepository.findAll();
    return words;
  }

//  public List<ExtraData> getExtraDatasByRole(String to, String from, String role) {
//    List<ExtraData> words = extraDataRepository.findAll();
//    return words;
//  }

  public ExtraData getExtraData(String id) {
    ExtraData word = extraDataRepository.findById(Integer.parseInt(id)).get();
    return word;
  }

  public ExtraData getExtraDataForDate(String date) {
    ExtraData word = null;
    return word;
  }

  public void addWord(Word word) {
    if(null == word.getCreatedOn()) {
      word.setCreatedOn(new Date());
    }
    wordRepository.save(word);
  }

  public void addExtraData(ExtraData word) {
    if(null == word.getCreatedDate()) {
      word.setCreatedDate(new Date());
    }
    extraDataRepository.save(word);
  }

  public void deleteExtraDataById(String extraId) {
    extraDataRepository.deleteById(Integer.parseInt(extraId));
  }

  public void deleteWordById(String wordId) {
    wordRepository.deleteById(Integer.parseInt(wordId));
  }
}
