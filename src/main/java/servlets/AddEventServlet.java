package servlets;

import lombok.SneakyThrows;
import manager.EventManager;
import model.Event;
import model.EventType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet("/events/add")
public class AddEventServlet  extends HttpServlet {
    private EventManager eventManager = new EventManager();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addEvent.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String place = req.getParameter("place");
        double price = Double.parseDouble(req.getParameter("price"));
        boolean isOnline = Boolean.valueOf(req.getParameter("isOnline"));
        EventType eventType = EventType.valueOf(req.getParameter("eventType"));
        String eventDateStr = req.getParameter("eventDate");
       Event event = Event.builder()
                .name(name)
                .place(place)
                .isOnline(isOnline)
                .price(price)
                .eventType(eventType)
               .eventDate(sdf.parse(eventDateStr))
                .build();

        eventManager.add(event);
        resp.sendRedirect("/events");
    }

}
