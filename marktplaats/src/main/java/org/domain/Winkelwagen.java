package org.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Winkelwagen extends AbstracteEntiteit {

    @Getter
    @OneToMany(mappedBy = "winkelwagen", fetch = FetchType.LAZY)
    private List<Product> productlijst = new ArrayList<>();


    public void plaats(Product product){
        this.productlijst.add(product);
    }

    public void verwijder(Product product){
        this.productlijst.remove(product);
        product.setWinkelwagen(null);
    }
}
