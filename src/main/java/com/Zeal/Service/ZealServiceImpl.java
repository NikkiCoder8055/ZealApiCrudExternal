package com.Zeal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Zeal.Exceptions.ResourceNotFound;
import com.Zeal.Model.Zeal;
import com.Zeal.Repo.ZealRepository;

@Service
public class ZealServiceImpl implements ZealService {

	@Autowired
	private ZealRepository zealrepo;

	@Override
	public Zeal createZeal(Zeal zeal) {
		return this.zealrepo.save(zeal);
	}

	@Override
	public List<Zeal> getAllZealData() {
		return this.zealrepo.findAll();
	}

	@Override
	public Zeal findByID(int id) {
		Zeal findbyData = this.zealrepo.findById(id).orElseThrow(()->new ResourceNotFound("Zeal","Id", id));
		return findbyData;
	}

	@Override
	public Zeal update(int id) {
	   Zeal updateZeal = this.zealrepo.findById(id).orElseThrow(()->new ResourceNotFound("Zeal","Id",id));
		return updateZeal;
	}

	@Override
	public void delete(int id) {
	  Zeal deletethis = this.zealrepo.findById(id).orElseThrow(()->new ResourceNotFound("Zeal","Id",id));
	
	}
	
	
	
	

	
}
