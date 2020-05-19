package Tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class First_Tests {

    @Test(description = "Перейти на сайт", groups = "TC")
    public void goToWebsite() {
        open("https://www.sberbank.ru/ru/person");
        //$(withText("Генеральная лицензия")).scrollIntoView(true);
        $(withText("Генеральная лицензия")).shouldBe(Condition.exist);

    }

    @Test(description = "Авторизация в демо режиме", groups = "TC")
    public void demoAuthorization() {
        goToWebsite();
        $(By.xpath("//div[contains(@class,'ya-site-form-search__button ya-site-form-search_visible')]")).click();
        $(By.xpath("//input[contains(@name,'text')]")).setValue("демо").pressEnter();
        $(withText("версия Сбербанк Онлайн")).click();
        switchTo().window(1);
        $(byTitle("Выключить обучение")).click();
        $(byText("Выход")).click();
        $(byText("Скрыть подсказки")).click();
        $(By.id("login")).setValue("SberClient");
        $(By.id("password")).setValue("12345678").pressEnter();
        $(By.className("enjoyhint_skip_btn")).click();
        $(By.name("$$confirmSmsPassword")).setValue("12345");
        $(By.xpath("//div[@class='clientButton']//div[contains(@class,'buttonGreen')]")).click();
        $(byText("Выключить обучение")).click();
        closeWebDriver();
    }

    @Test(description = "Переход в демо Сбербанк бизнес онлайн", groups = "TC")
    public void goToBussinessDemo() {
        goToWebsite();
        $(By.xpath("//div[contains(@class,'ya-site-form-search__button ya-site-form-search_visible')]")).click();
        $(By.xpath("//input[contains(@name,'text')]")).setValue("демо").pressEnter();
        $(withText("Сбербанк Бизнес Онлайн")).click();
        switchTo().window(1);
        $(By.xpath("//a[@class='b-btn btn-inverse b-btn_green-hover']")).click();
        $(byClassName("link-outer")).click();
        $(byText("Войти в демо-режим")).click();
        closeWebDriver();

    }

    @Test(description = "Поиск и клик вакансий", groups = "TC")
    public void searchVacanciesAndClick() {
        goToWebsite();
        $(byXpath("//div[contains(@class,'kit-col kit-col_xs_12 kit-col_md_7 kit-col_lg_7 footer__subfooter-col')]//li[3]//a[1]")).scrollIntoView(true).click();
        $(byClassName("career__search-input")).setValue("Тестировщик").pressEnter();
        switchTo().window(1);
        $(withText("Автотестировщик")).click();
        closeWebDriver();
    }

    @Test(description = "Переход в раздел о банке, оценить статью и отправить отзыв", groups = "TC")
    public void goToInfoAboutBank() {
        goToWebsite();
        $(byXpath("//div[contains(@class,'kit-col kit-col_xs_12 kit-col_md_7 kit-col_lg_7 footer__subfooter-col')]//li[2]//a[1]")).scrollIntoView(true).click();
        $(byText("Страница была вам полезна?")).scrollIntoView(true);
        $(byClassName("form-like__icon-like")).click();
        $(byXpath("//textarea[contains(@placeholder,'Что мы могли бы улучшить?')]")).setValue("бла-бла");
        closeWebDriver();
    }

}
