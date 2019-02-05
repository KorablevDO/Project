package ru.test.lab.questions.interview.interview1;

import java.util.*;

public class Project {
    private String name;
    private List<Package> packages;

    public Project(String name) {
        this.name = name;
        this.packages = new ArrayList<>();
    }

    public boolean hasCyclicDependencies() {
        for(Package aPackage : this.packages){
        //TODO
        }
        return false;
    }

    public List<Package> getCompilationOrder() {
        return this.packages;
    }

    public void addPackage(Package mPackage) {
        this.packages.add(mPackage);
    }
}
