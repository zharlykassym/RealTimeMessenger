package com.tamerlan.realtimemessenger;

public class User {
    private String id;
    private String name;
    private String lastMame;
    private int age;
    private boolean isOnline;

    public User(String id, String name, String lastMame, int age, boolean isOnline) {
        this.id = id;
        this.name = name;
        this.lastMame = lastMame;
        this.age = age;
        this.isOnline = isOnline;
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

    public boolean isOnline() {
        return isOnline;
    }


}
