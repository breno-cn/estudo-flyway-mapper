package com.example.demo.mapper;

import com.example.demo.data.HelloData;
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

}
