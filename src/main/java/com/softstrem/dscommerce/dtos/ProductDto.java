package com.softstrem.dscommerce.dtos;

import java.math.BigDecimal;

import com.softstrem.dscommerce.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDto {

	private Long id;
	
	@Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres")
	@NotBlank(message = "Campo requerido")
	private String name;
	
	@Size(min = 10, message = "Descrição precisa ter no minimo 10 caracteres")
	@NotBlank(message = "Campo requerido")
	private String description;
	
	@Positive(message = "O preço deve ser positivo")
	private BigDecimal price;
	private String imgUrl;

	public ProductDto(Long id, String name, String description, BigDecimal price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	public ProductDto(Product entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

}
