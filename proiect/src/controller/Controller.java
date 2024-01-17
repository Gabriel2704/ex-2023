package controller;

import model.common.Bilet;
import view.View;

import java.io.*;
import java.util.Scanner;

public class Controller {
    public View view;
    private static Scanner input = new Scanner(System.in);

    public Controller(View view){
        super();
        this.view = view;
    }

    public void showMenu() {
        System.out.println(view.meniu);
    }

    public void showStates() {
        System.out.println(view.stareBilet);
    }

    public String readOption(){
        System.out.println(">>>");
        return input.nextLine();
    }

    public Bilet getBilet(int numar){
        for(Bilet bilet : view.bilete){
            if (bilet.getNumar() == numar){
                return bilet;
            }
        }
            return null;
    }

    public void processStateOption(int number, String option){
        Bilet bilet = getBilet(number);
        if(bilet != null){
            switch (option) {
                case "1":
                    bilet.creareBilet();
                    break;
                case "2":
                    bilet.validareBilet();
                    break;
                case "3":
                    bilet.expirareBilet();
                    break;
                default:
                    System.out.println("Optiunea nu exista!");
                    break;
            }
        } else {
            System.out.println("Biletul nu exista!");
        }
    }

    public void processOption(String option){
        switch (option) {
            case "1":
                for (Bilet bilet : view.bilete) {
                    System.out.println(bilet.toString() + "\n");
                }
                System.out.println("--------------Continut fisier text-------------------\n");
                System.out.println("\n");
                readFromFile();
                System.out.println("\n---------------------------------------------------\n");
                break;
            case "2":
                System.out.println("Numar Bilet:\n");
                int nrObiect = Integer.parseInt(readOption());
                Bilet bilet = getBilet(nrObiect);
                if (bilet != null) {
                    System.out.println(bilet.toString());
                } else {
                    System.out.println("Nu exista");
                }
                break;
            case "3":
                System.out.println("Numar Bilet:\n");
                int numar = Integer.parseInt(readOption());
                showStates();
                String stare = readOption();
                processStateOption(numar, stare);
                break;
            case "X":
                System.out.println("Modificari salvate");

                try (BufferedWriter out = new BufferedWriter(new FileWriter("out.txt"))) {
                    out.write(Integer.toString(view.bilete.size()));
                    out.newLine();
                    for (Bilet ob : view.bilete) {
                        ob.savedObject(out);
                    }
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Optiunea nu exista");
                break;
        }
    }

    public static void readFromFile(){
        try {
            File myObj = new File("out.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    public void start() {
        String option = " ";
        while (option != "X") {
            showMenu();
            option = readOption();
            processOption(option);
        }
    }
}
