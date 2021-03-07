package net.xdclass.forum.controller;

import net.xdclass.forum.domain.Category;
import net.xdclass.forum.service.CategoryService;
import net.xdclass.forum.service.CategoryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "categoryServlet",urlPatterns = {"/category"})
public class CategoryServlet extends BaseServlet {


    private CategoryService categoryService=new CategoryServiceImpl();

    /**
     * 返回全部分类
     * http://localhost:8080/category?method=list
     */
    public void list(HttpServletRequest request, HttpServletResponse response){

        List<Category>list=categoryService.list();
        System.out.println(list);

        request.setAttribute("categoryList",list);

    }
}
