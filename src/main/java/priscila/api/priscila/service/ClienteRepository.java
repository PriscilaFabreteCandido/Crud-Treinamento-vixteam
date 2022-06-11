package priscila.api.priscila.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import priscila.api.priscila.models.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente>  findByNome(String nome);
    List<Cliente>  findByEmailAndSenha(String email, String senha);
    List<Cliente>  findByEmail(String email);
    List<Cliente> findAllById(Long id);

}
