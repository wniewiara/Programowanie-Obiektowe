package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap{

    private final int grassPlaces;


    public GrassField(int grassPlaces){
        this.grassPlaces = grassPlaces;

        grassGenerator();
    }

    public void grassGenerator(){

        while( grassTufts.size()<this.grassPlaces){
            Random random = new Random();
            int x = random.nextInt((int)(Math.sqrt(this.grassPlaces*10) + 1));
            int y = random.nextInt((int)(Math.sqrt(this.grassPlaces*10) + 1));

            Vector2d vector2d = new Vector2d(x,y);
            if(!(isOccupied(vector2d))){
                Grass grass = new Grass(vector2d);
                grassTufts.add(grass);
            }
        }

    }

    public List<Grass> getGrassTufts() {
        return grassTufts;
    }

    @Override
    public int[] findBoundaries() {

        int[] boundaries = new int[4];

        int maxX, minX, maxY, minY;
        maxY = minY = grassTufts.get(0).getPosition().y;
        maxX = minX = grassTufts.get(0).getPosition().x;
        for(Grass grass : grassTufts){
            if(grass.getPosition().x > maxX)
                maxX = grass.getPosition().x;
            if(grass.getPosition().y > maxY)
                maxY = grass.getPosition().y;
            if(grass.getPosition().x < minX)
                minX = grass.getPosition().x;
            if(grass.getPosition().y < minY)
                minY = grass.getPosition().y;
        }

        for(Animal animal : animalsOnMap){
            if(animal.getPosition().x > maxX)
                maxX = animal.getPosition().x;
            if(animal.getPosition().y > maxY)
                maxY = animal.getPosition().y;
            if(animal.getPosition().x < minX)
                minX = animal.getPosition().x;
            if(animal.getPosition().y < minY)
                minY = animal.getPosition().y;
        }
        boundaries[0] = minX;
        boundaries[1] = minY;
        boundaries[2] = maxX;
        boundaries[3] = maxY;

        return boundaries;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

}
