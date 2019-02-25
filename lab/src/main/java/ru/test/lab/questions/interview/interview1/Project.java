package ru.test.lab.questions.interview.interview1;

import java.util.*;

public class Project {
    private String name;
    private List<Package> packages;
    private int counter = 0;

    public Project(String name) {
        this.name = name;
        this.packages = new ArrayList<>();
    }

    public boolean hasCyclicDependencies() {
        for(Package aPackage : this.packages){
        //TODO обход графа!
        }
        //http://jdevnotes.blogspot.com/2011/01/blog-post_18.html
        return false;
    }

    private boolean inNext(){
        int i = 3;
        if((this.counter != i)){
            this.counter++;
            return true;
        } else {
            return false;
        }
    }

    public List<Package> getCompilationOrder() {
        return this.packages;
    }

    public void addPackage(Package mPackage) {
        this.packages.add(mPackage);
    }
}
