package dev.vilas.productservices.controller;

import dev.vilas.productservices.dtos.GenericProductDTO;
import dev.vilas.productservices.exception.NotFoundException;
import dev.vilas.productservices.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public GenericProductDTO getProductById(@PathVariable("id") Long id) throws NotFoundException {

        return productService.getProductById(id);
    }

    @GetMapping
    public List<GenericProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("{id}")
    public HttpStatus deleteProductById(@PathVariable("id") Long id) {
        GenericProductDTO genericProductDTO = productService.deleteProductById(id);

        return Optional.ofNullable(genericProductDTO)
                .map(genericProductDTO1 -> HttpStatus.OK)
                .orElse(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public GenericProductDTO createProduct(@RequestBody GenericProductDTO genericProductDTO) {
        return productService.createProduct(genericProductDTO);
    }

    @PutMapping("{id}")
    public GenericProductDTO updateProduct(@RequestBody GenericProductDTO genericProductDTO,@PathVariable("id") Long id) {
        return productService.updateProduct(genericProductDTO,id);
    }
}
