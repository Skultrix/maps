package net.battlecade.game.strongholdsiege.maps;

public enum GameMapComponent {
    NAME("name", false, false),
    LOBBY("lobby", true, false),
    ITEM_SPAWNS("item-spawns", true, true),
    LEGENDARY_ITEM_SPAWNS("legendary-item-spawns", true, true),
    SUPPLY_DROPS("supply-drops", true, true),
    BRICKS("bricks", true, true),
    METAL("metal", true, true),
    WOOD("wood", true, true);

    private String path;
    private boolean isLocation;
    private boolean isLocationList;

    GameMapComponent(String path, boolean isLocation, boolean isLocationList) {
        this.path = path;
        this.isLocation = isLocation;
        this.isLocationList = isLocationList;
    }

    public String getPath() {
        return path;
    }

    public boolean isLocation() {
        return isLocation;
    }

    public boolean isLocationList() {
        return isLocationList;
    }
}
