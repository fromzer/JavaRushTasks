package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("A", 1,2));
        users.add(new User("B", 3, 4));
        modelData.setUsers(users);
    }
}
