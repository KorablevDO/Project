package org.game.td;

import org.game.td.mob.Mob;
import org.game.td.mob.MobBuilder;
import org.game.td.mob.MobType;
import org.game.td.tower.Tower;
import org.game.td.tower.TowerBuilder;
import org.game.td.tower.TowerType;

public class Run {
    public static void main(String[] args) {
        MobBuilder mobBuilder = new MobBuilder()
                .setName("nub")
                .setType(MobType.SOLDIER)
                .setHitPoints(100)
                .setDefense(0);
        Mob mob = mobBuilder.build();
        System.out.println(mob);

        TowerBuilder towerBuilder = new TowerBuilder()
                .setDamage(10)
                .setType(TowerType.BASE);
        Tower tower = towerBuilder.build();
        System.out.println(tower);

        do {
            mob.setDamage(tower.getDamage());
            System.out.println(mob);
        } while (mob.isAlive());
    }
}
