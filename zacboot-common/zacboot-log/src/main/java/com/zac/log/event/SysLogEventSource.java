package com.zac.log.event;

import com.zac.request.req.admin.LogRequest;
import lombok.Data;

/**
 * spring event log
 *
 * @author lengleng
 * @date 2023/8/11
 */
@Data
public class SysLogEventSource extends LogRequest {

	/**
	 * 参数重写成object
	 */
	private Object body;

}