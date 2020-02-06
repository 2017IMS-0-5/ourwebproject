package com.example.webproject.entity;

import java.io.Serializable;

public class UserFavorMultiKey implements Serializable{
        private String userAccount;
        private String infold;

        public String getUserAccount() {
            return userAccount;
        }

        public void setUserAccount(String userAccount) {
            this.userAccount = userAccount;
        }

        public String getInfold() {
            return infold;
        }

        public void setInfold(String infold) {
            this.infold = infold;
        }
}
