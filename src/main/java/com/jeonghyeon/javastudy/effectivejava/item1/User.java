package com.jeonghyeon.javastudy.effectivejava.item1;



public class User {
    private String userName;
    private Integer age;
    private UserRole userRole;

    public User(String userName, Integer age,UserRole userRole){
        this.userName = userName;
        this.age = age;
        this.userRole = userRole;
    }

    public static User ofBasic(String userName,Integer age){
        User user = new User(userName,age,UserRole.BASIC);

        return user;
    }
    public static User ofAdmin(String userName,Integer age){
        User user = new User(userName,age,UserRole.ADMIN);
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
