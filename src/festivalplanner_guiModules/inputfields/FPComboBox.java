package festivalplanner_guiModules.inputfields;

import festivalPlanner.data_system.Artist;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;

public class FPComboBox extends ComboBox<Artist> {

    public FPComboBox(String promptText) {

        defaultStyle();



        setPromptText(promptText);

        setMinSize(150,40);
        setPrefSize(150,40);
        setMaxSize(150,40);


    }



    public void defaultStyle() {
        setStyle("-fx-background-color: #EEEEEE; " +
                "-fx-text-fill: #B76F88; " +
                "-fx-background-radius: 50; " +
                "-fx-font-size: 15; " +
                "-fx-font-family: Helvetica; " +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0 , 0 , 1.5 );");
    }
}
