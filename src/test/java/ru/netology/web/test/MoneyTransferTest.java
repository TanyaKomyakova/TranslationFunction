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
        val cardBalance1Expected = 12000;
        val cardBalance2Expected = 8000;
        val updateСardBalance1 = dashboardPage.getCardBalance1();
        val updateСardBalance2 = dashboardPage.getCardBalance2();
        assertEquals(cardBalance1Expected,updateСardBalance1);
        assertEquals(cardBalance2Expected,updateСardBalance2);
    }

    @Test
    @Order(1)
    void makeATransferCard2(){
        val sum = 1000;
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val cardBalance1 = dashboardPage.getCardBalance1();
        val cardBalance2 = dashboardPage.getCardBalance2();
        val balanсe = dashboardPage.getCardBalance2();
        val transferPage = dashboardPage.transferToCard2();
        transferPage.tranfserMoney(getCard().getCardFirst(),sum);
        val cardBalance1Expected = 9000;
        val cardBalance2Expected = 11000;
        val updateСardBalance1 = dashboardPage.getCardBalance1();
        val updateСardBalance2 = dashboardPage.getCardBalance2();
        assertEquals(cardBalance1Expected,updateСardBalance1);
        assertEquals(cardBalance2Expected,updateСardBalance2);
    }

    @Test
    @Order(3)
    void transferOfTheAmountMoreThanTheBalance(){
        val sum = 12001;
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val cardBalance1 = dashboardPage.getCardBalance1();
        val cardBalance2 = dashboardPage.getCardBalance2();
        val balanсe = dashboardPage.getCardBalance2();
        val transferPage = dashboardPage.transferToCard2();
        transferPage.tranfserMoney(getCard().getCardFirst(),sum);
        val cardBalance1Expected = -1;
        val cardBalance2Expected = 20001;
        val updateСardBalance1 = dashboardPage.getCardBalance1();
        val updateСardBalance2 = dashboardPage.getCardBalance2();
        assertEquals(cardBalance1Expected,updateСardBalance1);
        assertEquals(cardBalance2Expected,updateСardBalance2);
    }

    @Test
    @Order(4)
    void transfer1000000ToCard1(){
        val sum = 1000000;
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
        val cardBalance1Expected = -1;
        val cardBalance2Expected = 20001;
        val updateСardBalance1 = dashboardPage.getCardBalance1();
        val updateСardBalance2 = dashboardPage.getCardBalance2();
        assertEquals(cardBalance1Expected,updateСardBalance1);
        assertEquals(cardBalance2Expected,updateСardBalance2);
    }

}
