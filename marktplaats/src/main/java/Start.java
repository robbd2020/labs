import org.App;
import org.VulDatabase;
import org.dao.ArtikelDao;
import org.dao.CategorieDao;
import org.dao.GebruikerDao;
import org.domain.Artikel;
import org.domain.Categorie;
import org.domain.Gebruiker;
import org.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

import static org.domain.Bezorgwijze.*;
import static org.domain.Bezorgwijze.AFHALEN;
import static org.views.Printers.printMenuHeader;
import static org.views.Printers.printOpties;

public class Start {

    public static void main(String[] args) {
        App app = new App();
        VulDatabase.start();
//        VulDatabase.drop();
    }


}
