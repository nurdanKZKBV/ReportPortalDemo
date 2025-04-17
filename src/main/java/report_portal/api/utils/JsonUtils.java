package report_portal.api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object obj){
        try {
            return mapper.writeValueAsString(obj);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
