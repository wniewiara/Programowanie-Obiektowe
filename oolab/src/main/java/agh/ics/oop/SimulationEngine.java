package agh.ics.oop;



public class SimulationEngine implements IEngine {

    private MoveDirection[] directions;
    private Animal[] animals;
    private IWorldMap map;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){

        this.directions = directions;
        this.animals = new Animal[positions.length];
        this.map = map;
        int i = 0;
        for(Vector2d vector : positions){
            Animal animal = new Animal(this.map, vector);
            animals[i] = animal;
            i++;
            this.map.place(animal);
        }
    }

    @Override
    public void run() {

        int i = 0;
        for(MoveDirection direction : directions){
            this.animals[i].move(direction);
            i=(i+1)% animals.length;
        }
    }
}
