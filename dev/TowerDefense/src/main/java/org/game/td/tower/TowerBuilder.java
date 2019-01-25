package org.game.td.tower;

public class TowerBuilder {
    private int damage;
    private TowerType type;

    public TowerBuilder setDamage(int damage){
        this.damage = damage;
        return this;
    }

    public TowerBuilder setType(TowerType type){
        this.type = type;
        return this;
    }

    public Tower build(){
        TowerImpl tower = new TowerImpl();
        tower.setDamage(this.damage);
        tower.setType(this.type);
        return tower;
    }
}
