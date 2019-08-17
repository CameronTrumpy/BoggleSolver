// Java program to create a blank text
// field of definite number of columns.
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
class SwingWindow extends JFrame implements ActionListener {
    // JTextField
    static JTextField t;

    // JFrame
    static JFrame f;

    // JButton
    static JButton b;

    static String inputText;

    public static boolean completed = false;

    // default constructor
    SwingWindow()
    {
    }
    public static void create() throws AWTException, IOException {
        // default constructor
        // create a new frame to stor text field and button
        f = new JFrame("textfield");


        // create a new button
        b = new JButton("submit");

        // create a object of the text class
        SwingWindow te = new SwingWindow();

        // addActionListener to button
        b.addActionListener(te);

        // create a object of JTextField with 16 columns
        t = new JTextField(16);

        // create a panel to add buttons and textfield
        JPanel p = new JPanel();

        BufferedImage image = new Robot().createScreenCapture(new Rectangle(700, 180, 590,680 ));
        ImageIO.write(image, "png", new File("src/Capture.png"));
        BufferedImage myPicture = ImageIO.read(new File("src/Capture.png"));
//        Image scaledPicture = myPicture.getScaledInstance(960, 540, Image.SCALE_SMOOTH);
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setSize(960, 540);
        p.add(picLabel);
        // add buttons and textfield to panel
        p.add(t);
        p.add(b);

        // add panel to framep
        f.add(p);

        // set the size of frame
        f.setSize(590, 1080);

        f.show();
    }


    // if the vutton is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("submit")) {
            // set the text of the label to the text of the field
            inputText= t.getText();
            completed = true;
            f.dispose();

        }
    }
    public static boolean getFinished(){
        return completed;
    }
}
