package persistence;

import java.io.IOException;

public interface Persistence {
  void save() throws IOException;

  void load() throws IOException;
}
