package priscila.api.priscila.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priscila.api.priscila.service.ClienteRepository;
import priscila.api.priscila.service.ClienteServiceImpl;
import priscila.api.priscila.models.Cliente;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {
    @Autowired
    private ClienteServiceImpl clienteSerice;
    @Autowired
    private ClienteRepository clienteRepository;
    @PostMapping("/adicionar")
    public String salvar(@RequestParam String nome,
                         @RequestParam String senha,
                         @RequestParam String email) {
        List<Cliente> clienteEncontrado = clienteSerice.getClienteByEmail(email);
        if(clienteEncontrado.isEmpty()){
            Cliente cliente = new Cliente(senha, nome, email);
            clienteSerice.cadastrarCliente(cliente);
            return "salvo com sucesso";
        }
        return "você já se cadastrou";
    }

}
