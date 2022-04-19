package com.example.demo.design_pattern_observer.practice_one;

public class Client {
    public static void main(String[] args) {
        Battery battery = new Battery();
        BatteryLevelDisplay display = new BatteryLevelDisplay(battery);
        LowBatteryWarning lowBatteryWarning = new LowBatteryWarning(battery);
        battery.setDisplay(display);
        battery.setWarning(lowBatteryWarning);
        battery.consume(10);
        battery.consume(60);
        battery.consume(10);
        battery.getLevel();
    }
}
