package net.xdclass.forum.service;

import net.xdclass.forum.dao.UserDao;
import net.xdclass.forum.domain.User;
import net.xdclass.forum.util.CommonUtil;

import java.util.Date;
import java.util.Random;

public class UserServiceImpl implements UserService{

    private UserDao userDao=new UserDao();

    @Override
    public int register(User user) {

        user.setRole(1);
        user.setCreateTime(new Date());
        user.setImg(getRandomImg());
        user.setPwd(CommonUtil.MD5(user.getPwd()));

        try {
            return userDao.save(user);
        }catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public User login(String phone, String pwd) {

        String md5pwd=CommonUtil.MD5(pwd);

        User user=userDao.findByPhoneAndPwd(phone,md5pwd);

        return user;
    }

    /**
     * 放在CDN上的随机头像
     */
    private static final String [] headImg={
      "https://c-ssl.duitang.com/uploads/item/201802/18/20180218141335_ikrHl.jpeg",
      "https://c-ssl.duitang.com/uploads/item/201510/02/20151002094317_2jmkS.jpeg",
      "https://c-ssl.duitang.com/uploads/item/201710/04/20171004175500_3keju.thumb.700_0.jpeg",
      "https://c-ssl.duitang.com/uploads/item/201609/24/20160924213204_Mje8i.jpeg"
    };
    private String getRandomImg(){
        int size=headImg.length;
        Random random=new Random();
        int index=random.nextInt(size);
        return headImg[index];
    }
}
