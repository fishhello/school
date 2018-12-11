package com.example.sha.fish03.utils;

import com.example.sha.fish03.R;
import com.example.sha.fish03.entity.EssayItem;
import com.example.sha.fish03.entity.User;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class Dbutils {
    //获取指定用户密码
    public static String getPasswd(String userName){
        List<User> passwd = LitePal.select("userpass").where("username=?",userName).find(User.class);
        if(passwd.size()>0){
            return passwd.get(0).getUserPass();
        }
        return null;
    }
    //检查用户是否唯一
    public static boolean checkUnique(String userName){
        List<User> list = LitePal.where("username =?",userName).find(User.class);
        if(list.size()==0) {
            //用户名不重复
            return true;
        }
        return false;
    }

    //根据用户名获取当前userId
    public static int getUserId(String userName){
        List<User> passwd = LitePal.select("userpass").where("username=?",userName).find(User.class);
        if(passwd.size()>0){
            return passwd.get(0).getId();
        }
        return -1;
    }

    //保存活动信息
    public static void saveInput(User user,String title,String text) {
        EssayItem essayItem = new EssayItem();
        essayItem.setEssayAutor(user.getId());
        essayItem.setEssayTitle(title);
        essayItem.setEssayText(text);
        essayItem.setCreateTime(TimeUtils.getTime());
        essayItem.setImageId(R.drawable.ic_done);
        essayItem.save();
    }

    //获取全部活动信息
    public static List<EssayItem> getAllItem() {
        List<EssayItem> lists = LitePal.findAll(EssayItem.class);
        return lists;
    }

    //h获取活动总数
    public static int getItemSize() {
        List<EssayItem> lists = LitePal.findAll(EssayItem.class);
        return lists.size();
    }

    //根据当前id获取当前活动
    public static EssayItem getCurrent(int id){
        EssayItem list = LitePal.find(EssayItem.class,id);
        return list;
    }

}
