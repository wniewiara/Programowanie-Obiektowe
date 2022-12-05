package agh.ics.oop;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
w celu zaimplementowania mechanizmu, wykluczającego pojawienie się dwóch zwierząt w tym samym miejscu
należy dodać metodę isOccupied(Vector2d vector) sprawdzająca czy w danym miejscu jest już jakieś zwierzę,
następnie przy każdej próbie przesunięcia się zwierzęta należy sprawdzać czy może pójść w dane miejsce,
jeżeli nie to np. zostaje w tym co było. Należy również zmodyfikować konstruktor tak aby w przypadku gdy
miejsce wywołania zwierzęcia jest już zajęte przenosił je na najbliższe wolne miejsce i wyświetlał o tym
komunikat.
 */
public class Animal {
    private MapDirection direction = MapDirection.North;
    private Vector2d position = new Vector2d(2,2);
    private final IWorldMap map;
    private Set<IPositionChangeObserver> observers = new HashSet<>();


    public Animal(IWorldMap map){
        this.map = map;
        addObserver((IPositionChangeObserver) map);
        if (!(map.objectAt(this.position) instanceof Animal)){
            this.map.place(this);
        }
        else{
            System.out.println("pozycja na której chcesz utworzyć zwierze jest już zajęta");
        }

    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        addObserver((IPositionChangeObserver) map);
        this.position = initialPosition;
        if(!(map.objectAt(this.position) instanceof Animal)){
            this.map.place(this);
        }
        else{
            System.out.println("pozycja na której chcesz utworzyć zwierze jest już zajęta");
        }
    }

    public Vector2d getPosition() {

        return position;
    }

    public MapDirection getDirection() {
        return direction;
    }

    public IWorldMap getMap() {
        return map;
    }

    public String toString() {

        switch(this.direction){
            case North -> {
                return "^";
            }
            case West -> {
                return "<";
            }
            case East -> {
                return ">";
            }
            case South-> {
                return "v";
            }
        }
        return "There is something wrong with orientation of the animal";
    }

    public boolean isAt(Vector2d position) {

        return this.position.equals(position);
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    public void positionChange(Vector2d oldPosition, Vector2d newPosition){
        observers.forEach(observer -> observer.positionChange(oldPosition, newPosition));
    }

    public void move(MoveDirection direction) {

        switch (direction) {
            case Right -> this.direction = this.direction.next();
            case Left -> this.direction = this.direction.previous();
            case Forward -> {
                Vector2d nextPosition = this.position.add(this.direction.toUnitVector());
                if (this.map.canMoveTo(nextPosition)){
                    positionChange(this.position,nextPosition);
                    this.position = nextPosition;
                }


            }
            case Backward -> {
                Vector2d nextPosition = this.position.subtract(this.direction.toUnitVector());
                if (this.map.canMoveTo(nextPosition)){
                    positionChange(this.position,nextPosition);
                    this.position = nextPosition;
                }

            }
        }
    }


}
