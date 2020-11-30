package org.domain;

import java.util.Collection;
import java.util.List;

public interface IDaoDB<E>{

    E getById(long id);

    void insert(E e);


    void removeById(long id);

    boolean updateById(long id, E e);

    List<E> getAllWithNamedQuery();


}

