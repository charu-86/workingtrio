package com.workingtrio.workingtrio.repository;

import com.workingtrio.workingtrio.model.Biling;
import com.workingtrio.workingtrio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BilingRepository extends JpaRepository <Biling, Long>{
    Optional<List<Biling>> findByUserId(User user);
}
