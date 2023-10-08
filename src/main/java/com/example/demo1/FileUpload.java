package com.example.demo1;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "FileUpload", value = "/file-upload")
@MultipartConfig
public class FileUpload extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        Part part = req.getPart("myFile");

        String realPath = req.getServletContext().getRealPath("/");
        System.out.println(realPath);

        String path = realPath + File.separator + part.getSubmittedFileName();

        System.out.println(path);

        part.write(path);
    }
}
