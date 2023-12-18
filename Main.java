int blueCarRightAxisVal = 0;
int truck2LeftAxisVal = 1000;
int greenCarLeftAxisVal = 1000;
int truck2RightAxisVal = 0;
int truckLeftAxisVal = 1000;
int log1Val = 0;
int log2Val = 1000;
int log3Val = 0;
int log4Val = 1000;
int froggerYAxis = 825;
int froggerXAxis = 500;
int frogX = 450;
int frogY = 820;
int youWinVal = 25;
int dir = 1;

String[] frogger_up = {"frog_up_0.png", "frog_up_1.png", "frog_up_2.png"};
String[] frogger_down = {"frog_down_0.png", "frog_down_1.png", "frog_down_2.png"};
String[] frogger_left = {"frog_left_0.png", "frog_left_1.png", "frog_left_2.png"};
String[] frogger_right = {"frog_right_0.png", "frog_right_1.png", "frog_right_2.png"};

PImage blueCarRight;
PImage truck2Left;
PImage greenCarLeft;
PImage truck2Right;
PImage truckLeft;
PImage log1;
PImage log2;
PImage log3;
PImage log4;
PImage youWin;

int froggerImageIndex = 0;

void setup() {
  size(1000, 875);
}

void draw() {
  PImage background = loadImage("background-complete.png");
  image(background, 0, 0);

  drawTheBoard();

  blueCarRightAxisVal += 3;
  if (blueCarRightAxisVal > 1000) {
    blueCarRightAxisVal = -125;
  }
  truck2LeftAxisVal -= 2;
  if (truck2LeftAxisVal < -250) {
    truck2LeftAxisVal = 1150;
  }
  greenCarLeftAxisVal -= 4;
  if (greenCarLeftAxisVal < -250) {
    greenCarLeftAxisVal = 1150;
  }
  truck2RightAxisVal += 2;
  if (truck2RightAxisVal > 1000) {
    truck2RightAxisVal = -175;
  }
  truckLeftAxisVal -= 3;
  if (truckLeftAxisVal < -250) {
    truckLeftAxisVal = 1150;
  }
  log1Val += 2;
  if (log1Val > 1000) {
    log1Val = -350;
  }
  log2Val -= 2;
  if (log2Val < -350) {
    log2Val = 1000;
  }
  log3Val += 2;
  if (log3Val > 1000) {
    log3Val = -350;
  }
  log4Val -= 2;
  if (log4Val < -350) {
    log4Val = 1000;
  }
  if (frogY > height) {
    frogY = height - 75;
  }
    if(frogY < 0) {
    frogY = 0;
    }
  if (frogX > width) {
    frogX = width - 75;
  }
  if (frogX < 0) {
    frogX = 0;
  }
  if (frogY < 25) {
//    text("You Win!",500,400);
    PImage youWin = loadImage("youWin.png");
    image(youWin,0,0);
    noLoop();
  }

  PImage frog;

  switch(dir) {
  case 1: 
    frog = loadImage(frogger_up[froggerImageIndex]);
    break;
  case 2: 
    frog = loadImage(frogger_down[froggerImageIndex]);
    break;
  case 3: 
    frog = loadImage(frogger_left[froggerImageIndex]);
    break;
  case 4: 
    frog = loadImage(frogger_right[froggerImageIndex]);
    break;
  default:
    frog = loadImage(frogger_up[0]);
  }


  boolean didSquishFrog = squishFrog(frogX, frogY, frog.width, frog.height, blueCarRightAxisVal, 620, blueCarRight.width, blueCarRight.height);
  if (didSquishFrog == true) {
    frog = loadImage("dead_frog.png");
    noLoop();
  }

  boolean didSquishFrog2 = squishFrog(frogX, frogY, frog.width, frog.height, truck2LeftAxisVal, 500, truck2Left.width, truck2Left.height);
  if (didSquishFrog2 == true) {
    frog = loadImage("dead_frog.png");
    noLoop();
  }

  boolean didSquishFrog3 = squishFrog(frogX, frogY, frog.width, frog.height, greenCarLeftAxisVal, 680, greenCarLeft.width, greenCarLeft.height);
  if (didSquishFrog3 == true) {
    frog = loadImage("dead_frog.png");
    noLoop();
  }

  boolean didSquishFrog4 = squishFrog(frogX, frogY, frog.width, frog.height, truck2RightAxisVal, 750, truck2Right.width, truck2Right.height);
  if (didSquishFrog4 == true) {
    frog = loadImage("dead_frog.png");
    noLoop();
  }

  boolean didSquishFrog5 = squishFrog(frogX, frogY, frog.width, frog.height, truckLeftAxisVal, 560, truckLeft.width, truckLeft.height);
  if (didSquishFrog5 == true) {
    frog = loadImage("dead_frog.png");
    noLoop();
  }
  
  boolean didSquishFrog6 = squishFrog(frogX, frogY, frog.width, frog.height, log1Val, 125, log1.width, log1.height);
  if (didSquishFrog6 == true) {
    frog = loadImage("dead_frog.png");
    noLoop();
  }
  
  boolean didSquishFrog7 = squishFrog(frogX, frogY, frog.width, frog.height, log2Val, 200, log2.width, log2.height);
  if (didSquishFrog7 == true) {
    frog = loadImage("dead_frog.png");
    noLoop();
  }
  
  boolean didSquishFrog8 = squishFrog(frogX, frogY, frog.width, frog.height, log3Val, 300, log3.width, log3.height);
  if (didSquishFrog8 == true) {
    frog = loadImage("dead_frog.png");
    noLoop();
  }
  
  boolean didSquishFrog9 = squishFrog(frogX, frogY, frog.width, frog.height, log4Val, 375, log4.width, log4.height);
  if (didSquishFrog9 == true) {
    frog = loadImage("dead_frog.png");
    noLoop();
  }

  image(frog, frogX, frogY);
}

void keyPressed() {
  if (key == 'w' || key == 'W') {
    dir = 1;
    froggerImageIndex += 1;
    frogY -= 26;
    if (froggerImageIndex > 2) {
      froggerImageIndex = 0;
    }
    froggerYAxis -= 26;
  }
  if (key == 's' || key == 'S') {
    dir = 2;
    froggerImageIndex += 1;
    frogY += 26;
    if (froggerImageIndex > 2) {
      froggerImageIndex = 0;
    }
    froggerYAxis += 26;
  }
  if (key == 'a' || key == 'A') {
    dir = 3;
    froggerImageIndex += 1;
    frogX -= 26;
    if (froggerImageIndex > 2) {
      froggerImageIndex = 0;
    }
    froggerXAxis -= 26;
  }
  if (key == 'd' || key == 'D') {
    dir = 4;
    froggerImageIndex += 1;
    frogX += 26;
    if (froggerImageIndex > 2) {
      froggerImageIndex = 0;
    }
    froggerXAxis += 26;
  }
}

void drawTheBoard() {

  blueCarRight = loadImage("car1.png");
  image(blueCarRight, blueCarRightAxisVal, 620);

  truck2Left = loadImage("truck2_left.png");
  image(truck2Left, truck2LeftAxisVal, 500);

  greenCarLeft = loadImage("car2_left.png");
  image(greenCarLeft, greenCarLeftAxisVal, 680);

  truck2Right = loadImage("truck2_right.png");
  image(truck2Right, truck2RightAxisVal, 750);

  truckLeft = loadImage("truck_left.png");
  image(truckLeft, truckLeftAxisVal, 560);

  log1 = loadImage("log.png");
  image(log1, log1Val, 125);

  log2 = loadImage("log.png");
  image(log2, log2Val, 200);

  log3 = loadImage("log.png");
  image(log3, log3Val, 300);

  log4 = loadImage("log.png");
  image(log4, log4Val, 375);
  
}


boolean squishFrog(float r1x, float r1y, float r1w, float r1h, float r2x, float r2y, float r2w, float r2h) {

  // are the sides of one rectangle touching the other?

  if (r1x + r1w >= r2x &&    // r1 right edge past r2 left
    r1x <= r2x + r2w &&    // r1 left edge past r2 right
    r1y + r1h >= r2y &&    // r1 top edge past r2 bottom
    r1y <= r2y + r2h) {    // r1 bottom edge past r2 top
    return true;
  }
  return false;
}
