/**
The thinking for this bot.
*/

import java.io.*;
import java.util.*;
// bot imports
import java.awt.*;
import java.awt.event.*;

public class AI {
    // main thread
	public static void main(String args[]) throws AWTException {
        Robot bot = new Robot();
        int mInitPos[] = mousePos();
        bot.keyPress(KeyEvent.VK_UP);
        bot.delay(5000);
        bot.keyRelease(KeyEvent.VK_UP);
    }
    
    static int[] mousePos() {
        Point mouse = MouseInfo.getPointerInfo().getLocation();
        int a[] = {mouse.x, mouse.y};
        return a;
    }
}
