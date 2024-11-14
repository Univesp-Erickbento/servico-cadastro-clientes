package com.mypet.mypet.userCase;
import com.mypet.mypet.domain.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String ENDERECO_SERVICE_URL = "http://endereco-service/api/enderecos";

    public Endereco salvarEndereco(Endereco endereco) {
        return restTemplate.postForObject(ENDERECO_SERVICE_URL, endereco, Endereco.class);
    }

    public Endereco buscarEnderecoPorId(Long id) {
        return restTemplate.getForObject(ENDERECO_SERVICE_URL + "/{id}", Endereco.class, id);
    }

    public Endereco atualizarEndereco(Endereco endereco) {
        restTemplate.put(ENDERECO_SERVICE_URL + "/{id}", endereco, endereco.getId());
        return endereco;
    }

    public void deletarEndereco(Long id) {
        restTemplate.delete(ENDERECO_SERVICE_URL + "/{id}", id);
    }
}
