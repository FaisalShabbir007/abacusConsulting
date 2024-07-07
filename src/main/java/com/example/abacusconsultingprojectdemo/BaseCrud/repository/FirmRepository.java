package com.example.abacusconsultingprojectdemo.BaseCrud.repository;

import com.example.abacusconsultingprojectdemo.BaseCrud.entity.FirmModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FirmRepository extends JpaRepository<FirmModel,Integer> {

//    FirmModel findByFirmId(int id);
    FirmModel findByEmailAddress(String emailAddress);

    Optional<FirmModel> findByFirmId(int id);



}
