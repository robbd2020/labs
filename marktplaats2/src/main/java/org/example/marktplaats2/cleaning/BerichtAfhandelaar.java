package org.example.marktplaats2.cleaning;

import org.example.marktplaats2.service.SchoonmaakSet;

import javax.inject.Inject;

import static org.example.marktplaats2.util.DateUtils.MAX_LEEFTIJD_ADVERTENTIE_IN_DAGEN;

public class BerichtAfhandelaar implements BerichtAfhandelaarI {
    @Inject
    private SchoonmaakSet schoonmaakSet;

    @Override
    public void verwerkBericht(String bericht) {
        String[] berichtArray = bericht.split("\\+");
        switch (berichtArray[0]) {
            case "productlijstopruimen":
                schoonmaakSet.verwijderProductenMetLeeftijdInDagen(MAX_LEEFTIJD_ADVERTENTIE_IN_DAGEN);
                break;
            case "productverwijderen":
                schoonmaakSet.verwijderIndividueelProduct(Long.parseLong(berichtArray[1]));
                break;
        }
    }
}
