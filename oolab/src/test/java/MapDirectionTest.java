import agh.ics.oop.MapDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {
    @Test
    public void nextTest(){
       Assertions.assertEquals(MapDirection.South,MapDirection.East.next());
       Assertions.assertEquals(MapDirection.East,MapDirection.North.next());
       Assertions.assertEquals(MapDirection.West,MapDirection.South.next());
       Assertions.assertEquals(MapDirection.North,MapDirection.West.next());
    }
    @Test
    public void previousTest(){
        Assertions.assertEquals(MapDirection.East,MapDirection.South.previous());
        Assertions.assertEquals(MapDirection.North,MapDirection.East.previous());
        Assertions.assertEquals(MapDirection.South,MapDirection.West.previous());
        Assertions.assertEquals(MapDirection.West,MapDirection.North.previous());
    }
}
