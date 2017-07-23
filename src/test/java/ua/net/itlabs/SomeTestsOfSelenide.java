package ua.net.itlabs;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class SomeTestsOfSelenide {
    ReentrantLock lock;
    @BeforeTest
    public  void initConfig(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path+"\\chromedriver.exe");
        //Doesn't matter chrome or Chrome as this is case insensitive.
        System.setProperty("selenide.browser", "Chrome");
    }

    @Test
    public synchronized void userCanLogin() throws InterruptedException {
        open("https://github.com/");
        $(byAttribute("data-ga-click", "(Logged out) Header, clicked Sign in, text:sign-in")).click();
        wait(5000);

        $(byCssSelector("#login_field")).setValue("archital");
        $(byCssSelector("#login_field")).setValue("archital");
        $(byCssSelector("#password")).setValue("rfpljnrfpljn15");
        wait(5000);
        $(byCssSelector("#login > form > div.auth-form-body.mt-3 > input.btn.btn-primary.btn-block")).click();
        wait(5000);
        $(byCssSelector("#js-pjax-container > div.shelf.intro-shelf.js-notice > div > div > h2")).shouldHave(
                Condition.exactTextCaseSensitive( "Learn Git and GitHub without any code!")
        );

    }




}
