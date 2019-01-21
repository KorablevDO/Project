package org.game.td.models.mob;

public class MobBuilder {
    private String name;
    private MobType type;
    private int hitPoints;
    private int defense;

    public MobBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MobBuilder setType(MobType type) {
        this.type = type;
        return this;
    }

    public MobBuilder setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
        return this;
    }

    public MobBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    public MobImpl build(){
        MobImpl mob = new MobImpl();
        mob.setName(this.name);
        mob.setType(this.type);
        mob.setHitPoints(this.hitPoints);
        mob.setDefense(this.defense);
        return mob;
    }
}
