package com.softstrem.dscommerce.dto;

import java.math.BigDecimal;

import com.softstrem.dscommerce.entities.Product;

public class ProductMinDTO {

	private Long id;
	private String name;
	private BigDecimal price;
	private String imgUrl;

	public ProductMinDTO(Long id, String name, String description, BigDecimal price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	public ProductMinDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

}
