package view;

import model.common.Bilet;
import model.common.Eveniment;
import model.states.Achizitonat;

import java.util.ArrayList;

import abstractfactory.EvenimentConcert;
import abstractfactory.EvenimentTeatru;
import model.strategy.StrategyBilet;

public class View {
    public String meniu;
    public String stareBilet;
    public ArrayList<Bilet> bilete = new ArrayList<>();

    public View(){
        super();
        meniu = "**********************\n";
        meniu += "1 - Vizualizare \n";
        meniu += "2 - Cautare Bilet\n";
        meniu += "3 - Schimba stare bilete \n";
        meniu += "X - Inchide si salveaza\n";
        meniu += "**********************\n";

        stareBilet = "-----------------------------------\n";
        stareBilet += "1 - Achizitionat \n";
        stareBilet += "2 - Validat\n";
        stareBilet += "3 - Expirat \n";
        stareBilet += "-----------------------------------\n";

        Eveniment eveniment1 = new EvenimentConcert(100, "Concert Megadeath", "METALHEAD");
        Eveniment eveniment2 = new EvenimentTeatru(101, "10 Negrii Mititei", "Teatru Odeon");
        Eveniment eveniment3 = new EvenimentConcert(102, "Concert Metalhead Meeting", "METALHEAD");
        Eveniment eveniment4 = new EvenimentTeatru(103, "Troia", "TNR");
        Eveniment eveniment5 = new EvenimentTeatru(104, "2 Loturi", "Teatru de Comedie");
        Eveniment eveniment6 = new EvenimentConcert(105, "Fuego", "Sala palatului");


        Bilet bilet1 = new Bilet(111, new Achizitonat(), 200, eveniment1);
        bilete.add(bilet1);
        bilet1.inregistrareObserver(eveniment1);

        Bilet bilet11 = new Bilet(115, new Achizitonat(), 200, eveniment1);
        bilete.add(bilet11);
        bilet11.inregistrareObserver(eveniment1);


        Bilet bilet2 = new Bilet(112, new Achizitonat(), 150, eveniment2);
        bilete.add(bilet2);
        bilet2.inregistrareObserver(eveniment2);

        Bilet bilet22 = new Bilet(116, new Achizitonat(), 150, eveniment2);
        bilete.add(bilet22);
        bilet22.inregistrareObserver(eveniment2);

        Bilet bilet23 = new Bilet(117, new Achizitonat(), 150, eveniment2);
        bilet23.setStrategy(new StrategyBilet());
        bilet23.primesteReducereBilet();
        bilete.add(bilet23);
        bilet23.inregistrareObserver(eveniment2);


        Bilet bilet3 = new Bilet(113, new Achizitonat(), 375, eveniment3);
        bilete.add(bilet3);
        bilet3.inregistrareObserver(eveniment3);

        Bilet bilet4 = new Bilet(114, new Achizitonat(), 375, eveniment3);
        bilet4.setStrategy(new StrategyBilet());
        bilet4.primesteReducereBilet();
        bilete.add(bilet4);
        bilet4.inregistrareObserver(eveniment3);


        Bilet bilet5 = new Bilet(118, new Achizitonat(), 500, eveniment5);
        bilet5.setStrategy(new StrategyBilet());
        bilet5.primesteReducereBilet();
        bilete.add(bilet5);
        bilet5.inregistrareObserver(eveniment5);

    }
}
