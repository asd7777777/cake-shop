package com.three.shop.exception;

import com.three.shop.utils.Status;

/**
 * @author Administrator
 */
public class DaoException extends RuntimeException{
    private int status;
    private String msg;

    public DaoException(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public DaoException(Status status) {
        this.status = status.getStatus();
        this.msg = status.getMsg();
    }
}
