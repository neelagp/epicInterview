package game.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by NeelaGouda on 6/2/19.
 */
public class Region {

    private final Locale country;

    private Region(String countryCode) {
        this.country = new Locale("", countryCode);
    }


    public List<Region> getRegions() {

        List<Region> allCountries = new ArrayList<>();
        String[] isoCountryCodes = Locale.getISOCountries();

        for (String countryCode : isoCountryCodes) {
            allCountries.add(new Region(countryCode));
        }

        return allCountries;
    }

    public static Region resolveRegion(String code){
        //find from existing all countries list
        //Handle codes that do not exist etc
        //for now just create region
        return new Region(code);
    }


}
