package net.jetbrains.selenide_demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;

@Owner("AngularJS")
public class MainTest {

    private final TodomvcExampleAngularJsPage page = new TodomvcExampleAngularJsPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 8000;
        SelenideLogger.addListener("allure", new AllureSelenide());

        // Selenoid
//        Configuration.remote = "http://localhost:4444/wd/hub";
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("enableVNC", true);
//        Configuration.browserCapabilities = capabilities;
    }

    @Feature("todo")
    @Test
    void totoMvc() {
        open("https://todomvc.com/examples/angularjs/");

        page.addItem("Show Selenide");

        page.shouldHaveShowItem();
        page.clickShowItem();
    }
}
