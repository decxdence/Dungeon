package dungeon;

import dungeon.Map.GameMap;
import dungeon.Model.Position;
import dungeon.UI.Renderer;

public class Main {
    public static void main() {
        GameMap map = new GameMap(5, 10);
        Renderer rend = new Renderer(map);
    }
}
