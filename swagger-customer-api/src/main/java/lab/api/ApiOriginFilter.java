package lab.api;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ApiOriginFilter implements javax.servlet.Filter {

    private static Log LOG = LogFactory.getLog(ApiOriginFilter.class);

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;

        LOG.info("**** HTTP Request Logging");
        LOG.info("Context Path " + req.getServletContext().getContextPath());
        LOG.info("Servlet Context Name: " + req.getServletContext().getServletContextName());
        LOG.info("Request URI: " + req.getRequestURI());
        LOG.info("Method: " + req.getMethod());

        final Enumeration<String> headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            final String headerName = headers.nextElement();
            LOG.info("Header name: " + headerName + " , header value: " + req.getHeader(headerName));
        }

        LOG.info("**** HTTP Request Logging Complete");

        LOG.info("**** Setting access controls: ");

        final HttpServletResponse res = (HttpServletResponse) response;
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        res.addHeader("Access-Control-Allow-Headers", "Accept, Content-Type, Location, Content-Length, apiKey");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
    }
}