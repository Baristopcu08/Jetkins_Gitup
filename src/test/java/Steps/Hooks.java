package Steps;

import Utils.Driver;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void quit(){
        Driver.quit();
    }

}
