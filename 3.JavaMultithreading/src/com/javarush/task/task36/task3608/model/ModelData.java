package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

public class ModelData {
    private List<User> users;
    private List<User> deletedUsers;

    public List<User> getDeletedUsers() {
        return deletedUsers;
    }

    public void setDeletedUsers(List<User> deletedUsers) {
        this.deletedUsers = deletedUsers;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
