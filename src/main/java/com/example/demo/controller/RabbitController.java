package com.example.demo.controller;

import com.example.demo.rabbit.Receiver;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@AllArgsConstructor
@RequestMapping("/rabbit")
public class RabbitController {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    @GetMapping("/{message}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendMessage(@PathVariable(name = "message") String message) throws InterruptedException {
        rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.baz", message);
        receiver.getLatch().await(10_000, TimeUnit.MILLISECONDS);
    }

}
