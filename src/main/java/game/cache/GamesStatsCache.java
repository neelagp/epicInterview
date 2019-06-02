package game.cache;

import game.common.GameMode;

import java.util.Set;

/**
 * Created by NeelaGouda on 6/2/19.
 */
public interface GamesStatsCache {

    void add(GameMode mode);

    Set<GameMode> getPopularModes();
}
