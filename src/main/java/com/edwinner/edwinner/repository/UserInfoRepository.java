package com.edwinner.edwinner.repository;

import com.edwinner.edwinner.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

  @Query(
      value = "SELECT * FROM user_info t where t.email = :id",
      nativeQuery=true)
  public Optional<UserInfo>  findUserByEmail(@Param("id") String id);

}
