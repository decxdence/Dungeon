package dungeon.UI;

import dungeon.Map.GameMap;
import dungeon.Model.*;
import dungeon.Service.Game;

import java.util.HashMap;

public class Renderer {
    private final GameMap map;

    public Renderer(GameMap map){
        this.map = map;
        render(map);
    }

    private void render(GameMap map) {
        String s;
        for (int i = 0; i < map.getWidth(); i++) {
            System.out.println();
            for (int j = 0; j < map.getHeight(); j++) {
                s = switch (map.getEntityAtPosition(new Position(i, j))) {
                    case Hero hero -> "웃";
                    case Monster monster -> "☠";
                    case Treasure treasure -> "♦";
                    case null -> "·";
                    default ->
                            throw new IllegalStateException("Unexpected value: " + map.getEntityAtPosition(new Position(i, j)));
                };
                    System.out.print(s + " ");
            }
        }
    }
}
