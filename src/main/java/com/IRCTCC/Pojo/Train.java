package com.IRCTCC.Pojo;


import java.sql.Date;
import java.sql.Time;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="trains")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String source;
    private String destination;
    private Date date;
    private Time time;
    private int availableSeats;
    private float price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public Train(Long id, String name, String source, String destination, Date date, Time time, int availableSeats,float price) {
		super();
		this.id = id;
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.time = time;
		this.availableSeats = availableSeats;
		this.price=price;
	}
	public Train() {
		super();
	}
}
