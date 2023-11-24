package servlets;

import java.io.IOException;
import java.io.*;
import java.time.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Search;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
    public void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
        Search.date = request.getParameter("date");
        Search.source = request.getParameter("source");
        Search.destination = request.getParameter("destination");
        Search.persons = Integer.parseInt(request.getParameter("persons"));

        if (Search.date.equals("")) {
            PrintWriter out = response.getWriter();
            out.println("Please enter a valid date");
        }
        else {
            Search.day = getDay(Search.date);
            response.sendRedirect("/search-results.jsp");
        }
    }

    public String getDay(String dateInp) {
        LocalDate dt = LocalDate.parse(dateInp);
        return dt.getDayOfWeek().toString();
    }

}
