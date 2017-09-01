/**
 * Sticker, Contains all images and sounds needed for a sticker item
 * @author Nagoshi, Vincent
 * @version 1.00.01
 */
public class Sticker extends Item {
  int imageX;
  int imageY;
  int imageType;

  /**
   * Creates a sticker and loads its associated images and sounds
   * @param stickerNumber, the number of the sticker to create (1-5)
   * @param x, the x position of the sticker in Sticker Book
   * @param y, the y position of the sticker in Sticker Book
   */
  public Sticker(int stickerNumber, int x, int y){
    imageX = x;
    imageY = y;
    imageType = stickerNumber;
    switch (stickerNumber){
      case 1:
        image1 = EZ.addImage("CG/PIC101.png", x, y);
        image2 = EZ.addImage("CG/PIC201.png", x, y);
        sound1 = EZ.addSound("SOUNDS/SFX101.wav");
        sound2 = EZ.addSound("SOUNDS/SFX201.wav");
        break;
      case 2:
        image1 = EZ.addImage("CG/PIC102.png", x, y);
        image2 = EZ.addImage("CG/PIC202.png", x, y);
        sound1 = EZ.addSound("SOUNDS/SFX102.wav");
        sound2 = EZ.addSound("SOUNDS/SFX202.wav");
        break;
      case 3:
        image1 = EZ.addImage("CG/PIC103.png", x, y);
        image2 = EZ.addImage("CG/PIC203.png", x, y);
        sound1 = EZ.addSound("SOUNDS/SFX103.wav");
        sound2 = EZ.addSound("SOUNDS/SFX203.wav");
        break;
      case 4:
        image1 = EZ.addImage("CG/PIC104.png", x, y);
        image2 = EZ.addImage("CG/PIC204.png", x, y);
        sound1 = EZ.addSound("SOUNDS/SFX104.wav");
        sound2 = EZ.addSound("SOUNDS/SFX204.wav");
        break;
      case 5:
        image1 = EZ.addImage("CG/PIC105.png", x, y);
        image2 = EZ.addImage("CG/PIC205.png", x, y);
        sound1 = EZ.addSound("SOUNDS/SFX105.wav");
        sound2 = EZ.addSound("SOUNDS/SFX205.wav");
        break;
    }
  }

  /**
   * Moves a sticker to the coordinates (x, y) in Sticker Book
   * @param x, the x coordinate to move the sticker to
   * @param y, the y coordinate to move the sticker to
   */
  public void moveTo (int X, int Y){
    image1.translateTo(X, Y);
    image2.translateTo(X, Y);
  }
}
