import processing.core.PApplet;
import processing.core.PImage;

/**
* This class represents a simple game sketch.
* It extends the PApplet class from the Processing library.
*
* @author J. Lai
*/
public class Sketch extends PApplet {
  PImage imgBackground, imgPlayer, imgHeart, imgGameOver;

  int numSnowflakes = 100;
  float[] snowX = new float[numSnowflakes];
  float[] snowY = new float[numSnowflakes];
  float[] snowSpeed = new float[numSnowflakes];
  boolean[] ballHideStatus = new boolean[numSnowflakes];

  float playerX, playerY;
  int lives = 3;
  float speedMultiplier = 1;

  boolean wPressed = false, aPressed = false, sPressed = false, dPressed = false, upPressed = false, downPressed = false;

  /**
  * This method sets up the size of the window.
  */
  public void settings() {
    size(800, 400);
  }

  /**
  * This method initializes the sketch by loading images and setting up initial parameters.
  */
  public void setup() {
    imgBackground = loadImage("snowbackground.jpg");
    imgBackground.resize(width, height);
    imgPlayer = loadImage("player.png");
    imgPlayer.resize(width / 16, height / 8);
    imgHeart = loadImage("heart.png");
    imgHeart.resize(width / 24, height / 12);
    imgGameOver = loadImage("gameover.jpg");
    imgGameOver.resize(width, height);
    
    playerX = width / 2 - imgPlayer.width / 2;
    playerY = height - imgPlayer.height - 10;

    // Initialize snowflakes positions and speeds
    for (int i = 0; i < numSnowflakes; i++) {
      snowX[i] = random(width);
      snowY[i] = random(-height, 0);
      snowSpeed[i] = random(1f, 3f);
      ballHideStatus[i] = false;
    }
  }

  /**
  * This method draws the sketch, handling player movement, snowflakes, collisions, and game over conditions.
  */
  public void draw() {
    background(imgBackground);

    // Handle player movement
    if (wPressed) playerY -= 5;
    if (sPressed) playerY += 5;
    if (aPressed) playerX -= 5;
    if (dPressed) playerX += 5;

    // Handle speed multiplier
    if (downPressed) speedMultiplier = 2f;
    else if (upPressed) speedMultiplier = 0.5f;
    else speedMultiplier = 1f;

    // Draw and update snowflakes
    for (int i = 0; i < numSnowflakes; i++) {
      if (!ballHideStatus[i]) {
        fill(255);
        ellipse(snowX[i], snowY[i], 10, 10);
        snowY[i] += snowSpeed[i] * speedMultiplier;
        
        // Reset snowflake to top if it goes off screen
        if (snowY[i] > height) {
          snowY[i] = random(-height, 0);
          snowX[i] = random(width);
        }
        
        // Check collision with player
        if (snowX[i] > playerX && snowX[i] < playerX + imgPlayer.width && snowY[i] > playerY && snowY[i] < playerY + imgPlayer.height) {
          lives--;
          snowY[i] = random(-height, 0);
          snowX[i] = random(width);
          if (lives <= 0) {
            image(imgGameOver, 0, 0);
            for (int j = 0; j < ballHideStatus.length; j++) {
              ballHideStatus[j] = true;
            }
            playerX = -100;
            playerY = -100;
            noLoop();
          }
        }
      }
    }
    
    // Draw player
    image(imgPlayer, playerX, playerY);
    
    // Draw lives as hearts
    for (int i = 0; i < lives; i++) { 
      image(imgHeart, width - (i + 1) * (imgHeart.width + 10) - 10, 10);
    }
  }

  /**
  * This method handles key presses for player movement and speed control.
  */
  public void keyPressed() {
    if (key == 'w' || key == 'W') wPressed = true;
    if (key == 's' || key == 'S') sPressed = true;
    if (key == 'a' || key == 'A') aPressed = true;
    if (key == 'd' || key == 'D') dPressed = true;
    if (keyCode == UP) upPressed = true;
    if (keyCode == DOWN) downPressed = true;
  }

  /**
  * This method handles key releases for player movement and speed control.
  */
  public void keyReleased() {
    if (key == 'w' || key == 'W') wPressed = false;
    if (key == 's' || key == 'S') sPressed = false;
    if (key == 'a' || key == 'A') aPressed = false;
    if (key == 'd' || key == 'D') dPressed = false;
    if (keyCode == UP) upPressed = false;
    if (keyCode == DOWN) downPressed = false;
  }

  /**
  * This method handles mouse presses to hide snowflakes.
  */
  public void mousePressed() {
    for (int i = 0; i < numSnowflakes; i++) {
      if (!ballHideStatus[i] && dist(mouseX, mouseY, snowX[i], snowY[i]) < 10) {
        ballHideStatus[i] = true;
      }
    }
  }
}