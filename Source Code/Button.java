/**
 * Button, Contains all image handling for the buttons in Sticker Book
 * @author Nagoshi, Vincent
 * @version 1.00.01
 */
public class Button extends Item {

  /**
   * Creates a button and loads its associated images
   * @param i, the number of the button to create (0-13)
   */
  public Button(int i){
    switch (i){
      case 0:
        image1 = EZ.addImage("CG/STICKERS.png", i * 111 + 55, 55);
        image2 = EZ.addImage("CG/STICKERS.png", i * 111 + 55, 55);
        selectImage = EZ.addImage("CG/SELECT.png", i * 111 + 55, 55);
        break;
      case 1:
        image1 = EZ.addImage("CG/PLACEMULTIPLE.png", i * 111 + 55, 55);
        image2 = EZ.addImage("CG/PLACEMULTIPLE.png", i * 111 + 55, 55);
        selectImage = EZ.addImage("CG/SELECT.png", i * 111 + 55, 55);
        break;
      case 2:
        image1 = EZ.addImage("CG/MOVE.png", i * 111 + 55, 55);
        image2 = EZ.addImage("CG/MOVE.png", i * 111 + 55, 55);
        selectImage = EZ.addImage("CG/SELECT.png", i * 111 + 55, 55);
        break;
      case 3:
        image1 = EZ.addImage("CG/CURSOR.png", i * 111 + 55, 55);
        image2 = EZ.addImage("CG/CURSOR.png", i * 111 + 55, 55);
        selectImage = EZ.addImage("CG/SELECT.png", i * 111 + 55, 55);
        break;
      case 4:
        image1 = EZ.addImage("CG/SAVE.png", i * 111 + 55, 55);
        image2 = EZ.addImage("CG/SAVE.png", i * 111 + 55, 55);
        selectImage = EZ.addImage("CG/SELECT.png", i * 111 + 55, 55);
        break;
      case 5:
        image1 = EZ.addImage("CG/LOAD.png", i * 111 + 55, 55);
        image2 = EZ.addImage("CG/LOAD.png", i * 111 + 55, 55);
        selectImage = EZ.addImage("CG/SELECT.png", i * 111 + 55, 55);
        break;
      case 6:
        image1 = EZ.addImage("CG/ERASE.png", i * 111 + 55, 55);
        image2 = EZ.addImage("CG/ERASE.png", i * 111 + 55, 55);
        selectImage = EZ.addImage("CG/SELECT.png", i * 111 + 55, 55);
        break;
      case 7:
        image1 = EZ.addImage("CG/CLEAR.png", i * 111 + 55, 55);
        image2 = EZ.addImage("CG/CLEAR.png", i * 111 + 55, 55);
        selectImage = EZ.addImage("CG/SELECT.png", i * 111 + 55, 55);
        break;
      case 8:
        image1 = EZ.addImage("CG/CHANGETHEME.png", i * 111 + 55, 55);
        image2 = EZ.addImage("CG/CHANGETHEME.png", i * 111 + 55, 55);
        selectImage = EZ.addImage("CG/SELECT.png", i * 111 + 55, 55);
        break;
      case 9:
        image1 = EZ.addImage("CG/PIC101.png", -55, 166);
        image2 = EZ.addImage("CG/PIC201.png", -55, 166);
        selectImage = EZ.addImage("CG/SELECT.png", -55, 166);
        break;
      case 10:
        image1 = EZ.addImage("CG/PIC102.png", -55, 277);
        image2 = EZ.addImage("CG/PIC202.png", -55, 277);
        selectImage = EZ.addImage("CG/SELECT.png", -55, 277);
        break;
      case 11:
        image1 = EZ.addImage("CG/PIC103.png", -55, 388);
        image2 = EZ.addImage("CG/PIC203.png", -55, 388);
        selectImage = EZ.addImage("CG/SELECT.png", -55, 388);
        break;
      case 12:
        image1 = EZ.addImage("CG/PIC104.png", -55, 499);
        image2 = EZ.addImage("CG/PIC204.png", -55, 499);
        selectImage = EZ.addImage("CG/SELECT.png", -55, 499);
        break;
      case 13:
        image1 = EZ.addImage("CG/PIC105.png", -55, 610);
        image2 = EZ.addImage("CG/PIC205.png", -55, 610);
        selectImage = EZ.addImage("CG/SELECT.png", -55, 610);
        break;
    }
  }

  /**
   * Toggles a buttons selection image based on the current state of Sticker Book
   * @param i, the number of the button to update (0-13)
   * @param pictureSelected, if a picture is currently selected in Sticker Book
   * @param palateOpen, if the picture palate is currently open in Sticker Book
   * @param placeMultipleOn, if the place multiple mode is currently on in Sticker Book
   * @param movementOn, if the movement mode is currently on in Sticker Book
   * @param followCursorOn, if the follow cursor mode is currently on in Sticker Book
   * @param eraseOn, if the erase mode is currently on in Sticker Book
   */
  public void toggleSelectPicture(int i, int pictureSelected, boolean palateOpen, boolean placeMultipleOn, boolean movementOn, boolean followCursorOn, boolean eraseOn){
    switch (i){
      case 0:
        if (pictureSelected != 0 && palateOpen == false){
          selectImage.show();
        }
        else {
          selectImage.hide();
        }
        break;
      case 1:
        if (placeMultipleOn){
          selectImage.show();
        }
        else {
          selectImage.hide();
        }
        break;
      case 2:
        if (movementOn){
          selectImage.show();
        }
        else {
          selectImage.hide();
        }
        break;
      case 3:
        if (followCursorOn){
          selectImage.show();
        }
        else {
          selectImage.hide();
        }
        break;
      case 4:
        selectImage.hide();
        break;
      case 5:
        selectImage.hide();
        break;
      case 6:
        if (eraseOn){
          selectImage.show();
        }
        else {
          selectImage.hide();
        }
        break;
      case 7:
        selectImage.hide();
        break;
      case 8:
        selectImage.hide();
        break;
      case 9:
        if (pictureSelected == 1){
          selectImage.show();
        }
        else {
          selectImage.hide();
        }
        break;
      case 10:
        if (pictureSelected == 2){
          selectImage.show();
        }
        else {
          selectImage.hide();
        }
        break;
      case 11:
        if (pictureSelected == 3){
          selectImage.show();
        }
        else {
          selectImage.hide();
        }
        break;
      case 12:
        if (pictureSelected == 4){
          selectImage.show();
        }
        else {
          selectImage.hide();
        }
        break;
      case 13:
        if (pictureSelected == 5){
          selectImage.show();
        }
        else {
          selectImage.hide();
        }
        break;
    }
  }
}