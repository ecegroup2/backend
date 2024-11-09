package com.ece.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ece.backend.models.DataSet;
import com.ece.backend.repositories.DataSetrepo;


@RestController
@RequestMapping("/api/data")
public class DatasetController {
    @Autowired
    DataSetrepo repo;
    @GetMapping("/getall")
    public ResponseEntity<List<DataSet>> getall(){
        return new ResponseEntity<>( repo.findAll(),HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<DataSet> getById(@PathVariable Long id){
        if (repo.count()>0){
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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletedata(@PathVariable Long id){
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
