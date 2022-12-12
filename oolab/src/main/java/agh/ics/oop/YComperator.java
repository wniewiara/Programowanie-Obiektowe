package agh.ics.oop;

import java.util.Comparator;

public class YComperator implements Comparator<Vector2d> {
    @Override
    public int compare(Vector2d o1, Vector2d o2) {
        if(o1.y == o2.y)
            return Integer.compare(o1.x,o2.x);
        return Integer.compare(o1.y, o2.y);
    }
}
