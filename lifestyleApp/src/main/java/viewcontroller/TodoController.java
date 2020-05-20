package viewcontroller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import model.MainModel;


import java.util.Optional;

import javafx.fxml.FXML;
import model.TodoEntry;

public class TodoController implements page {

    private MainModel model;

    @FXML
    private FlowPane todoFlowPane;

    @FXML
    private TextField todoTextField;

    @FXML
    void addTodoButton(ActionEvent event) {
        model.addTodo(todoTextField.getText());
    }

    public void initPage(MainModel model, Optional<MainPageController> empty) {
        this.model = model;
        update();
    }



    void showTodos() {
        todoFlowPane.getChildren().clear();
        if (model.getTodos() != null) {
            for (TodoEntry te : model.getTodos()) {
                AnchorPane todoPane = PageLoader.createTodoPane();
                AnchorPane todoItem = PageLoader.createTodoItemPage();
                todoFlowPane.getChildren().add(todoPane);
                todoFlowPane.getChildren().add(todoItem);

            }
        }
    }

    private void update() {
        todoTextField.setText("");
        todoFlowPane.getChildren().clear();
        showTodos();
    }

}