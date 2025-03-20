package com.ece.backend.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ece.backend.models.DataSet;

/*
 * DataSetrepo is the repository interface for the DataSet entity.
 * It extends JpaRepository to provide CRUD operations for DataSet entities.
 * Additionally, it contains a custom query method to retrieve data based on the userId.
 */

@Repository
public interface DataSetrepo extends JpaRepository<DataSet,Long> {
    // * Custom query method to retrieve a list of DataSet entries based on the userId.
    // * The userId is expected to be in a format that includes a date portion (e.g., yyyyMMdd).
    @Query(value = "SELECT * FROM DATA_SET WHERE USER_ID like ?1%", nativeQuery = true)
    List<DataSet> findByDate(String id);
    @Query(value = "SELECT * FROM DATA_SET ORDER BY USER_ID DESC LIMIT 1", nativeQuery = true)
    DataSet findLastData();
}
