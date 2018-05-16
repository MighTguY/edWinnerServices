package com.edwinner.edwinner.repository;


import com.edwinner.edwinner.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WordRepository extends JpaRepository<Word, Integer> {

  List<Word> findByRole(int role);

  @Query(
      value = "SELECT * FROM word t where t.id < :id limit 3",
      nativeQuery=true
  )
  List<Word> findByLessId(@Param("id") int id);

  @Query(
      value = "SELECT * FROM word t where t.id > :id order by id asc limit 1",
      nativeQuery=true
  )
  Word findTopByIdGreaterThanOrderByidAsc(@Param("id")  int id);
}
