package org.example.puissance4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;

@ExtendWith(MockitoExtension.class)
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

    @Test
    public void JaiGagneSiJaligne4JetonsVerticalement(){
        String expectedDisplay = ". . . . . . .\n"
                +". . . . . . .\n"
                +"X . . . . . .\n"
                +"X . . . . . .\n"
                +"X . . . . . .\n"
                +"X . . . . . .\n";

        Puissance4 puissance4 = new Puissance4();
        puissance4.ajouterJeton(1,"X");
        puissance4.ajouterJeton(2,"O");
        puissance4.ajouterJeton(1,"X");
        puissance4.ajouterJeton(2,"O");
        puissance4.ajouterJeton(1,"X");
        puissance4.ajouterJeton(2,"O");
        puissance4.ajouterJeton(1,"X");
        assertTrue(puissance4.isFinished());
        //assertEquals(expectedDisplay,puissance4.toString());
        //Mockito.verify(puissance4VictoryTestor, atLeast(1)).isFinished(puissance4.grille);
    }

    @Test
    public void JaiGagneSiJaligne4JetonsHorizontalement(){
        String expectedDisplay = ". . . . . . .\n"
                +". . . . . . .\n"
                +". . . . . . .\n"
                +". . . . . . .\n"
                +". . . . . . .\n"
                +"X X X X . . .\n";

        Puissance4 puissance4 = new Puissance4();
        puissance4.ajouterJeton(1,"X");
        puissance4.ajouterJeton(1,"O");
        puissance4.ajouterJeton(2,"X");
        puissance4.ajouterJeton(2,"O");
        puissance4.ajouterJeton(3,"X");
        puissance4.ajouterJeton(3,"O");
        puissance4.ajouterJeton(4,"X");
        assertTrue(puissance4.isFinished());
        //assertEquals(expectedDisplay,puissance4.toString());
        //Mockito.verify(puissance4VictoryTestor, atLeast(1)).isFinished(puissance4.grille);
    }

    @Test
    public void JaiGagneSiJaligne4JetonsEnDiagonale(){
        String expectedDisplay = ". . . . . . .\n"
                +". . . . . . .\n"
                +". . . X . . .\n"
                +". . X X . . .\n"
                +"O X X O . . .\n"
                +"X O O O . . .\n";

        Puissance4 puissance4 = new Puissance4();
        puissance4.ajouterJeton(1,"X");
        puissance4.ajouterJeton(2,"O");
        puissance4.ajouterJeton(2,"X");
        puissance4.ajouterJeton(3,"O");
        puissance4.ajouterJeton(3,"X");
        puissance4.ajouterJeton(4,"O");
        puissance4.ajouterJeton(3,"X");
        puissance4.ajouterJeton(4,"O");
        puissance4.ajouterJeton(4,"X");
        puissance4.ajouterJeton(1,"O");
        puissance4.ajouterJeton(4,"X");
        assertTrue(puissance4.isFinished());
        //assertEquals(expectedDisplay,puissance4.toString());
    }

    @Test
    public void JaiGagneSiJaligne4JetonsEnDiagonaleGauche(){
        String expectedDisplay = ". . . . . . .\n"
                +". . . . . . .\n"
                +". . . X . . .\n"
                +". . . X X . .\n"
                +". . . O X X O\n"
                +". . . O O O X\n";

        Puissance4 puissance4 = new Puissance4();
        puissance4.ajouterJeton(7,"X");
        puissance4.ajouterJeton(6,"O");
        puissance4.ajouterJeton(6,"X");
        puissance4.ajouterJeton(5,"O");
        puissance4.ajouterJeton(5,"X");
        puissance4.ajouterJeton(4,"O");
        puissance4.ajouterJeton(5,"X");
        puissance4.ajouterJeton(4,"O");
        puissance4.ajouterJeton(4,"X");
        puissance4.ajouterJeton(7,"O");
        puissance4.ajouterJeton(4,"X");
        assertTrue(puissance4.isFinished());
        //assertEquals(expectedDisplay,puissance4.toString());
    }

    @Test
    public void ImpossibleDAjouterUnJetonDansUneColonnePleine(){
        Puissance4 puissance4 = new Puissance4();
        puissance4.ajouterJeton(1,"X");
        puissance4.ajouterJeton(1,"O");
        puissance4.ajouterJeton(1,"X");
        puissance4.ajouterJeton(1,"O");
        puissance4.ajouterJeton(1,"X");
        puissance4.ajouterJeton(1,"O");
        assertThrows(IndexOutOfBoundsException.class, () -> {puissance4.ajouterJeton(1,"X");});
    }

    @Test
    public void ImpossibleDeJouer2FoisDeSuite(){
        Puissance4 puissance4 = new Puissance4();
        puissance4.ajouterJeton(1,"X");
        assertFalse(puissance4.ajouterJeton(1,"X"));
    }

    @Test
    public void QuandPartieTermineeImpossibleDeJouer(){
        Puissance4 puissance4 = new Puissance4();
        puissance4.ajouterJeton(7,"X");
        puissance4.ajouterJeton(6,"O");
        puissance4.ajouterJeton(6,"X");
        puissance4.ajouterJeton(5,"O");
        puissance4.ajouterJeton(5,"X");
        puissance4.ajouterJeton(4,"O");
        puissance4.ajouterJeton(5,"X");
        puissance4.ajouterJeton(4,"O");
        puissance4.ajouterJeton(4,"X");
        puissance4.ajouterJeton(7,"O");
        puissance4.ajouterJeton(4,"X");
        assertFalse(puissance4.ajouterJeton(1,"O"));
    }

    @Test
    public void LaGrilleSeVide(){
        String expectedDisplay = ". . . . . . .\n"
                +". . . . . . .\n"
                +". . . . . . .\n"
                +". . . . . . .\n"
                +". . . . . . .\n"
                +". . . . . . .\n";
        Puissance4 puissance4 = new Puissance4();
        puissance4.ajouterJeton(7,"X");
        puissance4.ajouterJeton(6,"O");
        puissance4.ajouterJeton(6,"X");
        puissance4.ajouterJeton(5,"O");
        puissance4.ajouterJeton(5,"X");
        puissance4.ajouterJeton(4,"O");
        puissance4.ajouterJeton(5,"X");
        puissance4.ajouterJeton(4,"O");
        puissance4.ajouterJeton(4,"X");
        puissance4.ajouterJeton(7,"O");
        puissance4.ajouterJeton(4,"X");
        puissance4.vider();
        assertEquals(expectedDisplay,puissance4.toString());
    }

}
