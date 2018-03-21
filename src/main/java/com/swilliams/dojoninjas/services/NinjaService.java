package com.swilliams.dojoninjas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.swilliams.dojoninjas.models.Ninja;
import com.swilliams.dojoninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private NinjaRepository nR;
	
	public NinjaService(NinjaRepository nR) {
		this.nR = nR;
	}
	
	public void create(Ninja ninja) {
		nR.save(ninja);
	}
	
	public ArrayList<Ninja> all(){
		return (ArrayList<Ninja>) nR.findAll();
	}
	
	public Optional<Ninja> find(Long id){
		return nR.findById(id);
	}
	
	public void delete(Long id) {
		nR.deleteById(id);
	}
	
	public void update(Ninja ninja) {
		nR.save(ninja);
	}
	
}
