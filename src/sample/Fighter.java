package sample;

import java.util.Random;

public class Fighter {
    private String name;
    private String description;
    private String picture;
    private int currentHitPoints;
    private int maxHitPoints;
    private int minDamage;
    private int maxDamage;
    private int numOfPotions;
    private boolean stoleSoul;
    private boolean alive;

    public Fighter(String n, String d, String p, int chp, int mhp, int minD, int maxD, int nop) {
        name = n;
        description = d;
        picture = p;
        currentHitPoints = chp;
        maxHitPoints = mhp;
        minDamage = minD;
        maxDamage = maxD;
        numOfPotions = nop;
        stoleSoul = false;
        alive = true;
    }

    public void setStoleSoul(boolean ss) {
        stoleSoul = ss;
    }

    public boolean getStoleSoul() {
        return stoleSoul;
    }

    public boolean isAlive() {
        if (currentHitPoints > 0) {
            return true;
        }
        return false;
    }

    public String getPicture() {
        return picture;
    }

    public boolean heal() {
        if (numOfPotions > 0) {
            currentHitPoints = maxHitPoints;
            numOfPotions -= 1;
            return true;
        }
        return false;
    }

    public int attack() {
        Random random = new Random();
        int randNum = random.nextInt(maxDamage - minDamage) + minDamage;
        return randNum;
    }

    public void setCurrentHitPoints(int deductThisAmount) {
        currentHitPoints = currentHitPoints - deductThisAmount;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public int getNumOfPotions() {
        return numOfPotions;
    }

    public void setNumOfPotions(int nop) {
        numOfPotions = nop;
    }

    public void setHitPoints() {
        currentHitPoints = maxHitPoints;
    }

    public void setDead() {
        alive = false;
    }

    public boolean getAlive() {
        return alive;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
