package priscila.api.priscila.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import priscila.api.priscila.service.ClienteRepository;
import priscila.api.priscila.service.ClienteServiceImpl;
import priscila.api.priscila.models.Cliente;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    ClienteServiceImpl clienteService;

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(clienteService.getAllCliente());
    }

    @DeleteMapping("excluir/{id}")
    public void excluir(@PathVariable("id") Long id) {
        System.out.println(id);
        List<Cliente> clienteEncontrado = clienteRepository.findAllById(id);
        if (!clienteEncontrado.isEmpty()) {
            clienteService.excluir(clienteEncontrado.get(0));
        }
    }

    @PutMapping("/editar")
    public void editar(@RequestParam Long id, @RequestParam String nome, @RequestParam String email,
                       @RequestParam String senha) {
        List<Cliente> clienteEncontrado = clienteRepository.findAllById(id);
        if(!clienteEncontrado.isEmpty()){
            Cliente cliente = new Cliente(id, senha, nome, email);
            clienteService.cadastrarCliente(cliente);
        }
    }
}