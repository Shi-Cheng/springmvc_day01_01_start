package cn.dx.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Account implements Serializable {
    private String username;
    private float money;

    private User user;
//    private List<User> list;
//    private Map<String,User> map;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", money=" + money +
                ", user=" + user +
                '}';
    }


//    public List<User> getList() {
//        return list;
//    }
//
//    public void setList(List<User> list) {
//        this.list = list;
//    }
//
//    public Map<String, User> getMap() {
//        return map;
//    }
//
//    public void setMap(Map<String, User> map) {
//        this.map = map;
//    }
//
//    @Override
//    public String toString() {
//        return "Account{" +
//                "username='" + username + '\'' +
//                ", money=" + money +
//                ", list=" + list +
//                ", map=" + map +
//                '}';
//    }
}
