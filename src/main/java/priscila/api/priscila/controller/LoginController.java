package priscila.api.priscila.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priscila.api.priscila.service.ClienteRepository;
import priscila.api.priscila.service.ClienteServiceImpl;
import priscila.api.priscila.models.Cliente;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteServiceImpl clienteService;
    @PostMapping("/logar")
    public Boolean salvar(@RequestParam String email,
                         @RequestParam String senha){
        List<Cliente> clienteEncontrado = clienteRepository.findByEmailAndSenha(email, senha);
        if(!clienteEncontrado.isEmpty()){
            return true;
        }
        return false;
    }
}
