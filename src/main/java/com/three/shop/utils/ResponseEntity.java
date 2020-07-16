package com.three.shop.utils;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class ResponseEntity<T> {
    private int status;
    private String msg;
    private T data;

    public static <T> ResponseEntity<T> success(T data) {
        ResponseEntity<T> entity = new ResponseEntity<T>();
        entity.setStatus(Status.SUCCESS.getStatus());
        entity.setMsg(Status.SUCCESS.getMsg());
        entity.setData(data);
        return entity;
    }

    public static <T> ResponseEntity<T> error(Status status) {
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setStatus(status.getStatus());
        entity.setMsg(status.getMsg());
        return entity;
    }
}
