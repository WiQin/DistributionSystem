package com.vshop.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;


public class ValidateFilter implements Filter {

    private ServletContext servletContext;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {


        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {
        servletContext = config.getServletContext();
    }

}
