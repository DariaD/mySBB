package com.jpa.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Дарья on 08.03.2015.
 */

public class UserList  {
    private static Map users = new HashMap();

    public static User findUser(String user){
        return (User)users.get(user);
    }

    public static boolean addUser(User user){
        boolean result = false;
        if ((!users.containsKey(user.getLogin()))&&(user.getPassword()!=null)&&(!"".equals(user.getPassword()))){
            users.put(user.getLogin(),user);
            result = true;
        }
        return result;
    }

}