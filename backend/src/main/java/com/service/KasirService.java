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

	public List<Kasir> getAllKasir(){
		return kasirRepository.findAll();
	}

	public Kasir getKasirByKode(String kode_kasir) {
		return kasirRepository.getById(kode_kasir);
	}

	public void updateKasir(Kasir kasirRequest) {
		kasirRepository.save(kasirRequest);
	}
}
