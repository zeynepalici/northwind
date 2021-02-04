package com.example.northwind.business.concretes;

import com.example.northwind.business.abstracts.IProductService;
import com.example.northwind.dataAccess.abstracts.ProductRepository;
import com.example.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements IProductService {
    //kurallar businessda implement edilir
    @Autowired

    private ProductRepository productRepository;


    private boolean isOkay(Product product) {
        List<Product> products = productRepository.findAllByCategoryId(product.getCategoryId());
        return products != null && products.size() < 10 && product.getProductName().length() >= 2;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }


    public Product add(Product product) {
        if (isOkay(product))
            return productRepository.save(product);
        else
            return null;
    }


    public Product update(int productId, Product product) {
        Product productToUpdate = productRepository.findById(productId);
        if (isOkay(product)) {
            productToUpdate.setProductName(product.getProductName());
            productToUpdate.setCategoryId(product.getCategoryId());
            productToUpdate.setQuantityPerUnit(product.getQuantityPerUnit());
            productToUpdate.setUnitPrice(product.getUnitPrice());
            return productRepository.save(productToUpdate);
        } else
            return null;
    }


    public Product findById(int id) {
        return productRepository.findById(id);
    }


    public Product delete(int id) {
        Product productToDelete = productRepository.findById(id);
        productRepository.delete(productToDelete);
        return productToDelete;
    }

}
