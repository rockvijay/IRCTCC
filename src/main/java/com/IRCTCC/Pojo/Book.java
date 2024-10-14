package com.IRCTCC.Pojo;


import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private long trainId;
	 private String bookingId;
	 private String name;
	 private String passengerName;
	 private LocalDate bookingDate;
	 private int gender;
	 private int age;
	 private int seatIndex;
	 private double price;
	 private String pnr;
	 
	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getTrainId() {
		return trainId;
	}

	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}

	
	
	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSeatIndex() {
		return seatIndex;
	}

	public void setSeatIndex(int seatIndex) {
		this.seatIndex = seatIndex;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public Book() {
		super();
	}

	

	public Book(Long id, long trainId, String bookingId, String name, String passengerName, LocalDate bookingDate,
			int gender, int age, int seatIndex, double price, String pnr) {
		super();
		this.id = id;
		this.trainId = trainId;
		this.bookingId = bookingId;
		this.name = name;
		this.passengerName = passengerName;
		this.bookingDate = bookingDate;
		this.gender = gender;
		this.age = age;
		this.seatIndex = seatIndex;
		this.price = price;
		this.pnr = pnr;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", trainId=" + trainId + ", bookingId=" + bookingId + ", name=" + name
				+ ", passengerName=" + passengerName + ", bookingDate=" + bookingDate + ", gender=" + gender + ", age="
				+ age + ", seatIndex=" + seatIndex + ", price=" + price + ", pnr=" + pnr + "]";
	}
	 

 
}

