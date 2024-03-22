package com.tamerlan.realtimemessenger;

public class User {
    private String id;
    private String name;
    private String lastMame;
    private int age;
    private boolean online;

    public User() {
    }

    public User(String id, String name, String lastMame, int age, boolean online) {
        this.id = id;
        this.name = name;
        this.lastMame = lastMame;
        this.age = age;
        this.online = online;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastMame() {
        return lastMame;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastMame='" + lastMame + '\'' +
                ", age=" + age +
                ", online=" + online +
                '}';
    }

    public boolean isOnline() {
        return online;
    }


}
