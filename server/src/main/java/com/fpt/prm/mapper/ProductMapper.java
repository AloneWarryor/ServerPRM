package com.fpt.prm.mapper;

import java.util.List;

import com.fpt.prm.model.Image;
import com.fpt.prm.model.Product;

public interface ProductMapper {
	
	public List<Product> getAllProductActive();

	public List<Product> getAllProductActiveByTypeId(String typeId);

	public Product getProductByID(String productId);
	
	public List<Image> getProductPicByID(String productId);

	public int createNewProduct(Product product);
	
}
