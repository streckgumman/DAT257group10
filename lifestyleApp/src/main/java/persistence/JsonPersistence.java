package persistence;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import model.MainModel;
import model.User;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonPersistence implements Persistence {
  private MainModel model; // reference to the model
  private Gson gson; // gson instance to convert from and to JSON
  private File jsonFile; // path to JSON user file

  public JsonPersistence(MainModel model) {
    this.model = model;
    gson = new Gson();
  }

  @Override
  public void save() throws IOException {
    FileWriter writer = new FileWriter("data.json");

    List<User> users = model.getUsers();
    String json = gson.toJson(users);
    writer.write(json);
    writer.close();
  }

  @Override
  public void load() throws IOException {
    FileReader reader = new FileReader("data.json");
    Type listType = new TypeToken<List<User>>() {}.getType();

    List<User> users = gson.fromJson(reader, listType);
    model.setUsers(users);
  }
}
