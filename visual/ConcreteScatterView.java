package visual;

import structure.*;
import controller.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart.Data;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.*;
import javafx.geometry.*;
import javafx.scene.control.*;

/*
            Adicionamos responsabilidade de mostrar informações sobre o grafo
            e criar um arquivo à visão usando Decorator Pattern

                        | Scatter View |---------------------|
                            /       \                        | 
                           /         \                       |
                          /           \                      |
                         /             \                     | 
            |ConcreteScatterView| |DecoratorScatterView| <---´
                                              \                         
                                               \                       
                                                \                      
                                                 \  
                                        |StatisticsScatterView|

 */

public class ConcreteScatterView extends ScatterView{
    private GraphController controller;
    XYChart.Series series1; 
    Map<Integer, Integer> map;

    public ConcreteScatterView(GraphController controller){
        super(controller.getGraph());
        this.controller = controller;
        controller.setObserver(this); //Observa o modelo
        map = new HashMap<>();
        
        controller.start(); //Pede pro controlador adicionar elementos ao grafo.

        
        System.out.println("Graph Ready"); //Grafo concluido
        this.show(); //Mostra uma nova tela.
    }


    public void update(int u, int vi){
        System.out.println(u + " " + vi);
        this.graph = controller.getGraph();
        System.out.println("Graph updated");
    }

    public void show(){
        HBox top = new HBox(20);
        Button button1 = new Button("Statistics"); 
        button1.setOnAction(e->{
                window.setScene(new StatisticsScatterView(this).getScene());
        });


        top.getChildren().addAll(button1);
        top.setAlignment(Pos.CENTER);



        final NumberAxis xAxis = new NumberAxis(0, 1,1);
        final NumberAxis yAxis = new NumberAxis(0, 1,1);        
        sc = new ScatterChart<Number,Number>(xAxis,yAxis);
        sc.getXAxis().setAutoRanging(true);
        sc.getYAxis().setAutoRanging(true);

        xAxis.setLabel("Degree");                
        yAxis.setLabel("#Vertex");
       
        series1 = new XYChart.Series();
        series1.setName("");

        
        for (Integer v : graph.getVertexs()) {
            map.put(graph.getDegree(v), 0);
        }

        for (Integer v : graph.getVertexs()) {
            map.put(graph.getDegree(v), map.get(graph.getDegree(v))+1);
        }

        for (Map.Entry<Integer,Integer> it : map.entrySet()) {
            series1.getData().add(new XYChart.Data(it.getKey(),it.getValue()));
        }

        sc.getData().addAll(series1);


        BorderPane layout = new BorderPane();
        layout.setCenter(sc);
        layout.setTop(top);

        scene  = new Scene(layout, 500, 400);
        window.setScene(scene); 
        window.show(); 
    }

   

}
