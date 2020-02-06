package festivalPlanner.gui;

import festivalPlanner.data_system.DatabaseConnection;
import festivalPlanner.gui.gui_views.ArtistView;
import festivalPlanner.gui.gui_views.EventView;
import festivalPlanner.gui.gui_views.LoginView;
import festivalPlanner.gui.gui_views.StageView;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageManager extends Application {

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        DatabaseConnection databaseConnection = new DatabaseConnection();
        SceneHandler sceneHandler = new SceneHandler(this, databaseConnection);
        LoginView loginView = new LoginView(sceneHandler, databaseConnection);

        this.stage = primaryStage;

        this.stage.setWidth(1280);
        this.stage.setHeight(800);
        this.stage.setResizable(false);
        this.stage.setTitle("Festival Planner");

        this.stage.setScene(new Scene(loginView));
        this.stage.show();
    }

    public void setStageScene(Scene scene){
        this.stage.setScene(scene);
    }

}