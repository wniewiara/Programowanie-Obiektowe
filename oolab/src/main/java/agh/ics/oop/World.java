package agh.ics.oop;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class World {
    public static void run(Direction[] arguments){

        int len=arguments.length;
        int i=0;
        System.out.println("Start");
        for(var argument: arguments)
        {
            if(argument==Direction.e){
                len--;
                if(i==len)
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


            if (i!=1)
                if(i!= len)
                    System.out.print(','+message);
                else
                    System.out.println(','+message);
            else
                if(i!= len)
                    System.out.print(message);
                else
                    System.out.println(message);
        }
        System.out.println("Stop");
    }

    public static Direction[] stringToDirections(String input){
        char[] chars=input.toCharArray();
        int len=input.length();
        Direction[] directions = new Direction[len];
        for(int i=0;i<len;i++){

            if(chars[i]=='f' || chars[i]=='b' || chars[i]=='r' || chars[i]=='l')
                directions[i]= Direction.valueOf(String.valueOf(chars[i]));
            else
                directions[i]=Direction.e;
        }
        return directions;
    }

     public static void main(String[] args) {
         Scanner scan= new Scanner(System.in);
         System.out.println("system wystartowal");
         String input=scan.nextLine();
         Direction[] directions=stringToDirections(input);
         run(directions);
         System.out.println("system zakończyl dzialanie");

    }

}
