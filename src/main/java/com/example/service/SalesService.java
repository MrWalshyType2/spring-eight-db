package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.ValidationException;
import com.example.model.Sale;
import com.example.repository.SalesRepo;


@Service
public class SalesService {

	@Autowired
	SalesRepo salesRepo;
	
	public void createSale() {
		Sale s = new Sale();
		
		s.setProductName("Coke");
		s.setQuantity(12);
		salesRepo.save(s);
	}
	
	public String deleteRecord(int id) {
		Optional<Sale> record = salesRepo.findById(id);
		
		if (record.isPresent()) {
			salesRepo.deleteById(id);
			return "Deleted";
		}
		return "Failed to delete";
	}
	
	public Sale addRecord(Sale sale) {
		return salesRepo.save(sale);
	}
	
	public Sale getRecord(int id) {
		Optional<Sale> record = salesRepo.findById(id);
		
		if (record.isPresent()) {
			return record.get();
		}
		throw new ValidationException("Sale record not found");
	}
	
	public List<Sale> getAllRecords() {
		return salesRepo.findAll();
	}
	
	public Sale updateRecord(Sale sale) {
		Optional<Sale> record = salesRepo.findById(sale.getSalesId());
		
		if (record.isPresent()) {
			Sale dbSale = record.get();
			dbSale.setProductName(sale.getProductName());
			dbSale.setProductId(sale.getProductId());
			dbSale.setQuantity(sale.getQuantity());
			dbSale.setPrice(sale.getPrice());
			
			return salesRepo.save(dbSale);
		}
		throw new ValidationException("Sale record does not exist...");
	}
}
