package com.zhelezny.vktestapp.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.zhelezny.vktestapp.CurrentUser;
import com.zhelezny.vktestapp.mvp.view.MainView;


@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public void checkAuth() {
        if(!CurrentUser.isAuthorized()) {
            //старт авторизации
            getViewState().startSignId();
        } else {
            //получение индентификатора авторизованного пользователя
            getViewState().signedId();
        }
    }
}
