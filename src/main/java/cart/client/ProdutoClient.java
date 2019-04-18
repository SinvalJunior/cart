package cart.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import cart.entity.Produto;

@Component
public class ProdutoClient {
    private RestOperations restOperations;
    private String productServiceUrl;

    public ProdutoClient(RestOperations restOperations, @Value("http://34.74.173.169:8888") String productServiceUrl) {
        this.restOperations = restOperations;
        this.productServiceUrl = productServiceUrl;
    }

    public Produto getProduct(Long id) {
        ResponseEntity<Produto> response = restOperations.getForEntity(productServiceUrl + "/produto/{id}/",
        		Produto.class, id);
        return response.getBody();
    }

}
