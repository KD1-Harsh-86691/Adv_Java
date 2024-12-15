package com.test.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entities.Teams;

public interface TeamDao extends JpaRepository<Teams, Long>{
	List<Teams> findAll();
}
