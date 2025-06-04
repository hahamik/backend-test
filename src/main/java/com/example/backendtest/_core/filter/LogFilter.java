package com.example.backendtest._core.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LogFilter implements Filter{

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String userAgent = req.getHeader("User-Agent");
        userAgent = userAgent == null ? "" : userAgent;

        String msg = "[로그] UA: ${ua}"
                .replace("${ua}", userAgent);
        log.info(msg);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
