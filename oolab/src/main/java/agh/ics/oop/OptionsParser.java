package agh.ics.oop;

public class OptionsParser  {

    public MoveDirection[] parse(String[] array) {
        int size = 0, iterator = -1;

        for (String element : array) {
            if (element.equals("b") || element.equals("backward") ||
                    element.equals("f") || element.equals("forward") ||
                    element.equals("r") || element.equals("right") ||
                    element.equals("l") || element.equals("left")) {
                size++;

            }
        }
        MoveDirection[] directions = new MoveDirection[size];
        for (String element : array) {
            if (element.equals("b") || element.equals("backward")) {
                iterator++;
                directions[iterator] = MoveDirection.Backward;

            }
            if (element.equals("f") || element.equals("forward")) {
                iterator++;
                directions[iterator] = MoveDirection.Forward;
            }
            if (element.equals("r") || element.equals("right")) {
                iterator++;
                directions[iterator] = MoveDirection.Right;
            }
            if (element.equals("l") || element.equals("left")) {
                iterator++;
                directions[iterator] = MoveDirection.Left;
            }
        }
        return directions;
    }
}
