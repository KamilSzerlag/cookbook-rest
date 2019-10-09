package com.kszerlag.cookbookrest.util;

/**
 * @author kszerlag
 *
 * Base class for
 * DTOs using as
 * responseBody
 */
public class BaseDto {

    private final Long id;
    private String msg;

    public BaseDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
