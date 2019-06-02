package game;

import game.cache.CountryGameStatsCache;
import game.cache.GamesStatsCache;
import game.cache.RegionCache;
import game.common.GameMode;
import game.common.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NeelaGouda on 6/2/19.
 */

@Service
public class GamingServiceImpl implements GamingService {


    /**
     * This cache should be kept in sync with data persisted 
     */
    @Autowired
    private RegionCache regionCache;

    /**
     * Below method should interact with databaseManager that actually persists data in the MongoDB
     * For simplicity replaced with maps
     */
    @Override
    public void registerGameMode(Region region, GameMode mode) {

        if (regionCache.exists(region)) {
            GamesStatsCache gamesStatsCache = regionCache.get(region);
            gamesStatsCache.add(mode);
        } else {
            CountryGameStatsCache countryGameStatsCache = new CountryGameStatsCache(region);
            countryGameStatsCache.add(mode);
            regionCache.add(region, countryGameStatsCache);
        }

    }

    /**
     * Below method should use aggregate function of key value table to retrieve popular modes
     * the interaction with DB could be abstracted in the databaseMaanger class
     */
    @Override
    public List<GameMode> getPopularModes(Region region) {
        List<GameMode> modes = new ArrayList<>();
        GamesStatsCache gamesStatsCache = regionCache.get(region);
        modes.addAll(gamesStatsCache.getPopularModes());
        return modes;
    }
}
