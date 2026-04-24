package part5.part5_1;

import java.util.List;

public interface Trainable {
    boolean train(String command);
    List<String> listCommands();
}