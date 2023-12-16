package dev.vilas.productservices.thridpartyclients.productservice.Fakestore;

import dev.vilas.productservices.dtos.GenericProductDTO;
import dev.vilas.productservices.exception.NotFoundException;
import dev.vilas.productservices.thridpartyclients.productservice.ThirdPartyProductService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


/***
 * Wrapper over FakeStore API
 */
@Service
public class FakeStoreProductServiceClients implements ThirdPartyProductService {
    private RestTemplateBuilder restTemplateBuilder;

    private String productRequestBaseUrl;

    private String specificProductRequestUri;

    public FakeStoreProductServiceClients(RestTemplateBuilder restTemplateBuilder,
                                            @Value("${fakestore.api.url}") String fakeStoreAPIUrl,
                                             @Value("${fakestore.api.paths.product}") String fakeStoreProductsApiPath) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.productRequestBaseUrl = fakeStoreAPIUrl+fakeStoreProductsApiPath;
        this.specificProductRequestUri = fakeStoreAPIUrl+fakeStoreProductsApiPath+"/{id}";
    }

    @Override
    public FakeStoreProductDTO getProductById(Long id) throws NotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity(specificProductRequestUri, FakeStoreProductDTO.class, id);

        return Optional.ofNullable(response.getBody())
                .orElseThrow(() ->
                        new NotFoundException("Product with Id " + id + " Not Found")
                );
    }

    @Override
    public List<FakeStoreProductDTO> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(productRequestBaseUrl, FakeStoreProductDTO[].class);

        return Arrays.asList(response.getBody());
    }

    @Override
    public FakeStoreProductDTO deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDTO.class);

        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);

        ResponseEntity<FakeStoreProductDTO> response = restTemplate.execute(specificProductRequestUri, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return response.getBody();
    }

    @Override
    public FakeStoreProductDTO createProduct(GenericProductDTO genericProductDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDTO> response = restTemplate.postForEntity(productRequestBaseUrl, genericProductDTO, FakeStoreProductDTO.class);
        return response.getBody();
    }

    @Override
    public FakeStoreProductDTO updateProduct(GenericProductDTO genericProductDTO, Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDTO.class);

        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);

        ResponseEntity<FakeStoreProductDTO> response = restTemplate.execute(specificProductRequestUri, HttpMethod.PUT, requestCallback, responseExtractor, id);

        return response.getBody();

    }

}
