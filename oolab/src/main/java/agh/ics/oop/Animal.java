package agh.ics.oop;
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
    private Vector2d position = new Vector2d(2, 2);

    public Animal() {
    }

    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString() {
        return "position: " + position + " direction:" + direction;
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
                        if (this.position.y < 4)
                            this.position = this.position.add(new Vector2d(0, 1));
                    }
                    case South -> {
                        if (this.position.y > 0)
                            this.position = this.position.add(new Vector2d(0, -1));
                    }
                    case West -> {
                        if (this.position.x > 0)
                            this.position = this.position.add(new Vector2d(-1, 0));
                    }
                    case East -> {
                        if (this.position.x < 4)
                            this.position = this.position.add(new Vector2d(1, 0));
                    }
                }
            }
            case Backward -> {
                switch (this.direction) {
                    case North -> {
                        if (this.position.y > 0)
                            this.position = this.position.subtract(new Vector2d(0, 1));
                    }
                    case South -> {
                        if (this.position.y < 4)
                            this.position = this.position.subtract(new Vector2d(0, -1));
                    }
                    case West -> {
                        if (this.position.x < 4)
                            this.position = this.position.subtract(new Vector2d(-1, 0));
                    }
                    case East -> {
                        if (this.position.x > 0)
                            this.position = this.position.subtract(new Vector2d(1, 0));
                    }
                }
            }
        }
    }
}
