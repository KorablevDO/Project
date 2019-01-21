package org.game.td.models.mob;

public class MobImpl implements Mob {
    private String name;
    private MobType type;
    private int hitPoints;
    private int defense;

    @Override
    public String toString() {
        return String.format("Name: %s,Type: %s,Hit Point: %d,Defense: %d", name, type, hitPoints, defense);
    }

    public boolean isAlive() {
        if (hitPoints > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setDamage(int damage) {
        this.defense = damageDefenseCalculation(this.defense, damage);
        this.hitPoints = damageCalculation(this.hitPoints, this.defense, damage);
    }

    private int damageCalculation(int hitPoints, int defense, int damage){
        int blocked = getBlocked(defense, damage);
        int result = hitPoints - (damage - blocked);
        return result;
    }

    private int getBlocked(int defense, int damage){
        int result = damage - defense / 5;

        return result;
    }

    private int damageDefenseCalculation(int defense, int damage){
        int result = 0;
        if(defense > 0) {
            result = defense - (damage / 2);
        }
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(MobType type) {
        this.type = type;
    }

    public void setHitPoints(int hitPoints){
        this.hitPoints = hitPoints;
    }

    public void setDefense(int defense){
        this.defense = defense;
    }
}
