package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;
import ru.netology.web.page.TransferPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.web.data.DataHelper.getCard;

public class MoneyTransferTest {

    @Test
    void makeATransferCard1(){
        val sum = 100;
        open("http://localhost:9999");
        val loginPage = new LoginPage();
//    val loginPage = open("http://localhost:9999", LoginPageV2.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val balanсe = dashboardPage.getCardBalance1();
        val transferPage = dashboardPage.map1();
        val cardReplenishment = transferPage.tranfserMoney(getCard().getCardSecond(),sum);
        val finalBalance = dashboardPage.getCardBalance1();


    }

    @Test
    void makeATransferCard2(){
        open("http://localhost:9999");
        val loginPage = new LoginPage();
//    val loginPage = open("http://localhost:9999", LoginPageV2.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val balanсe = dashboardPage.getCardBalance2();
        val transferPage = dashboardPage.map2();
        val cardReplenishment = transferPage.tranfserMoney(getCard().getCardFirst(),sum);
        val finalBalance = dashboardPage.getCardBalance2();

    }

}
