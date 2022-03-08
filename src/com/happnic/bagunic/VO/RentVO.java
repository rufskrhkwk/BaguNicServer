package com.happnic.bagunic.VO;

public class RentVO {
	private String email;
	private String ren_number;
	private String basket_id;
	private String rental_s_time;
	private String rental_e_time;
	private String latitude;
	private String longitude;
	private String ren_area;
	private String ren_hours;
	
	public RentVO(String email, String ren_number, String basket_id, String rental_s_time, String rental_e_time,
			String user_email, String latitude, String longitude, String ren_area) {
		super();
		this.email = email;
		this.ren_number = ren_number;
		this.basket_id = basket_id;
		this.rental_s_time = rental_s_time;
		this.rental_e_time = rental_e_time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.ren_area = ren_area;
		
	}
	public RentVO(String email, String ren_number, String basket_id, String ren_hours, String rental_s_time, String ren_area) {
		this.email = email;
		this.ren_number = ren_number;
		this.basket_id = basket_id;
		this.rental_s_time = rental_s_time;
		this.ren_hours = ren_hours;
		this.ren_area = ren_area;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRen_number() {
		return ren_number;
	}
	public void setRen_number(String ren_number) {
		this.ren_number = ren_number;
	}
	public String getBasket_id() {
		return basket_id;
	}
	public void setBasket_id(String basket_id) {
		this.basket_id = basket_id;
	}
	public String getRental_s_time() {
		return rental_s_time;
	}
	public void setRental_s_time(String rental_s_time) {
		this.rental_s_time = rental_s_time;
	}
	public String getRental_e_time() {
		return rental_e_time;
	}
	public void setRental_e_time(String rental_e_time) {
		this.rental_e_time = rental_e_time;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getRen_area() {
		return ren_area;
	}
	public void setRen_area(String ren_area) {
		this.ren_area = ren_area;
	}

	
}
