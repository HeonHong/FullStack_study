package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;
	// 반드시 jsp 파일을 줘야함
}
