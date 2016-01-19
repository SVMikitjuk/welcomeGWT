package com.mik.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mik.gwt.client.service.WelcomeService;
import com.mik.gwt.server.dao.UserDAO;
import com.mik.gwt.server.util.PasswordHashSalt;
import com.mik.gwt.server.util.Welcome;
import com.mik.gwt.shared.Response;
import com.mik.gwt.shared.ResponseStat;
import com.mik.gwt.shared.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Service("greet")
public class WelcomeServiceImpl extends RemoteServiceServlet implements WelcomeService {

    @Autowired
    private UserDAO userDAO;

    private static final Logger logger = LoggerFactory.getLogger(WelcomeServiceImpl.class);

    // Проверяем есть ли пользователь и правельность пароля
    // возвращает обьект ответа
    public Response loginServer(String login, String password, String locale, Date date) {

        Response ret;
        Users user = userDAO.getUsersByLogin(login);
        logger.debug("user is " + (user == null ? "not found" : "found"));

        if (user == null || !PasswordHashSalt.check(password, user.getPassword())) {
            logger.debug("user or password is not valid");
            ret = new Response(ResponseStat.denied, "user or password is not valid");

        } else {
            logger.debug("user passed authorization");
            ret = new Response(ResponseStat.access, getWelcomeStr(locale, date) + ", " + user.getName() + ".");
        }

        return ret;
    }

    // получение сообщения приветствия
    private String getWelcomeStr(String locale, Date date) {
        Welcome welcome = new Welcome(Locale.forLanguageTag(locale));
        LocalTime localTime = getLocaleFromClient(date);

        return welcome.getMessage(localTime);
    }

    // коневертация даты для получение сообщения приветствия
    private LocalTime getLocaleFromClient(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        Instant instant = Instant.ofEpochMilli(date.getTime());
        ZoneId zoneId = cal.getTimeZone().toZoneId();

        return LocalDateTime.ofInstant(instant, zoneId).toLocalTime();
    }
}
