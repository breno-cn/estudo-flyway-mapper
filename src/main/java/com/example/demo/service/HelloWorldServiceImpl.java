package com.example.demo.service;

import com.example.demo.data.HelloData;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public HelloData sayHello(HelloData helloData) {
        return helloData;
    }

}
