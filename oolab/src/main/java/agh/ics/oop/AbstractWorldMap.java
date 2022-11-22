package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {

    protected List<Grass> grassTufts = new ArrayList<>();
    protected List<Animal> animalsOnMap = new ArrayList<>();
    protected int width;
    protected int height;

    public abstract int[] findBoundaries();

    @Override
    public boolean canMoveTo(Vector2d position) {

        return !isOccupied(position) && position.x <= this.width && position.x >= 0 && position.y <= this.width && position.y >= 0;
    }

    @Override
    public boolean place(Animal animal) {
        if (objectAt(animal.getPosition()) instanceof Animal || !this.equals(animal.getMap())) {
            return false;
        } else {

            animalsOnMap.add(animal);
            return true;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {

        for (Animal animal : animalsOnMap) {
            if (position.equals(animal.getPosition())) {
                return true;
            }
        }

        for(Grass grass : grassTufts){
            if(position.equals(grass.getPosition())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {

        for(Animal animal : animalsOnMap){
            if( animal.isAt(position))
                return animal;
        }

        for(Grass grass : grassTufts){
            if(position.equals(grass.getPosition()))
                return grass;
        }

        return null;
    }

    @Override
    public String toString() {
        int minX = findBoundaries()[0], minY = findBoundaries()[1];
        int maxX = findBoundaries()[2], maxY = findBoundaries()[3];
        return new MapVisualizer(this).draw(new Vector2d(minX,minY), new Vector2d(maxX , maxY ));
    }

}
