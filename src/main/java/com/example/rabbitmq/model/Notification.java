package com.example.rabbitmq.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class Notification implements Serializable{
    private String id;
    private Date createdAt;
    private Boolean seen;
    private String message;

    public Notification(@JsonProperty("id") String id,
                        @JsonProperty("createdAt") Date createdAt,
                        @JsonProperty("seen") Boolean seen,
                        @JsonProperty("message") String message){
        this.id=id;
        this.createdAt=createdAt;
        this.seen = seen;
        this.message = message;
    }

}
