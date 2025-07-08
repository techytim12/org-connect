package com.org_connect.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Component
public class OrgContextFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String orgGroup = httpServletRequest.getHeader("X-ORG-GROUP");
        String role = httpServletRequest.getHeader("X-ROLE");

        if(StringUtils.hasText(orgGroup) && StringUtils.hasText(role)){
            OrgContext.setOrg(orgGroup);
            OrgContext.setRole(role);
        }

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            OrgContext.clear();
        }
    }
}
