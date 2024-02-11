package base;

import listeners.CustomITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(CustomITestListener.class)
public abstract class Tests{
    // Optional: Add any setup/tear down methods specifically for your tests

    @BeforeMethod
    public void testSetup() {
        // ...
    }

    @AfterMethod
    public void testTearDown() {
        // ...
    }
}
