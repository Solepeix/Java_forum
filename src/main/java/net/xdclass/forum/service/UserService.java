package net.xdclass.forum.service;

import net.xdclass.forum.domain.User;

public interface UserService {
    int register(User user);




    User login(String phone, String pwd);
}
