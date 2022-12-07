package com.bookstore.controller.shop;

import com.bookstore.dao.OrderDAO;
import com.bookstore.entity.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderProfileServlet", value = "/orderProfile")
public class OrderProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid = Integer.parseInt(request.getParameter("uid"));
        OrderDAO orderDAO = new OrderDAO();

        List<Order> orders = orderDAO.getOrderByIdUer(uid);


        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/store/views/myOrder.jsp").forward(request, response);
    }
}
