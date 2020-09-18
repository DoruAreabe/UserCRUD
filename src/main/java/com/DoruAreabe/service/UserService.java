package com.DoruAreabe.service;

import com.DoruAreabe.DAO.UserDao;
import com.DoruAreabe.entity.User;

import java.util.List;

public class UserService {
    public static List<User> listOfAll(){
        return UserDao.readAll();
    }
    public static boolean addNewOne(String userName, String email, String password){
        User user = new User(email,userName,password);
        User crated = UserDao.create(user);
        if(crated!=null) return true;
        return false;
    }
    public static void removeSelected(int id){
        UserDao.delete(id);
    }
    public static void editSelectedWithPassword(int id, String newUserName, String newEmail, String newPassword){
        User toUpdate = UserDao.read(id);
        toUpdate.setEmail(newEmail);
        toUpdate.setUserName(newUserName);
        toUpdate.setPassword(newPassword);
        UserDao.update(toUpdate);
    }
    public static void editSelectedWithoutPassword(int id, String newUserName, String newEmail){
        User toUpdate = UserDao.read(id);
        toUpdate.setEmail(newEmail);
        toUpdate.setUserName(newUserName);
        UserDao.update(toUpdate);
    }
}
