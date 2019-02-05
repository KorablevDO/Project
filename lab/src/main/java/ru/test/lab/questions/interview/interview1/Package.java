package ru.test.lab.questions.interview.interview1;

import java.util.ArrayList;
import java.util.List;

public class Package {
    private String name;
    private List<Package> dependencies;

    public Package(String name){
        this.name = name;
        this.dependencies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Package> getDependencies(){
        return this.dependencies;
    }

    public void addDependencies(Package mPackage){
        this.dependencies.add(mPackage);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }

        if(!Package.class.isAssignableFrom(obj.getClass())){
            return false;
        }

        Package aPackage = (Package) obj;
        String name = aPackage.getName();
        if(!this.name.equals(name)){

        }

        return true;
    }
}
