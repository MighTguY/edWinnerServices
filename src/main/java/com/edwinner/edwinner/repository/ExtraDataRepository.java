package com.edwinner.edwinner.repository;

import com.edwinner.edwinner.model.ExtraData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExtraDataRepository extends JpaRepository<ExtraData, Integer> {
}
