package com.fpt.prm.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.prm.mapper.ProductMapper;
import com.fpt.prm.model.Account;
import com.fpt.prm.model.BaseResponse;
import com.fpt.prm.model.Image;
import com.fpt.prm.model.Product;
import com.fpt.prm.model.ProductParam;
import com.fpt.prm.model.ProductResponse;
import com.fpt.prm.model.RegMappingEntity;

@RestController
@RequestMapping("api")
@CrossOrigin
public class ProductController {

	@Autowired
	ProductMapper productMapper;

	// Fetches all products
	@GetMapping(value = "public/products")
	public ResponseEntity<BaseResponse> getAllproducts() {
		BaseResponse baseResponse = new BaseResponse(0, null);
		try {
			List<Product> data = productMapper.getAllProductActive();
//			for (Product product : data) {
//				product.setImages(productMapper.getProductPicByID(product.getProductID()));
//			}
			baseResponse.setStatus(1);
			baseResponse.setData(data);
		} catch (Exception e) {
			baseResponse.setStatus(0);
			e.printStackTrace();
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}

	// Fetches all products by key
	@GetMapping(value = "public/productsSearch/{typeID}")
	public ResponseEntity<BaseResponse> getProductBySeachkey(@PathVariable("typeID") String searchKey) {
		BaseResponse baseResponse = new BaseResponse(0, null);
		try {
			List<ProductResponse> data = productMapper.getAllProductActiveByTypeId(searchKey);
			/*
			 * not needed anymore for (ProductResponse product : data) {
			 * product.setImages(productMapper.getProductPicByID(product.getProductID())); }
			 */
			baseResponse.setStatus(1);
			baseResponse.setData(data);
		} catch (Exception e) {
			baseResponse.setStatus(0);
			e.printStackTrace();
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}

	// Fetches all products by key
	@GetMapping(value = "public/productImage/{productId}")
	public ResponseEntity<BaseResponse> getProductImageById(@PathVariable("productId") int productId) {
		BaseResponse baseResponse = new BaseResponse(0, null);

		try {
			List<Image> data = productMapper.getProductPicByID(productId);
//						List<String> data = new ArrayList<String>();
//						for (Image productResponse : dataPetch) {
//							data.add(productResponse.getImage());
//						}
			/*
			 * not needed anymore for (ProductResponse product : data) {
			 * product.setImages(productMapper.getProductPicByID(product.getProductID())); }
			 */
			baseResponse.setStatus(1);
			baseResponse.setData(data);
		} catch (Exception e) {
			baseResponse.setStatus(0);
			e.printStackTrace();
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}

	// Fetches all products by key and location
	@GetMapping(value = "public/productsSearch/{typeID}/{searchKey}")
	public ResponseEntity<BaseResponse> getProductBySeachkey(@PathVariable("searchKey") String searchKey,
			@PathVariable("typeID") String typeID) {
		BaseResponse baseResponse = new BaseResponse(0, null);
		try {
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("searchKey", searchKey);
			paramMap.put("typeID", typeID);
			List<ProductResponse> data = productMapper.getAllProductActiveByKeyAndLocation(paramMap);
			for (ProductResponse product : data) {
				product.setImages(productMapper.getProductPicByID(product.getProductID()));
			}
			baseResponse.setStatus(1);
			baseResponse.setData(data);
		} catch (Exception e) {
			baseResponse.setStatus(0);
			e.printStackTrace();
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}

//	@GetMapping(value = "products/{typeId}")
//	public ResponseEntity<BaseResponse> getAllproductsByTypeId(@PathVariable("typeId") String typeId) {
//		BaseResponse baseResponse = new BaseResponse(0, null);
//		try {
//			List<Product> data = productMapper.getAllProductActiveByTypeId(typeId);
//			baseResponse.setStatus(1);
//			baseResponse.setData(data);
//		} catch (Exception e) {
//			baseResponse.setStatus(0);
//			e.printStackTrace();
//		}
//		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
//	}

	@GetMapping(value = "public/products/{addressID}/{typeID}/{status}")
	public ResponseEntity<BaseResponse> getProductByID(@PathVariable("addressID") String addressID, @PathVariable("typeID") String typeID, @PathVariable("status") String status) {
		BaseResponse baseResponse = new BaseResponse(0, null);
		try {
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("addressID", addressID);
			paramMap.put("typeID", typeID);
			paramMap.put("status", status);
			List<ProductResponse> data = productMapper.getProductByAddressTypeStatus(paramMap);
			for (ProductResponse product : data) {
				product.setImages(productMapper.getProductPicByID(product.getProductID()));
			}
			baseResponse.setStatus(1);
			baseResponse.setData(data);
		} catch (Exception e) {
			baseResponse.setStatus(0);
			e.printStackTrace();
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}
	
	

	// Creates a new product
	@PostMapping(path = "/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> addArticle(@RequestBody ProductParam product, Principal principal) {
		BaseResponse baseResponse = new BaseResponse(0, null);
		try {
			Product pro = new Product(0, product.getProductName(), product.getTypeID(),
					product.getPrice(), principal.getName(), product.getDescription(), product.getImages().get(0).getImage(), true,
					product.getAddressID(), 0, 0, new Date(),
					new Date(), principal.getName(), principal.getName());
			int productID = productMapper.createNewProduct(pro);
			for (Image image : product.getImages()) {
				productMapper.addImage(
						new Image(pro.getProductID(), image.getImage(), new Date(), new Date(), principal.getName(), principal.getName()));
			}
			baseResponse.setStatus(productID);
		} catch (Exception e) {
			baseResponse.setStatus(0);
			e.printStackTrace();
			return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
		}

		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.CREATED);
	}

	// Creates a new product
	@PutMapping(path = "/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> updateProduct(@RequestBody ProductParam product, Principal principal) {
		BaseResponse baseResponse = new BaseResponse(0, null);
		try {
			int status = productMapper.updateProduct(new Product(product.getProductID(), product.getProductName(), product.getTypeID(),
					product.getPrice(), principal.getName(), product.getDescription(), product.getImages().get(0).getImage(), product.isStatus(),
					product.getAddressID(), 0, 0, new Date(),
					new Date(), principal.getName(), principal.getName()));
			baseResponse.setStatus(status);
			if (status == 0) {
				throw new Exception("Product id not valid!");
			}
			productMapper.deleteOldImage(product.getProductID());
			for (Image image : product.getImages()) {
				productMapper.addImage(
						new Image(product.getProductID(), image.getImage(), new Date(), new Date(), principal.getName(), principal.getName()));
			}
		} catch (Exception e) {
			baseResponse.setStatus(0);
			e.printStackTrace();
			return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
		}

		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.CREATED);
	}

	@GetMapping("public/user/product/{username}")
	public ResponseEntity<BaseResponse> getProductByUserId(@PathVariable("username") String username) {
		BaseResponse baseResponse = new BaseResponse(0, null);
		try {
			List<ProductResponse> data = productMapper.findByUsername(username);
			baseResponse.setStatus(1);
			baseResponse.setData(data);
		} catch (Exception e) {
			baseResponse.setStatus(0);
			e.printStackTrace();
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}

	@GetMapping("public/user/productsActive/{username}")
	public ResponseEntity<BaseResponse> getProductActiveByUserId(@PathVariable("username") String username) {
		BaseResponse baseResponse = new BaseResponse(0, null);
		try {
			List<ProductResponse> data = productMapper.findActiveByUsername(username);
			baseResponse.setStatus(1);
			baseResponse.setData(data);
		} catch (Exception e) {
			baseResponse.setStatus(0);
			e.printStackTrace();
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}

	@GetMapping("public/user/productsDisable/{username}")
	public ResponseEntity<BaseResponse> getProductDisableByUserId(@PathVariable("username") String username) {
		BaseResponse baseResponse = new BaseResponse(0, null);
		try {
			List<ProductResponse> data = productMapper.findDisableByUsername(username);
			baseResponse.setStatus(1);
			baseResponse.setData(data);
		} catch (Exception e) {
			baseResponse.setStatus(0);
			e.printStackTrace();
		}
		return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
	}
}
