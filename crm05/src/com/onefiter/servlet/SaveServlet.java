package com.onefiter.servlet;

import com.onefiter.bean.Customer;
import com.onefiter.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save")
public class SaveServlet extends HttpServlet {
    private final CustomerDao dao = new CustomerDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        request.setCharacterEncoding("UTF-8");
        
        // 获取客户端发送的参数
        Customer customer = new Customer();
        customer.setName(request.getParameter("name"));
        customer.setAge(Integer.parseInt(request.getParameter("age")));
        customer.setHeight(Double.parseDouble(request.getParameter("height")));

        // 存储到数据库
        if (dao.save(customer)) {
            // 重定向
            response.sendRedirect("/crm/list");
        } else {
            request.setAttribute("error", "保存客户信息失败");
            request.getRequestDispatcher("/page/error.jsp").forward(request, response);
        }
    }
}
