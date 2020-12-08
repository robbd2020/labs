package org.dao;

import lombok.NoArgsConstructor;
import org.domain.Categorie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
@NoArgsConstructor
public class CategorieDao extends Dao<Categorie> {
}
