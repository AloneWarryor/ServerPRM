package com.fpt.prm.mapper;

import java.util.List;

import com.fpt.prm.model.Image;
import com.fpt.prm.model.Product;

public interface ProductMapper {
	
	public List<Product> getAllProductActive();

	public List<Product> getAllProductActiveByTypeId(String typeId);

	public Product getProductByID(int productId);
	
	public List<Image> getProductPicByID(int productId);

	public int createNewProduct(Product product);

	public void addImage(Image image);
	
}
