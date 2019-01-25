package org.game.td.mob;

import org.game.td.Coordinates;

/**
 * interface для описания NPC - не игрового персонажа.
 */
public interface Mob extends Coordinates {
    /**
     * Метод подразумевает реализоцию проверки уровня жизни данного NPC.
     * @return
     */
    public boolean isAlive();

    /**
     * Метод расчета нанесенного по NPC урона.
     * @param damage
     */
    public void setDamage(int damage);
}
