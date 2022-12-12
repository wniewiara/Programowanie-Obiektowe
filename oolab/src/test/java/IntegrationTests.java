import agh.ics.oop.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegrationTests {
    IWorldMap map = new RectangularMap(5,5);
    @Test
    public void testNorth(){
        Animal animal = new Animal(map);
        OptionsParser parser = new OptionsParser();
        String[] strings = {"f","f","f","f","f","f"};
        for(MoveDirection element : parser.parse(strings)){
            animal.move(element);
        }
        Assertions.assertEquals(MapDirection.North, animal.getDirection());
        Assertions.assertEquals(new Vector2d(2,5),animal.getPosition());
        Assertions.assertTrue(animal.isAt(new Vector2d(2,5)));
    }

    @Test
    public void testSouth(){
        Animal animal = new Animal(map);
        OptionsParser parser = new OptionsParser();
        String[] strings = {"r","b","r","right","r",  "backward", "b"};
        for(MoveDirection element : parser.parse(strings)){
            animal.move(element);
        }
        Assertions.assertEquals(MapDirection.North, animal.getDirection());
        Assertions.assertEquals(new Vector2d(1,0),animal.getPosition());
        Assertions.assertTrue(animal.isAt(new Vector2d(1,0)));
    }

    @Test
    public void testWest(){
        Animal animal = new Animal(map);
        OptionsParser parser = new OptionsParser();
        String[] strings = {"left","f","r", "right", "backward","l", "left", "f","forward"};
        for(MoveDirection element : parser.parse(strings)){
            animal.move(element);
        }
        Assertions.assertEquals(MapDirection.West, animal.getDirection());
        Assertions.assertEquals(new Vector2d(0,2),animal.getPosition());
        Assertions.assertTrue(animal.isAt(new Vector2d(0,2)));
    }

    @Test
    public void testEast(){
        Animal animal = new Animal(map);
        OptionsParser parser = new OptionsParser();
        String[] strings = {"backward","r","f","l","f","f","f","right","f","f","left"};
        for(MoveDirection element : parser.parse(strings)){
            animal.move(element);
        }
        Assertions.assertEquals(MapDirection.North, animal.getDirection());
        Assertions.assertEquals(new Vector2d(5,4),animal.getPosition());
        Assertions.assertTrue(animal.isAt(new Vector2d(5,4)));
    }
    // Integretrion test to lab4

    @Test
    public void mapTest(){
        String[] input = new String[]{"f", "b", "r", "l", "f", "f","r","r", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(input);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        IWorldMap map2 = new RectangularMap(10, 5);
        Animal animal1 = new Animal(map2,new Vector2d(2,2));
        Animal animal2 = new Animal(map2,new Vector2d(3,4));
        int i = 1;
        for(MoveDirection direction : directions){
            if(i%2 == 1)
                animal1.move(direction);
            else
                animal2.move(direction);
            i++;

        }

        Assertions.assertEquals( animal1.toString(), map.objectAt(new Vector2d(2,0)).toString());
        Assertions.assertEquals(animal2.toString(), map.objectAt(new Vector2d(3,5)).toString());
        System.out.println(animal1.getPosition());
        System.out.println(animal2.getPosition());
        System.out.println(map);
        Assertions.assertTrue(map.isOccupied(animal1.getPosition()));
        Assertions.assertTrue(map.isOccupied(animal2.getPosition()));
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->map.place(new Animal(map2,new Vector2d(2,0))));

    }

}
