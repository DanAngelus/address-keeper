package uk.danangelus.address.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dan Bennett (dbennett)
 * @since Fri, 20 December 2019
 */
@Data
@Builder
@NoArgsConstructor
public class RestResponse<T> {

    private int status = 200;
    private boolean success;
    private String error;
    private Map<String, Object> headers = new HashMap<>();
    private T body;

    public static <T> RestResponse<T> successful() {
        return RestResponse.<T>builder()
            .success(true)
            .status(200)
            .build();
    }

    public static <T> RestResponse<T> successful(T body) {
        return RestResponse.<T>builder()
            .body(body)
            .success(true)
            .status(200)
            .build();
    }

    public static <T> RestResponse<T> failed(String error) {
        return RestResponse.<T>builder().status(500).error(error).build();
    }

    public static <T> RestResponse<T> failed(String error, int code) {
        return RestResponse.<T>builder().status(code).error(error).build();
    }

}
