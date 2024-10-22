package title;

import javafx.application.Application;
import javafx.stage.Stage;
public class UserTitle extends Application {
    
    @Override
    public void start(Stage window) {
        Parameters parms = getParameters();
        String title = parms.getNamed().get("title");
        window.setTitle(title);
        window.show();
    }

}
