package net.simplifiedcoding.bottomnavigationexample.Model;

import net.simplifiedcoding.bottomnavigationexample.Model.Child;

import java.util.ArrayList;

public class ParentModel {

    String name;
    ArrayList<Child> arrayList;

    public ParentModel() {
    }

    public ParentModel(String name, ArrayList<Child> arrayList) {
        this.name = name;
        this.arrayList = arrayList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Child> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<Child> arrayList) {
        this.arrayList = arrayList;
    }
}
