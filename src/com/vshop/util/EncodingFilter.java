package com.vshop.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @ClassName EncodingFilter
 * @Description
 * @Author Wangyw
 */

@WebFilter(value = "/*",initParams = {@WebInitParam(name="encode",value="UTF-8")})
public class EncodingFilter implements Filter {

    private String encode;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        encode = fConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encode);
        response.setCharacterEncoding(encode);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

