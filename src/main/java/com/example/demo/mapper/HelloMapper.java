package com.example.demo.mapper;

import com.example.demo.data.HelloData;
import com.example.demo.entity.HelloEntity;
import com.example.demo.response.HelloResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HelloMapper {

    default HelloResponse dataToResponse(HelloData helloData) {
        return HelloResponse.builder()
                .prefix(helloData.getGreeting())
                .name(helloData.getName())
                .phrase(helloData.getGreeting() + ", " + helloData.getName())
                .build();
    }

    default HelloEntity dataToEntity(HelloData helloData) {
        return HelloEntity.builder()
                .prefix(helloData.getGreeting())
                .name(helloData.getName())
                .id(10)
                .build();
    }

    default HelloResponse entityToResponse(HelloEntity helloEntity) {
        return HelloResponse.builder()
                .prefix(helloEntity.getPrefix())
                .name(helloEntity.getName())
                .phrase(helloEntity.getPrefix() + ", " + helloEntity.getName() + "!")
                .build();
    }

}
