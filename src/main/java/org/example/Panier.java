package org.example;

import java.util.ArrayList;
import java.util.Observable;

public class Panier {
    private GestionDeStock stock;
    private Comptabilite compta;
    private String contenu;

    public Panier (GestionDeStock pStock, Comptabilite pCompta) {
        this.stock = pStock;
        this.compta = pCompta;
        this.contenu = new String ("Contenu du panier");
    }

    public String getContenu() {
        return this.contenu;
    };

    public void declencherCommande() {
        this.stock.traite(this.contenu);
        this.compta.traite(this.contenu);
    }

    class DeclenchementCommande extends Observable{
        public void notifyObservers() {
            super.setChanged();
            super.notifyObservers();
        }

        public void notifyObservers(Object arg) {
            super.setChanged();
            super.notifyObservers(arg);
        }

        @Override
        public synchronized boolean hasChanged() {
            return super.hasChanged();
        }
    }
}
