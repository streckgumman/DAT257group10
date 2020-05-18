package viewcontroller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import model.MainModel;


import java.util.ArrayList;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Ratings;
import model.TodoEntry;

public class TodoController implements page {

    private MainModel model;

    @FXML
    private FlowPane todoFlowPane;

    @FXML
    private TextArea todoTextArea;

    @FXML
    void addTodoButton(ActionEvent event) {
        model.addTodo(todoTextArea.getText());
    }

    public void initPage(MainModel model, Optional<MainPageController> empty) {
        this.model = model;
        update();
    }

    void showTodos() {
        todoFlowPane.getChildren().clear();
        if (model.getTodos() != null) {
            for (TodoEntry te : model.getTodos()) {
                AnchorPane todoItem = PageLoader.createTodoPane();
                todoFlowPane.getChildren().add(todoItem);
            }
        }
    }

    private void update() {
        todoTextArea.setText("");
        todoFlowPane.getChildren().clear();
        showTodos();
    }


    /*
    @FXML
    void addTodoButton(ActionEvent event) {
        if (todoTextArea.getText() != null) {
            TodoEntry todo = new TodoEntry(todoTextArea.getText());
            todoEntries.add(todo);
            todoListView.setItems(todoEntries);

            todoTextArea.setText(null);
        }

    }



    @FXML
    void deleteTodoButton(ActionEvent event) {

        final int selectedTodo = todoListView.getSelectionModel().getSelectedIndex();
        if (selectedTodo != -1) {
            // TodoEntry itemToRemove = todoListView.getSelectionModel().getSelectedItem();
            final int newSelectedTodo = (selectedTodo == todoListView.getItems().size() - 1) ? selectedTodo - 1 : selectedTodo;

            todoListView.getItems().remove(selectedTodo);
            todoListView.getSelectionModel().select(newSelectedTodo);

        }
    }


     */

}