package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement refillButtonCard1 = $("[data-test-id=action-deposit]");
    private SelenideElement refillButtonCard2 = $("[data-test-id=action-deposit]");
    private ElementsCollection cards1 = $$(".list__item");
    private ElementsCollection cards2 = $$(".list__item");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage() {
        heading.shouldBe(Condition.visible);
    }

    public int getCardBalance1() {
        val text = cards1.first().text();
        return extractBalance(text);
    }

    private int extractBalance1(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public int getCardBalance2() {
        val text = cards2.first().text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public TransferPage map1() {
        refillButtonCard1.click();
        return new TransferPage();
    }

    public TransferPage map2() {
        refillButtonCard2.click();
        return new TransferPage();
    }


}