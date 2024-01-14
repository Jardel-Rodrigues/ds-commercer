package com.softstrem.dscommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softstrem.dscommerce.dtos.ProductDto;
import com.softstrem.dscommerce.entities.Product;
import com.softstrem.dscommerce.repositories.ProductRepository;
import com.softstrem.dscommerce.services.exceptions.DatabaseException;
import com.softstrem.dscommerce.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	public ProductDto findById(Long id) {
		return repository.findById(id).map(product -> new ProductDto(product))
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

	}

	@Transactional(readOnly = true)
	public Page<ProductDto> findAll(Pageable pageable) {
		Page<Product> result = repository.findAll(pageable);
		return result.map(x -> new ProductDto(x));

	}

	@Transactional
	public ProductDto insert(ProductDto dto) {
		Product entity = new Product();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ProductDto(entity);

	}

	@Transactional
	public ProductDto update(Long id, ProductDto dto) {
		try {
			Product entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ProductDto(entity);
			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Recurso não encontrato");
		}

	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}

		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial");
		}

	}

	private void copyDtoToEntity(ProductDto dto, Product entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setImgUrl(dto.getImgUrl());

	}

}
