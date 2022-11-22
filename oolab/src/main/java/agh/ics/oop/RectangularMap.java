package agh.ics.oop;


public class RectangularMap extends AbstractWorldMap{

    public RectangularMap(int width, int height) {
        this.height = height;
        this.width = width;
    }




    @Override
    public int[] findBoundaries() {
        int[] boundaries = new int[4];
        boundaries[0] = 0;
        boundaries[1] = 0;
        boundaries[2] = width;
        boundaries[3] = height;

        return boundaries;
    }
}
