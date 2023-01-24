package com.block.proj.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserProfileMapper;
import com.example.demo.model.UserProfile;

import com.block.proj.model.WalletDB;

public class WalletDBController {

	
	private Map<String, WalletDB> walletMap;
	
	@PostConstruct
	public void init() {
		walletMap = new HashMap<String, WalletDB>();
		walletMap.put("1", new WalletDB("1", "1", "1", "1", "1"));
	}
	
	@GetMapping("/WalletDB/{id}")
	public WalletDB getWalletDB(@PathVariable("ID") String ID) {
		return walletMap.get(ID);
	}
	
	@GetMapping("/WalletDB/all")
	public List<WalletDB> getWalletDBProfileList() {
		return mapper.getUserProfileList();
	}
	
	@PutMapping("/WalletDB/{id}")
	public void putWalletDBProfile(@PathVariable("ID") String id, @RequestParam("WalletName") String WalletName, @RequestParam("PublicKey") String PublicKey, @RequestParam("PrivateKey") String PrivateKey, @RequestParam("Address") String Address) {
		mapper.insertWalletDBProfile(ID, WalletName, PublicKey, PrivateKey, Address);
	}
	
	@PostMapping("/WalletDB/{id}")
	public void postWalletDBProfile(@PathVariable("ID") String id, @RequestParam("WalletName") String WalletName, @RequestParam("PublicKey") String PublicKey, @RequestParam("PrivateKey") String PrivateKey, @RequestParam("Address") String Address) {
		mapper.updateWalletDBProfile(ID, WalletName, PublicKey, PrivateKey, Address);
	}
	
	@DeleteMapping("/WalletDB/{id}")
	public void deleteWalletDBProfile(@PathVariable("ID") String ID) {
		mapper.deleteWalletDBProfile(ID);
	}

}
