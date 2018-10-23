package ru.org.patterns.builder;

import java.net.DatagramPacket;

public class Director {
    private Builder builder;

    public Director(){
        this.builder = new Builder();
    }


}
