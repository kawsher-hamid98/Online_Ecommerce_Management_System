package com.onlineApp.Filter;

import com.onlineApp.Controller.CustomerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
@Order(1)
public class RequestResponseFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        int thisError = -1;
        System.out.println("Headers...");
        Map<String, String> map = new HashMap<>();
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = req.getHeader(key);
            map.put(key, value);
        }

        for (Map.Entry<String, String> entry: map.entrySet()) {
            logger.info(entry.getKey() + " || " + entry.getValue());
        }

        if (req.getRequestURL().toString().startsWith("http://localhost:8081")) {
            logger.info("valid url passed");
            logger.info(req.getMethod());
//            if (req.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
//                logger.info("valid mime type passed");
//                res.setHeader("ok", "ok");
                filterChain.doFilter(request, response);
                System.out.println("Sending responses");
//            } else {
//                thisError = 1;
//            }
        }
        else {
            thisError = 0;
        }

        if (thisError == 0) {
            res.setHeader("request-type", "invalid url request");
            res.getWriter().println("Invalid Url request");
            res.setStatus(404);
            System.out.println("error url");
        }
//        else if (thisError == 1)
//        {
//            res.setHeader("media-type", "unsupported mime type");
//            res.getWriter().println("unsupported mime type");
//            res.setStatus(404);
//            System.out.println("error mime type");
//        }
    }

    @Override
    public void destroy() { }
}
