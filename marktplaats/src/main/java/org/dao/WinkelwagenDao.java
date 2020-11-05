package org.dao;

import org.domain.Gebruiker;
import org.domain.Product;
import org.domain.Winkelwagen;

import javax.persistence.EntityManager;
import java.util.List;

public class WinkelwagenDao extends Dao<Winkelwagen, Long>{
    public WinkelwagenDao(EntityManager em) {
        super(em);
    }

    public List<Product> getProductLijst(Winkelwagen w){
        Winkelwagen winkelwagen = get(w.getId());
        List<Product> productLijst = winkelwagen.getProductlijst();
        em.detach(winkelwagen);
        return productLijst;
    }
}
