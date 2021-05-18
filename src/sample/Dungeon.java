package sample;

public class Dungeon {
    String name;
    String description;
    Fighter fighter;

    public Dungeon(String n, String d, Fighter f) {
        name = n;
        description = d;
        fighter = f;
    }

    public Fighter getFighter() {
        return fighter;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDefeated() {
        if (fighter.isAlive() == false) {
            return true;
        }
        return false;
    }
}