package com.three.shop.utils;

import com.three.shop.exception.ServiceException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Description：进行非空判断的工具类
 *
 * @author sheng
 * @date 2020/7/14 11:38
 * @since JDK 1.8
 */
public class JudgeEmptyUtils {
    /**
     * 用于判断所有的属性是否为空，要求属性有 get 方法
     *
     * @param o          要判断属性是否为空的对象
     * @param fieldNames 要排除的属性名
     * @return true 代表全属性为空，false 则相反
     */
    public static boolean getMethodJudgeFullPropertyEmpty(Object o, String... fieldNames) throws ServiceException {
        // 进行非空判断
        if (o == null) {
            return true;
        }
        // 排除的方法名
        List<String> namesList = null;
        // 非空判断
        if (fieldNames != null) {
            namesList = getMethodNamesList(fieldNames);
        }
        // 获取所有的方法
        Method[] methods = o.getClass().getDeclaredMethods();
        // 接收方法的值
        Object obj;
        // 循环判断
        try {
            for (Method method : methods) {
                // 是否排除某个元素
                if (fieldNames != null) {
                    // 判断是否为 get 方法
                    if (method.getName().startsWith("get") && !namesList.contains(method.getName())) {
                        // 设置权限
                        method.setAccessible(true);
                        // 执行方法
                        obj = method.invoke(o);
                        // 判断返回值是否为空
                        if (obj == null) {
                            return true;
                        }
                        // 判断是否为 ""
                        if (obj instanceof String && Objects.equals("", obj)) {
                            return true;
                        }
                    }
                } else {
                    // 判断是否为 get 方法
                    if (method.getName().startsWith("get")) {
                        // 设置权限
                        method.setAccessible(true);
                        // 执行方法
                        obj = method.invoke(o);
                        // 判断是否为空，为空返回 true
                        if (obj == null) {
                            return true;
                        }
                        // 判断是否为 ""
                        if (obj instanceof String && Objects.equals("", obj)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new ServiceException(Status.SERVICE_ERROR);
        }
        return false;
    }

    /**
     * 判断所有的属性是否为空，没有 get 方法
     *
     * @param o          要判断的对象
     * @param fieldNames 排除的方法名
     * @return true 代表为空
     */
    public static boolean valueJudgeFullPropertyIsEmpty(Object o, String... fieldNames) throws ServiceException {
        // 非空判断
        if (o == null) {
            return true;
        }
        // 用于存储排除的属性名
        List<String> nameLists = null;
        // 非空判断
        if (fieldNames != null) {
            nameLists = getFieldNamesList(fieldNames);
        }
        // 获取所有的属性
        Field[] fields = o.getClass().getDeclaredFields();
        // 用于接收属性的值
        Object obj = null;
        // 循环判断
        try {
            for (Field field : fields) {
                // 判断是否排除某个成员变量
                if (fieldNames != null) {
                    // 非空判断
                    if (field != null && !nameLists.contains(field.getName())) {
                        // 私有属性，设置开关
                        field.setAccessible(true);
                        // 判断值
                        obj = field.get(o);
                        // 非空判断
                        if (obj == null) {
                            return true;
                        }
                        // 判断是否为 ""
                        if (obj instanceof String && Objects.equals("", obj)) {
                            return true;
                        }
                    }
                } else {
                    if (field != null) {
                        // 私有属性，设置开关
                        field.setAccessible(true);
                        // 判断值
                        obj = field.get(o);
                        // 非空判断
                        if (obj == null) {
                            return true;
                        }
                        // 判断是否为 ""
                        if (obj instanceof String && Objects.equals("", obj)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new ServiceException(Status.SERVICE_ERROR);
        }
        return false;
    }

    /**
     * 根据传入的属性名判断对象对应的属性是否为空
     *
     * @param o          对象
     * @param fieldNames 属性名
     * @return true 代表为空
     */
    public static boolean judgeFieldsEmpty(Object o, String... fieldNames) throws ServiceException {
        // 非空判断
        if (o == null || fieldNames == null) {
            return true;
        }
        // 用来存储属性名
        List<String> fieldNamesList = getFieldNamesList(fieldNames);
        // 获取所有的属性
        Field[] fields = o.getClass().getDeclaredFields();
        // 判断是否拥有属性
        if (!judgeOwnField(fields, fieldNames)) {
            return true;
        }
        // 用来接收属性的值
        Object obj = null;
        // 循环判断
        try {
            for (Field field : fields) {
                // 判断是否存在
                if (field != null && fieldNamesList.contains(field.getName())) {
                    // 设置开关
                    field.setAccessible(true);
                    // 判断值
                    obj = field.get(o);
                    // 非空判断
                    if (obj == null) {
                        return true;
                    }
                    System.out.println(field.getName() + ": " + obj);
                    // 判断是否为 ""
                    if (obj instanceof String && Objects.equals("", obj)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            throw new ServiceException(Status.SERVICE_ERROR);
        }
        return false;
    }

    /**
     * 判断传入的字符串是否为空
     *
     * @param param 字符串
     * @return true 代表为空
     */
    public static boolean judgeObjectNull(Object... param) {
        // 非空判断
        if (param == null) {
            return true;
        }
        // 循环判断
        for (Object o : param) {
            // 非空判断
            if (o == null) {
                return true;
            }
            // 非空判断
            if (o instanceof String && Objects.equals("", o)) {
                return true;
            }
        }
        // 默认不为空
        return false;
    }

    /**
     * 将数组转换为集合
     *
     * @param fieldNames 属性名数组
     * @return 属性名集合
     */
    private static List<String> getFieldNamesList(String[] fieldNames) {
        // 用于存储成员变量名
        List<String> list = new ArrayList<>();
        // 循环取值
        for (String fieldName : fieldNames) {
            // 非空判断
            if (!judgeObjectNull(fieldName)) {
                // 添加属性名到集合
                list.add(fieldName);
            }
        }
        return list;
    }

    /**
     * 将传入的属性名拼接成 get 方法名添加到集合
     *
     * @param fieldNames 属性名数组
     * @return 方法名集合
     */
    private static List<String> getMethodNamesList(String[] fieldNames) {
        List<String> list = new ArrayList<>();
        // 接收首字母
        String start;
        // 用于拼接方法名
        StringBuilder methodName = new StringBuilder();
        // 循环取值，拼接字符串
        for (String fieldName : fieldNames) {
            // 非空判断
            if (!judgeObjectNull(fieldName)) {
                // 清空可变字符串
                methodName.setLength(0);
                // 取首字母
                start = fieldName.substring(0, 1);
                // 将首字母转换为大写
                start = start.toUpperCase();
                //  例如 getField()
                methodName.append("get").append(start).append(fieldName.substring(1));
                // 添加到数组
                list.add(methodName.toString());
            }
        }
        return list;
    }

    /**
     * 判断是否拥有传入的字符串对应的属性值
     *
     * @param fields     属性数组
     * @param fieldNames 字符串
     * @return true 代表拥有
     */
    private static boolean judgeOwnField(Field[] fields, String... fieldNames) {
        // 存储属性名
        List<String> list = new ArrayList<>();
        // 取值
        if (fields != null) {
            for (Field field : fields) {
                // 非空判断
                if (field != null) {
                    // 添加到集合
                    list.add(field.getName());
                }
            }
        }
        // 判断
        for (String fieldName : fieldNames) {
            // 判断是否拥有
            if (list.contains(fieldName)) {
                return true;
            }
        }
        return false;
    }
}
