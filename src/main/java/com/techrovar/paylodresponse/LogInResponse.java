package com.techrovar.paylodresponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LogInResponse {
    String message;
    Boolean status;


    @Override
    public String toString() {
        return "LogInResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
