package festivalplanner_guiModules.inputfields;

import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class FPListView extends ListView implements FPInputFields {

    public FPListView(String promptText) {

        defaultStyle();

        setMinSize(200, 48);
        setPrefSize(200, 150);
        setMaxSize(200, 300);

    }

    @Override
    public void invalidInputStyle() {

    }

    @Override
    public void defaultStyle() {

    }
}