package org.game.td.tower;

import org.game.td.Coordinates;

/**
 * interface для описания строений.
 */
public interface Tower extends Coordinates {
    /**
     * Метод подразумевает получение наносимото башней урона.
     * @return
     */
    public int getDamage();
}
