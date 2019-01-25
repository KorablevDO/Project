package org.game.td.location;

public class LocationImpl implements Location {
    private int width = 10;
    private int length = 10;
    private Object[][] location;

    public int getWidth() {
        return 0;
    }

    public int setWidth() {
        return 0;
    }

    public int getLength() {
        return 0;
    }

    public int setLength() {
        return 0;
    }

    public void generate(){
       location = new Object[width][length];
    }

    public void setObject(int x,int y, Object object){
        location[x][y] = object;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        return super.toString();
    }
}
