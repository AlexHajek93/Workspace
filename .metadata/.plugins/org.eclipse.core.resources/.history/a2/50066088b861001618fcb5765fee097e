package org.ims.beans;

import java.sql.Blob;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="IMS_PRODUCT")
public class ProductBean {
	
	@Id
	@Column(name="PRODUCT_UPC")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productUPC;
	@Column(name="PRODUCT_NAME")
	private String productName;
	@Column(name="PRODUCT_DESCRIPTION")
	private String productDescription;
	@Column(name="SHORT_NAME")
	private String shortName;
	@Column(name="UNIT_COST")
	private int unitCost;
	@Column(name="PACK_SIZE")
	private String packSize;
	@Column(name="REORDER_QUANTITY")
	private int reorderQuantity;
	@Column(name="RETAIL_PRICE")
	private int retailPrice;
	@Column(name="PRODUCT_WEIGHT")
	private int productWeight;
	@Column(name="PRODUCT_IMAGE")
	private Blob productImage;
	@ManyToMany
	@JoinTable(name="PRODUCT_CATEGORIES",
					joinColumns=@JoinColumn(name="PRODUCT_UPC"),
					inverseJoinColumns=@JoinColumn(name="CATEGORY_ID"))
	private Set<ProductCategoryBean> categoriesForProduct;
<<<<<<< HEAD
	@OneToMany(mappedBy="product")
	private Set<POLineBean> linesForProduct;
=======
>>>>>>> master
	
	public int getProductUPC() {
		return productUPC;
	}
	public void setProductUPC(int productUPC) {
		this.productUPC = productUPC;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public int getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}
	public String getPackSize() {
		return packSize;
	}
	public void setPackSize(String packSize) {
		this.packSize = packSize;
	}
	public int getReorderQuantity() {
		return reorderQuantity;
	}
	public void setReorderQuantity(int reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}
	public int getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(int retailPrice) {
		this.retailPrice = retailPrice;
	}
	public int getProductWeight() {
		return productWeight;
	}
	public void setProductWeight(int productWeight) {
		this.productWeight = productWeight;
	}
	public Blob getProductImage() {
		return productImage;
	}
	public void setProductImage(Blob productImage) {
		this.productImage = productImage;
	}
	public Set<ProductCategoryBean> getCategoriesForProduct() {
		return categoriesForProduct;
	}
	public void setCategoriesForProduct(Set<ProductCategoryBean> categoriesForProduct) {
		this.categoriesForProduct = categoriesForProduct;
	}
<<<<<<< HEAD
	public Set<POLineBean> getLinesForProduct() {
		return linesForProduct;
	}
	public void setLinesForProduct(Set<POLineBean> linesForProduct) {
		this.linesForProduct = linesForProduct;
	}
=======
>>>>>>> master
	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductBean(int productUPC, String productName, String productDescription, String shortName, int unitCost,
			String packSize, int reorderQuantity, int retailPrice, int productWeight, Blob productImage,
<<<<<<< HEAD
			Set<ProductCategoryBean> categoriesForProduct, Set<POLineBean> linesForProduct) {
=======
			Set<ProductCategoryBean> categoriesForProduct) {
>>>>>>> master
		super();
		this.productUPC = productUPC;
		this.productName = productName;
		this.productDescription = productDescription;
		this.shortName = shortName;
		this.unitCost = unitCost;
		this.packSize = packSize;
		this.reorderQuantity = reorderQuantity;
		this.retailPrice = retailPrice;
		this.productWeight = productWeight;
		this.productImage = productImage;
		this.categoriesForProduct = categoriesForProduct;
<<<<<<< HEAD
		this.linesForProduct = linesForProduct;
	}
}
=======
	}	
}
>>>>>>> master
