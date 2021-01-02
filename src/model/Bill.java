package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "billID")
	private int billID;

	@Column(name = "address")
	private String address;
	@ManyToOne(optional = false)
	@JoinColumn(name = "userID", referencedColumnName = "userID")
	private User user;
	@Column(name = "date")
	// @Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "total")
	private double total;

	@Column(name = "paid")
	private boolean paid;

	@Column(name = "state")
	private boolean state;

//	@OneToMany(mappedBy="bill",cascade=CascadeType.ALL)
//	private Set<BillDetail> billDetail;

	public Bill() {
	}

	public Bill(int billID, String address, User user, Date date, double total, boolean paid, boolean state) {
		super();
		this.billID = billID;
		this.address = address;
		this.user = user;
		this.date = date;
		this.total = total;
		this.paid = paid;
		this.state = state;
	}

	public int getBillID() {
		return billID;
	}

	public void setBillID(int billID) {
		this.billID = billID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}