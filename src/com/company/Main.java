package com.company;

import java.util.Random;

public class Main {

    public static int bossHealth = 600;
    public static int bossDamage = 50;
    public static String bossDefenceTybe = "";
    public static int[] heroesHealth = {260, 270, 300, 350};
    public static int[] heroesDamage = {10, 20, 5, 0};
    public static String[] heroesAttakType = {"Phycical", "Magical", "Mental", "Medic"};
    public static int countRound;

    public static void main(String[] args) {


        while (!isFinihed()) {
            round();
        }


    }


    public static void round() {
        printStatistics();
        countRound++;
        System.out.println("Round: "+countRound);
        System.out.println("Round was started!");
        heroesHit();
        changeBossDefenceType();
        bossHit();
        printStatistics();
    }

    public static void printStatistics() {
        System.out.println("---------------");
        System.out.println("Boss health: " + bossHealth);
        System.out.println("Warrior health: " + heroesHealth[0]);
        System.out.println("Magic health: " + heroesHealth[1]);
        System.out.println("Kinetic health: " + heroesHealth[2]);
        System.out.println("Medic health:" + heroesHealth[3]);
        System.out.println("----------------");
    }

    public static void bossHit() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                if (heroesHealth[i] - bossDamage < 0) heroesHealth[i] = 0;
                else heroesHealth[i] = heroesHealth[i] - bossDamage;
            }
            if (heroesHealth[i] < 100 && heroesHealth[3] > 0) {
                Random random = new Random();
                int help = random.nextInt(90);
                heroesHealth[i] = heroesHealth[i] + help;
            }
        }


    }
    public static void heroesHit () {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (bossHealth > 0 && heroesHealth[i] > 0) {
                if (bossHealth - heroesDamage[i] < 0) bossHealth = 0;
                else bossHealth = bossHealth - heroesDamage[i];
            }
        }
    }

    public static boolean isFinihed () {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        if (heroesHealth[0] <= 0 && heroesHealth[1] <= 0
                && heroesHealth[2] <= 0) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }
    public static void changeBossDefenceType () {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttakType.length);
        bossDefenceTybe = heroesAttakType[randomIndex];
        System.out.println("Boss defence type:" + bossDefenceTybe);

    }
}
