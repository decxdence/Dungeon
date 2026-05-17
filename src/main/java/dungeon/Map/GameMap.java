package dungeon.Map;

import dungeon.Model.*;

import java.util.HashMap;
import java.util.Random;

public class GameMap {
    private final int width;
    private final int height;
    private final HashMap<Position, Entity> entities;

    public GameMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = initializeMap();
    }

    private HashMap<Position, Entity> initializeMap() {
        HashMap<Position, Entity> map = new HashMap<>();
        Entity entity = null;
        Random rand = new Random();
        int x;

        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                x = rand.nextInt(101);
                if (x < 60){
                    entity = null;
                } else if (x > 60 && x < 90){
                    entity = (Treasure) new Treasure(10, new Position(i,j));
                } else if (x > 90 && x < 100){
                    entity = (Monster) new Monster(10, new Position(i,j));
                }
                map.put(new Position(i,j), entity);
            }
        }
        return map;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String sizeOfMap(){
        return width + "x" + height;
    }

    public Entity getEntityAtPosition(Position pos){
        return entities.get(pos);
    }

}
