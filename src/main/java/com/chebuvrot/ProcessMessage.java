package com.chebuvrot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ProcessMessage {

    @Autowired
    StartUpInit startUpInit;

    @PostMapping("/process_message")
    public String index(@RequestBody Body res) {
        startUpInit.telegaBot.sendMsg(res.getMessage());
        return "ok";
    }
}


class Body {
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}