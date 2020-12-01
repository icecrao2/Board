package com.jaewoong.board.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistAccountDTO implements IAccountDTO{

	private String id;
	private String password;
	private String name;
	private String phoneNumber;
	private String birth;
	private String zipno;
	private String roadAddrPart1;
	private String addrDetail;
	private String roadAddrPart2;
	
	
	public AccountDTO Swappping() {

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		String address = roadAddrPart1 + " " + addrDetail + " " + roadAddrPart2 + " " + zipno;
		Date d_birth = new Date();
		try {
			d_birth = transFormat.parse(this.birth);
			AccountDTO dto = new AccountDTO(id, password, name, phoneNumber, d_birth, address);
			return dto;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return "{'id'='" + id + "', 'password'='" + password + "', 'name'='" + name
				+ "', 'phoneNumber'='" + phoneNumber + "', 'birth'='" + birth + "', 'zipno'='" + zipno + ",' 'roadAddrPart1'='"
				+ roadAddrPart1 + "', 'addrDetail'='" + addrDetail + "', 'roadAddrPart2'='" + roadAddrPart2 + "'}";
	}
	
	public RegistAccountDTO() {
		
	}
	
	public RegistAccountDTO(String id, String password, String name, String phoneNumber, String birth,
			String zipno, String roadAddrPart1, String addrDetail, String roadAddrPart2) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birth = birth;
		this.zipno = zipno;
		this.roadAddrPart1 = roadAddrPart1;
		this.addrDetail = addrDetail;
		this.roadAddrPart2 = roadAddrPart2;
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
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
