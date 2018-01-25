package teardown;

import org.testng.annotations.AfterSuite;

import session.Instance;

public class Teardown {

    @AfterSuite
    public void finish(){
        Instance.quitDriverSession();
    }

}
