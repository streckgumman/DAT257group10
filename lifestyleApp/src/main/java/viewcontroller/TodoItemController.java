package viewcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.MainModel;
import model.TodoEntry;


import java.util.Optional;

public class TodoItemController implements page {
    private MainModel model;
    private TodoEntry todo;

    @FXML
    private AnchorPane confirmationAnchorPane;

    @FXML
    private Text todoName;

    @FXML
    private CheckBox checkbox;

    @FXML
    void cancel(ActionEvent event){
        confirmationAnchorPane.toBack();
    }

    @FXML
    void confirm(ActionEvent event){
        model.removeTodo(todo);
    }

    @FXML
    void delete(ActionEvent event){
        confirmationAnchorPane.toFront();
    }

    @Override
    public void initPage(MainModel model, Optional<MainPageController> mainPage) {
        this.model = model;
        todoName.setText(todo.getDescription());
    }

    @FXML
    public void clickCheckbox(ActionEvent event){
        if (checkbox.isSelected()){
            todo.setActive();
            checkbox.setSelected(true);
        }
        else{
            todo.setInactive();
            checkbox.setSelected(false);
        }
    }

    public void setTodo(TodoEntry te) {
        this.todo = te;
    }
}
