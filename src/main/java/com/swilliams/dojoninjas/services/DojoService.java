package com.swilliams.dojoninjas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.swilliams.dojoninjas.models.Dojo;
import com.swilliams.dojoninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private DojoRepository dR;
	
	public DojoService(DojoRepository dR) {
		this.dR = dR;
	}
	
	public void create(Dojo dojo) {
		dR.save(dojo);
	}
	
	public ArrayList<Dojo> all(){
		return (ArrayList<Dojo>) dR.findAll();
	}
	
	public Optional<Dojo> find(Long id){
		return dR.findById(id);
	}
	
	public void delete(Long id) {
		dR.deleteById(id);
	}
	
	public void update(Dojo dojo) {
		dR.save(dojo);
	}

}
