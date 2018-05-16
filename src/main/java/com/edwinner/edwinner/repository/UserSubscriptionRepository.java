package com.edwinner.edwinner.repository;


import com.edwinner.edwinner.model.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Integer> {
  UserSubscription findByuserId(int userId);
  List<UserSubscription> deleteByuserId(int userId);
}
