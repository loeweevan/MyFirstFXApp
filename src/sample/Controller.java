package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Controller {

    Dungeon[][] dungeonMaze = new Dungeon[4][4];
    Fighter player;
    int playerRow;
    int playerColumn;
    Fighter opponent;
    Dungeon currentDungeon;

    @FXML
    ImageView playerImageView;
    @FXML
    ImageView fighterImageView;
    @FXML
    Label informationLabel;
    @FXML
    Label playerHP;
    @FXML
    Label opponentHP;
    @FXML
    Label potionLabel;
    @FXML
    Button healButton;

    @FXML
    public void initialize() {
        initializeMazeAndStartGame();
    }

    @FXML
    private void initializeMazeAndStartGame() {
        Fighter f1 = new Fighter("Mr. Krabs", "rich man", "mrkrabs.png", 100, 100, 50, 100, 0);
        Fighter f2 = new Fighter("Patrick", "stupid man", "patrick.png", 100, 100, 50, 100, 0);
        Fighter f3 = new Fighter("Spongebob", "happy man", "spongbob.jpg", 100, 100, 50, 100, 0);
        Fighter f4 = new Fighter("Squidward", "mean man", "squidward.png", 100, 100, 50, 100, 0);
        Fighter f5 = new Fighter("Squilliam", "fancy man", "squilliam.png", 100, 100, 50, 100, 0);
        Fighter f6 = new Fighter("Sandy", "smart woman", "sandy.png", 100, 100, 50, 100, 0);
        Fighter f7 = new Fighter("Pearl", "rich woman", "pearl.png", 100, 100, 50, 100, 0);
        Fighter f8 = new Fighter("Larry", "strong man", "larry.png", 100, 100, 50, 100, 0);
        Fighter f9 = new Fighter("Gary", "slow snail", "gary.png", 100, 100, 50, 100, 0);
        Fighter f10 = new Fighter("Plankton", "tiny man", "plankton.jpg", 100, 100, 10, 20, 0);
        Fighter f11 = new Fighter("Karen", "mean computer", "karen.png", 100, 100, 50, 100, 0);
        Fighter f12 = new Fighter("King Neptune", "strong king", "kingneptune.png", 100, 100, 50, 100, 0);
        Fighter f13 = new Fighter("The Flying Dutchman", "ghost pirate", "flyingdutchman.png", 100, 100, 50, 100, 0);
        Fighter f14 = new Fighter("Mermaid Man", "superhero", "mermaidman.jpg", 100, 100, 50, 100, 0);
        Fighter f15 = new Fighter("Barnacle Boy", "superhero", "barnacleboy.png", 100, 100, 50, 100, 0);
        Fighter f16 = new Fighter("Mrs. Puff", "nervous woman", "mrspuff.png", 100, 100, 50, 100, 0);

        Fighter[] fighters = {f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16};
        Collections.shuffle(Arrays.asList(fighters));
        fighters[0].setStoleSoul(true);
        Random rand = new Random();
        int randomOpponent = rand.nextInt(16);
        opponent = fighters[randomOpponent];

        Dungeon d1 = new Dungeon("The Krusty Krab", "a burger restaurant", fighters[0]);
        Dungeon d2 = new Dungeon("Patrick's House", "a large rock", fighters[1]);
        Dungeon d3 = new Dungeon("Spongebob's House", "a large pineapple", fighters[2]);
        Dungeon d4 = new Dungeon("Squidward's House", "a Moai", fighters[3]);
        Dungeon d5 = new Dungeon("Squilliam's House", "a larger, fancy tower", fighters[4]);
        Dungeon d6 = new Dungeon("Sandy's House", "a large glass dome", fighters[5]);
        Dungeon d7 = new Dungeon("Pearl's House", "a large anchor", fighters[6]);
        Dungeon d8 = new Dungeon("Larry's Gym", "a large gym", fighters[7]);
        Dungeon d9 = new Dungeon("Gary's House", "a large pineapple", fighters[8]);
        Dungeon d10 = new Dungeon("The Chum Bucket", "a gross restaurant", fighters[9]);
        Dungeon d11 = new Dungeon("Karen's House", "a gross restaurant", fighters[10]);
        Dungeon d12 = new Dungeon("King Neptune's House", "the ocean", fighters[11]);
        Dungeon d13 = new Dungeon("The Flying Dutchman's Ship", "a large, ghost pirate ship", fighters[12]);
        Dungeon d14 = new Dungeon("Mermaid Man's House", "a retirement home", fighters[13]);
        Dungeon d15 = new Dungeon("Barnacle Boy's House", "a retirement home", fighters[14]);
        Dungeon d16 = new Dungeon("Mrs. Puff's Boating School", "a driver's ed place for boats", fighters[15]);

        Dungeon[] dungeons = {d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16};
        Collections.shuffle(Arrays.asList(dungeons));

        dungeonMaze[0][0] = dungeons[0];
        dungeonMaze[0][1] = dungeons[1];
        dungeonMaze[0][2] = dungeons[2];
        dungeonMaze[0][3] = dungeons[3];
        dungeonMaze[1][0] = dungeons[4];
        dungeonMaze[1][1] = dungeons[5];
        dungeonMaze[1][2] = dungeons[6];
        dungeonMaze[1][3] = dungeons[7];
        dungeonMaze[2][0] = dungeons[8];
        dungeonMaze[2][1] = dungeons[9];
        dungeonMaze[2][2] = dungeons[10];
        dungeonMaze[2][3] = dungeons[11];
        dungeonMaze[3][0] = dungeons[12];
        dungeonMaze[3][1] = dungeons[13];
        dungeonMaze[3][2] = dungeons[14];
        dungeonMaze[3][3] = dungeons[15];

        player = new Fighter("Evan", "Weak man", "fred.png", 1000, 1000, 75, 125, 3);

        playerRow = rand.nextInt(3);
        playerColumn = rand.nextInt(3);
        currentDungeon = dungeonMaze[playerColumn][playerRow];
        opponent = currentDungeon.getFighter();

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);


        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());
        potionLabel.setText("Potions: " + player.getNumOfPotions());

    }

    @FXML
    private void attackButtonPressed() {
        int playerAttackStrength = player.attack();
        opponent.setCurrentHitPoints(playerAttackStrength);
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());
        if(opponent.isAlive() == false) {
            if (opponent.getStoleSoul() == true) {
                    informationLabel.setText("Congratulations! You have defeated " + opponent.getName() +
                            "\nGreat News! This is the fighter that stole your soul.  " +
                            "\nYou have reclaimed and reinserted your soul.  " +
                            "\nYou feel a sense of calm rush over you.  ");
                }
            else {
                informationLabel.setText("Congratulations! You have defeated " + opponent.getName() +
                        "\nUnfortunately, this is not the fighter who stole your soul.  " +
                        "\nPlease move to a different dungeon.");
                opponentHP.setText("HP: 0");
            }
        }
        else {
            int opponentAttackStrength = opponent.attack();
            player.setCurrentHitPoints(opponentAttackStrength);
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            informationLabel.setText("You attacked with a strength of " + playerAttackStrength + " hit points." +
                    "\nYour opponent now has " + opponent.getCurrentHitPoints() + " hit points remaining." +
                    "\nYour opponent attacks with a strength of " + opponentAttackStrength + " hit points." +
                    ".\nYou now have " + player.getCurrentHitPoints() + " hit points remaining.");
        }
    }

    @FXML
    private void healButtonPressed() {
        if(player.heal()) {
            player.setHitPoints();
            playerHP.setText("HP: 1000");
            int opponentAttackStrength = opponent.attack();
            player.setCurrentHitPoints(opponentAttackStrength);
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            informationLabel.setText("You used a healing potion." +
                    "\nYour opponent attacks with a strength of " + opponentAttackStrength + " hit points." +
                    ".\nYou now have " + player.getCurrentHitPoints() + " hit points remaining.");
        }
        else {
            informationLabel.setText("Uh oh! You are out of potions, so you must attack.");
            healButton.setDisable(true);

        }
        potionLabel.setText("Potions: " + player.getNumOfPotions());
    }

    @FXML
    private void button00Pressed() {
        playerRow = 0;
        playerColumn = 0;
        currentDungeon = dungeonMaze[0][0];
        opponent = currentDungeon.getFighter();

        player.setNumOfPotions(3);
        player.setHitPoints();
        opponent.setHitPoints();
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);
    }

    @FXML
    private void button10Pressed() {
        playerRow = 1;
        playerColumn = 0;
        currentDungeon = dungeonMaze[1][0];
        opponent = currentDungeon.getFighter();

        player.setNumOfPotions(3);
        player.setHitPoints();
        opponent.setHitPoints();
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button20Pressed() {
        playerRow = 2;
        playerColumn = 0;
        currentDungeon = dungeonMaze[2][0];
        opponent = currentDungeon.getFighter();

        player.setNumOfPotions(3);
        player.setHitPoints();
        opponent.setHitPoints();
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button30Pressed() {
        playerRow = 3;
        playerColumn = 0;
        currentDungeon = dungeonMaze[3][0];
        opponent = currentDungeon.getFighter();

        player.setNumOfPotions(3);
        player.setHitPoints();
        opponent.setHitPoints();
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button01Pressed() {
        playerRow = 0;
        playerColumn = 1;
        currentDungeon = dungeonMaze[0][1];
        opponent = currentDungeon.getFighter();

        player.setNumOfPotions(3);
        player.setHitPoints();
        opponent.setHitPoints();
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button11Pressed() {
        playerRow = 1;
        playerColumn = 1;
        currentDungeon = dungeonMaze[1][1];
        opponent = currentDungeon.getFighter();

        player.setNumOfPotions(3);
        player.setHitPoints();
        opponent.setHitPoints();
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button21Pressed() {
        playerRow = 2;
        playerColumn = 1;
        currentDungeon = dungeonMaze[2][1];
        opponent = currentDungeon.getFighter();

        player.setNumOfPotions(3);
        player.setHitPoints();
        opponent.setHitPoints();
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button31Pressed() {
        playerRow = 3;
        playerColumn = 1;
        currentDungeon = dungeonMaze[3][1];
        opponent = currentDungeon.getFighter();

        player.setNumOfPotions(3);
        player.setHitPoints();
        opponent.setHitPoints();
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button02Pressed() {
        playerRow = 0;
        playerColumn = 2;
        currentDungeon = dungeonMaze[0][2];
        opponent = currentDungeon.getFighter();

        player.setNumOfPotions(3);
        player.setHitPoints();
        opponent.setHitPoints();
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button12Pressed() {
        playerRow = 1;
        playerColumn = 2;
        currentDungeon = dungeonMaze[1][2];
        opponent = currentDungeon.getFighter();

        player.setNumOfPotions(3);
        player.setHitPoints();
        opponent.setHitPoints();
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button22Pressed() {
        playerRow = 2;
        playerColumn = 2;
        currentDungeon = dungeonMaze[2][2];
        opponent = currentDungeon.getFighter();

        player.setNumOfPotions(3);
        player.setHitPoints();
        opponent.setHitPoints();
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button32Pressed() {
        playerRow = 3;
        playerColumn = 2;
        currentDungeon = dungeonMaze[3][2];
        opponent = currentDungeon.getFighter();

        player.setNumOfPotions(3);
        player.setHitPoints();
        opponent.setHitPoints();
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button03Pressed() {
        playerRow = 0;
        playerColumn = 3;
        currentDungeon = dungeonMaze[0][3];
        opponent = currentDungeon.getFighter();

        player.setNumOfPotions(3);
        player.setHitPoints();
        opponent.setHitPoints();
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button13Pressed() {
        playerRow = 1;
        playerColumn = 3;
        currentDungeon = dungeonMaze[1][3];
        opponent = currentDungeon.getFighter();

        player.setNumOfPotions(3);
        player.setHitPoints();
        opponent.setHitPoints();
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button23Pressed() {
        playerRow = 2;
        playerColumn = 3;
        currentDungeon = dungeonMaze[2][3];
        opponent = currentDungeon.getFighter();

        player.setNumOfPotions(3);
        player.setHitPoints();
        opponent.setHitPoints();
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button33Pressed() {
        playerRow = 3;
        playerColumn = 3;
        currentDungeon = dungeonMaze[3][3];
        opponent = currentDungeon.getFighter();

        player.setNumOfPotions(3);
        player.setHitPoints();
        opponent.setHitPoints();
        playerHP.setText("HP: " + player.getCurrentHitPoints());
        opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

        informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                "\nand can best be described as a " + opponent.getDescription() + ". " +
                "\nChoose “Attack” or “Heal”");

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

}

