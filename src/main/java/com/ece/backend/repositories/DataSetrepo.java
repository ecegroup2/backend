package com.ece.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ece.backend.models.DataSet;
@Repository
public interface DataSetrepo extends JpaRepository<DataSet,Integer> {

    
}
