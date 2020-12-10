package org.example.marktplaats2.dao;

import java.util.List;

public interface IDaoDB<E>{

    E getById(long id);

    E insert(E e);


    void removeById(long id);

    boolean updateById(long id, E e);

    List<E> getAllWithNamedQuery();


}

