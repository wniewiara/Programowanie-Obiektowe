package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    private SortedSet<Vector2d> xSet = new TreeSet<>(new XComperator());
    private SortedSet<Vector2d> ySet = new TreeSet<>(new YComperator());


    public void addPosition(Vector2d v1){
        xSet.add(v1);
        ySet.add(v1);
    }

    public void removePosition(Vector2d v1){
        xSet.remove(v1);
        ySet.remove(v1);
    }

    public Vector2d getUpperBound(){
        return new Vector2d(xSet.last().x, ySet.last().y);
    }

    public Vector2d getLowerBound(){
        return new Vector2d(xSet.first().x, ySet.first().y);
    }

    @Override
    public void positionChange(Vector2d oldPosition, Vector2d newPosition) {
        this.removePosition(oldPosition);
        this.addPosition(newPosition);
    }
}
