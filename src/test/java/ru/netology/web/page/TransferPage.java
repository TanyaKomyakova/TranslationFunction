package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement updateButton = $("[data-test-id=action-transfer]");
    private SelenideElement sum = $("[data-test-id=amount] input");
    private SelenideElement fromCard = $("[data-test-id=from] input");

    public TransferPage(){
        heading.shouldBe(Condition.visible);
    }

    public DashboardPage fromCard1(DataHelper.CardInfo cardInfo){
        sum.setValue("100");
        fromCard.setValue(cardInfo.getCardSecond());
        updateButton.click();
        return new DashboardPage();
    }

    public DashboardPage fromCard2(DataHelper.CardInfo cardInfo){
        sum.setValue("100");
        fromCard.setValue(cardInfo.getCardFirst());
        updateButton.click();
        return new DashboardPage();
    }
}
