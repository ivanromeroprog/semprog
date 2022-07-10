/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seminarioprogramacion.main;

import java.util.concurrent.TimeoutException;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.testfx.framework.junit5.ApplicationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.testfx.api.FxToolkit;

/**
 *
 * @author ikukl
 */
public abstract class TestFXBase extends ApplicationTest {
    @BeforeEach
    public void setUpClass() throws Exception{
        ApplicationTest.launch(App.class);
    }
    
    @Override
    public void start(Stage stage) throws Exception{
        stage.show();
    }

    
    @AfterEach
    public void afterEachTest() throws TimeoutException{
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }
    
    // Método de ayuda para devolver elementos GUI de JavaFX
    public <T extends Node> T find(final String query){
        return (T) lookup(query).queryAll().iterator().next();
    }
}
