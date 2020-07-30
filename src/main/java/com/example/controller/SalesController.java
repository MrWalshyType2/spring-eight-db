package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Sale;
import com.example.service.SalesService;

@CrossOrigin
@RestController
public class SalesController {
	
	SalesService service;
	
	public SalesController(SalesService service) {
		this.service = service;
	}
	
	@GetMapping("/get/all")
	public List<Sale> getAllRecords() {
		return service.getAllRecords();
	}
	
	@GetMapping("/get/{id}")
	public Sale getRecordById(@PathVariable int id) {
		return service.getRecord(id);
	}
	
	@PostMapping("/addRecord")
	public Sale addRecord(@RequestBody Sale sale) {
		return service.addRecord(sale);
	}
	
	@PutMapping("/updateRecord")
	public Sale updateRecord(@RequestBody Sale sale) {
		return service.updateRecord(sale);
	}

	@GetMapping("/deleteRecord/{id}")
	public String deleteRecord(@PathVariable int id) {
		return service.deleteRecord(id);
	}
}
