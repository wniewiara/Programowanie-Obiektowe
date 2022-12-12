import agh.ics.oop.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapTests {

    RectangularMap map = new RectangularMap(5,5);
    GrassField grassField = new GrassField(10);
    GrassField grassField2 = new GrassField(10);
    Vector2d v1 = new Vector2d(2,2);
    Vector2d v2 = new Vector2d(3,3);
    Vector2d v3 = new Vector2d(1,1);
    Vector2d v4 = new Vector2d(100, 100);
    Animal animal1 = new Animal(map, v1);
    Animal animal2 = new Animal(grassField, v1);
    Animal animal3 = new Animal(map, v2);
    Vector2d grassPosition = grassField2.getGrassTufts().entrySet().iterator().next().getValue().getPosition();

    @Test
    public void canMoveToTest(){

        Assertions.assertTrue(map.canMoveTo(new Vector2d(2,3)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(2,2)));
        Assertions.assertTrue(grassField.canMoveTo(new Vector2d(2,3)));
        Assertions.assertFalse(grassField.canMoveTo(new Vector2d(2,2)));

    }

    @Test
    public void placeTest(){

        Assertions.assertThrows(IllegalArgumentException.class,
                ()->grassField.place(animal1));
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->grassField.place(animal2));
        Assertions.assertTrue(grassField.place(animal3));
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->map.place(animal1));
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->map.place(animal2));
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->map.place(animal3));

    }

    @Test
    public void objectAtTest(){

        Assertions.assertEquals(map.objectAt(v1),animal1);
        Assertions.assertEquals(grassField.objectAt(v1),animal2);
        Assertions.assertNull(map.objectAt(v3));
        Assertions.assertNull(map.objectAt(v4));
        Assertions.assertNull(grassField.objectAt(v4));



        Assertions.assertEquals(grassField2.objectAt(grassPosition), grassField2.getGrassTufts().get(grassPosition));

        Animal animal4 = new Animal(grassField2, grassPosition);

        Assertions.assertEquals(grassField2.objectAt(grassPosition), animal4);

    }

    @Test
    public void isOccupiedTest(){

        Assertions.assertTrue(map.isOccupied(v1));
        Assertions.assertTrue(grassField.isOccupied(v1));
        Assertions.assertTrue(grassField2.isOccupied(grassPosition));
        Assertions.assertFalse(map.isOccupied(v3));
        Assertions.assertFalse(grassField.isOccupied(v4));

    }
}
