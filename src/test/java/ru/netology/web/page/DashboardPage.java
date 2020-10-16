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
    private SelenideElement refillButtonCard1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] [data-test-id='action-deposit']");
    private SelenideElement refillButtonCard2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] [data-test-id='action-deposit']");
    private ElementsCollection cards = $$(".list__item");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage() {
        heading.shouldBe(Condition.visible);
    }

    public int getCardBalance1() {
        val text = cards.first().text();
        return extractBalance1(text);
    }

    private int extractBalance1(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public int getCardBalance2() {
        val text = cards.last().text();
        return extractBalance2(text);
    }

    private int extractBalance2(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public TransferPage transferToCard1 () {
        refillButtonCard1.click();
        return new TransferPage();
    }

    public TransferPage transferToCard2() {
        refillButtonCard2.click();
        return new TransferPage();
    }

}