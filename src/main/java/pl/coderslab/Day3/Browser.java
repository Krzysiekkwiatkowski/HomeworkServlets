package pl.coderslab.Day3;

import com.mysql.jdbc.Connection;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebFilter(filterName = "Browser", urlPatterns = "/*")
public class Browser implements Filter {

    private String ADD_QUERY = "INSERT INTO browser(name, date, parameters,time) VALUES (?,?,?,?)";
    private String browser;
    private String date;
    private String parameters;
    private int time;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try {
            Map<String, String> map = new HashMap<String, String>();
            HttpServletRequest httpServletRequest = (HttpServletRequest) req;
            Enumeration headerNames = ((HttpServletRequest) req).getHeaderNames();
            Enumeration<String> params = req.getParameterNames();
            while (headerNames.hasMoreElements()) {
                String key = (String) headerNames.nextElement();
                String value = httpServletRequest.getHeader(key);
                map.put(key, value);
            }
            while (params.hasMoreElements()){
                String element = params.nextElement();
                String[] elem = req.getParameterValues(element);
                parameters = element + " - " + elem[0] + "; ";
            }
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                if (key.equals("user-agent")) {
                    browser = map.get(key);
                }
            }
            long startTime = System.currentTimeMillis();
            chain.doFilter(req, resp);
            long stopTime = System.currentTimeMillis();
            date = LocalDateTime.now().toString();
            time = (int)(stopTime - startTime);
            java.sql.Connection connection = DBFilter.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1, browser);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, parameters);
            preparedStatement.setInt(4, time);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
