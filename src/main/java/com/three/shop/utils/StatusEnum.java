package com.three.shop.utils;

/**
 * Description：
 *
 * @author sheng
 * @date 2020/7/14 14:18
 * @since JDK 1.8
 */
public enum StatusEnum {
    /**
     * 成功
     */
    SUCCESS(20000, "success", "成功"),
    /**
     * 参数错误
     */
    PARAM_ERROR(40000, "param_error", "参数错误"),
    /**
     * dao 层异常
     */
    DAO_ERROR(40001, "dao_error", "数据异常"),
    /**
     * service 层异常
     */
    SERVICE_ERROR(40002, "service_error", "业务异常"),
    /**
     * 库存不足
     */
    STOCK_ERROR(60000, "stock_error", "库存不足"),
    /**
     * 未知错误
     */
    ERROR(50000, "error", "业务繁忙，请稍后尝试");

    /**
     * 状态码
     */
    private Integer status;
    /**
     * 信息
     */
    private String message;
    /**
     * 信息的提示
     */
    private String hint;

    StatusEnum(Integer status, String message, String hint) {
        this.status = status;
        this.message = message;
        this.hint = hint;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
