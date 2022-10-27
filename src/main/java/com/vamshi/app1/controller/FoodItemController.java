package com.vamshi.app1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import com.vamshi.app1.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Map;
import com.vamshi.app1.model.FoodItem;
import com.vamshi.app1.repository.FoodItemRepository;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class FoodItemController {
	@Autowired
	private FoodItemRepository fooditemRepository;

	@GetMapping("/fooditems")
	public List<FoodItem> getAllFoodItems() {
		return fooditemRepository.findAll();
	}

	@PostMapping("/fooditems")
	public FoodItem createfoodItem(@RequestBody FoodItem fooditem) {
		return fooditemRepository.save(fooditem);
	}

	@GetMapping("/fooditems/{id}")
	public ResponseEntity<FoodItem> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {
		FoodItem fooditem = fooditemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(fooditem);
	}

	@PutMapping("/fooditems/{id}")
	public ResponseEntity<FoodItem> updateFoodItem(@PathVariable Long id, @RequestBody FoodItem fooditemDetails) {
		FoodItem fooditem = fooditemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Food Item not exist with id :" + id));
		fooditem.setfName(fooditemDetails.getfName());
		fooditem.setfPrice(fooditemDetails.getfPrice());
		fooditem.setfQuantity(fooditemDetails.getfQuantity());
		FoodItem updatedFoodItem = fooditemRepository.save(fooditem);
		return ResponseEntity.ok(updatedFoodItem);
	}

	@DeleteMapping("/fooditems/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
		FoodItem fooditem = fooditemRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("FoodItem not exist with id :" + id));
		fooditemRepository.delete(fooditem);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
