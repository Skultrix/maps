package net.battlecade.game.strongholdsiege.maps;

import net.battlecade.util.LocationUtils;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameMap {
    private Map<World, EnumMap<GameMapComponent, Object>> cache = new HashMap<>();

    private File file;
    private FileConfiguration data;

    private String name;
    private String world;
    private boolean published;

    public GameMap(File file) {
        this.file = file;
        this.data = YamlConfiguration.loadConfiguration(file);

        this.name = data.getString("name");
        this.world = data.getString("world");
        this.published = data.getBoolean("published");
    }

    public Location getLocation(GameMapComponent component, World world) {
        if (cache.containsKey(world)) {
            if (cache.get(world).containsKey(component)) {
                return (Location) cache.get(world).get(component);
            }
        } else {
            cache.put(world, new EnumMap<GameMapComponent, Object>(GameMapComponent.class));
        }

        Location location = LocationUtils.getLocation(data.getString(component.getPath()), world);
        cache.get(world).put(component, location);

        return location;
    }

    public List<Location> getLocations(GameMapComponent component, World world) {
        return null;
    }

    public void clear(World world) {
        cache.remove(world);
    }

    public void save() {
        try {
            data.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getWorld() {
        return world;
    }

    public boolean isPublished() {
        return published;
    }

    public static GameMap create(String name) {
        return null;
    }

}
