package com.example.demo.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class TradeStoreModel{

	/*Composite key ?
	 * @Id private TradeID tradeId;
	 */
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String tradeId;
	
	private int version;
	private String counterPartyId;
	private String bookId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_created")
	private Date createdDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Column(name="date_maturity")
	private String maturityDate;
	
	@Column(name = "Expired")
	private String isExpired;
	
	public String getIsExpired() {
		return isExpired;
	}
	public void setIsExpired(String isExpired) {
		this.isExpired = isExpired;
	}
	public String getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getCounterPartyId() {
		return counterPartyId;
	}
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public TradeStoreModel(String tradeId, int version, String counterPartyId, String bookId, String maturityDate) {
		super();
		this.tradeId = tradeId;
		this.version = version;
		this.counterPartyId = counterPartyId;
		this.bookId = bookId;
		this.createdDate= new Date();
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
		Date mDate;
		try {
			mDate = smf.parse(maturityDate);
			if (mDate.before(new Date()))
			{
				this.isExpired = "Y";
				System.out.println("maturity date is in past trade has expired...thank you");
			}
			else
			{
				this.isExpired = "N";
			}
		  } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public TradeStoreModel() {
		
	}
	
	
	
	
	
}


