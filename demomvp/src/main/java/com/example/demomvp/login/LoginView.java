package com.example.demomvp.login;

public interface LoginView {
  void showProgress();
  void hideProgress();
  void setUserNameError();
  void setPassWordError();
  void navigateHome();
}
