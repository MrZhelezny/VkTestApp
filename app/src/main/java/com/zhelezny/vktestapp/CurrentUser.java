package com.zhelezny.vktestapp;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdk;


public class CurrentUser {

    //возврат токен доступа от сервера VK
    public static String getAccesToken() {
        if (VKAccessToken.currentToken() == null)
            return null;
        return VKAccessToken.currentToken().accessToken;
    }

    //возврат ID текущего пользователя, если получен токен
    public static String getId() {
        if (VKAccessToken.currentToken() == null)
            return null;
        return VKAccessToken.currentToken().userId;
    }

    //если пользователь авторизован, пользовательский токен != 0 и не устарел
    public static boolean isAuthorized() {
        return VKSdk.isLoggedIn()
                && VKAccessToken.currentToken() != null
                && VKAccessToken.currentToken().isExpired();
    }
}
