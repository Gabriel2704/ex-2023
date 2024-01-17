package model.states;

public class Validat implements State {
    @Override
    public String schimbaState() {
        return  "Evenimentul se afla in desfasurare, bilet validat!";
    }
}
