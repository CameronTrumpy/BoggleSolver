//import javax.imageio.ImageIO;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//public class SwingWindow2 {
//    public static void create() throws IOException, AWTException {
//        JFrame f=new JFrame();//creating instance of JFrame
//        JPanel panel=new JPanel();
//        JTextField textInput = new JTextField(16);
//        JButton button = new JButton("Submit");
//        text te = new text();
//        panel.setBounds(0,0,1920,1080);
//        panel.setBackground(Color.gray);
//        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//        ImageIO.write(image, "png", new File("src/Capture.png"));
//        BufferedImage myPicture = ImageIO.read(new File("src/Capture.png"));
//        Image scaledPicture = myPicture.getScaledInstance(960, 540, Image.SCALE_SMOOTH);
//        JLabel picLabel = new JLabel(new ImageIcon(scaledPicture));
//        picLabel.setSize(960, 540);
//        panel.add(picLabel);
//        panel.add(textInput);
//        panel.add(button);
//        f.add(panel);
//        f.setSize(1920,1080);
//        f.setLayout(null);
//        f.setVisible(true);
//        f.repaint();
//        f.setLayout(null);//using no layout managers
//        f.setVisible(true);//making the frame visible
//    }
//    public static void getUserInput(){
//
//    }
//}