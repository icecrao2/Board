package com.jaewoong.board.DTO;

import java.util.Date;

public class AccountDTO {

	private String id;
	private String password;
	private String name;
	private int permission;
	private String phoneNumber;
	private Date birth;
	private String address;
	
	
	
	
	

	@Override
	public String toString() {
		return "{'id': '" + id + "', 'password':'" + password + "', 'name':'" + name + "', 'permission':'" + permission
				+ "', 'phoneNumber':'" + phoneNumber + "', 'birth':'" + birth + "', 'address':'" + address + "'}";
	}

	public AccountDTO(String id, String password, String name, int permission, String phoneNumber, Date birth,
			String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.permission = permission;
		this.phoneNumber = phoneNumber;
		this.birth = birth;
		this.address = address;
	}
	
	public AccountDTO() {
		this("unknown","unknown","unknown",1,"unknown",new Date("0000-00-00"),"unknown");
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
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
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
