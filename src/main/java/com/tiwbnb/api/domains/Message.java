package com.tiwbnb.api.domains;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the messages database table.
 * 
 */
@Entity
public class Message implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "TEXT")
	private String content;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User receiver;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User sender;

	@Temporal(TemporalType.DATE)
	private Date sendDate;

	public Message() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
}