package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class World {
    public static void run(Direction[] arguments) {

        int len = arguments.length;
        int i = 0;
        System.out.println("Start");
        for (var argument : arguments) {
            if (argument == Direction.e) {
                len--;
                if (i == len)
                    System.out.println();
                continue;
            }

            i++;
            String message = switch (argument) {
                case f -> "Zwierzak idzie do przodu";
                case b -> "Zwierzak idzie do tyłu";
                case r -> "Zwierzak skręca w prawo";
                case l -> "Zwierzak skręca w lewo";
                case e -> "";

            };


            if (i != 1)
                if (i != len)
                    System.out.print(',' + message);
                else
                    System.out.println(',' + message);
            else if (i != len)
                System.out.print(message);
            else
                System.out.println(message);
        }
        System.out.println("Stop");
    }

    public static Direction[] stringToDirections(String input) {
        char[] chars = input.toCharArray();
        int len = input.length();
        Direction[] directions = new Direction[len];
        for (int i = 0; i < len; i++) {

            if (chars[i] == 'f' || chars[i] == 'b' || chars[i] == 'r' || chars[i] == 'l')
                directions[i] = Direction.valueOf(String.valueOf(chars[i]));
            else
                directions[i] = Direction.e;
        }
        return directions;
    }

    public static void main(String[] args) {


        MoveDirection[] directions = new OptionsParser().parse(new String[]{"f", "b", "r", "l", "f", "f","r","r", "f", "f", "f", "f", "f", "f", "f", "f"});
        IWorldMap map = new GrassField(4);
        IWorldMap map2 = new RectangularMap(4,4);
        System.out.println(map);
        System.out.println(map2);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        IEngine engine2 = new SimulationEngine(directions, map2, positions);
        engine2.run();


        System.out.println(map);
        System.out.println(map2);


    }

}
