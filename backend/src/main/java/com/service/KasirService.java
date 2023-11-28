package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.KasirRepository;
import java.util.List;

import com.model.Kasir;

@Service
public class KasirService {
	@Autowired
	KasirRepository kasirRepository;
	
	public void addKasir(Kasir kasirRequest) {
		kasirRepository.save(kasirRequest);
	}

}
