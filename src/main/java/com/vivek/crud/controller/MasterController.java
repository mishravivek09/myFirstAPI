package com.vivek.crud.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.crud.exception.ResourceNotFoundException;
import com.vivek.crud.model.Master;
import com.vivek.crud.repository.MasterRepository;
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("api/v1")
public class MasterController {
	@Autowired
	private MasterRepository masterRepository;
	@GetMapping("/master")
	public List<Master> getMasterData(){
		return masterRepository.findAll();
	}
	@GetMapping("/master/{id}")
    public ResponseEntity<Master> getEmployeeById(@PathVariable(value = "id") Long masterId)
        throws ResourceNotFoundException {
        Master master = masterRepository.findById(masterId)
          .orElseThrow(() -> new ResourceNotFoundException("Data not found for this id :: " + masterId));
        return ResponseEntity.ok().body(master);
    }
	
	@PostMapping("/master")
    public Master createEmployee(@Validated @RequestBody Master master) {
        return masterRepository.save(master);
    }
	
	@PutMapping("/master/{id}")
    public ResponseEntity<Master> updateEmployee(@PathVariable(value = "id") Long masterId,
         @Validated @RequestBody Master masterData) throws ResourceNotFoundException {
        Master master = masterRepository.findById(masterId)
        .orElseThrow(() -> new ResourceNotFoundException("Data not found for this id :: " + masterId));

        master.setName(masterData.getName());
        master.setYear(masterData.getYear());
        master.setRating(masterData.getRating());
        master.setImgUrl(masterData.getImgUrl());
        master.setUrl(masterData.getUrl());
        final Master updatedMaster = masterRepository.save(master);
        return ResponseEntity.ok(updatedMaster);
    }
	
	@DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long masterId)
         throws ResourceNotFoundException {
        Master master = masterRepository.findById(masterId)
       .orElseThrow(() -> new ResourceNotFoundException("Data not found for this id :: " + masterId));

        masterRepository.delete(master);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
