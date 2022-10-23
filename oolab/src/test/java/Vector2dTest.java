import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {

    @Test
    public void equalsTest() {
        Vector2d v1 = new Vector2d(1, 1);
        Assertions.assertTrue(v1.equals(new Vector2d(1, 1)));
        Assertions.assertTrue(v1.equals(v1));
        Assertions.assertFalse(v1.equals(new Vector2d(1, -1)));
        Assertions.assertFalse(v1.equals(new Vector2d(4, 1)));
        Assertions.assertFalse(v1.equals(new Vector2d(4, 4)));
        Assertions.assertFalse(v1.equals("(1,1)"));
    }

    @Test
    public void toStringTest() {
        Assertions.assertEquals("(1,2)", new Vector2d(1, 2).toString());
        Assertions.assertEquals("(1234458998,-984745678)", new Vector2d(1234458998, -984745678).toString());
        Assertions.assertNotEquals("(3,-2)", new Vector2d(-3, -2).toString());
    }

    @Test
    public void precedesTest() {
        Vector2d v1 = new Vector2d(2, 3);
        Assertions.assertTrue(v1.precedes(new Vector2d(3, 4)));
        Assertions.assertTrue(v1.precedes(new Vector2d(2, 3)));
        Assertions.assertFalse(v1.precedes(new Vector2d(-1, 90)));
        Assertions.assertFalse(v1.precedes(new Vector2d(93920, 2)));
    }

    @Test
    public void followsTest() {
        Vector2d v1 = new Vector2d(-3, 6);
        Assertions.assertTrue(v1.follows(new Vector2d(-3, 6)));
        Assertions.assertTrue(v1.follows(new Vector2d(-40, -98499)));
        Assertions.assertFalse(v1.follows(new Vector2d(-3, 7)));
        Assertions.assertFalse(v1.follows(new Vector2d(-2, 6)));
        Assertions.assertFalse(v1.follows(new Vector2d(-2, 7)));
    }

    @Test
    public void upperRightTest() {
        Vector2d v1 = new Vector2d(1, 1);
        Assertions.assertEquals(v1, new Vector2d(0, 1).upperRight(new Vector2d(1, 0)));
        Assertions.assertEquals(v1, new Vector2d(1, 1).upperRight(new Vector2d(1, 1)));
        Assertions.assertNotEquals(v1, new Vector2d(1, -10).upperRight(new Vector2d(-12, 2)));
    }

    @Test
    public void lowerLeftTest() {
        Vector2d v1 = new Vector2d(0, 0);
        Assertions.assertEquals(v1, new Vector2d(0, 1).lowerLeft(new Vector2d(1, 0)));
        Assertions.assertEquals(v1, new Vector2d(0, 0).lowerLeft(new Vector2d(0, 0)));
        Assertions.assertNotEquals(v1, new Vector2d(0, -10).lowerLeft(new Vector2d(12, 2)));
    }

    @Test
    public void addTest() {
        Vector2d v1 = new Vector2d(6, 8), v2 = new Vector2d(-2, 0);
        Assertions.assertEquals(v1, v2.add(new Vector2d(8, 8)));
        Assertions.assertNotEquals(v2, v1.add(new Vector2d(-4, -8)));
    }

    @Test
    public void subtractTest() {
        Vector2d v1 = new Vector2d(6, 8), v2 = new Vector2d(-2, 0);
        Assertions.assertEquals(v1, v2.subtract(new Vector2d(-8, -8)));
        Assertions.assertNotEquals(v2, v1.subtract(new Vector2d(4, 8)));
    }

    @Test
    public void oppositeTest() {
        Vector2d v1 = new Vector2d(3, 4), v2 = new Vector2d(-3, -4);
        Vector2d v3 = new Vector2d(0, 0);
        Assertions.assertEquals(v1, v2.opposite());
        Assertions.assertEquals(v3, v3.opposite());
        Assertions.assertNotEquals(v1, v1.opposite());
    }
}
