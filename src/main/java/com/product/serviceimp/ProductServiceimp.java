package com.product.serviceimp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.model.Product;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;

@Service
public class ProductServiceimp implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceimp(ProductRepository productRepository) {
		this.productRepository = productRepository;

	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub

		if (product != null) {
			Product products = new Product();

			products.setProductName(product.getProductName());
			products.setDescription(product.getDescription());
			products.setStatus(product.getStatus());
			products.setPrice(product.getPrice());

			return productRepository.save(products);

		}
		return product;

	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}

	@Override
	public String deleteProductById(Integer id) {

		// TODO Auto-generated method stub
		Product product = productRepository.findById(id).get();

		if (product != null) {
			productRepository.delete(product);

			return "product Delete Successfully";
		}

		return "some thing Server Problem";
	}

	@Override
	public Product editProduct(Product product, Integer id) {
		try {
          Product oldproduct=productRepository.findById(id).get();
          
          oldproduct.setProductName(product.getProductName());
          oldproduct.setDescription(product.getDescription());
          oldproduct.setPrice(product.getPrice());
          oldproduct.setStatus(product.getStatus());

		return productRepository.save(oldproduct);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

}
