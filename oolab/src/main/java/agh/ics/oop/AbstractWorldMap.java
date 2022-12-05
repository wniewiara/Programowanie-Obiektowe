package agh.ics.oop;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected Map<Vector2d, Grass> grassTufts = new HashMap<>();
    protected Map<Vector2d, Animal> animalsOnMap = new HashMap<>();
    protected int width;
    protected int height;

    public abstract int[] findBoundaries();

    @Override
    public boolean canMoveTo(Vector2d position) {

        return !isOccupied(position) && position.x <= this.width && position.x >= 0 && position.y <= this.height && position.y >= 0;
    }

    @Override
    public boolean place(Animal animal) {
        if (objectAt(animal.getPosition()) instanceof Animal || !this.equals(animal.getMap())) {
            return false;
        } else {

            animalsOnMap.put(animal.getPosition(),animal);
            return true;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {


        if (animalsOnMap.get(position) != null) {
            return true;
        }

        return grassTufts.get(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {

        Animal animal = animalsOnMap.get(position);
        Grass grass = grassTufts.get(position);

        if(animal != null)
            return animal;

        return grass;
    }

    @Override
    public String toString() {
        int minX = findBoundaries()[0], minY = findBoundaries()[1];
        int maxX = findBoundaries()[2], maxY = findBoundaries()[3];
        return new MapVisualizer(this).draw(new Vector2d(minX,minY), new Vector2d(maxX , maxY ));
    }

    @Override
    public void positionChange(Vector2d oldPosition, Vector2d newPosition) {

        Animal animal = animalsOnMap.get(oldPosition);
        animalsOnMap.remove(oldPosition);
        animalsOnMap.put(newPosition, animal);
    }
}
