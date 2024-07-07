package com.example.abacusconsultingprojectdemo.common.response;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response<T>{

    private String responseCode;
    private String responseMessage;
    private T responseBody;

}
