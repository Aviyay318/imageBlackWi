package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessingFrame extends JFrame {

    private BufferedImage image;
    private JLabel imageLabel;

    public ImageProcessingFrame() {
        try {
            // Load the image (replace "path/to/image.jpg" with the actual image file path)
            image = ImageIO.read(new File("src/main/java/org/example/image.png"));

            imageLabel = new JLabel(new ImageIcon(image));
            add(imageLabel, BorderLayout.CENTER);

            JButton btnToGrayscale = new JButton("Convert to Grayscale");
            btnToGrayscale.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    image = toGrayscale(image);
                    imageLabel.setIcon(new ImageIcon(image));
                }
            });
            add(btnToGrayscale, BorderLayout.SOUTH);

            setSize(500, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static BufferedImage toGrayscale(BufferedImage original) {
        BufferedImage grayscaleImage = new BufferedImage(original.getWidth(),
                original.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = grayscaleImage.getGraphics();
        g.drawImage(original, 0, 0, null);
        g.dispose();
        return grayscaleImage;
    }

}
