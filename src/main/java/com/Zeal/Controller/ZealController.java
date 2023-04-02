package com.Zeal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Zeal.Model.User;
import com.Zeal.Model.Zeal;
import com.Zeal.Service.ExternalApiService;
import com.Zeal.Service.ZealService;
import com.Zeal.Utils.ApiResponseReturn;

@RestController
@RequestMapping("/api")
public class ZealController {

	@Autowired
	private ZealService zealservice;
	
	@Autowired
	private ExternalApiService service;
	
	//this all about crud operation 
	
	@PostMapping("/")
	public ResponseEntity<Zeal> saveZealInDb(@RequestBody Zeal zeal){
		Zeal createZeal = this.zealservice.createZeal(zeal);
		return new ResponseEntity<Zeal>(createZeal,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Zeal>> getDataZeal(){
		List<Zeal> allZealData = this.zealservice.getAllZealData();
		return new ResponseEntity<List<Zeal>>(allZealData,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Zeal> getDataZeal(@PathVariable int id){
		Zeal findByID = this.zealservice.findByID(id);
		return new ResponseEntity<>(findByID,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponseReturn> deleteById(@PathVariable int id){
		this.zealservice.delete(id);
		return new ResponseEntity<ApiResponseReturn>(new ApiResponseReturn("Deleted Successfully",true),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Zeal> updateZeal(@RequestBody Zeal zeal ,@PathVariable int id){
		Zeal findByID = this.zealservice.findByID(id);
		if(findByID==null) {
			return new ResponseEntity<Zeal>(findByID,HttpStatus.NOT_FOUND);
		}
		zeal.setId(id);
		Zeal createZeal = this.zealservice.createZeal(zeal);
		return new ResponseEntity<Zeal>(createZeal,HttpStatus.OK);
	}
	
	
	//this will return the external api endpoints use it
	
	@GetMapping("/api")
	public ResponseEntity<User> getUserData(){
	User consumeZealApi = this.service.consumeZealApi();
	return new ResponseEntity<User>(consumeZealApi,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getUserDataAll(){
	List<User> consumeZealUserApi = this.service.consumeZealUserApi();
	return new ResponseEntity<>(consumeZealUserApi,HttpStatus.OK);
	}
	
	
	
	
	
	
}
