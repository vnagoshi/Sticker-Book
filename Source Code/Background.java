/**
 * Background, Contains all background images
 * @author Nagoshi, Vincent
 * @version 1.00.01
 */
public class Background extends Item {
  
  /**
   * Default constructor, loads and stores background images used by Sticker Book
   */
  public Background(){
    image1 = EZ.addImage("CG/BACKGROUND101.png" , 499, 350);
    image2 = EZ.addImage("CG/BACKGROUND201.png" , 499, 350);
  }
}
