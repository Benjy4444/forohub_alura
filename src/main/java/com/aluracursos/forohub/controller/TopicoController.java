package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.topico.DatosListadoTopico;
import com.aluracursos.forohub.domain.topico.Topico;
import com.aluracursos.forohub.domain.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/topicos")
//@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<Topico> registrarTopico(@RequestBody Topico topicoCreado,
                                                  UriComponentsBuilder uriComponentsBuilder) {
        topicoCreado.setFechacreacion(LocalDateTime.now());
        topicoCreado.setStatus(true);
        topicoRepository.save(topicoCreado);
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topicoCreado.getId()).toUri();
        return ResponseEntity.created(url).body(topicoCreado);

    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault() Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findByStatusTrue(Pageable.unpaged())
                .map(DatosListadoTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Topico> actualizaTopico(@RequestBody Topico topicoActualizado) {
        var id = topicoActualizado.getId();
        return topicoRepository.findById(id)
                .map(topico -> {
                    topico.actualizarTopico(topicoActualizado);
                    topicoRepository.save(topico);
                    return ResponseEntity.ok(topico);
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> retornaTopico(@PathVariable Long id) {
        return topicoRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

}
