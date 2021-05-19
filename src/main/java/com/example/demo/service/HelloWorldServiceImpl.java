package com.example.demo.service;

import com.example.demo.data.HelloData;
import com.example.demo.entity.HelloEntity;
import com.example.demo.mapper.HelloMapper;
import com.example.demo.repository.HelloRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HelloWorldServiceImpl implements HelloWorldService {

    private final HelloRepository helloRepository;
    private final HelloMapper helloMapper;

    @Override
    public HelloData sayHello(HelloData helloData) {
        return helloData;
    }

    @Override
    public HelloEntity createHello(HelloData helloData) {
        return helloRepository.save(helloMapper.dataToEntity(helloData));
    }

    @Override
    public HelloEntity getById(Integer id) {
        return helloRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

}
