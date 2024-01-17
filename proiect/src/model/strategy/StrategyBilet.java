package model.strategy;

import model.common.Bilet;

public class StrategyBilet implements InterfataStrategy{


    @Override
    public void aplicaStrategy(Bilet bilet) {
         if(bilet.getPret()>400){
             bilet.setPret(bilet.getPret()-100);
             System.out.println("A fost aplicata o reducere pentru pretul biletului!");
         } else {
             bilet.setPret(bilet.getPret());
         }
    }
}
