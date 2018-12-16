package com.tiwbnb.api.domains;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the transactions database table.
 * 
 */
@Entity
@Table(name="transaction")
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
        
		private static final long serialVersionUID = 1L;
		public static final String ACCEPTED = "ACCEPTED";
		public static final String PENDING = "PENDING";
		public static final String REJECTED = "REJECTED";

		@Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name="id")
        private Long id;

        @Temporal(TemporalType.DATE)
        private Date cardDate;

        @Column(name="card_num", columnDefinition = "VARCHAR(16)", nullable = false)
        private String cardNum;

        private int cv2;

        @Temporal(TemporalType.DATE)
        private Date endDate;

        @Temporal(TemporalType.DATE)
        private Date startDate;

        private String status;

        @ManyToOne
        private House house;

        @ManyToOne(cascade=CascadeType.PERSIST)
        private User invoiced;

        public Transaction() {
        }

        
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Date getCardDate() {
                return cardDate;
        }

        public void setCardDate(Date cardDate) {
                this.cardDate = cardDate;
        }

        public String getCardNum() {
                return cardNum;
        }

        public void setCardNum(String cardNum) {
                this.cardNum = cardNum;
        }
        

        public Date getEndDate() {
            return endDate;
	    }
	
	    public void setEndDate(Date endDate) {
	            this.endDate = endDate;
	    }
	    
	    public Date getStartDate() {
            return endDate;
	    }
	
	    public void setStartDate(Date startDate) {
	            this.startDate = startDate;
	    }
	    public House getHouse(){
	    	return this.house;
	    }
	    
	    public void setHouse(House house){
	    	this.house = house;
	    }
	    
	    public int getCV2(){
	    	return this.cv2;
	    }
	    public User getInvoiced(){
	    	return this.invoiced;
	    }
	    
	    public void setInvoiced(User invoiced){
	    	this.invoiced = invoiced;
	    }
	    public String getStatus(){
	    	return this.status;
	    }
	    
	    public void accept(){
	    	this.status = Transaction.ACCEPTED;
	    }
	    
	    public void reject(){
	    	this.status = Transaction.REJECTED;
	    }
}
