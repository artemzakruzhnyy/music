package by.epam.training.controllers;

import by.epam.training.services.jena.JenaWorker;
import org.apache.jena.base.Sys;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class InitServlet extends HttpServlet {
    private JenaWorker jenaWorker;

    @Override
    public void init() throws ServletException {
        jenaWorker = new JenaWorker();
        System.out.println("init=" + jenaWorker);
        getServletContext().setAttribute("jena", jenaWorker);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bands = req.getParameter("getBands");
        if ("1".equals(bands)) {
            resp.getWriter().print(jenaWorker.selectBands());
        }
    }
}
