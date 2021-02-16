package io.github.witherdoggie.rpt.entity;

import net.minecraft.entity.passive.HorseColor;

import java.util.Arrays;
import java.util.Comparator;

public enum AngryPotatoColor {

    BROWN(0),
    AQUA(1);

    private final int index;

    private AngryPotatoColor(int index){
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    private static final AngryPotatoColor[] VALUES = (AngryPotatoColor[])Arrays.stream(values()).sorted(Comparator.comparingInt(AngryPotatoColor::getIndex)).toArray((i) -> {
        return new AngryPotatoColor[i];
    });

    public static AngryPotatoColor byIndex(int index) {
        return VALUES[index % VALUES.length];
    }
}

