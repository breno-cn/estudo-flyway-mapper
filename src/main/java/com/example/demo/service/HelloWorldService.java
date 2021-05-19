package com.example.demo.service;

import com.example.demo.data.HelloData;
import com.example.demo.entity.HelloEntity;

public interface HelloWorldService {

    public HelloData sayHello(HelloData helloData);

    public HelloEntity createHello(HelloData helloData);

    public HelloEntity getById(Integer id);

}
