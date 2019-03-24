package com.fpt.prm.mapper;

import java.util.List;
import java.util.Map;

import com.fpt.prm.model.Image;
import com.fpt.prm.model.Product;
import com.fpt.prm.model.ProductResponse;

public interface ProductMapper {
	
	public List<Product> getAllProductActive();

	public List<ProductResponse> getAllProductActiveByTypeId(String typeId);

	public Product getProductByID(int productId);
	
	public List<Image> getProductPicByID(int productId);

	public int createNewProduct(Product product);

	public void addImage(Image image);

	public List<Product> getAllProductActiveByKey(String searchKey);

	public List<ProductResponse> getAllProductActiveByKeyAndLocation(Map<String, String> paramMap);
	
}
