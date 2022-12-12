package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class World {

    public static void main(String[] args) {

        try{

            Application.launch(App.class, args);

        } catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

    }

}
