package com.chebuvrot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import javax.annotation.PostConstruct;

@Component
public class StartUpInit {

    TelegaBot telegaBot;

    @PostConstruct
    public void init() throws TelegramApiRequestException {
        ApiContextInitializer.init();
        this.telegaBot = new TelegaBot();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        botsApi.registerBot(telegaBot);
    }
}