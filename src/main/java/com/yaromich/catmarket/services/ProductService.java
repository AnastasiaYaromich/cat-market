package com.yaromich.catmarket.services;
import com.yaromich.catmarket.dtos.CreateNewProductDto;
import com.yaromich.catmarket.entities.Product;
import com.yaromich.catmarket.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void createNewProduct(CreateNewProductDto createNewProductDto) {
        Product product = new Product();
        product.setTitle(createNewProductDto.getTitle());
        product.setPrice(createNewProductDto.getPrice());
        productRepository.save(product);
    }

    public Product findProductById(Long id) {
        return productRepository.findOneById(id);
    }
}
