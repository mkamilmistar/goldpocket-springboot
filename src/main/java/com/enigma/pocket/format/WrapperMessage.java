package com.enigma.pocket.format;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class WrapperMessage<T>{

    private Integer responseCode;
    private String description;
    private LocalDateTime timestamp;
    private T data;

    public WrapperMessage(Integer responseCode, String description, T data) {
        this.responseCode = responseCode;
        this.description = description;
        this.data = data;
    }

    //FACTORY METHOD
    //mengembalikan dari constructor
    public static <T> WrapperMessage<T> acceptedResponse(T data){
        return new WrapperMessage<>(HttpStatus.ACCEPTED.value(), "SUCCESS", data);
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
