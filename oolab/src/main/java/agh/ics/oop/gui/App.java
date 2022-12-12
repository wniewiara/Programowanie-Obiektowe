package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {

    private Label label;
    private GridPane grid = new GridPane();
    private AbstractWorldMap map;

    @Override
    public void init() throws Exception {
        super.init();
        List<String> arguments = getParameters().getRaw();
        String[] args = arguments.toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(args);
        map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map);
        grid.getColumnConstraints().add(new ColumnConstraints(20));
        grid.getRowConstraints().add(new RowConstraints(20));
        grid.setAlignment(Pos.CENTER);
        label = new Label("y/x");
        grid.add(label,0,0);
        GridPane.setHalignment(label, HPos.CENTER);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        grid.setGridLinesVisible(true);
        int width = map.getUpperBound().x - map.getLowerBound().x;
        int height = map.getUpperBound().y - map.getLowerBound().y;

        for(int i = 0; i<=width; i++){
            int widthIndex = map.getLowerBound().x + i;
            label = new Label(Integer.toString(widthIndex));
            grid.add(label,i+1,0);
            GridPane.setHalignment(label, HPos.CENTER);

            for(int j = 0; j<=height; j++){
                if( i==0 ){
                    int heightIndex = map.getUpperBound().y - j;
                    label = new Label(Integer.toString(heightIndex));
                    grid.add(label,0,j+1);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
                String object = drawObject(new Vector2d(i + map.getLowerBound().x,
                        j + map.getLowerBound().y));
                label = new Label(object);
                grid.add(label,i+1,height-j+1);
                GridPane.setHalignment(label,HPos.CENTER);
            }
        }
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String drawObject(Vector2d currentPosition) {
        String result = null;
        if (this.map.isOccupied(currentPosition)) {
            Object object = this.map.objectAt(currentPosition);
            if (object != null) {
                result = object.toString();
            } else {
                result = " ";
            }
        } else {
            result = " ";
        }
        return result;
    }
}
