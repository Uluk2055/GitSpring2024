package demoqa_tests;

import org.testng.annotations.Test;

public class BasicAuthDemo extends BaseTest{

    @Test
    public void basicAuthTest() throws InterruptedException {

        helpers.getBrowserManager().openURL("https://admin:admin@practice.expandtesting.com/digest-auth");
        Thread.sleep(5000);
    }

    @Test
    public void basicAuthTelentLMS() throws InterruptedException {
        helpers.getBrowserManager().openURL("https://ouk2055:1111Sad!@ouk2055.talentlms.com");
        Thread.sleep(10000);
    }

}
