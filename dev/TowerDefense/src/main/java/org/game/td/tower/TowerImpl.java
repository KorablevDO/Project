package org.game.td.tower;

public class TowerImpl implements Tower {
    private int damage;
    private TowerType type;

    @Override
    public String toString() {
        return String.format("Damage: %d, Type: %s", this.damage, type);
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setType(TowerType type) {
        this.type = type;
    }

    public TowerType getType() {
        return type;
    }
}
