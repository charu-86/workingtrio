package com.workingtrio.workingtrio.repository;

import com.workingtrio.workingtrio.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacilityRepository extends JpaRepository<Facility,Long>{

//    Optional<List<Facility>> findBy

}
