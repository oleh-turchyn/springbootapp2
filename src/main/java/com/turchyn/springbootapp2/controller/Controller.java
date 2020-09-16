package com.turchyn.springbootapp2.controller;

import com.turchyn.springbootapp2.domain.Message;
import com.turchyn.springbootapp2.domain.User;
import com.turchyn.springbootapp2.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private MessageRepository messageRepository;


    @GetMapping("/")
    public String method(Map<String, Object> model) {
        return "greet";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false ,defaultValue = "")String filter,Map<String, Object> model) {
        Iterable<Message> messages = messageRepository.findAll();
        if (filter != null && !filter.isEmpty()) {
            messages = messageRepository.findBytag(filter);
        } else {
            messages = messageRepository.findAll();
        }
        model.put("messages", messages);
        model.put("filter",filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag, user);
        messageRepository.save(message);
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "main";
    }
}
