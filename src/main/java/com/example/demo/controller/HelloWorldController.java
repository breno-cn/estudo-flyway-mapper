package com.example.demo.controller;

import com.example.demo.data.HelloData;
import com.example.demo.mapper.HelloMapper;
import com.example.demo.response.HelloResponse;
import com.example.demo.service.HelloWorldServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    private final HelloWorldServiceImpl helloWorldServiceImpl;
    private final HelloMapper helloMapper;

    @GetMapping
    public HelloResponse helloWorld(@RequestBody HelloData helloData) {
        return helloMapper.dataToResponse(helloWorldServiceImpl.sayHello(helloData));
    }

}
