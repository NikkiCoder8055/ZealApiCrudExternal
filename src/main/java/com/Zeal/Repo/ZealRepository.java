package com.Zeal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Zeal.Model.Zeal;

@Repository
public interface ZealRepository extends JpaRepository<Zeal, Integer> {

}
