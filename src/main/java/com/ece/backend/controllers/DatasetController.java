package com.ece.backend.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ece.backend.models.DataSet;
import com.ece.backend.repositories.DataSetrepo;

/*
 * DatasetController handles API requests related to the data readings.
 * Provides endpoints for retrieving data, filtering by date, 
 * adding new data, and deleting data entries based on ID.
 */
@RestController
@RequestMapping("/api/data")
public class DatasetController {
    // JPA repository for query management
    @Autowired
    DataSetrepo repo;

    // Provides origins to handle cors in testing and production
    @CrossOrigin(origins = {"http://localhost:5501","http://raspi.local","https://raspi.local"})
    // * Retrieves all available data entries from the database.
    @GetMapping("/getall")
    public ResponseEntity<List<DataSet>> getall(){
        return new ResponseEntity<>( repo.findAll(),HttpStatus.OK);
    }

    @CrossOrigin(origins = {"http://localhost:5501","http://raspi.local","https://raspi.local"})
    // Provides individual data based on its id
    @GetMapping("/get/{id}")
    public ResponseEntity<DataSet> getById(@PathVariable Long id){
        // Checks for empty list to throw not found
        if (repo.count()>0){
            // checks for id exists or not in DB
            if (repo.existsById(id)) {
                return new ResponseEntity<>( repo.findById(id).get(),HttpStatus.OK);
            }
            else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = {"http://localhost:5501","http://raspi.local","https://raspi.local"})
    /* 
    * Filters data based on date in format yyyy-mm--dd
    *api is avialaible by /getBydate?date=yyyy-mm-dd
    */
    @GetMapping("/getByDate")
    public ResponseEntity<List<DataSet>> getByDate(@RequestParam String date){
        // converts yyyy-mm-dd format of date to yyyymmdd to better searching 
        // based on id which is yyyymmddHourMinSec
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date2 =LocalDate.parse(date.toString());
        String parsedDate=date2.format(formatter);
        return new ResponseEntity<>( repo.findByDate(parsedDate),HttpStatus.OK);
    }
    
    // This method is only used to add data into DB
    // its used by arduino to upload data
    // its simple postrequest at /add with json format of data
    @PostMapping("/add")
    public ResponseEntity<DataSet> adddata(@RequestBody DataSet data){
        DataSet dataSet=new DataSet();
        dataSet.setSpo2(data.getSpo2());
        dataSet.setUserId(data.getUserId());
        dataSet.setHeartrate(data.getHeartrate());
        System.out.println(dataSet);
        repo.save(dataSet);
        return new ResponseEntity<>(dataSet,HttpStatus.CREATED);
    }
    
    @CrossOrigin(origins = {"http://localhost:5501","http://raspi.local","https://raspi.local"})
    // this provides api to delete a particular data bassed on its id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletedata(@PathVariable Long id){
        // checks for existance of id in DB
         Boolean isExists=repo.existsById(id);
        if(isExists){
            DataSet data=repo.findById(id).get();
            repo.delete(data);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
