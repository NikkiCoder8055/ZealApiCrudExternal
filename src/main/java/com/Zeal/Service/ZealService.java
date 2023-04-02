package com.Zeal.Service;

import java.util.List;

import com.Zeal.Model.Zeal;

public interface ZealService {
	
	Zeal createZeal(Zeal zeal);
	
	List<Zeal> getAllZealData();
	
	Zeal findByID(int id);
	
	Zeal update(int id);
	
	void delete(int id);

}
