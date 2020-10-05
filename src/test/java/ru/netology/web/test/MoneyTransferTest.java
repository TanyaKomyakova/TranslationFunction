package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;
import ru.netology.web.page.TransferPage;

import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {
    @Test
    void shouldTransferMoneyBetweenOwnCardsV2() {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
//    val loginPage = open("http://localhost:9999", LoginPageV2.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
    }

    @Test
    void makeATransferCard1(){
        open("http://localhost:9999");
        val loginPage = new LoginPage();
//    val loginPage = open("http://localhost:9999", LoginPageV2.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        val balanсe = dashboardPage.getCardBalance();
        val transferPage = dashboardPage.map1();
        val cardReplenishment = transferPage.fromCard1(DataHelper.getCard(authInfo));
        val finalBalance = dashboardPage.getCardBalance();

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
        val balanсe = dashboardPage.getCardBalance();
        val transferPage = dashboardPage.map2();
        val cardReplenishment = transferPage.fromCard2(DataHelper.getCard(authInfo));
        val finalBalance = dashboardPage.getCardBalance();

    }

}
