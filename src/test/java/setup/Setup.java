package setup;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import session.Instance;

public class Setup {

    @BeforeTest
    @Parameters({"browser", "url"})
    public void init(String browser, String url) {
        if (browser.equals("chrome")) {
            Instance.chromeInitConfigAndNavigateTo(url);
        } else if (browser.equals("firefox")) {
           Instance.chromeInitConfigAndNavigateTo(url);
        }

    }

}
