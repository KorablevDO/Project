package org.game.td;

import org.game.td.models.mob.MobBuilder;
import org.game.td.models.mob.MobImpl;
import org.game.td.models.mob.MobType;

public class Run {
    public static void main(String[] args) {
        MobBuilder builder = new MobBuilder()
                .setName("nub")
                .setType(MobType.SOLDIER)
                .setHitPoints(100)
                .setDefense(0);
        MobImpl mob  = builder.build();
        System.out.println(mob);
    }
}
