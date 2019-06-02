package game.cache;

import game.common.GameMode;
import game.common.Region;

import java.util.Set;

/**
 * Created by NeelaGouda on 6/2/19.
 */

/**
 * I think its a good idea to have a cache per region because
 * a region does not  care about popular modes in other region
 */
public class CountryGameStatsCache extends SimpleCache<GameMode, Integer> implements GamesStatsCache{

    private final Region region;

    public CountryGameStatsCache(Region region) {
        this.region = region;
    }

    public void add(GameMode mode) {
        Boolean modeExists = exists(mode);
        if (modeExists) {
            Integer modeRank = get(mode);
            modeRank = modeRank + 1; // do those integer max check
            super.add(mode, modeRank);
        } else {
            super.add(mode, 1);
        }
    }

    public Set<GameMode> getPopularModes(){
        return getAllSorted().keySet();
    }

}
