package com.hcc.springboot_integrated.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 整合Servlet
 *
 * @ClassName FirstServlet
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/7 16:12
 * @Version 1.0
 **/

@WebServlet(name = "FirstServlet", urlPatterns = "/firstServlet")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("......doGet");
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("......doPost");
        super.doPost(req, resp);
    }
}
