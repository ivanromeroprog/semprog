package com.seminarioprogramacion.semtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.stage.Modality;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("LoginWindow"));
        this.stage = stage;
        stage.setTitle("Sistema Supercharger");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
    }

    /*
    No usar 
    */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    /*
    No usar 
    */
    static void setRoot(String fxml, double height, double witdh) throws IOException {
        stage.setHeight(height);
        stage.setWidth(witdh);
        scene.setRoot(loadFXML(fxml));
    }

    /*
    Carga el archivo FXML de vista
    */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    /*
    Crea una nueva ventana de la aplicación sin cerrar la anterior
    */
    public static Stage newWindow(String vista, Stage parentw) throws IOException {
        Scene sn = new Scene(loadFXML(vista));
        Stage st = new Stage();
        st.setScene(sn);
        st.initOwner(parentw);
        st.initModality(Modality.APPLICATION_MODAL); 
        st.showAndWait();
        return st;
    }
    
        /*
    Crea una nueva ventana de la aplicación sin cerrar la anterior
    */
    public static Stage newWindow(String vista, Stage parentw, String titulo) throws IOException {
        Scene sn = new Scene(loadFXML(vista));
        Stage st = new Stage();
        st.setScene(sn);
        st.setTitle(titulo);
        st.initOwner(parentw);
        st.initModality(Modality.APPLICATION_MODAL); 
        st.showAndWait();
        return st;
    }

    /*
    Crea una nueva ventana modal (no se puede interactuar con el padre) sin cerrar la anterior
    */
    public static Stage newWindow(String vista) throws IOException {
        Scene sn = new Scene(loadFXML(vista));
        Stage st = new Stage();
        st.setScene(sn);
        st.show();

        return st;
    }

    /*
    Crea una nueva ventana modal (no se puede interactuar con el padre) sin cerrar la anterior
    */
    public static Stage newWindow(String vista, String titulo) throws IOException {
        Scene sn = new Scene(loadFXML(vista));
        Stage st = new Stage();
        st.setScene(sn);
        st.setTitle(titulo);
        st.show();

        return st;
    }
    public static void main(String[] args) {
        launch(args);
    }

}
