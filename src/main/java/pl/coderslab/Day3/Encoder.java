package pl.coderslab.Day3;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "Encoder", urlPatterns = "/*")
public class Encoder implements Filter {

    private String charsetEncoding = "UTF-8";
    private String contentType = "text/html";

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(charsetEncoding);
        resp.setCharacterEncoding(charsetEncoding);
        resp.setContentType(contentType);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        String encodingParam = config.getInitParameter("charsetEncoding");
        String charsetParam = config.getInitParameter("contentType");
        if(encodingParam != null && charsetParam != null){
            charsetEncoding = encodingParam;
            contentType = charsetParam;
        }
    }

}
