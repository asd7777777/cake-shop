package com.three.shop.domain.vo;

import com.three.shop.utils.StatusEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * Description：封装业务层返回数据的 JavaBean
 *
 * @author sheng
 * @date 2020/7/14 10:54
 * @since JDK 1.8
 */
@Data
public class ResultVo<T> implements Serializable {
    /**
     * 状态码
     */
    private Integer status;
    /**
     * 状态码对应的提示信息
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
     * @return 封装了数据的 ResultVo 对象
     */
    public static <T> ResultVo<T> success(T data, StatusEnum status) {
        ResultVo<T> resultVo = new ResultVo<>();
        // 封装数据
        resultVo.setStatus(status.getStatus());
        resultVo.setMessage(status.getMessage());
        resultVo.setHint(status.getHint());
        resultVo.setData(data);
        return resultVo;
    }

    /**
     * 错误返回结果时调用，封装了错误信息的 ResultVo 对象
     *
     * @param status 枚举类对象
     * @param <T>    泛型
     * @return 封装了错误信息的 ResultVo 对象
     */
    public static <T> ResultVo<T> error(StatusEnum status) {
        ResultVo<T> resultVo = new ResultVo<>();
        // 封装数据
        resultVo.setStatus(status.getStatus());
        resultVo.setMessage(status.getMessage());
        resultVo.setHint(status.getHint());
        return resultVo;
    }
}
