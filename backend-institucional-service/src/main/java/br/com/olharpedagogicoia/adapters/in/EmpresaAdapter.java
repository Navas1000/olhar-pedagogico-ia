package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.EmpresaDTO;
import br.com.olharpedagogicoia.application.exceptions.EmpresaNaoEncontradaException;
import br.com.olharpedagogicoia.application.port.in.CadastrarEmpresaPortIn;
import br.com.olharpedagogicoia.application.port.in.ConsultarEmpresaPortIn;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/empresa")
@AllArgsConstructor
public class EmpresaAdapter {

    final CadastrarEmpresaPortIn cadastrarEmpresaPortIn;
    final ConsultarEmpresaPortIn consultarEmpresaPortIn;

    @GetMapping("/{id}")
    public ResponseEntity<?> consultaEmpresa (@PathVariable Integer id) {

        try {
            EmpresaDTO empresaConsultada = consultarEmpresaPortIn.consultar(id);
            return ResponseEntity.ok(empresaConsultada);
        } catch (EmpresaNaoEncontradaException excecao) {

            Map<String, String> erro = new HashMap<>();
            erro.put("mensagem", excecao.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
        }
    }

    @PostMapping
    public ResponseEntity<EmpresaDTO> cadastraEmpresa (@RequestBody EmpresaDTO empresaDTO) {

        System.out.println("Estou cadastrando a empresa");
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerEmpresa (@PathVariable Integer id) {

        System.out.println("Removendo Empresa");
        return ResponseEntity.noContent().build();

    }

    @PatchMapping()
    public ResponseEntity<EmpresaDTO> atualizaEmpresa (@RequestBody EmpresaDTO empresaDTO) {

        System.out.println("Estou atualizando a empresa " + empresaDTO.getIdEmpresa());
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaDTO);
    }
}


