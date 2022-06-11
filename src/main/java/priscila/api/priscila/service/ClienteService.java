package priscila.api.priscila.service;

import org.springframework.stereotype.Service;
import priscila.api.priscila.models.Cliente;

import java.util.List;


public interface ClienteService {
    List<Cliente> getAllCliente();
    List<Cliente> getClienteByNome(String nome);
    List<Cliente> getClienteByEmail(String email);
    List<Cliente> getClienteByEmailAndSenha(String email, String senha);

}
