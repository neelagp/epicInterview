package game.common;

/**
 * Created by NeelaGouda on 6/2/19.
 */
public enum GameMode {

    STARKS("ST"),
    TARGAREYEN("TG"),
    LANNISTER("LN"),
    TYRELL("TY"),
    MORMONTS("MN"),
    WIGHTS("WT");

    final String code;

    GameMode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "GameMode{" +
                "code='" + code + '\'' +
                '}';
    }
}
