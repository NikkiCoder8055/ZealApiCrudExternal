package com.Zeal.Service;

import java.util.List;

import com.Zeal.Model.User;

public interface ExternalApiService {

	public User consumeZealApi();
	
	public List<User> consumeZealUserApi();

}
