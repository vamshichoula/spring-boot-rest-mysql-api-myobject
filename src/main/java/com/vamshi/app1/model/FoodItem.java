package com.vamshi.app1.model;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "fooditems")
public class FoodItem {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "f_name")
	private String fName;
	@Column(name = "f_quantity")
	private String fQuantity;
	@Column(name = "f_price")
	private String fPrice;

	public FoodItem() {
		super();
	}

	public FoodItem(String fName, String fQuantity, String fPrice) {
		super();
		this.fName = fName;
		this.fQuantity = fQuantity;
		this.fPrice = fPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfQuantity() {
		return fQuantity;
	}

	public void setfQuantity(String fQuantity) {
		this.fQuantity = fQuantity;
	}

	public String getfPrice() {
		return fPrice;
	}

	public void setfPrice(String fPrice) {
		this.fPrice = fPrice;
	}

}
