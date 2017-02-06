package com.epam.controller;

import com.epam.exception.LoginException;
import com.epam.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by Konstantin Yalovik on 30.01.2017.
 */
@Controller
public class LoginController {

    public static final String SUCCESSFUL_LOGIN = "successfulLogin";

    public static final String ERROR_PAGE = "errorPage";

    public static final String USERNAME = "username";

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String username, @RequestParam String password){
        loginService.processLogin(username, password);

        return new ModelAndView(SUCCESSFUL_LOGIN, USERNAME, username);
    }

    @ExceptionHandler(LoginException.class)
    public ModelAndView handleLoginException(Exception ex){
        return new ModelAndView(ERROR_PAGE, "exception", ex);
    }
}
