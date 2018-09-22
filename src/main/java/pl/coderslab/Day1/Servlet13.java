package pl.coderslab.Day1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@WebServlet(name = "Servlet13", urlPatterns = "/Servlet13")
public class Servlet13 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Path path = Paths.get("/home/oem/Coderslab/HomeworkServlets/src/main/java/pl/coderslab/oop.txt");
            Scanner scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                response.getWriter().append(scanner.nextLine() + "\n");
            }
        } catch (FileNotFoundException e){
            response.getWriter().append("Nie znaleziono pliku");
        }
    }
}
