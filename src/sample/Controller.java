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
    Button attackButton;
    @FXML
    Button button00;
    @FXML
    Button button10;
    @FXML
    Button button20;
    @FXML
    Button button30;
    @FXML
    Button button01;
    @FXML
    Button button11;
    @FXML
    Button button21;
    @FXML
    Button button31;
    @FXML
    Button button02;
    @FXML
    Button button12;
    @FXML
    Button button22;
    @FXML
    Button button32;
    @FXML
    Button button03;
    @FXML
    Button button13;
    @FXML
    Button button23;
    @FXML
    Button button33;


    @FXML
    public void initialize() {
        initializeMazeAndStartGame();
    }

    @FXML
    private void initializeMazeAndStartGame() {
        Fighter f1 = new Fighter("Mr. Krabs", "rich man", "mrkrabs.png", 200, 200, 50, 100, 0);
        Fighter f2 = new Fighter("Patrick", "stupid man", "patrick.png", 110, 110, 50, 100, 0);
        Fighter f3 = new Fighter("Spongebob", "happy man", "spongbob.jpg", 150, 150, 50, 100, 0);
        Fighter f4 = new Fighter("Squidward", "mean man", "squidward.png", 90, 90, 50, 100, 0);
        Fighter f5 = new Fighter("Squilliam", "fancy man", "squilliam.png", 250, 250, 50, 100, 0);
        Fighter f6 = new Fighter("Sandy", "smart woman", "sandy.png", 70, 70, 50, 100, 0);
        Fighter f7 = new Fighter("Pearl", "rich woman", "pearl.png", 60, 60, 50, 100, 0);
        Fighter f8 = new Fighter("Larry", "strong man", "larry.png", 300, 300, 50, 100, 0);
        Fighter f9 = new Fighter("Gary", "slow snail", "gary.png", 400, 400, 50, 100, 0);
        Fighter f10 = new Fighter("Plankton", "tiny man", "plankton.jpg", 25, 25, 10, 20, 0);
        Fighter f11 = new Fighter("Karen", "mean computer", "karen.png", 250, 250, 50, 100, 0);
        Fighter f12 = new Fighter("King Neptune", "strong king", "kingneptune.png", 350, 350, 50, 100, 0);
        Fighter f13 = new Fighter("The Flying Dutchman", "ghost pirate", "flyingdutchman.png", 100, 100, 50, 100, 0);
        Fighter f14 = new Fighter("Mermaid Man", "superhero", "mermaidman.jpg", 125, 125, 50, 100, 0);
        Fighter f15 = new Fighter("Barnacle Boy", "superhero", "barnacleboy.png", 75, 75, 50, 100, 0);
        Fighter f16 = new Fighter("Mrs. Puff", "nervous woman", "mrspuff.png", 50, 50, 50, 100, 0);

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

        Image fighterImage = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(fighterImage);
        Image playerImage = new Image(String.valueOf(getClass().getResource(player.getPicture())));
        playerImageView.setImage(playerImage);


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
        if (opponent.isAlive() == false) {
            if (opponent.getStoleSoul() == true) {
                informationLabel.setText("Congratulations! You have defeated " + opponent.getName() + "." +
                        "\nGreat News! This is the fighter that stole your soul.  " +
                        "\nYou have reclaimed and reinserted your soul.  " +
                        "\nYou feel a sense of calm rush over you.  " +
                        "\nGAME OVER");
                healButton.setDisable(true);
                attackButton.setDisable(true);
                button00.setDisable(true);
                button01.setDisable(true);
                button02.setDisable(true);
                button03.setDisable(true);
                button10.setDisable(true);
                button11.setDisable(true);
                button12.setDisable(true);
                button13.setDisable(true);
                button20.setDisable(true);
                button21.setDisable(true);
                button22.setDisable(true);
                button23.setDisable(true);
                button30.setDisable(true);
                button31.setDisable(true);
                button32.setDisable(true);
                button33.setDisable(true);
            } else {
                informationLabel.setText("Congratulations! You have defeated " + opponent.getName() +
                        "\nUnfortunately, this is not the fighter who stole your soul.  " +
                        "\nPlease move to a different dungeon.");
                opponentHP.setText("HP: 0");
                healButton.setDisable(true);
                attackButton.setDisable(true);


            }
            opponent.setDead();
        } else {
            int opponentAttackStrength = opponent.attack();
            player.setCurrentHitPoints(opponentAttackStrength);
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            informationLabel.setText("Boom! You attack with a strength of " + playerAttackStrength + " hit points." +
                    "\nYour opponent now has " + opponent.getCurrentHitPoints() + " hit points remaining." +
                    "\nOuch! Your opponent attacks with a strength of " + opponentAttackStrength + " hit points." +
                    "\nYou now have " + player.getCurrentHitPoints() + " hit points remaining.");
        }
    }

    @FXML
    private void healButtonPressed() {
        if (player.heal()) {
            player.setHitPoints();
            int opponentAttackStrength = opponent.attack();
            player.setCurrentHitPoints(opponentAttackStrength);
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            informationLabel.setText("You have successfully healed. Your current hit points are 1000." +
                    "\nOuch! Your opponent attacks with a strength of " + opponentAttackStrength + " hit points" +
                    "\nYou now have " + player.getCurrentHitPoints() + " hit points remaining.");
        } else {
            informationLabel.setText("Uh oh! You are out of potions, so you must attack.");
            healButton.setDisable(true);

        }
        potionLabel.setText("Potions: " + player.getNumOfPotions());
    }

    @FXML
    private void button00Pressed() {
        button00.setStyle("-fx-background-color: #ff0000; ");
        playerRow = 0;
        playerColumn = 0;
        currentDungeon = dungeonMaze[0][0];
        opponent = currentDungeon.getFighter();
        if (opponent.getAlive() == true) {
            healButton.setDisable(false);
            attackButton.setDisable(false);

            player.setNumOfPotions(3);
            player.setHitPoints();
            opponent.setHitPoints();
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

            informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                    "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                    "\nand can best be described as a " + opponent.getDescription() + ". " +
                    "\nChoose “Attack” or “Heal”");
        } else {
            informationLabel.setText("You have already defeated the fighter in this dungeon. Please move again.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);
    }

    @FXML
    private void button10Pressed() {
        button10.setStyle("-fx-background-color: #ff0000; ");
        playerRow = 1;
        playerColumn = 0;
        currentDungeon = dungeonMaze[1][0];
        opponent = currentDungeon.getFighter();
        if (opponent.getAlive() == true) {
            healButton.setDisable(false);
            attackButton.setDisable(false);

            player.setNumOfPotions(3);
            player.setHitPoints();
            opponent.setHitPoints();
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

            informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                    "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                    "\nand can best be described as a " + opponent.getDescription() + ". " +
                    "\nChoose “Attack” or “Heal”");
        } else {
            informationLabel.setText("You have already defeated the fighter in this dungeon. Please move again.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button20Pressed() {
        button20.setStyle("-fx-background-color: #ff0000; ");
        playerRow = 2;
        playerColumn = 0;
        currentDungeon = dungeonMaze[2][0];
        opponent = currentDungeon.getFighter();
        if (opponent.getAlive() == true) {
            healButton.setDisable(false);
            attackButton.setDisable(false);

            player.setNumOfPotions(3);
            player.setHitPoints();
            opponent.setHitPoints();
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

            informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                    "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                    "\nand can best be described as a " + opponent.getDescription() + ". " +
                    "\nChoose “Attack” or “Heal”");
        } else {
            informationLabel.setText("You have already defeated the fighter in this dungeon. Please move again.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button30Pressed() {
        button30.setStyle("-fx-background-color: #ff0000; ");
        playerRow = 3;
        playerColumn = 0;
        currentDungeon = dungeonMaze[3][0];
        opponent = currentDungeon.getFighter();
        if (opponent.getAlive() == true) {
            healButton.setDisable(false);
            attackButton.setDisable(false);

            player.setNumOfPotions(3);
            player.setHitPoints();
            opponent.setHitPoints();
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

            informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                    "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                    "\nand can best be described as a " + opponent.getDescription() + ". " +
                    "\nChoose “Attack” or “Heal”");
        } else {
            informationLabel.setText("You have already defeated the fighter in this dungeon. Please move again.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button01Pressed() {
        button01.setStyle("-fx-background-color: #ff0000; ");
        playerRow = 0;
        playerColumn = 1;
        currentDungeon = dungeonMaze[0][1];
        opponent = currentDungeon.getFighter();
        if (opponent.getAlive() == true) {
            healButton.setDisable(false);
            attackButton.setDisable(false);

            player.setNumOfPotions(3);
            player.setHitPoints();
            opponent.setHitPoints();
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

            informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                    "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                    "\nand can best be described as a " + opponent.getDescription() + ". " +
                    "\nChoose “Attack” or “Heal”");
        } else {
            informationLabel.setText("You have already defeated the fighter in this dungeon. Please move again.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button11Pressed() {
        button11.setStyle("-fx-background-color: #ff0000; ");
        playerRow = 1;
        playerColumn = 1;
        currentDungeon = dungeonMaze[1][1];
        opponent = currentDungeon.getFighter();
        if (opponent.getAlive() == true) {
            healButton.setDisable(false);
            attackButton.setDisable(false);

            player.setNumOfPotions(3);
            player.setHitPoints();
            opponent.setHitPoints();
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

            informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                    "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                    "\nand can best be described as a " + opponent.getDescription() + ". " +
                    "\nChoose “Attack” or “Heal”");
        } else {
            informationLabel.setText("You have already defeated the fighter in this dungeon. Please move again.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button21Pressed() {
        button21.setStyle("-fx-background-color: #ff0000; ");
        playerRow = 2;
        playerColumn = 1;
        currentDungeon = dungeonMaze[2][1];
        opponent = currentDungeon.getFighter();
        if (opponent.getAlive() == true) {
            healButton.setDisable(false);
            attackButton.setDisable(false);

            player.setNumOfPotions(3);
            player.setHitPoints();
            opponent.setHitPoints();
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

            informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                    "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                    "\nand can best be described as a " + opponent.getDescription() + ". " +
                    "\nChoose “Attack” or “Heal”");
        } else {
            informationLabel.setText("You have already defeated the fighter in this dungeon. Please move again.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button31Pressed() {
        button31.setStyle("-fx-background-color: #ff0000; ");
        playerRow = 3;
        playerColumn = 1;
        currentDungeon = dungeonMaze[3][1];
        opponent = currentDungeon.getFighter();
        if (opponent.getAlive() == true) {
            healButton.setDisable(false);
            attackButton.setDisable(false);

            player.setNumOfPotions(3);
            player.setHitPoints();
            opponent.setHitPoints();
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

            informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                    "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                    "\nand can best be described as a " + opponent.getDescription() + ". " +
                    "\nChoose “Attack” or “Heal”");
        } else {
            informationLabel.setText("You have already defeated the fighter in this dungeon. Please move again.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button02Pressed() {
        button02.setStyle("-fx-background-color: #ff0000; ");
        playerRow = 0;
        playerColumn = 2;
        currentDungeon = dungeonMaze[0][2];
        opponent = currentDungeon.getFighter();
        if (opponent.getAlive() == true) {
            healButton.setDisable(false);
            attackButton.setDisable(false);

            player.setNumOfPotions(3);
            player.setHitPoints();
            opponent.setHitPoints();
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

            informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                    "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                    "\nand can best be described as a " + opponent.getDescription() + ". " +
                    "\nChoose “Attack” or “Heal”");
        } else {
            informationLabel.setText("You have already defeated the fighter in this dungeon. Please move again.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button12Pressed() {
        button12.setStyle("-fx-background-color: #ff0000; ");
        playerRow = 1;
        playerColumn = 2;
        currentDungeon = dungeonMaze[1][2];
        opponent = currentDungeon.getFighter();
        if (opponent.getAlive() == true) {
            healButton.setDisable(false);
            attackButton.setDisable(false);

            player.setNumOfPotions(3);
            player.setHitPoints();
            opponent.setHitPoints();
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

            informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                    "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                    "\nand can best be described as a " + opponent.getDescription() + ". " +
                    "\nChoose “Attack” or “Heal”");
        } else {
            informationLabel.setText("You have already defeated the fighter in this dungeon. Please move again.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button22Pressed() {
        button22.setStyle("-fx-background-color: #ff0000; ");
        playerRow = 2;
        playerColumn = 2;
        currentDungeon = dungeonMaze[2][2];
        opponent = currentDungeon.getFighter();
        if (opponent.getAlive() == true) {
            healButton.setDisable(false);
            attackButton.setDisable(false);

            player.setNumOfPotions(3);
            player.setHitPoints();
            opponent.setHitPoints();
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

            informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                    "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                    "\nand can best be described as a " + opponent.getDescription() + ". " +
                    "\nChoose “Attack” or “Heal”");
        } else {
            informationLabel.setText("You have already defeated the fighter in this dungeon. Please move again.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button32Pressed() {
        button32.setStyle("-fx-background-color: #ff0000; ");
        playerRow = 3;
        playerColumn = 2;
        currentDungeon = dungeonMaze[3][2];
        opponent = currentDungeon.getFighter();
        if (opponent.getAlive() == true) {
            healButton.setDisable(false);
            attackButton.setDisable(false);

            player.setNumOfPotions(3);
            player.setHitPoints();
            opponent.setHitPoints();
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

            informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                    "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                    "\nand can best be described as a " + opponent.getDescription() + ". " +
                    "\nChoose “Attack” or “Heal”");
        } else {
            informationLabel.setText("You have already defeated the fighter in this dungeon. Please move again.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button03Pressed() {
        button03.setStyle("-fx-background-color: #ff0000; ");
        playerRow = 0;
        playerColumn = 3;
        currentDungeon = dungeonMaze[0][3];
        opponent = currentDungeon.getFighter();
        if (opponent.getAlive() == true) {
            healButton.setDisable(false);
            attackButton.setDisable(false);

            player.setNumOfPotions(3);
            player.setHitPoints();
            opponent.setHitPoints();
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

            informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                    "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                    "\nand can best be described as a " + opponent.getDescription() + ". " +
                    "\nChoose “Attack” or “Heal”");
        } else {
            informationLabel.setText("You have already defeated the fighter in this dungeon. Please move again.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button13Pressed() {
        button13.setStyle("-fx-background-color: #ff0000; ");
        playerRow = 1;
        playerColumn = 3;
        currentDungeon = dungeonMaze[1][3];
        opponent = currentDungeon.getFighter();
        if (opponent.getAlive() == true) {
            healButton.setDisable(false);
            attackButton.setDisable(false);

            player.setNumOfPotions(3);
            player.setHitPoints();
            opponent.setHitPoints();
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

            informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                    "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                    "\nand can best be described as a " + opponent.getDescription() + ". " +
                    "\nChoose “Attack” or “Heal”");
        } else {
            informationLabel.setText("You have already defeated the fighter in this dungeon. Please move again.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button23Pressed() {
        button23.setStyle("-fx-background-color: #ff0000; ");
        playerRow = 2;
        playerColumn = 3;
        currentDungeon = dungeonMaze[2][3];
        opponent = currentDungeon.getFighter();
        if (opponent.getAlive() == true) {
            healButton.setDisable(false);
            attackButton.setDisable(false);

            player.setNumOfPotions(3);
            player.setHitPoints();
            opponent.setHitPoints();
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

            informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                    "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                    "\nand can best be described as a " + opponent.getDescription() + ". " +
                    "\nChoose “Attack” or “Heal”");
        } else {
            informationLabel.setText("You have already defeated the fighter in this dungeon. Please move again.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }

        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

    @FXML
    private void button33Pressed() {
        button33.setStyle("-fx-background-color: #ff0000; ");
        playerRow = 3;
        playerColumn = 3;
        currentDungeon = dungeonMaze[3][3];
        opponent = currentDungeon.getFighter();
        if (opponent.getAlive() == true) {
            healButton.setDisable(false);
            attackButton.setDisable(false);

            player.setNumOfPotions(3);
            player.setHitPoints();
            opponent.setHitPoints();
            playerHP.setText("HP: " + player.getCurrentHitPoints());
            opponentHP.setText("HP: " + opponent.getCurrentHitPoints());

            informationLabel.setText("You are currently in the dungeon " + currentDungeon.getName() + ". It can best be " +
                    "\ndescribed as " + currentDungeon.getDescription() + ". The fighter before you is called " + opponent.getName() + " " +
                    "\nand can best be described as a " + opponent.getDescription() + ". " +
                    "\nChoose “Attack” or “Heal”");
        } else {
            informationLabel.setText("You have already defeated the fighter in this dungeon. Please move again.");
            attackButton.setDisable(true);
            healButton.setDisable(true);
        }
        Image image = new Image(String.valueOf(getClass().getResource(opponent.getPicture())));
        fighterImageView.setImage(image);

    }

}

