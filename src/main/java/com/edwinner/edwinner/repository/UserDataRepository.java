package com.edwinner.edwinner.repository;


import com.edwinner.edwinner.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserDataRepository  extends JpaRepository<UserData, Integer> {
  UserData findByuserId(int userId);
  List<UserData> deleteByuserId(int userId);

  @Query(
      value = "SELECT * FROM user_data t where t.role = :role AND t.days_left > :days_left",
      nativeQuery=true
  )
  public List<UserData> findByRoleAnddaysLeft(@Param("role") int role,
                                                      @Param("days_left") int days_left);
}
