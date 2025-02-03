package com.challenge.Foro.hub.service;

import com.challenge.Foro.hub.DTO.DatosActualizarTopico;
import com.challenge.Foro.hub.DTO.DatosTopico;
import com.challenge.Foro.hub.DTO.MostraDatosTopico;
import com.challenge.Foro.hub.model.Topico;
import com.challenge.Foro.hub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    //metodo para guardar topicos
    @Transactional
    public void guardarTopico(DatosTopico datosTopicos){
        topicoRepository.save(new Topico(datosTopicos));
    }

    //metodo para buscar topicos de tipo page
    public Page<Topico> buscarTopicos(Pageable pageable){
        Page<Topico>topicoPage = topicoRepository.findAll(pageable);
        return topicoPage;
    }

    //busqueda de topicos por curso y fecha
    public Page<Topico> findByCursoAndFechaDeCreacion(Pageable pageable, String curso, String anio){
        return topicoRepository.findByCursoAndFechaDeCreacionBefore(pageable, curso, anio);
    }

    //busqueda por id
    public MostraDatosTopico buscarTopicopPorId(Long id) {

        MostraDatosTopico datosTopicopPorId;

        Topico topico = topicoRepository.findById(id).orElseThrow(()->new RuntimeException("No se encontro el Id, verifique Id ingresado"));

        datosTopicopPorId = new MostraDatosTopico(topico);

        return datosTopicopPorId;
    }

    public void actualizarTopico(Long id, @Valid DatosActualizarTopico datosActualizarTopico) {
        //traemos consulta
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if(topicoOptional.isPresent()){
            //actualizamos topico
            Topico topicoActualizar = topicoOptional.get();
            topicoActualizar.actualizarTopicos(datosActualizarTopico);
            topicoRepository.save(topicoActualizar);
        }else {
            System.out.println("No se encontro el Id, verifique Id ingresado");
        }
    }

    //eliminar por Id
    public void eliminarTopico(Long id) {
        //traemos consulta
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if(topicoOptional.isPresent()){
            //eliminamos topico
            topicoRepository.deleteById(id);
        }else {
            System.out.println("No se encontro el Id, verifique Id ingresado");
        }
    }




}
