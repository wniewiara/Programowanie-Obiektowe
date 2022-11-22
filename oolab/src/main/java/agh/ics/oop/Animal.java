package agh.ics.oop;

import java.util.Objects;

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


    public Animal(IWorldMap map){
        this.map = map;
        if (!(map.objectAt(this.position) instanceof Animal)){
            this.map.place(this);
        }
        else{
            System.out.println("pozycja na której chcesz utworzyć zwierze jest już zajęta");
        }

    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
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

    public void move(MoveDirection direction) {

        switch (direction) {
            case Right -> this.direction = this.direction.next();
            case Left -> this.direction = this.direction.previous();
            case Forward -> {
                switch (this.direction) {
                    case North -> {
                        Vector2d nextPosition = this.position.add(MapDirection.North.toUnitVector());
                        if (this.map.canMoveTo(nextPosition))
                            this.position = nextPosition;
                    }
                    case South -> {
                        Vector2d nextPosition = this.position.add(MapDirection.South.toUnitVector());
                        if (this.map.canMoveTo(nextPosition))
                            this.position = nextPosition;
                    }
                    case West -> {
                        Vector2d nextPosition = this.position.add(MapDirection.West.toUnitVector());
                        if (this.map.canMoveTo(nextPosition))
                            this.position = nextPosition;
                    }
                    case East -> {
                        Vector2d nextPosition = this.position.add(MapDirection.East.toUnitVector());
                        if (map.canMoveTo(nextPosition))
                            this.position = nextPosition;
                    }
                }
            }
            case Backward -> {
                switch (this.direction) {
                    case North -> {
                        Vector2d nextPosition = this.position.subtract(MapDirection.North.toUnitVector());
                        if (this.map.canMoveTo(nextPosition))
                            this.position = nextPosition;
                    }
                    case South -> {
                        Vector2d nextPosition = this.position.subtract(MapDirection.South.toUnitVector());
                        if (this.map.canMoveTo(nextPosition))
                            this.position = nextPosition;
                    }
                    case West -> {
                        Vector2d nextPosition = this.position.subtract(MapDirection.West.toUnitVector());
                        if (map.canMoveTo(nextPosition))
                            this.position = nextPosition;
                    }
                    case East -> {
                        Vector2d nextPosition = this.position.subtract(MapDirection.East.toUnitVector());
                        if (this.map.canMoveTo(nextPosition))
                            this.position = nextPosition;
                    }
                }
            }
        }
    }


}
