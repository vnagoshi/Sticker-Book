/**
 * Cursor, Contains all cursor images
 * @author Nagoshi, Vincent
 * @version 1.00.01
 */
public class Cursor {
  EZImage Image1 = EZ.addImage("CG/PIC101ALT.png", 50, 50);
  EZImage Image2 = EZ.addImage("CG/PIC102ALT.png", 50, 50);
  EZImage Image3 = EZ.addImage("CG/PIC103ALT.png", 50, 50);
  EZImage Image4 = EZ.addImage("CG/PIC104ALT.png", 50, 50);
  EZImage Image5 = EZ.addImage("CG/PIC105ALT.png", 50, 50);
  EZImage Image6 = EZ.addImage("CG/PIC201ALT.png", 50, 50);
  EZImage Image7 = EZ.addImage("CG/PIC202ALT.png", 50, 50);
  EZImage Image8 = EZ.addImage("CG/PIC203ALT.png", 50, 50);
  EZImage Image9 = EZ.addImage("CG/PIC204ALT.png", 50, 50);
  EZImage Image10 = EZ.addImage("CG/PIC205ALT.png", 50, 50);

  /**
   * Hides all cursor images from view
   */
  public void hideAll(){
    Image1.hide();
    Image2.hide();
    Image3.hide();
    Image4.hide();
    Image5.hide();
    Image6.hide();
    Image7.hide();
    Image8.hide();
    Image9.hide();
    Image10.hide();
  }
}
