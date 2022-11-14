package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;


public class RectangularMap implements IWorldMap {

    public int width;
    public int height;
    public List<Animal> animalsAtMap = new LinkedList<>();

    public RectangularMap(int width, int height) {
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {

        return !isOccupied(position) && position.x < this.width && position.x >= 0 && position.y < this.height && position.y >= 0;
    }

    @Override
    public boolean isOccupied(Vector2d position) {

        for (Animal place : animalsAtMap) {
            if (position.equals(place.getPosition())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getPosition()) || !this.equals(animal.getMap())) {
            return false;
        } else {
            animalsAtMap.add(animal);
            return true;
        }
    }


    @Override
    public Object objectAt(Vector2d position) {

        for(Animal animal : animalsAtMap){
            if( animal.isAt(position))
                return animal;
        }

        return null;
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(new Vector2d(0,0), new Vector2d(this.width-1, this.height-1));
       // RectangularMap
    }
}
