package priscila.api.priscila.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priscila.api.priscila.models.Cliente;
import priscila.api.priscila.service.ClienteRepository;
import priscila.api.priscila.service.ClienteService;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<Cliente> getAllCliente(){
        return clienteRepository.findAll();
    }
    @Override
    public  List<Cliente> getClienteByNome(String nome){
        return clienteRepository.findByNome(nome);
    }
    @Override
    public  List<Cliente> getClienteByEmail(String email){
        return clienteRepository.findByEmail(email);
    }
    @Override
    public  List<Cliente> getClienteByEmailAndSenha(String email, String senha) {
        return clienteRepository.findByEmailAndSenha(email, senha);
    }

    public void cadastrarCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }
    public void excluir(Cliente cliente){
        clienteRepository.delete(cliente);
    }


}
