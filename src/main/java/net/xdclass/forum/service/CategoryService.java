package net.xdclass.forum.service;

import net.xdclass.forum.domain.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 全部分类
     * @return
     */
    List<Category> list();
}
