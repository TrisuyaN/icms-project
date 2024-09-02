package com.sc.scbackend.aop;

import com.sc.scbackend.base.BaseResult;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@Aspect
@ControllerAdvice
public class SQLExceptionAspect {

//    @AfterThrowing(pointcut = "execution(* com.sc.scbackend..*(..))", throwing = "ex")
//    public ResponseEntity<String> handleDatabaseException(Exception ex) {
//
//        String errorMessage;
//
//        if (ex instanceof DuplicateKeyException) {
//            errorMessage = "插入失败：主键重复，请检查车辆 ID。";
//        } else if (ex instanceof SQLIntegrityConstraintViolationException) {
//            errorMessage = "插入失败：违反完整性约束。";
//        } else {
//            errorMessage = "发生未知SQL错误。";
//        }
//        return ResponseEntity.badRequest().body(errorMessage);
//    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<BaseResult> handleDuplicateKeyException(DuplicateKeyException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseResult.fail("主键重复错误，请检查数据"));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<BaseResult> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseResult.fail("数据一致性错误，请检查数据"));
    }

}