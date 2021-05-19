package com.example.demo.controller;

import com.example.demo.data.HelloData;
import com.example.demo.mapper.HelloMapper;
import com.example.demo.response.HelloResponse;
import com.example.demo.service.HelloWorldServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

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

    @Cacheable(value = "hello_entity", key = "#id", unless = "#result.followers < 12000")
    @GetMapping("/{id}")
    public HelloResponse getHelloById(@PathVariable(name = "id") Integer id) {
        return helloMapper.entityToResponse(
                helloWorldServiceImpl.getById(id)
        );
    }

    @PostMapping
    public HelloResponse createHello(@RequestBody HelloData helloData) {
        return helloMapper.entityToResponse(
                helloWorldServiceImpl.createHello(helloData)
        );
    }

}
