package servlet;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Items;

import java.io.IOException;

@WebServlet(value = "/update")

public class UpdateItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          String id = req.getParameter("id");
          String name =req.getParameter("name");
          String description = req.getParameter("description");
          String price =req.getParameter("price");
          Items item = DBManager.getItemById(Long.parseLong(id));
          item.setName(name);
          item.setDescription(description);
          item.setPrice(Double.parseDouble(price));
          DBManager.updateItem(item);
          resp.sendRedirect("/home");


    }
}
