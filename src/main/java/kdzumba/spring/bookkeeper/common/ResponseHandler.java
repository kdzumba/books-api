package kdzumba.spring.bookkeeper.common;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ResponseHandler <T>{
    private ResponseObject<T> responseObject;

    public ResponseEntity<ResponseObject<T>> handleSuccess(T body, String message, HttpStatus status){
        responseObject.result = body;
        responseObject.message = message;
        responseObject.status = status;
        responseObject.timestamp = LocalDateTime.now();

        return new ResponseEntity<>(responseObject, status);
    }
}
