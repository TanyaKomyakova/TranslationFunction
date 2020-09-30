package ru.netology.web.data;

import com.codeborne.selenide.SelenideElement;

import lombok.Data;
import lombok.Value;
@Data
public class DataHelper {
    private DataHelper(){}

    @Value
    public static class AuthInfo{
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo(){
        return new AuthInfo("vasya","qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardFirst{
        private String first;
    }

    public static CardFirst getCardFirst(AuthInfo authInfo){
        return new CardFirst("5559000000000001");
    }

    @Value
    public static class CardSecond{
        private String second;
    }

    public static CardSecond getCardSecond(AuthInfo authInfo){
        return new CardSecond("5559000000000002");
    }



}
