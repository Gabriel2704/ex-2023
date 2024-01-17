package model.common;

import model.observer.ManagerNotificari;
import model.states.Achizitonat;
import model.states.Expirat;
import model.states.State;
import model.states.Validat;
import model.strategy.InterfataStrategy;

import java.io.BufferedWriter;
import java.io.IOException;

public class Bilet extends ManagerNotificari {
    private int numar;
    private State state;
    private float pret;
    private Eveniment eveniment;
    private InterfataStrategy strategy = null;

    public Bilet() {
    }

    public Bilet(int numar, State state, float pret, Eveniment eveniment) {
        this.numar = numar;
        this.state = state;
        this.pret = pret;
        this.eveniment = eveniment;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public Eveniment getEveniment() {
        return eveniment;
    }

    public void setEveniment(Eveniment eveniment) {
        this.eveniment = eveniment;
    }

    public void setStrategy(InterfataStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "numar=" + numar +
                ", state=" + state.schimbaState() +
                ", pret=" + pret +
                ", pentru evenimentul nr=" + eveniment.getNumar() + "--- Nume Eveniment ---"
                + eveniment.getNumeEveniment() + "--- Nume Organizator ---" + eveniment.getNumeOrganizator() + "}";

    }

    public void primesteReducereBilet(){
        if(this.strategy != null){
            this.strategy.aplicaStrategy(this);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void creareBilet() {
        state = new Achizitonat();
        state.schimbaState();
        super.notificaObservers("Biletul cu nr." + numar + " a fost inregistrat");
    }

    public void validareBilet(){
        if(state instanceof Achizitonat) {
            state = new Validat();
            state.schimbaState();
            super.notificaObservers("Biletul cu nr. " + numar + " a fost validat");
        } else
            System.out.println("Actiune invalida!");
    }

    public void expirareBilet(){
        if(state instanceof Validat) {
            state = new Expirat();
            state.schimbaState();
            super.notificaObservers("Biletul cu nr. " + numar + " a fost deja validat sau a expirat");
        } else
            System.out.println("Actiune invalida!");
    }

    public void savedObject (BufferedWriter out) throws IOException{
        out.write("Numar Bilet - ");
        out.write(Integer.toString(this.numar));
        out.write("----------------------------");
        out.write(state.schimbaState());
        out.newLine();
        out.write("Pret - ");
        out.write(Integer.toString((int) this.pret));
        out.newLine();
        out.write("Eveniment - ");
        out.write(Integer.toString(this.eveniment.getNumar()));
        out.write(" - ");
        out.write(this.eveniment.getNumeEveniment());
        out.write(" - ");
        out.write(this.eveniment.getNumeOrganizator());
        out.newLine();
        out.newLine();
    }


}
