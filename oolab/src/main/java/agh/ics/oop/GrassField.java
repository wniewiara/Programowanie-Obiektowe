package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap{

    private final int grassPlaces;


    public GrassField(int grassPlaces){
        this.grassPlaces = grassPlaces;
        grassGenerator();
    }

    public void grassGenerator(){

        while( grassTufts.size() < this.grassPlaces){
            Random random = new Random();
            int x = random.nextInt((int)(Math.sqrt(this.grassPlaces*10) + 1));
            int y = random.nextInt((int)(Math.sqrt(this.grassPlaces*10) + 1));

            Vector2d vector2d = new Vector2d(x,y);
            if(!(isOccupied(vector2d))){
                Grass grass = new Grass(vector2d);
                grassTufts.put(vector2d, grass);
                mapBoundary.addPosition(vector2d);
            }
        }

    }

    public Map<Vector2d,Grass> getGrassTufts() {
        return grassTufts;
    }

    @Override
    public int[] findBoundaries() {

        int[] boundaries = new int[4];
        boundaries[0] = mapBoundary.getLowerBound().x;
        boundaries[1] = mapBoundary.getLowerBound().y;
        boundaries[2] = mapBoundary.getUpperBound().x;
        boundaries[3] = mapBoundary.getUpperBound().y;

        return boundaries;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

//    @Override
//    public boolean place(Animal animal){
//        mapBoundary.addPosition(animal.getPosition());
//        super.place(animal);
//        return true;
//    }
//
//    @Override
//    publi

}
