package com.jaewoong.board.DTO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountDTO implements IAccountDTO{

	private String id;
	private String password;
	private String name;
	private String phoneNumber;
	private Date birth;
	private String address;
	

	public RegistAccountDTO Swappping(){
		
		
		String[] addressArray = new String[4];
		
		addressArray = this.address.split(" ");
		
		String zipno = addressArray[0];
		String roadAddrPart1 = addressArray[1];
		String addrDetail = addressArray[2];
		String roadAddrPart2 = addressArray[3];
		
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

		String s_birth = transFormat.format(birth);
	
		
		RegistAccountDTO dto = new RegistAccountDTO(id, password, name, phoneNumber, s_birth, zipno,
												roadAddrPart1, addrDetail, roadAddrPart2);
		
		return dto;
	}
	
	@Override
	//toString 은 address까지만 나오면 됨
	public String toString() {

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

		String to = transFormat.format(birth);

		
		return "{'id': '" + id + "', 'password':'" + password + "', 'name':'" + name
				+ "', 'phoneNumber':'" + phoneNumber + "', 'birth':'" + to + "', 'address':'" + address + "'}";
	}
	
	public AccountDTO(String id, String password, String name, String phoneNumber, Date birth,
			String address) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birth = birth;
		this.address = address;
	}
	
	
	public AccountDTO() {
		this("unknown","unknown","unknown","unknown",new Date(),"");
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
