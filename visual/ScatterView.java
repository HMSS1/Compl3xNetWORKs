package visual;
import structure.*;

import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.chart.*;

public abstract class ScatterView{
    Stage window;
    Graph graph;
    Scene scene;
    ScatterChart<Number,Number> sc;

    
    public ScatterView(Graph graph){
        this.graph = graph;
        window = new Stage();
        window.setTitle("Scatter Chart");

    }


    public ScatterChart<Number,Number> getScatter(){
       return sc;
    }

    public Graph getGraph(){
        return graph;
    }

    public void setScene(Scene scene){
        window.setScene(scene);
    }

    public Scene getScene(){
        return scene;
    }


	

}
