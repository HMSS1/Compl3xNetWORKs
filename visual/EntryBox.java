package visual;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class EntryBox {

	static String result;

	public static String display(String msg){
		Stage window = new Stage();

		window.initModality(Modality.APPLICATION_MODAL);
		

		window.setTitle("");
		window.setMinWidth(250);

		Label label = new Label();
		label.setText(msg);

		TextField path = new TextField();

		Button ok = new Button("OK");
		ok.setOnAction(e -> {
			result = path.getCharacters().toString();
			window.close();
		});

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, path, ok);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout, 700,300);
		window.setScene(scene);
		window.showAndWait();


		return result;
	}
}