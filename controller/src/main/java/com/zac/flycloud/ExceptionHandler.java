package com.zac.flycloud;

import com.zac.flycloud.basebean.DataResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.connection.PoolException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 异常处理器
 * 
 * @Author scott
 * @Date 2019
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(NoHandlerFoundException.class)
	public DataResponseResult<?> handlerNoFoundException(Exception e) {
		log.error(e.getMessage(), e);
		return DataResponseResult.error(404, "路径不存在，请检查路径是否正确");
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(DuplicateKeyException.class)
	public DataResponseResult<?> handleDuplicateKeyException(DuplicateKeyException e){
		log.error(e.getMessage(), e);
		return DataResponseResult.error("数据库中已存在该记录");
	}

	@org.springframework.web.bind.annotation.ExceptionHandler({AuthenticationException.class})
	public DataResponseResult<?> handleAuthorizationException(AuthenticationException e){
		log.error(e.getMessage(), e);
		return DataResponseResult.noauth("认证失败，请联系管理员授权");
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public DataResponseResult<?> handleException(Exception e){
		log.error(e.getMessage(), e);
		return DataResponseResult.error("操作失败，"+e.getMessage());
	}
	
	/**
	 * @Author 政辉
	 * @param e
	 * @return
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public DataResponseResult<?> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
		StringBuffer sb = new StringBuffer();
		sb.append("不支持");
		sb.append(e.getMethod());
		sb.append("请求方法，");
		sb.append("支持以下");
		String [] methods = e.getSupportedMethods();
		if(methods!=null){
			for(String str:methods){
				sb.append(str);
				sb.append("、");
			}
		}
		log.error(sb.toString(), e);
		//return DataResponseResult.error("没有权限，请联系管理员授权");
		return DataResponseResult.error(405,sb.toString());
	}
	
	 /** 
	  * spring默认上传大小100MB 超出大小捕获异常MaxUploadSizeExceededException 
	  */
    @org.springframework.web.bind.annotation.ExceptionHandler(MaxUploadSizeExceededException.class)
    public DataResponseResult<?> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
    	log.error(e.getMessage(), e);
        return DataResponseResult.error("文件大小超出10MB限制, 请压缩或降低文件质量! ");
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(DataIntegrityViolationException.class)
    public DataResponseResult<?> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
    	log.error(e.getMessage(), e);
        return DataResponseResult.error("字段太长,超出数据库字段的长度");
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(PoolException.class)
    public DataResponseResult<?> handlePoolException(PoolException e) {
    	log.error(e.getMessage(), e);
        return DataResponseResult.error("Redis 连接异常!");
    }

}
