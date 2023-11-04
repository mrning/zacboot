package com.zac.security.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zac.base.basebeans.Result;
import com.zac.base.constants.CommonConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.PrintWriter;

/**
 * @author lengleng
 * @date 2019/2/1
 *
 * 客户端异常处理 AuthenticationException 不同细化异常处理
 */
@RequiredArgsConstructor
public class ResourceAuthExceptionEntryPoint implements AuthenticationEntryPoint {

	private final ObjectMapper objectMapper;

	private final MessageSource messageSource;

	@Override
	@SneakyThrows
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) {
		response.setCharacterEncoding(CommonConstants.UTF8);
		response.setContentType(CommonConstants.CONTENT_TYPE);
		Result<String> result = new Result<>();
		result.setCode(CommonConstants.FAIL);
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		if (authException != null) {
			result.setMessage("error");
			result.setResult(authException.getMessage());
		}

		// 针对令牌过期返回特殊的 424
		if (authException instanceof InsufficientAuthenticationException) {
			response.setStatus(org.springframework.http.HttpStatus.FAILED_DEPENDENCY.value());
			result.setMessage(this.messageSource.getMessage("OAuth2ResourceOwnerBaseAuthenticationProvider.tokenExpired",
					null, LocaleContextHolder.getLocale()));
		}
		PrintWriter printWriter = response.getWriter();
		printWriter.append(objectMapper.writeValueAsString(result));
	}

}