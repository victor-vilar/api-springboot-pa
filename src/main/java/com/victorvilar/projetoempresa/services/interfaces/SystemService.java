package com.victorvilar.projetoempresa.services.interfaces;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Interface with a method to search the entity by customer
 *
 * @param <C> class of CreateDto
 * @param <U> class of UpdateDto
 * @param <R> class of ResponseDto
 */
public interface SystemService<C,U,R> {


    public ResponseEntity<List<R>> getAll();


    public ResponseEntity<R> getById(@PathVariable Long id);


    public ResponseEntity<R> save(@Valid @RequestBody C createDto);


    public ResponseEntity<Void> delete(@PathVariable Long id);


    public ResponseEntity<R> update(@RequestBody U updateDto);
}
