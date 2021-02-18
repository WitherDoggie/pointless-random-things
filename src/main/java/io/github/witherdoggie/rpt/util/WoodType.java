package io.github.witherdoggie.rpt.util;

public enum WoodType {

    OAK(0, "oak"),
    BIRCH(1, "birch"),
    SPRUCE(2, "spruce"),
    DARK_OAK(3, "dark_oak"),
    ACACIA(4, "acacia"),
    JUNGLE(5, "jungle"),
    WARPED(6, "warped"),
    CRIMSON(7, "crimson");

    private int id;
    private String name;

    private WoodType(int id, String name){
        this.id = id;
        this.name = name;
    }
}
