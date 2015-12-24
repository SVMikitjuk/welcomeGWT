package com.mik.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mik.gwt.client.WelcomeService;
import com.mik.gwt.server.dao.UserDAO;
import com.mik.gwt.server.util.PasswordHashSalt;
import com.mik.gwt.server.util.Welcome;
import com.mik.gwt.shared.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

@Service("greet")
public class WelcomeServiceImpl extends RemoteServiceServlet implements WelcomeService {

    @Autowired
    private UserDAO userDAO;

    private static final Logger logger = LoggerFactory.getLogger(WelcomeServiceImpl.class);

    // Проверяем есть ли пользователь и правельность пароля
    // возвращаем построеную фразу приветствия
    // при неудочной проверке кидаем соответствующий Exception
    public String loginServer(String login, String password, String locale, Date date) throws IllegalArgumentException {

        String retStr;
        Users user = userDAO.getUsersByLogin(login);
        logger.debug("user is "  + (user==null ? "not found": "found"));

        Instant instant = Instant.ofEpochMilli(date.getTime());
        LocalTime localTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();

        if (user == null || !PasswordHashSalt.check(password, user.getPassword())) {
            logger.debug("user or password is not valid");
            throw new IllegalArgumentException("Access Denied. Check your user-name and password.");
        } else {
            logger.debug("user passed authorization");
            retStr = new Welcome(Locale.forLanguageTag(locale)).getMessage(localTime) + ", " + user.getName() +".";
        }

        return retStr ;
  }
}
