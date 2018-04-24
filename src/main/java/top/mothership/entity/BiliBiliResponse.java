/**
  * Copyright 2018 aTool.org 
  */
package top.mothership.entity;

/**
 * Auto-generated: 2018-04-15 0:3:31
 *
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool.org/json2javabean.php
 */
@lombok.Data
public class BiliBiliResponse<T> {
    private int code;
    private String msg;
    ///应该是他们接口的重复字段
//    private String message;
    private T data;
}