package ru.netology.web.test;

import com.codeborne.selenide.Condition;
import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;
import ru.netology.web.page.TransferPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.web.data.DataHelper.getCard;

public class MoneyTransferTest {

    @Test
    void makeATransferCard1(){
        val sum = 15000;
        open("http://localhost:9999");
        val loginPage = new LoginPage();
//    val loginPage = open("http://localhost:9999", LoginPageV2.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val balanсe1 = dashboardPage.getCardBalance1();
        val balanсe2 = dashboardPage.getCardBalance2();
        val transferPage = dashboardPage.transferToCard1();
        transferPage.tranfserMoney(getCard().getCardSecond(),sum);
        val finalBalance = dashboardPage.getCardBalance1();
        $("data-test-id=action-reload").click();


    }

    @Test
    void makeATransferCard2(){
        val sum = 1000000;
        open("http://localhost:9999");
        val loginPage = new LoginPage();
//    val loginPage = open("http://localhost:9999", LoginPageV2.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val balanсe = dashboardPage.getCardBalance2();
        val transferPage = dashboardPage.transferToCard2();
        transferPage.tranfserMoney(getCard().getCardFirst(),sum);
        val finalBalance = dashboardPage.getCardBalance2();

    }

}
