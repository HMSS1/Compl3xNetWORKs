package visual;
import structure.*;
import algorithm.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;


/*
    Para não executar O(N^3) toda vez que uma estatistica necessaria
    calcula apenas uma vez n*bfs = O(n(n+m)) = O(n^3)
    e armazena o resultado no grafo e atualiza os dados.

*/
public class StatisticsScatterView extends DecoratorScatterView{
	Graph graph;
	public StatisticsScatterView(ScatterView scatterView){
		super(scatterView);
        graph = scatterView.getGraph();
        graph.execute();

		VBox right = new VBox(20);
       	Label medida1 = new Label(  "Number Vertex:" + graph.getNumberVertex() + "\t" );
        Label medida2 = new Label(  "Number Edge:" + graph.getNumberEdge() + "\t" );
        Label medida3 = new Label(  "Diameter:" + graph.getDiameter() + "\t" );
        Label medida4 = new Label(  "Mean Distance:" + String.format("%.2f", graph.getMeanDistance()) + "\t" );


        right.getChildren().addAll(medida1,medida2,medida3,medida4);
        right.setAlignment(Pos.CENTER);

        BorderPane layout = new BorderPane();
        layout.setCenter(scatterView.getScatter());
        layout.setRight(right);

        Button button2 = new Button("Make File");
        button2.setOnAction(e->{
            String name = EntryBox.display("file name?");
            new MakeFile(graph).make(name);
        });

        HBox bottom = new HBox();
        bottom.getChildren().add(button2);
        layout.setBottom(bottom);
        bottom.setAlignment(Pos.CENTER);

        scene  = new Scene(layout, 600, 400);
        window.setScene(scene);
	}

}

