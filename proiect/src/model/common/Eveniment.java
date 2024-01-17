package model.common;

import model.observer.Observer;

public abstract class Eveniment implements Observer {

    private int numar;
    private String numeEveniment;
    private String numeOrganizator;

    public Eveniment(String numeEveniment) {
    	this.numeEveniment = numeEveniment;
    }

    public Eveniment(int numar, String numeEveniment, String numeOrganizator) {
        this.numar = numar;
        this.numeEveniment = numeEveniment;
        this.numeOrganizator = numeOrganizator;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public String getNumeEveniment() {
        return numeEveniment;
    }

    public void setNumeEveniment(String numeEveniment) {
        this.numeEveniment = numeEveniment;
    }

    public String getNumeOrganizator() {
        return numeOrganizator;
    }

    public void setNumeOrganizator(String numeOrganizator) {
        this.numeOrganizator = numeOrganizator;
    }

    @Override
    public String toString() {
        return "Eveniment{" +
                "numar=" + numar +
                ", numeEveniment='" + numeEveniment + '\'' +
                ", numeOrganizator='" + numeOrganizator + '\'' +
                '}';
    }

    @Override
    public void primesteNotificare(String notificare) {
        System.out.println(numeOrganizator + " a schimbat starea biletului in: " + notificare);
    }
}
