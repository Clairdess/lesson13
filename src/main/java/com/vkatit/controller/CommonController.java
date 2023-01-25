package com.vkatit.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommonController<E> {

    ResponseEntity<Integer> create(E entity);

    ResponseEntity<List<E>> getAll();

    ResponseEntity<E> getById( Long id);

    ResponseEntity<String> delete( E e);
}
