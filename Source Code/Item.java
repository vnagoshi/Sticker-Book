/**
 * Item, Defines an item that can be displayed in Sticker Book
 * @author Nagoshi, Vincent
 * @version 1.00.01
 */
public class Item {
  EZImage image1;
  EZImage image2;
  EZImage selectImage;
  EZSound sound1;
  EZSound sound2;

  /**
   * Changes the theme of the item
   * @param themeNumber, the number of the theme to change to (1-2)
   */
  public void changeTheme(int themeNumber) {
    switch (themeNumber){
      case 1:
        image2.hide();
        image1.show();
        break;
      case 2:
        image1.hide();
        image2.show();
        break;
    }
  }
  
  /**
   * Plays this item's sound based on the current theme
   * @param themeNumber, the number of the current theme in Sticker Book (1-2)
   */
  public void playSound(int themeNumber){
    switch (themeNumber){
      case 1:
        sound1.play();
        break;
      case 2:
        sound2.play();
        break;
    }
  }
  
  /**
   * Erases this item from Sticker Book
   */
  public void erase(){
    image1.hide();
    image2.hide();
  }

  /**
   * Checks if a coordinate pair are within the boundaries of the item
   * @param themeNumber, the number of the current theme in Sticker Book (1-2)
   * @param mouseX, the x coordinate of the pair
   * @param mouseY, the y coordinate of the pair
   * @return true if the coordinate pair is within the boundaries if the item, false otherwise
   */
  public boolean inElement(int themeNumber, int mouseX, int mouseY){
    if(themeNumber == 1){
      return image1.isPointInElement(mouseX, mouseY);
    }
    else{
      return image2.isPointInElement(mouseX, mouseY);
    }
  }

  /**
   * Moves the item to the coordinates (x, y) in Sticker Book
   * @param x, the x coordinate to move the item to
   * @param y, the y coordinate to move the item to
   */
  public void moveTo (int x, int y){
    image1.translateTo(x, y);
    image2.translateTo(x, y);
    selectImage.translateTo(x, y);
  }
  
  /**
   * Changes the items z-value to be above all other items in Sticker Book
   */
  public void raiseUp (){
    image1.pullToFront();
    image2.pullToFront();
    selectImage.pullToFront();
  }
}
