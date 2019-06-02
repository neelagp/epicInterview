package game.cache;

import game.common.GameMode;
import game.common.Region;
import org.springframework.stereotype.Component;

/**
 * Created by NeelaGouda on 6/2/19.
 */
@Component
public class RegionCache extends SimpleCache<Region, GamesStatsCache> {

    public void add(Region region, GamesStatsCache gamesStatsCache) {
        super.add(region, gamesStatsCache);
    }

    public GamesStatsCache get(Region region){
        return super.get(region);
    }

}
