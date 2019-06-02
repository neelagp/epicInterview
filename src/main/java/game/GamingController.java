package game;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import game.common.GameMode;
import game.common.Region;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by NeelaGouda on 6/2/19.
 */

@RestController
public class GamingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GamingController.class);

    @Autowired
    GamingService gamingService;

    @ResponseBody
    @RequestMapping(value="/game/play", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="register the region and the game mode in which user is playing ")
    public ResponseEntity<Map<String,Object>> registerGameMode(@RequestBody Map<String, String> requestBody){

        Map<String,Object> response = new HashMap();

        String regionCode = requestBody.get("region");
        String mode = requestBody.get("mode");

        Objects.requireNonNull(regionCode,"Region code must be provided");
        Objects.requireNonNull(mode,"Mode must be provided");

        GameMode gameMode = GameMode.valueOf(mode); // check for invalid modes
        Region region = Region.resolveRegion(regionCode); //check for invalid regions

        gamingService.registerGameMode(region, gameMode);

        //TODO: Build appropriate response like Gaming Response object and set in the response entity
        response.put("success", true);
        return ResponseEntity.ok().body(response);

    }

    @ResponseBody
    @RequestMapping(value="/game/modes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="register the region and the game mode in which user is playing ")
    public ResponseEntity<Map<String,Object>> getPopularModes(@RequestParam("region") String regionCode) {

        Map<String, Object> response = new HashMap();
        Objects.requireNonNull(regionCode, "Region code must be provided");

        Region region = Region.resolveRegion(regionCode); //check for invalid regions
        List<GameMode> popularModes = gamingService.getPopularModes(region);

        response.put("success", "true");
        response.put("modes", popularModes);
        return ResponseEntity.ok().body(response);

    }


}
