package com.fang.wxcloudrun.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

/**
 * @author FPH
 * @since 2022年8月22日23:49:48
 *
 */
public class ResultUtil {

    public static ResponseEntity success(Object object){
        Result result = new Result();
        result.setCode(Result.SUCCESS);
        result.setData(object);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public static ResponseEntity success(String msg) {
        Result result = new Result(new HashMap());
        result.setCode(Result.SUCCESS);
        result.setMsg(msg);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity success(String msg, Object object) {
        Result result = new Result();
        result.setCode(Result.SUCCESS);
        result.setMsg(msg);
        result.setData(object);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity success() {
        Result result = new Result(new HashMap());
        result.setCode(Result.SUCCESS);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    //失败

    public static ResponseEntity error(String msg) {
        Result result = new Result(new HashMap());
        result.setCode(Result.INTERNAL_SERVER_ERROR);
        result.setMsg(msg);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    public static ResponseEntity error(String msg, Object errdata) {
        Result result = new Result();
        result.setCode(Result.INTERNAL_SERVER_ERROR);
        result.setMsg(msg);
        result.setData(errdata);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
