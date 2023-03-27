package org.vinuvicho.labs.protection.four;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GrayScaleImageSteganography {

    public static void main(String[] args) {

        // Message to be embedded
        String message = "Hello World!";

        // Gray Scale 8-bit graphic file to be used
        String imagePath = "inputImage.jpg";

        // Embed the message in the image and save the new image
        embedMessageInImage(message, imagePath, "outputImage.jpg");
    }

    // Embeds the message in the specified image and saves the new image
    public static void embedMessageInImage(String message, String imagePath, String outputImagePath) {

        try {
            // Read in the image
            BufferedImage image = ImageIO.read(new File(imagePath));

            // Loop through each character in the message
            for (int i = 0; i < message.length(); i++) {

                // Get the current character and convert it to binary
                char c = message.charAt(i);
                String binaryString = Integer.toBinaryString(c);

                // Pad the binary string with leading zeros to make it 8 bits long
                while (binaryString.length() < 8) {
                    binaryString = "0" + binaryString;
                }

                // Loop through each bit in the binary string
                for (int j = 0; j < binaryString.length(); j++) {

                    // Get the current bit
                    char bit = binaryString.charAt(j);

                    // Get the current pixel
                    int x = (i * 8) + j;
                    int y = 0;

                    // Get the current pixel's color
                    int color = image.getRGB(x, y);

                    // Modify the color based on the bit value
                    if (bit == '0') {
                        color = color & 0xFEFEFE;
                    } else {
                        color = color | 0x010101;
                    }

                    // Set the new color for the pixel
                    image.setRGB(x, y, color);
                }
            }

            // Save the new image
            ImageIO.write(image, "jpg", new File(outputImagePath));

            System.out.println("Message embedded in image successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
