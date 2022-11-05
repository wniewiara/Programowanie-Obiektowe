import agh.ics.oop.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegrationTests {
    @Test
    public void testNorth(){
        Animal animal = new Animal();
        OptionsParser parser = new OptionsParser();
        String[] strings = {"f","f","f","f"};
        for(MoveDirection element : parser.parse(strings)){
            animal.move(element);
        };
        Assertions.assertEquals(MapDirection.North, animal.getDirection());
        Assertions.assertEquals(new Vector2d(2,4),animal.getPosition());
        Assertions.assertTrue(animal.isAt(new Vector2d(2,4)));
    }

    @Test
    public void testSouth(){
        Animal animal = new Animal();
        OptionsParser parser = new OptionsParser();
        String[] strings = {"back","r","b","r","right","r",  "backward", "sjf", "b"};
        for(MoveDirection element : parser.parse(strings)){
            animal.move(element);
        };
        Assertions.assertEquals(MapDirection.North, animal.getDirection());
        Assertions.assertEquals(new Vector2d(1,0),animal.getPosition());
        Assertions.assertTrue(animal.isAt(new Vector2d(1,0)));
    }

    @Test
    public void testWest(){
        Animal animal = new Animal();
        OptionsParser parser = new OptionsParser();
        String[] strings = {"sr","left","f","r", "right", "backward","l", "left", "f","forward"};
        for(MoveDirection element : parser.parse(strings)){
            animal.move(element);
        };
        Assertions.assertEquals(MapDirection.West, animal.getDirection());
        Assertions.assertEquals(new Vector2d(0,2),animal.getPosition());
        Assertions.assertTrue(animal.isAt(new Vector2d(0,2)));
    }

    @Test
    public void testEast(){
        Animal animal = new Animal();
        OptionsParser parser = new OptionsParser();
        String[] strings = {"backward","r","f","l","f","f","f","right","f","f","left"};
        for(MoveDirection element : parser.parse(strings)){
            animal.move(element);
        };
        Assertions.assertEquals(MapDirection.North, animal.getDirection());
        Assertions.assertEquals(new Vector2d(4,4),animal.getPosition());
        Assertions.assertTrue(animal.isAt(new Vector2d(4,4)));
    }
}
