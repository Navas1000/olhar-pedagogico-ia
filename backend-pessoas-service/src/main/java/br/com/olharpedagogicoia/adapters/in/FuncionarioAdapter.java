package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.FuncionarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioAdapter {

    @GetMapping("/{id}/pessoa/{idPessoa}/papel/{idPapel}")
    public ResponseEntity<FuncionarioDTO> consultaFuncionario(@PathVariable Integer id,
                                                              @PathVariable Integer idPessoa,
                                                              @PathVariable Integer idPapel) {

        FuncionarioDTO funcionarioConsultado = new FuncionarioDTO();

        funcionarioConsultado.setIdFuncionario(id);
        funcionarioConsultado.setIdPessoa(idPessoa);
        funcionarioConsultado.setIdPapel(idPapel);
        funcionarioConsultado.setNomeUsuario("joao");
        funcionarioConsultado.setSenha("123456");
        funcionarioConsultado.setUltimoLogin(LocalDateTime.now());
        funcionarioConsultado.setAtivo(true);
        funcionarioConsultado.setDataCriacao(LocalDateTime.now());
        funcionarioConsultado.setDataModificacao(LocalDateTime.now());

        return ResponseEntity.ok(funcionarioConsultado);
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> cadastraFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {

        System.out.println("Estou cadastrando o funcionário");
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioDTO);
    }
    @DeleteMapping("/{id}/pessoa/{idPessoa}/papel/{idPapel}")
    public ResponseEntity<Void> removerFuncionario (@PathVariable Integer id,
                                                    @PathVariable Integer idPessoa,
                                                    @PathVariable Integer idPapel) {

        System.out.println("Removendo Funcionario");
        return ResponseEntity.noContent().build();

    }

    @PatchMapping()
    public ResponseEntity<FuncionarioDTO> atualizaFuncionario (@RequestBody FuncionarioDTO funcionarioDTO) {

        System.out.println("Estou atualizando o funcionario " + funcionarioDTO.getIdFuncionario());
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioDTO);
    }
}