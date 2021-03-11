package org.example.puissance4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Puissance4Test {

    @Test
    public void grilleEstVideAuDebutDuJeu(){
        String expectedDisplay = ". . . . . . .\n"
                                +". . . . . . .\n"
                                +". . . . . . .\n"
                                +". . . . . . .\n"
                                +". . . . . . .\n"
                                +". . . . . . .\n";

        Puissance4 puissance4 = new Puissance4();
        assertEquals(expectedDisplay,puissance4.toString());
    }

    @Test
    public void jetonEnBasSiAjoutColonneVide(){
        String expectedDisplay = ". . . . . . .\n"
                +". . . . . . .\n"
                +". . . . . . .\n"
                +". . . . . . .\n"
                +". . . . . . .\n"
                +"X . . . . . .\n";

        Puissance4 puissance4 = new Puissance4();
        puissance4.ajouterJeton(1,"X");
        assertEquals(expectedDisplay,puissance4.toString());
    }

    @Test
    public void jetonEnDexiemeLigneSiAjoutDansColonneAvecUnJeton(){
        String expectedDisplay = ". . . . . . .\n"
                +". . . . . . .\n"
                +". . . . . . .\n"
                +". . . . . . .\n"
                +"O . . . . . .\n"
                +"X . . . . . .\n";

        Puissance4 puissance4 = new Puissance4();
        puissance4.ajouterJeton(1,"X");
        puissance4.ajouterJeton(1,"O");
        assertEquals(expectedDisplay,puissance4.toString());
    }

    @Test
    public void jetonEnTroisiemeLigneSiAjoutDansColonneAvecDeuxJeton(){
        String expectedDisplay = ". . . . . . .\n"
                +". . . . . . .\n"
                +". . . . . . .\n"
                +"X . . . . . .\n"
                +"O . . . . . .\n"
                +"X . . . . . .\n";

        Puissance4 puissance4 = new Puissance4();
        puissance4.ajouterJeton(1,"X");
        puissance4.ajouterJeton(1,"O");
        puissance4.ajouterJeton(1,"X");
        assertEquals(expectedDisplay,puissance4.toString());
    }

}
