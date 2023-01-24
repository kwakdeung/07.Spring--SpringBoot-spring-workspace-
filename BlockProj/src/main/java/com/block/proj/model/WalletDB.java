package com.block.proj.model;



public class WalletDB {
	private String id;
	private String walletname;
	private String publicKey;
	private String privateKey;
	private String address;
	public WalletDB() {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWalletname() {
		return walletname;
	}

	public void setWalletname(String walletname) {
		this.walletname = walletname;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", walletname=" + walletname + ", publicKey=" + publicKey + ", privateKey=" + privateKey + ",  address=" + address + "]";
	}
	
}