package com.cts.rs.ws.dao;

import java.util.List;

import com.cts.rs.ws.dto.Consumer;

public interface BillingDao {

	public Consumer create(Consumer consumer);
	
	public List<Consumer> findAll();
	
	public Consumer findById(int id);
	
	public Consumer deleteById(int id);
	
	public Consumer update(Consumer consumer);
	
	public int calculateCost(int id);
}
