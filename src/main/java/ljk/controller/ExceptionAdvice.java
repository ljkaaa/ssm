package ljk.controller;

import ljk.exception.BusinessException;
import ljk.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler({BusinessException.class})
    public Result doBusinessException(BusinessException exception){
        return new Result(exception.getCode(),null,exception.getMessage());
    }

    @ExceptionHandler({SystemException.class})
    public Result doSystemException(SystemException exception){
        return new Result(exception.getCode(),null,exception.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public Result doException(Exception exception){
        return new Result(100,null,"网络的锅");
    }
}
