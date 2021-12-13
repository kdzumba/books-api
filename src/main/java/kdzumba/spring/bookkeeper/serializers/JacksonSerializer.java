package kdzumba.spring.bookkeeper.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class JacksonSerializer<T> {
    ObjectMapper mapper = new ObjectMapper();

    public String serialize(T object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }
}
