package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.KasirService;
import com.model.Kasir;

@RestController
@CrossOrigin
public class KasirController {
	@Autowired
	KasirService kasirService;
	
	@PostMapping("/kasir/insert")
	public ResponseEntity<String> addKasir(@RequestBody Kasir kasirRequest){
        String nama = kasirRequest.getNama();
        kasirService.addKasir(kasirRequest);
		return ResponseEntity.ok("Kasir dengan nama " +nama+ " berhasil ditambahkan");
	}

	@GetMapping("/kasir")
	public List<Kasir> getAllKasir(){
		return kasirService.getAllKasir();
	}
	@PostMapping("/kasir/update")
	public ResponseEntity<String> updateKasir(@RequestBody Kasir kasirRequest){
		String nama = kasirService.getKasirByKode(kasirRequest.getKode_kasir()).getNama();
		kasirService.updateKasir(kasirRequest);
		return ResponseEntity.ok("Kasir dengan nama " + nama + " berhasil diupdate");
	}
	@DeleteMapping("/kasir/delete")
	public ResponseEntity<String> deleteKasir(@RequestParam String kode_kasir){
		String nama = kasirService.getKasirByKode(kode_kasir).getNama();
		kasirService.deleteKasir(kode_kasir);
		return ResponseEntity.ok("Kasir dengan nama " + nama + " berhasil dihapus");
	}

}
