package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.PessoaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/pessoa")
public class PessoaAdapter {

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> consultaPessoa(@PathVariable Integer id) {

        PessoaDTO pessoaConsultada = new PessoaDTO();

        pessoaConsultada.setIdPessoa(1);
        pessoaConsultada.setNome("João da Silva");
        pessoaConsultada.setCpf("12345678901");
        pessoaConsultada.setDataNascimento(LocalDate.of(2010, 5, 20));
        pessoaConsultada.setEmail("joao@email.com");
        pessoaConsultada.setTelefone("19988887777");
        pessoaConsultada.setDataCriacao(LocalDateTime.now());
        pessoaConsultada.setDataModificacao(LocalDateTime.now());

        return ResponseEntity.ok(pessoaConsultada);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> cadastraPessoa(@RequestBody PessoaDTO pessoaDTO) {

        System.out.println("Estou cadastrando a pessoa");
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPessoa (@PathVariable Integer id) {

        System.out.println("Removendo Pessoa");
        return ResponseEntity.noContent().build();

    }

    @PatchMapping()
    public ResponseEntity<PessoaDTO> atualizaPessoa (@RequestBody PessoaDTO pessoaDTO) {

        System.out.println("Estou atualizando a pessoa " + pessoaDTO.getIdPessoa());
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaDTO);
    }
}