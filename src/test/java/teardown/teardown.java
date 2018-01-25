package teardown;

import org.testng.annotations.AfterSuite;

import session.Instance;

public class teardown {

    @AfterSuite
    public void finish(){
        Instance.quitDriverSession();
    }

}
