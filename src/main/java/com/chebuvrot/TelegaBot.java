package com.chebuvrot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Map;

@Service
public class TelegaBot extends TelegramLongPollingBot{

    ArrayList<Long> list = new ArrayList<>();

    @Override
    public void onUpdateReceived(Update update) {
        Long id = update.getMessage().getChatId();
        if(!list.contains(id))
            list.add(id);

        System.out.print("Hello " + id);

    }

    @Override
    public String getBotUsername() {
        return "ChebuVrot";
    }

    @Override
    public String getBotToken() {
        return "816525400:AAHi0jKgmdssitaOhfZYeYWU0zg40mimGRo";
    }

    void sendMsg(String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        for (Long aLong : list) {
            sendMessage.setChatId(aLong);
            sendMessage.setText(text);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
}
