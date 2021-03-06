package com.zac.flycloud.bean.basebean;

import com.zac.flycloud.bean.constant.CommonConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *   接口返回数据格式
 * @author zac
 * @date  2019年1月19日
 */
@Data
@ApiModel(value="接口返回对象", description="接口返回对象")
public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 成功标志
	 */
	@ApiModelProperty(value = "成功标志")
	private boolean success = true;

	/**
	 * 返回处理消息
	 */
	@ApiModelProperty(value = "返回处理消息")
	private String message = "操作成功！";

	/**
	 * 返回代码
	 */
	@ApiModelProperty(value = "返回代码")
	private Integer code = 0;

	/**
	 * 返回数据对象 data
	 */
	@ApiModelProperty(value = "返回数据对象")
	private T result;

	/**
	 * 时间戳
	 */
	@ApiModelProperty(value = "时间戳")
	private long timestamp = System.currentTimeMillis()/1000;

	private enum ResEnum {
		SUCCESS("SUCCESS","成功"),
		FAIL("FAIL","失败");

		private final String code;
		private final String message;

		ResEnum(String code, String message) {
			this.code = code;
			this.message = message;
		}
	}

	public static Result<Object> success() {
		Result<Object> r = new Result<Object>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setResult(ResEnum.SUCCESS.code);
		r.setMessage(ResEnum.SUCCESS.message);
		return r;
	}
	
	public static Result<Object> success(String msg) {
		Result<Object> r = new Result<Object>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setResult(ResEnum.SUCCESS.code);
		r.setMessage(msg);
		return r;
	}

	public static<T> Result<T> success(T data) {
		Result<T> r = new Result<T>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setResult(data);
		r.setMessage(ResEnum.SUCCESS.message);
		return r;
	}

	public static<T> Result<T> success(T data, String message) {
		Result<T> r = new Result<T>();
		r.setSuccess(true);
		r.setCode(CommonConstant.SC_OK_200);
		r.setResult(data);
		r.setMessage(message);
		return r;
	}

	public static Result<String> success(ResEnum resEnum) {
		return success(resEnum.code,resEnum.message);
	}

	
	public static Result<Object> error(String msg) {
		return error(CommonConstant.SC_INTERNAL_SERVER_ERROR_500, msg);
	}
	
	public static Result<Object> error(int code, String msg) {
		Result<Object> r = new Result<Object>();
		r.setCode(code);
		r.setMessage(msg);
		r.setSuccess(false);
		return r;
	}

	public Result<T> error500(String message) {
		this.message = message;
		this.code = CommonConstant.SC_INTERNAL_SERVER_ERROR_500;
		this.success = false;
		return this;
	}

	public Result<T> error404(String message) {
		this.message = message;
		this.code = CommonConstant.SC_RESOURCE_NOTFOUND_ERROR_404;
		this.success = false;
		return this;
	}
	/**
	 * 无权限访问返回结果
	 */
	public static Result<Object> noauth(String msg) {
		return error(CommonConstant.SC_NO_AUTH, msg);
	}
}