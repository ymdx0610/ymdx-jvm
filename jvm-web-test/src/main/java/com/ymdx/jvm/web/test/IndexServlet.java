package com.ymdx.jvm.web.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName: IndexServlet
 * @Description: TODO
 * @Author: ymdx
 * @Email: y_m_d_x@163.com
 * @Date: 2020-01-03 10:39
 * @Version: 1.0
 **/
@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    private int count = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");
//        final PrintWriter out = resp.getWriter();
//        out.println("你好，义码当仙！");

//        System.out.println("index:" + (++count));
    }

}
