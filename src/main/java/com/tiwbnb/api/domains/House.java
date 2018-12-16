package com.tiwbnb.api.domains;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class House {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String city;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private String fullDescription;
	private String shortDescription;
	private String imageUrl;
	private Integer maxGuests;
	private String name;
	private Float price;
	private Boolean shared;
	
	@OneToMany(mappedBy = "house", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private Set<Transaction> transactions = new LinkedHashSet<Transaction>();
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	//@JoinColumn(name="owner_id")
	private User owner;

	public House(){
	}
	

	public void setOwner(User pUser){
		owner = pUser;		
	}
	
	public User getOwner(){
		return owner;
	}
	

	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getFullDescription() {
		return fullDescription;
	}


	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}


	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public int getMaxGuests() {
		return maxGuests;
	}


	public void setMaxGuests(int maxGuests) {
		this.maxGuests = maxGuests;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public boolean isShared() {
		return shared;
	}


	public void setShared(boolean shared) {
		this.shared = shared;
	}


	public String getShortDescription() {
		return shortDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	public Date getEndDate() {
		return this.endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}


	public Long getId() {
		return this.id;
	}

	public void updateHouse(House house){
		
		if(house.shared != null){
			this.shared = house.shared;
		}
		if(house.startDate != null){
			this.startDate = house.startDate;
		}
		if(house.endDate != null){
			this.endDate = house.endDate;
		}
		if(house.city!= null){
			this.city= house.city;
		}
		if(house.maxGuests != null){
			this.maxGuests = house.maxGuests;
		}
		if(house.fullDescription != null){
			this.fullDescription = house.fullDescription;
		}
		if(house.shortDescription != null){
			this.shortDescription = house.shortDescription;
		}
		if(house.imageUrl != null){
			this.imageUrl = house.imageUrl;
		}
		if(house.price != null){
			this.price = house.price;
		}
		if(house.name != null){
			this.name = house.name;
		}
		
	}


}
