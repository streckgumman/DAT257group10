package viewcontroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import model.MainModel;


import java.util.ArrayList;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.TodoEntry;

public class TodoController implements page{

    private ObservableList<TodoEntry> todoEntries = FXCollections.observableArrayList();
    private ArrayList<TodoEntry> todoEntryArrayList = new ArrayList<>();

    @FXML
    private TextArea todoTextArea;

    @FXML
    private ListView<TodoEntry> todoListView = new ListView<>();

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

    public void initPage(MainModel model, Optional<MainPageController> empty) {
    }
}