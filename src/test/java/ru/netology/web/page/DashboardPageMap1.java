package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPageMap1 {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement map1 = $("[data-test-id=92df3f1c-a033-48e6-8390-206f6b1f56c0]");
    private SelenideElement updateButton = $("[data-test-id=action-transfer]");
    private SelenideElement sum = $("[data-test-id=amount] input");
    private SelenideElement fromCard = $("[data-test-id=from] input");


    public DashboardPage fromCard(DataHelper.CardFirst cardFirst){
        map1.click();
        sum.setValue("100");
        fromCard.setValue(cardFirst.getFirst());
        updateButton.click();
        return new DashboardPage();
    }
}
