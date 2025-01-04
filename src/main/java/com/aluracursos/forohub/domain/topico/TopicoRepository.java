package com.aluracursos.forohub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

        Page<Topico> findByStatusTrue(Pageable paginacion);

        @Query("""
            select t.status
            from Topico t
            where
            t.id = :idTopico
            """)
        boolean findStatusById(Long idTopico);
}

