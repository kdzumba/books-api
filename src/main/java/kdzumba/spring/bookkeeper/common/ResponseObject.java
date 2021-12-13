package kdzumba.spring.bookkeeper.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject<T> {
    public T  result;
    public HttpStatus status;
    public LocalDateTime timestamp;
    public String  message;
}
