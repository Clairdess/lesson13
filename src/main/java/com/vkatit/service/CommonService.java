package com.vkatit.service;

import java.util.List;

public interface CommonService<E> {

    int save(E e);

    E findById(Long id);

    List<E> findAll();

    boolean delete(E e);

}
