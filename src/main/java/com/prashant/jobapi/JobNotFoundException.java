package com.prashant.jobapi;

import org.hibernate.sql.ast.tree.expression.JsonObjectAggUniqueKeysBehavior;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class JobNotFoundException extends RuntimeException{

    public JobNotFoundException(String message){
        super(message);
    }
}
