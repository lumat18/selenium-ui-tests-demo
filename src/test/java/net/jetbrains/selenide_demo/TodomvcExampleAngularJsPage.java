package net.jetbrains.selenide_demo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

// https://todomvc.com/examples/angularjs/#/
public class TodomvcExampleAngularJsPage {
    public SelenideElement newTodoInput = $("input.new-todo");
    public SelenideElement showItem = $(byText("Show Selenide"));

    void addItem(final String text) {
        newTodoInput.sendKeys(text);
        newTodoInput.pressEnter();
    }

    void shouldHaveShowItem() {
        showItem.shouldBe(visible);
    }

    public void clickShowItem() {
        showItem.click();
    }
}
