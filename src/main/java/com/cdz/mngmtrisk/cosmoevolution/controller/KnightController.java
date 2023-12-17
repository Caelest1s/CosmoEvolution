package com.cdz.mngmtrisk.cosmoevolution.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cdz.mngmtrisk.cosmoevolution.dto.KnightDTO;
import com.cdz.mngmtrisk.cosmoevolution.services.KnightService;

import jakarta.validation.Valid;

// configura a execução da aplicação respondendo pela WEB (REST)
@RestController
@RequestMapping(value = "/knights")
// responsável pelas regras de negócio WEB -> DTO -> Service -> BD
public class KnightController {

    @Autowired
    private KnightService service;

    // @GetMapping, value -> encontra ID por numero no navegador juntamente com o
    // @PathVariable
    @GetMapping(value = "/{id}")
    public ResponseEntity<KnightDTO> findById(@PathVariable Long id) {

        KnightDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<KnightDTO>> findAll(Pageable pageable) {

        Page<KnightDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<KnightDTO> insert(@Valid @RequestBody KnightDTO dto) {

        dto = service.insert(dto);
        // cod. 200 mostra que não teve nenhum erro, cod. 201 é de inserção, created
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<KnightDTO> update(@PathVariable Long id, @Valid @RequestBody KnightDTO dto) {

        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);
        return ResponseEntity.noContent().build();

    }
}
