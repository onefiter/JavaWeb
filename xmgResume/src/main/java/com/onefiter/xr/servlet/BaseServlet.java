package com.onefiter.xr.servlet;

import com.onefiter.xr.bean.UploadParams;
import com.onefiter.xr.service.BaseService;
import com.onefiter.xr.util.Uploads;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public abstract class BaseServlet<T> extends HttpServlet {
    protected BaseService<T> service = newService();
            protected BaseService<T> newService() {
                // com.onefiter.xr.servlet.WebsiteServlet
                // com.onefiter.xr.service.impl.WebsiteServiceImpl
                try {
                    String clsName = getClass().getName()
                            .replace(".servlet.", ".service.impl.")
                            .replace("Servlet", "ServiceImpl");
                    return (BaseService<T>) Class.forName(clsName).newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
            return null;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 设置编码
            request.setCharacterEncoding("UTF-8");

            // 利用方法名调用方法
            String uri = request.getRequestURI();
            String[] cmps = uri.split("/");
            String methodName = cmps[cmps.length - 1];
            Method method = getClass()
                    .getMethod(methodName,
                            HttpServletRequest.class,
                            HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();

            // e一般是InvocationTargetException
            Throwable cause = e;
            while (cause.getCause() != null) {
                cause = cause.getCause();
            }

            forwardError(request, response, cause.getClass().getSimpleName() + ": " + cause.getMessage());
        }
    }

    protected void redirect(HttpServletRequest request, HttpServletResponse response, String path)
            throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/" + path);
    }

    protected void forward(HttpServletRequest request, HttpServletResponse response, String path)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/page/" + path).forward(request, response);
    }

    protected void forwardError(HttpServletRequest request, HttpServletResponse response, String error)
            throws ServletException, IOException {
        request.setAttribute("error", error);
        forward(request, response, "error.jsp");
    }
}
