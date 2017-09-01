import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Main, Driver for the program
 * @author Nagoshi, Vincent
 * @version 1.00.01
 */
public class Main {
  
  /**
   * Handles generating all buttons and stickers, tracking and applying modes,
   * and all user-program interaction handling
   * @param args
   * @throws java.io.IOException
   */
  public static void main(String[] args) {
    EZ.initialize(999, 700);

    boolean leftClicked;
    boolean rightClicked;
    int mouseX;
    int mouseY;

    int buttonCap = 14;
    int currentTheme = 1;

    int stickerSelected = 0;
    boolean stickerPalateOpen = false;
    boolean placeMultipleOn = false;
    boolean movementOn = true;
    int movingSticker = -1;
    boolean followCursorOn = false;
    boolean eraseOn = false;

    int stickerCount = 0;

    //Background
    Background background = new Background();
    background.changeTheme(currentTheme);

    //Cursor
    Cursor cursor = new Cursor();
    cursor.hideAll();

    //Buttons
    EZImage overlay = EZ.addImage("CG/OVERLAY.png", 499, 55);
    EZImage sidebar = EZ.addImage("CG/SIDEBAR.png", -55, 388);
    Button buttons[] = new Button[buttonCap];
    for (int i = 0; i < buttonCap; i++){
      buttons[i] = new Button(i);
      buttons[i].changeTheme(currentTheme);
      buttons[i].toggleSelectPicture(i, stickerSelected, stickerPalateOpen, placeMultipleOn, movementOn, followCursorOn, eraseOn);
    }

    //Sticker Handler
    ArrayList<Sticker> stickers = new ArrayList<Sticker>();

    while (true){
      leftClicked = false;
      rightClicked = false;

      mouseX = EZInteraction.getXMouse();
      mouseY = EZInteraction.getYMouse();
      if (EZInteraction.wasMouseLeftButtonPressed()){
        leftClicked = true;
      }
      if (EZInteraction.wasMouseRightButtonPressed()){ 
        rightClicked = true;
      }

      //Left Click Handler
      if (leftClicked){
        for(int i = 0; i < buttonCap; i++){
          if (buttons[i].inElement(currentTheme, mouseX, mouseY)){
            switch (i){
              //Sticker Palate Button
              case 0:
                if(stickerPalateOpen == false){
                  stickerPalateOpen = true;
                  sidebar.translateTo(55, 388);
                  for (int e = 9; e < buttonCap; e++){
                    buttons[e].moveTo(55, 166 + (111 * (e - 9)));
                  }
                }
                else{
                  stickerPalateOpen = false;
                  sidebar.translateTo(-55, 388);
                  for (int e = 9; e < buttonCap; e++){
                    buttons[e].moveTo(-55, 166 + (111 * (e - 9)));
                  }
                  buttons[0].toggleSelectPicture(0, stickerSelected, stickerPalateOpen, placeMultipleOn, movementOn, followCursorOn, eraseOn);
                }
                movingSticker = -1;
                break;
              //Place Multiple Button
              case 1:
                if(placeMultipleOn == false){
                  placeMultipleOn = true;
                }
                else{
                  placeMultipleOn = false;
                  if (stickerSelected != 0){
                    stickerSelected = 0;
                  }
                }
                for (int e = 0; e < buttonCap; e++){
                  buttons[e].toggleSelectPicture(e, stickerSelected, stickerPalateOpen, placeMultipleOn, movementOn, followCursorOn, eraseOn);
                }
                movingSticker = -1;
                break;
              //Movement Toggle Button
              case 2:
                if(movementOn == false){
                  movementOn = true;
                }
                else{
                  movementOn = false;
                }
                buttons[2].toggleSelectPicture(2, stickerSelected, stickerPalateOpen, placeMultipleOn, movementOn, followCursorOn, eraseOn);
                movingSticker = -1;
                break;
              //Follow Cursor Toggle
              case 3: 
                if(followCursorOn == false){
                  followCursorOn = true;
                }
                else{
                  followCursorOn = false;
                }
                buttons[3].toggleSelectPicture(3, stickerSelected, stickerPalateOpen, placeMultipleOn, movementOn, followCursorOn, eraseOn);
                movingSticker = -1;
                break;
              //Save Button
              case 4:
                BufferedWriter save;
                try {
                  save = new BufferedWriter(new FileWriter("save.txt"));
                  String savedCurrentTheme = Integer.toString(currentTheme);
                  save.write(savedCurrentTheme, 0, savedCurrentTheme.length());
                  save.newLine();
                  for (int e = 0; e < stickerCount; e++){
                    String token = "    ";
                    String stickerX = Integer.toString(stickers.get(e).imageX);
                    String stickerY = Integer.toString(stickers.get(e).imageY);
                    String stickerType = Integer.toString(stickers.get(e).imageType);
                    save.write(stickerX, 0, stickerX.length());
                    save.write(token, 0, token.length());
                    save.write(stickerY, 0, stickerY.length());
                    save.write(token, 0, token.length());
                    save.write(stickerType, 0, stickerType.length());
                    save.write(token, 0, token.length());
                    if (e < stickerCount - 1){
                      save.newLine();
                    }
                  }
                  save.close();
                } catch (IOException e1) {
                  e1.printStackTrace();
                }
                movingSticker = -1;
                break;
              //Load Button
              case 5:
                try {
                  BufferedReader load = new BufferedReader(new FileReader("save.txt"));

                  String line;
                  int count = 1;
                  for (int e = stickerCount -1; e >= 0 ; e--){
                    stickers.get(e).erase();
                    stickers.remove(e);
                  }
                  stickerCount = 0;
                  while((line = load.readLine()) != null) {
                    if (count == 1){
                      currentTheme = Integer.parseInt(line);
                    }
                    else{
                      StringTokenizer st = new StringTokenizer(line);
                      String token;
                      token = st.nextToken();
                      int stickerX = Integer.parseInt(token);
                      token = st.nextToken();
                      int stickerY = Integer.parseInt(token);
                      token = st.nextToken();
                      int stickerType = Integer.parseInt(token);
                      stickers.add(new Sticker(stickerType, stickerX, stickerY));
                      stickerCount++;
                    }
                    count++;
                  }
                  load.close();
                }
                catch (java.io.FileNotFoundException e){
                  try {
                    BufferedWriter saveBase = new BufferedWriter(new FileWriter("save.txt"));
                    saveBase.close();
                  }
                  catch (IOException e1) {
                    e1.printStackTrace();
                  }
                }
                catch (IOException e) {
                  e.printStackTrace();
                }
                background.changeTheme(currentTheme);
                for (int e = 0; e < buttonCap; e++){
                  buttons[e].changeTheme(currentTheme);
                }
                for (int e = 0; e < stickerCount; e++){
                  stickers.get(e).changeTheme(currentTheme);
                }
                overlay.pullToFront();
                sidebar.pullToFront();
                for (int e = 0; e < buttonCap; e++){
                  buttons[e].raiseUp();
                }
                movingSticker = -1;
                break;
              //Erase Toggle
              case 6:
                if(eraseOn == false){
                  eraseOn = true;
                  stickerSelected = 0;
                }
                else{
                  eraseOn = false;
                }
                movingSticker = -1;
                for (int e = 0; e < buttonCap; e++){
                  buttons[e].toggleSelectPicture(e, stickerSelected, stickerPalateOpen, placeMultipleOn, movementOn, followCursorOn, eraseOn);
                }
                break;
              //Clear All Button
              case 7:
                movingSticker = -1;
                for (int e = stickerCount -1; e >= 0 ; e--){
                  stickers.get(e).erase();
                  stickers.remove(e);
                }
                stickerCount = 0;
                break;
              //Change Theme Button
              case 8:
                currentTheme++;
                if(currentTheme == 3){
                  currentTheme = 1;
                }
                background.changeTheme(currentTheme);
                for (int e = 0; e < buttonCap; e++){
                  buttons[e].changeTheme(currentTheme);
                }
                for (int e = 0; e < stickerCount; e++){
                  stickers.get(e).changeTheme(currentTheme);
                }
                movingSticker = -1;
                break;
              //First Sticker Button
              case 9:
                if (stickerSelected != 1){
                  stickerSelected = 1;
                  eraseOn = false;
                }
                else{
                  stickerSelected = 0;
                }
                for (int e = 0; e < buttonCap; e++){
                  buttons[e].toggleSelectPicture(e, stickerSelected, stickerPalateOpen, placeMultipleOn, movementOn, followCursorOn, eraseOn);
                }
                movingSticker = -1;
                break;
              //Second Sticker Button
              case 10:
                if (stickerSelected != 2){
                  stickerSelected = 2;
                  eraseOn = false;
                }
                else{
                  stickerSelected = 0;
                }
                for (int e = 0; e < buttonCap; e++){
                  buttons[e].toggleSelectPicture(e, stickerSelected, stickerPalateOpen, placeMultipleOn, movementOn, followCursorOn, eraseOn);
                }
                movingSticker = -1;
                break;
              //Third Sticker Button
              case 11:
                if (stickerSelected != 3){
                  stickerSelected = 3;
                  eraseOn = false;
                }
                else{
                  stickerSelected = 0;
                }
                for (int e = 0; e < buttonCap; e++){
                  buttons[e].toggleSelectPicture(e, stickerSelected, stickerPalateOpen, placeMultipleOn, movementOn, followCursorOn, eraseOn);
                }
                movingSticker = -1;
                break;
              //Fourth Sticker Button
              case 12:
                if (stickerSelected != 4){
                  stickerSelected = 4;
                  eraseOn = false;
                }
                else{
                  stickerSelected = 0;
                }
                for (int e = 0; e < buttonCap; e++){
                  buttons[e].toggleSelectPicture(e, stickerSelected, stickerPalateOpen, placeMultipleOn, movementOn, followCursorOn, eraseOn);
                }
                movingSticker = -1; //Sets movingSticker to -1.
                break;
              //Fifth Sticker Button
              case 13:
                if (stickerSelected != 5){
                  stickerSelected = 5;
                  eraseOn = false;
                }
                else{
                  stickerSelected = 0;
                }
                for (int e = 0; e < buttonCap; e++){
                  buttons[e].toggleSelectPicture(e, stickerSelected, stickerPalateOpen, placeMultipleOn, movementOn, followCursorOn, eraseOn);
                }
                movingSticker = -1;
                break;
            }
            break;
          }
        }
        //Page Manipulation Handler
        if(mouseY > 111 && sidebar.isPointInElement(mouseX, mouseY) == false){
          if (stickerSelected != 0){
            stickers.add(new Sticker(stickerSelected, mouseX, mouseY));
            stickers.get(stickerCount).changeTheme(currentTheme);
            stickers.get(stickerCount).playSound(currentTheme);
            stickerCount++;
            overlay.pullToFront();
            sidebar.pullToFront();
            for (int i = 0; i < buttonCap; i++){
              buttons[i].raiseUp();
            }
            if(placeMultipleOn == false){
              stickerSelected = 0;
              for (int i = 0; i < buttonCap; i++){
                buttons[i].toggleSelectPicture(i, stickerSelected, stickerPalateOpen, placeMultipleOn, movementOn, followCursorOn, eraseOn);
              }
            }
          }
          else if (eraseOn){
            for (int i = stickerCount -1; i >= 0; i--){
              if(stickers.get(i).inElement(currentTheme, mouseX, mouseY)){
                stickers.get(i).erase();
                stickers.remove(i);
                stickerCount--;
                break;
              }
            }
          }
          else if (movementOn){
            if (movingSticker == -1){
              for (int i = stickerCount -1; i >= 0; i--){
                if(stickers.get(i).inElement(currentTheme, mouseX, mouseY)){
                  movingSticker = i;
                  stickers.get(i).playSound(currentTheme);
                  break;
                }
              }
            }
            else {
              stickers.get(movingSticker).moveTo(mouseX, mouseY);
              stickers.get(movingSticker).imageX = mouseX;
              stickers.get(movingSticker).imageY = mouseY;
              movingSticker = -1;
            }
          }
          else {
            for (int i = stickerCount -1; i >= 0; i--){
              if(stickers.get(i).inElement(currentTheme, mouseX, mouseY)){
                stickers.get(i).playSound(currentTheme);
                break;
              }
            }
          }
        }
      }

      //Short Cut Erase
      if (rightClicked){
        for (int i = stickerCount -1; i >= 0; i--){
          if(stickers.get(i).inElement(currentTheme, mouseX, mouseY)){
            stickers.get(i).erase();
            stickers.remove(i);
            stickerCount--;
            break;
          }
        }
      }

      //Cursor Handler
      if (followCursorOn){
        cursor.hideAll();
        cursor.Image1.translateTo(mouseX, mouseY);
        cursor.Image2.translateTo(mouseX, mouseY);
        cursor.Image3.translateTo(mouseX, mouseY);
        cursor.Image4.translateTo(mouseX, mouseY);
        cursor.Image5.translateTo(mouseX, mouseY);
        cursor.Image6.translateTo(mouseX, mouseY);
        cursor.Image7.translateTo(mouseX, mouseY);
        cursor.Image8.translateTo(mouseX, mouseY);
        cursor.Image9.translateTo(mouseX, mouseY);
        cursor.Image10.translateTo(mouseX, mouseY);
        if (stickerSelected == 1 || (movingSticker != -1 && stickers.get(movingSticker).imageType == 1)){
          if (currentTheme == 1){
            cursor.Image1.show();
          }
          else {
            cursor.Image6.show();
          }
        }
        else if (stickerSelected == 2 || (movingSticker != -1 && stickers.get(movingSticker).imageType == 2)){
          if (currentTheme == 1){
            cursor.Image2.show();
          }
          else {
            cursor.Image7.show();
          }
        }
        else if (stickerSelected == 3 || (movingSticker != -1 && stickers.get(movingSticker).imageType == 3)){
          if (currentTheme == 1){
            cursor.Image3.show();
          }
          else {
            cursor.Image8.show();
          }
        }
        else if (stickerSelected == 4 || (movingSticker != -1 && stickers.get(movingSticker).imageType == 4)){
          if (currentTheme == 1){
            cursor.Image4.show();
          }
          else {
            cursor.Image9.show();
          }
        }
        else if (stickerSelected == 5 || (movingSticker != -1 && stickers.get(movingSticker).imageType == 5)){
          if (currentTheme == 1){
            cursor.Image5.show();
          }
          else {
            cursor.Image10.show();
          }
        }
      }
      else{
        cursor.hideAll();
      }
      EZ.refreshScreen();
    }
  }
}
