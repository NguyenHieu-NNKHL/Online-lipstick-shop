package model;

public class Product {
	private String productID;
	private String name;
	private String categoryID;
	private String brandID;
	private String imgFirst;
	private String imgLast;
	private double price;
	private String description;
	private int quantity;

	public Product() {
	}

	public Product(String productID, String name, String categoryID, String brandID, String imgFirst, String imgLast,
			double price, String description, int quantity) {
		super();
		this.productID = productID;
		this.name = name;
		this.categoryID = categoryID;
		this.brandID = brandID;
		this.imgFirst = imgFirst;
		this.imgLast = imgLast;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String getBrandID() {
		return brandID;
	}

	public void setBrandID(String brandID) {
		this.brandID = brandID;
	}

	public String getImgFirst() {
		return imgFirst;
	}

	public void setImgFirst(String imgFirst) {
		this.imgFirst = imgFirst;
	}

	public String getImgLast() {
		return imgLast;
	}

	public void setImgLast(String imgLast) {
		this.imgLast = imgLast;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}