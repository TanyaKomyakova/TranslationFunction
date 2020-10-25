package ru.netology.web.test;

import com.codeborne.selenide.Condition;
import lombok.val;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;
import ru.netology.web.page.TransferPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.web.data.DataHelper.getCard;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MoneyTransferTest {
    @Test
    @Order(2)
    void makeATransferCard1(){
        val sum = 3000;
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val cardBalance1 = dashboardPage.getCardBalance1();
        val cardBalance2 = dashboardPage.getCardBalance2();
        val transferPage = dashboardPage.transferToCard1();
        transferPage.tranfserMoney(getCard().getCardSecond(),sum);
        val cardBalance1Expected = cardBalance1 + sum;
        val cardBalance2Expected = cardBalance2 - sum;
        val updateCardBalance1 = dashboardPage.getCardBalance1();
        val updateCardBalance2 = dashboardPage.getCardBalance2();
        assertEquals(cardBalance1Expected,updateCardBalance1);
        assertEquals(cardBalance2Expected,updateCardBalance2);
    }

    @Test
    @Order(1)
    void makeATransferCard2(){
        int sum = 1000;
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val cardBalance1 = dashboardPage.getCardBalance1();
        val cardBalance2 = dashboardPage.getCardBalance2();
        val transferPage = dashboardPage.transferToCard2();
        transferPage.tranfserMoney(getCard().getCardFirst(),sum);
        val cardBalance1Expected = cardBalance1 - sum;
        val cardBalance2Expected = cardBalance2 + sum;
        val updateCardBalance1 = dashboardPage.getCardBalance1();
        val updateCardBalance2 = dashboardPage.getCardBalance2();
        assertEquals(cardBalance1Expected,updateCardBalance1);
        assertEquals(cardBalance2Expected,updateCardBalance2);
    }

    @Test
    @Order(3)
    void transferOfTheAmountMoreThanTheBalanceOnTheCard1(){
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val cardBalance1 = dashboardPage.getCardBalance1();
        val cardBalance2 = dashboardPage.getCardBalance2();
        val sum = Math.abs(cardBalance1) + 1;
        val transferPage = dashboardPage.transferToCard2();
        transferPage.tranfserMoney(getCard().getCardFirst(),sum);
        val updateCardBalance1 = dashboardPage.getCardBalance1();
        val updateCardBalance2 = dashboardPage.getCardBalance2();
        assertEquals(cardBalance1,updateCardBalance1);
        assertEquals(cardBalance2,updateCardBalance2);
    }

    @Test
    @Order(4)
    void transferOfTheAmountMoreThanTheBalanceOnTheCard2() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val cardBalance1 = dashboardPage.getCardBalance1();
        val cardBalance2 = dashboardPage.getCardBalance2();
        val sum = Math.abs(cardBalance2) + 1;
        val transferPage = dashboardPage.transferToCard1();
        transferPage.tranfserMoney(getCard().getCardSecond(), sum);
        val updateCardBalance1 = dashboardPage.getCardBalance1();
        val updateCardBalance2 = dashboardPage.getCardBalance2();
        assertEquals(cardBalance1, updateCardBalance1);
        assertEquals(cardBalance2, updateCardBalance2);
    }
}
