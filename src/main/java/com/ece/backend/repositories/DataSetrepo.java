package com.ece.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ece.backend.models.DataSet;
@Repository
public interface DataSetrepo extends JpaRepository<DataSet,Long> {

    @Query(value = "SELECT * FROM DATA_SET WHERE USER_ID like ?1%", nativeQuery = true)
    List<DataSet> findByDate(String id);
}
