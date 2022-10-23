package agh.ics.oop;

public enum MapDirection {
    North,
    South,
    West,
    East;


    public String toString() {
        String name;
        switch (this.name()) {
            case "West" -> name = "Zachód";
            case "East" -> name = "Wschód";
            case "North" -> name = "Północ";
            case "South" -> name = "Południe";
            default -> name = "Error";
        }
        return name;
    }

    public MapDirection next() {
        switch (this) {
            case East -> {
                return South;
            }
            case South -> {
                return West;
            }
            case West -> {
                return North;
            }
            case North -> {
                return East;
            }

        }
        return null;
    }

    public MapDirection previous() {
        switch (this) {
            case East -> {
                return North;
            }
            case South -> {
                return East;
            }
            case West -> {
                return South;
            }
            case North -> {
                return West;
            }

        }
        return null;
    }

    public Vector2d toUnitVector() {

        Vector2d unitVector = new Vector2d(0, 0);

        switch (this) {
            case East -> {
                unitVector = new Vector2d(1, 0);
            }
            case South -> {
                unitVector = new Vector2d(0, -1);
            }
            case West -> {
                unitVector = new Vector2d(-1, 0);
            }
            case North -> {
                unitVector = new Vector2d(0, 1);
            }

        }
        return unitVector;
    }
}
