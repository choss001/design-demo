package com.example.demo.design_pattern_observer.practice_one;

public class BatteryLevelDisplay{
    private int level = 100;
    private Battery battery;

    public BatteryLevelDisplay(Battery battery) {
        this.battery = battery;
    }

    public void update() {
        int level = battery.getLevel();
        System.out.println("Level: " + level);
    }
}