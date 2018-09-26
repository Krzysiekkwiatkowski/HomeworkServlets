package pl.coderslab.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/favImages")
public class HM7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Integer[] choices = null;
        Integer[] newChoices = null;
        Object pages = session.getAttribute("pagesVisited");
        choices = (Integer[]) session.getAttribute("choices");
        int pagesVisited = (int) pages;
        if (pagesVisited == 1) {
            String choice = request.getParameter("choice_1");
            if (choice != null) {
                if (choice.equals("yes")) {
                    choices = new Integer[pagesVisited];
                    choices[pagesVisited - 1] = pagesVisited;
                }
            }
        } else if (pagesVisited == 2) {
            String choice = request.getParameter("choice_2");
            if (choice != null) {
                if (choice.equals("yes")) {
                    if (choices != null) {
                        newChoices = new Integer[choices.length + 1];
                        for (int i = 0; i < choices.length; i++) {
                            newChoices[i] = choices[i];
                        }
                        newChoices[choices.length] = pagesVisited;
                        choices = newChoices;
                    } else {
                        choices = new Integer[1];
                        choices[0] = pagesVisited;
                    }
                }
            }
        } else if (pagesVisited == 3) {
            String choice = request.getParameter("choice_3");
            if (choice != null) {
                if (choice.equals("yes")) {
                    if (choices != null) {
                        newChoices = new Integer[choices.length + 1];
                        for (int i = 0; i < choices.length; i++) {
                            newChoices[i] = choices[i];
                        }
                        newChoices[choices.length] = pagesVisited;
                        choices = newChoices;
                    } else {
                        choices = new Integer[1];
                        choices[0] = pagesVisited;
                    }
                }
            }
        } else if (pagesVisited == 4) {
            String choice = request.getParameter("choice_4");
            if(choice != null) {
                if (choice.equals("yes")) {
                    if (choices != null) {
                        newChoices = new Integer[choices.length + 1];
                        for (int i = 0; i < choices.length; i++) {
                            newChoices[i] = choices[i];
                        }
                        newChoices[choices.length] = pagesVisited;
                        choices = newChoices;
                    } else {
                        choices = new Integer[1];
                        choices[0] = pagesVisited;
                    }
                }
            }
        }
        session.setAttribute("choices", choices);
        session.setAttribute("pagesVisited", pagesVisited);
        response.sendRedirect("/favImages");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Object pages = session.getAttribute("pagesVisited");
        int pagesVisited = 0;
        if (pages != null) {
            pagesVisited = (int) pages;
            if (pagesVisited == 1) {
                response.sendRedirect("/HM72.html");
                pagesVisited++;
            } else if (pagesVisited == 2) {
                response.sendRedirect("/HM73.html");
                pagesVisited++;
            } else if (pagesVisited == 3) {
                response.sendRedirect("/HM74.html");
                pagesVisited++;
            } else {
                Object goodPages = session.getAttribute("choices");
                if (goodPages != null) {
                    Integer[] choices = (Integer[]) goodPages;
                    response.getWriter().append("Odwiedzono wszystkie strony, spodobały się strony numer: ");
                    for (int number : choices) {
                        response.getWriter().append(" " + number);
                    }
                } else {
                    response.getWriter().append("Odwiedzono wszystkie strony ale żadna się nie spodobała!");
                }
            }
        } else {
            response.sendRedirect("/HM71.html");
            pagesVisited = 1;
        }
        session.setAttribute("pagesVisited", pagesVisited);
    }
}
