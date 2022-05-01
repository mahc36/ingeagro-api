package com.co.ingeagro.controller;

public interface ControllerConstants {

    // CORS matriculation
    String REQUEST_ORIGIN = "http://localhost:4200";

    String CREATE = "/create";
    String SAVE = "/save";
    String UPDATE = "/update";
    String FIND = "/find";
    String FIND_ALL = "/findAll";
    String FIND_BY_ID = "/findById";

    interface User{
        String ROOT_REQUEST = "/user";
        String FIND_BY_USERNAME = "/findByUsername";
        String LOGIN = "/login";
        String LOGIN_PROFILE = "/login-profile";
    }

    interface Gender{
        String ROOT_REQUEST = "/gender";
    }

    interface ProductType{
        String ROOT_REQUEST = "/product-type";
    }

    interface IdentificationType{
        String ROOT_REQUEST = "/identification-type";
    }

    interface Profile{
        String ROOT_REQUEST = "/profile";
        String LOGIN = "/login";
    }


}
