package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement updateButton = $("[data-test-id=action-transfer]");
    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement cardInput = $("[data-test-id=from] input");

    public TransferPage(){
        heading.shouldBe(Condition.visible);
    }

    public void tranfserMoney(String cardNumber, int sum){
        amountField.setValue(String.valueOf(sum));
        cardInput.setValue(cardNumber);
        updateButton.click();
    }

}
