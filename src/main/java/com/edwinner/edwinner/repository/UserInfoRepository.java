package com.edwinner.edwinner.repository;

import com.edwinner.edwinner.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

}
