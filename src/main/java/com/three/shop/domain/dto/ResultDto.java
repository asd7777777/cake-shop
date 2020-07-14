package com.three.shop.domain.dto;

import com.three.shop.utils.StatusEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * Description：封装 mapper 返回结果的通用 dto
 *
 * @author sheng
 * @date 2020/7/14 10:39
 * @since JDK 1.8
 */
@Data
public class ResultDto<T> implements Serializable {
    /**
     * 状态码
     */
    private Integer status;
    /**
     * 状态码信息
     */
    private String message;
    /**
     * 状态码信息的提示信息
     */
    private String hint;
    /**
     * 要封装的数据
     */
    private T data;

    /**
     * 正确返回结果调用，返回封装了数据的 ResultDto 对象
     *
     * @param data   数据
     * @param status 枚举类对象
     * @param <T>    泛型
     * @return 封装了数据的 ResultDto 对象
     */
    public static <T> ResultDto<T> success(T data, StatusEnum status) {
        ResultDto<T> resultDto = new ResultDto<>();
        // 封装数据
        resultDto.setStatus(status.getStatus());
        resultDto.setMessage(status.getMessage());
        resultDto.setHint(status.getHint());
        resultDto.setData(data);
        return resultDto;
    }

    /**
     * 错误返回数据时调用，返回封装了错误信息的 ResultDto 对象
     *
     * @param status 枚举类对象
     * @param <T>    泛型
     * @return 封装了错误信息的 ResultDto 对象
     */
    public static <T> ResultDto<T> error(StatusEnum status) {
        ResultDto<T> resultDto = new ResultDto<>();
        // 封装数据
        resultDto.setStatus(status.getStatus());
        resultDto.setMessage(status.getMessage());
        resultDto.setHint(status.getHint());
        return resultDto;
    }
}
