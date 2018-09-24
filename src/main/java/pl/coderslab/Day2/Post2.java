package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.StringTokenizer;

@WebServlet(name = "Post2", urlPatterns = "/Post2")
public class Post2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String text = request.getParameter("text");
        String check = request.getParameter("check");
        if(check == null){
            String newText = checkText(text);
            response.getWriter().append(newText);
        } else {
            response.getWriter().append(text);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.sendRedirect("index_2.html");
    }

    public String checkWord(String word){
        String[] table = {"kurcze", "dupa", "lipa", "cholera"};
        String changedWord = "";
        for (String tableWord : table) {
            String toCheck = word.toLowerCase();
            if(tableWord.equals(toCheck)){
                for (int i = 0; i < word.length(); i++) {
                    changedWord += "*";
                }
                return changedWord;
            }
        }
        return word;
    }

    public String checkText(String text){
        StringTokenizer stringTokenizer = new StringTokenizer(text, " ");
        String newText = "";
        while(stringTokenizer.hasMoreTokens()){
            String word = checkWord(stringTokenizer.nextToken());
            newText += word + " ";
        }
        return newText;
    }
}
