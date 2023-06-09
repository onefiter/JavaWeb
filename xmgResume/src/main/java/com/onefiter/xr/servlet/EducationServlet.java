package com.onefiter.xr.servlet;

import com.onefiter.xr.bean.Education;
import com.onefiter.xr.service.UserService;
import com.onefiter.xr.service.WebsiteService;
import com.onefiter.xr.service.impl.UserServiceImpl;
import com.onefiter.xr.service.impl.WebsiteServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/education/*")
public class EducationServlet extends BaseServlet<Education> {
    private UserService userService = new UserServiceImpl();
    private WebsiteService websiteService = new WebsiteServiceImpl();

    public void front(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("user", userService.list().get(0));
        request.setAttribute("footer", websiteService.list().get(0).getFooter());
        request.setAttribute("educations", service.list());
        forward(request, response, "front/education.jsp");
    }

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("educations", service.list());
        forward(request, response, "admin/education.jsp");
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Education education = new Education();
        BeanUtils.populate(education, request.getParameterMap());
        if (service.save(education)) { // 保存成功
            redirect(request, response, "education/admin");
        } else {
            forwardError(request, response, "教育信息保存失败");
        }
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] idStrs = request.getParameterValues("id");
        List<Integer> ids = new ArrayList<>();
        for (String idStr : idStrs) {
            ids.add(Integer.valueOf(idStr));
        }
        // 删除
        if (service.remove(ids)) {
            redirect(request, response, "education/admin");
        } else {
            forwardError(request, response, "教育信息删除失败");
        }
    }
}
