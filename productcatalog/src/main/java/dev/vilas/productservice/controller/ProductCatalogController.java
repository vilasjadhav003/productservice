package dev.vilas.productservice.controller;

import dev.vilas.productservice.dtos.GenericProductDto;
import dev.vilas.productservice.exceptions.NotFoundException;
import dev.vilas.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductCatalogController {
   private ProductService productService;

   public ProductCatalogController(@Qualifier("fakeStoreProductService") ProductService productService) {
       this.productService = productService;
   }



    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {

       return productService.getProductById(id);
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts() {
       return productService.getAllProducts();
    }
}
