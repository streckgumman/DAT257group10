package viewcontroller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import model.MainModel;


import java.util.Optional;

import javafx.fxml.FXML;
import model.TodoEntry;
import viewcontroller.observers.TodoObserver;

public class TodoController implements page, TodoObserver {

    private MainModel model;

    @FXML
    private FlowPane todoFlowPane;

    @FXML
    private TextField todoTextField;

    @FXML
    void addTodoButton(ActionEvent event) {
        model.addTodo(todoTextField.getText());
        update();
    }

    public void initPage(MainModel model, Optional<MainPageController> empty) {
        this.model = model;
        model.attachTodoOb(this);
        update();
    }

    void showTodos() {
        todoFlowPane.getChildren().clear();
        if (model.getTodos() != null) {
            for (TodoEntry te : model.getTodos()) {
                AnchorPane todoItem = PageLoader.createTodoItemPage(te);
                todoFlowPane.getChildren().add(todoItem);
                if (te.getIsDone()){
                    te.setActive();
                }
            }
        }

    }

    @Override
    public void notified() {
        update();
    }

    private void update() {
        todoTextField.setText("");
        todoFlowPane.getChildren().clear();
        showTodos();
    }


}