package com.victorvilar.projetoempresa.services.interfaces;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Interface with basic crud methods
 *
 * @param <C> class of CreateDto
 * @param <U> class of UpdateDto
 * @param <R> class of ResponseDto
 */
public interface SystemService<C,U,R> {


    public List<R> getAll();
    public R getById( Long id);
    public R save( C createDto);
    public void delete( Long id);
    public R update( U updateDto);
}
