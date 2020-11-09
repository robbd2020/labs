package org.dao;

import org.domain.Product;

import javax.persistence.EntityManager;

public class ProductDao extends Dao<Product, Long> {
    public ProductDao(EntityManager em){super(em);}
}

