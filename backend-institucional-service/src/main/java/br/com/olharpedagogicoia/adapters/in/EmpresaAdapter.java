package br.com.olharpedagogicoia.adapters.in;

import br.com.olharpedagogicoia.application.dto.EmpresaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/empresa")
public class EmpresaAdapter {

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> consultaEmpresa (@PathVariable Integer id) {

        EmpresaDTO empresaConsultada = new EmpresaDTO();

        empresaConsultada.setIdEmpresa(1);
        empresaConsultada.setNome("Ursinho Pimpao");
        empresaConsultada.setCnpj("12312312312");
        empresaConsultada.setAtivo(true);
        empresaConsultada.setDataCriacao(LocalDateTime.now());
        empresaConsultada.setDataModificacao(LocalDateTime.now());
        
        return ResponseEntity.ok(empresaConsultada);
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


