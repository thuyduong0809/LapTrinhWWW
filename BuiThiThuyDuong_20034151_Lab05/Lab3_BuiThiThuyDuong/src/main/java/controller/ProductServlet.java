package controller;

import dao.ProductDAO;
import model.Product;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class ProductServlet extends HttpServlet {

    private ProductDAO dao;

    public void init() {
        dao = new ProductDAO();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getServletPath();

        switch (action) {
            case "/new":
                req.getRequestDispatcher("product-form.jsp").forward(req, resp);
                break;
            case "/insert":
                dao.insertProduct(new Product(
                        req.getParameter("name"),
                        Double.parseDouble(req.getParameter("price")),
                        req.getParameter("urlImage")
                ));
                resp.sendRedirect("list");
                break;
            case "/delete":
                dao.deleteProduct(Integer.parseInt(req.getParameter("id")));
                resp.sendRedirect("list");
                break;
            case "/edit":
                req.setAttribute("product",
                        dao.selectProduct(Integer.parseInt(req.getParameter("id"))));
                req.getRequestDispatcher("product-form.jsp").forward(req, resp);
                break;
            case "/update":
                dao.updateProduct(new Product(
                        Integer.parseInt(req.getParameter("id")),
                        req.getParameter("name"),
                        Double.parseDouble(req.getParameter("price")),
                        req.getParameter("urlImage")
                ));
                resp.sendRedirect("list");
                break;
            default:
                List<Product> list = dao.selectAllProducts();
                req.setAttribute("list", list);
                req.getRequestDispatcher("product-list.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
