package com.challenge.Foro.hub.repository;

import com.challenge.Foro.hub.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findAll(Pageable pageable);

    Page<Topico> findByCursoAndFechaDeCreacionBefore(Pageable pageable, String curso, String anio);

}
