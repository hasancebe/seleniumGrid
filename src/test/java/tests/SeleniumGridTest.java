package tests;

import org.junit.Test;
import utilities.SeleniumGridDriver;

import static utilities.SeleniumGridDriver.*;

public class SeleniumGridTest {
    @Test
    public void test01(){
        remoteDriverChromeOptions().get("https://amazon.com");
        SeleniumGridDriver.closeDriver();
    }

    @Test
    public void test02(){
        remoteDriverEdgeOptions().get("https://amazon.com");
        SeleniumGridDriver.closeDriver();
    }
    @Test
    public void test03(){
        setUpChromeDriver().get("https://amazon.com");
        SeleniumGridDriver.closeDriver();
    }

    @Test
    public void test04(){
        setUpEdgeDriver().get("https://amazon.com");
        SeleniumGridDriver.closeDriver();
    }

}
