package com.example.backendtest._core.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UriFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        String query = req.getQueryString();
        String path = (query == null) ? uri : uri + "?" + query;
        char[] isFilterableChar= {
                '!', '@', '#', '$', '%', '^', '*', '(', ')', '+', '{', '}', '[', ']', '\\', '|', '~', '`', '\'', '"', '<', '>', ','};
        for (char c : isFilterableChar) {
            if (path.indexOf(c) >= 0) {
                HttpServletResponse resp = (HttpServletResponse) response;
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                resp.setContentType("application/json; charset=UTF-8");
                resp.getWriter().println("{\"reason\":\"특수문자가 있음\"}");
                return;
            }
        }
        chain.doFilter(request, response);
    }
}


