package com.bw.controller;

import com.bw.bean.User;
import com.bw.dao.UserDao;
import com.bw.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;

/**
 * Created by ${hanwenjian} on 2017/7/28.
 */
@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/")
    public String zhu() {
        return "zhu";
    }

    @RequestMapping("/deng")
    public String deng() {
        return "deng";
    }
    @RequestMapping("/saveuser")
    public String saveUser(User user) {
        String upwd = user.getUpwd();
        String s = Md5Util.MD5(upwd);
        user.setUpwd(s);
        userDao.save(user);
        return "deng";
    }
    @RequestMapping("/denguser")
    public String loginUser(String uname, String upwd) {
        User userByUser = userDao.findByUnameAndUpwd(uname, upwd);
       /* session.setAttribute("user",userByUser);*/
        return "forward:finduser";
    }
    @RequestMapping("/finduser")
    public String findUser(Map<String, Object> map) {
        List<User> all = userDao.findAll();
        map.put("find",all);
        return "usershow";
    }

    @RequestMapping("/toupdateuser")
    public String toupdateUser(User user) {
        userDao.save(user);
        return "forward:finduser";
    }
@RequestMapping("/updateuser")
    public String updateUser(Integer uid, Map<String, Object> map, Model model) {

    User one = userDao.findOne(uid);
    System.out.println(one.getUname());
    map.put("up",one);
    model.addAttribute("up",one);
    return "xiu";
    }

    @RequestMapping("/deleteuser")
    public String deleteUser(Integer uid,Map<String, Object> map) {
        userDao.delete(uid);
        return "forward:finduser";
    }

    @RequestMapping("/namefind")
    public String namefind(String uname,Map<String, Object> map) {
        List<User> byUname = userDao.findByUname(uname);
        map.put("find",byUname);
        for (User user : byUname) {
            System.out.println(user.getUname());
        }
        System.out.println("ddd");
        return "usershow";
    }

    /*@RequestMapping("poi")
    public String exportEmployee(HttpServletResponse response ) throws Exception{

        Workbook wb=new HSSFWorkbook();
        String[] headers={"编号","姓名","性别"};
        List<User> all = userDao.findAll();
        ExcelUtil.excelOut(all, wb, headers);
        String fileName="导出.xls";//导出生产的工作薄名
        ExcelUtil.export(response, wb, fileName);
        return null;
    }*/
}
