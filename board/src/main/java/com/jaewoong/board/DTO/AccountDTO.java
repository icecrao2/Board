package com.jaewoong.board.DTO;

import java.util.Date;

public class AccountDTO {

	private String id;
	private String password;
	private String name;
	private Integer permission;
	private String phoneNumber;
	private Date birth;
	private String address;
	private String zipno;
	private String roadAddrPart1;
	private String addrDetail;
	private String roadAddrPart2;
	

	@Override
	//toString 은 address까지만 나오면 됨
	public String toString() {
		return "{'id': '" + id + "', 'password':'" + password + "', 'name':'" + name + "', 'permission':'" + permission
				+ "', 'phoneNumber':'" + phoneNumber + "', 'birth':'" + birth + "', 'address':'" + address + "'}";
	}
	
	

	public AccountDTO(String id, String password, String name, Integer permission, String phoneNumber, Date birth,
			String zipno, String roadAddrPart1, String addrDetail, String roadAddrPart2) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.permission = permission;
		this.phoneNumber = phoneNumber;
		this.birth = birth;
		this.zipno = zipno;
		this.roadAddrPart1 = roadAddrPart1;
		this.addrDetail = addrDetail;
		this.roadAddrPart2 = roadAddrPart2;
		this.address = "" + roadAddrPart1 + " " + addrDetail + " " + roadAddrPart2 + " " + zipno;
	}



	public AccountDTO(String id, String password, String name, Integer permission, String phoneNumber, Date birth,
			String address) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.permission = permission;
		this.phoneNumber = phoneNumber;
		this.birth = birth;
		this.address = address;
	}
	
	
	
	
	public AccountDTO() {
		this("unknown","unknown","unknown",1,"unknown",new Date(),"");
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

	public String getZipno() {
		return zipno;
	}



	public void setZipno(String zipno) {
		this.zipno = zipno;
	}



	public String getRoadAddrPart1() {
		return roadAddrPart1;
	}



	public void setRoadAddrPart1(String roadAddrPart1) {
		this.roadAddrPart1 = roadAddrPart1;
	}



	public String getAddrDetail() {
		return addrDetail;
	}



	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}



	public String getRoadAddrPart2() {
		return roadAddrPart2;
	}



	public void setRoadAddrPart2(String roadAddrPart2) {
		this.roadAddrPart2 = roadAddrPart2;
	}
	
	
}
