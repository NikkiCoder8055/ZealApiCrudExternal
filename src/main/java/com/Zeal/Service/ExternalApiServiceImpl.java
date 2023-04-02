package com.Zeal.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Zeal.Model.User;
import com.Zeal.Repo.UserRepository;

@Service
public class ExternalApiServiceImpl implements ExternalApiService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserRepository repository;

	@Override
	public User consumeZealApi() {
		User forObject = this.restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1",User.class);
		User save = this.repository.save(forObject);
		return save;
	}
	public List<User> consumeZealUserApi(){
		ResponseEntity<User[]> respone = this.restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos",User[].class);
		User[] body = respone.getBody();
		List<User> saveAll = this.repository.saveAll(Arrays.asList(body));
		return saveAll;
		
	}

}
