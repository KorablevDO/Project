package org.game.td.locomotive;

import java.util.Queue;

/**
 * interface для описания сбора NPC в волну атаки на игровом поле.
 */
public interface Locomotive<V> {
    public Queue<V> getLocomotive();
}
