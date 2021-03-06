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
      value = "SELECT * FROM word t where t.id <= :id  and role = :role limit 3",
      nativeQuery=true
  )
  List<Word> findByLessId(@Param("id") int id,@Param("role") int role);

  @Query(
      value = "SELECT * FROM word t where t.id > :id and role = :role order by id asc limit 1",
      nativeQuery=true
  )
  Word findTopByIdGreaterThanOrderByidAsc(@Param("id")  int id, @Param("role") int role);

  @Query(
      value = "SELECT * FROM word t where t.id <= :id and t.id > :from and role = :role and YEAR(created) = YEAR" +
          "(CURRENT_DATE - " +
          "INTERVAL 1 MONTH)\n" +
          "AND MONTH(created) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH) order by id asc limit 2",
      nativeQuery=true
  )
  List<Word> findByMonthLessId(@Param("id")  int id, @Param("role") int role, @Param("from") int from);

  @Query(
      value = "SELECT * FROM word t where  role = :role and YEAR(created) = YEAR(CURRENT_DATE - " +
          "INTERVAL 1 MONTH)\n" +
          "AND MONTH(created) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH) order by id asc limit 2",
      nativeQuery=true
  )
  List<Word> findByMonthLessIdDefault( @Param("role") int role);
}
