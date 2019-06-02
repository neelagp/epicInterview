package game;

import game.common.GameMode;
import game.common.Region;

import java.util.List;

/**
 * Created by NeelaGouda on 6/2/19.
 */
public interface GamingService {

    void registerGameMode(Region region,GameMode mode);

    List<GameMode> getPopularModes(Region region);
}
