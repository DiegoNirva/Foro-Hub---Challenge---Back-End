package com.challenge.Foro.hub.repository;

import com.challenge.Foro.hub.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    Page<Curso>findAll(Pageable pageable);

    //Optional<Curso> findById(Long id);

}
