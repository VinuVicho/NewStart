package org.vinuvicho.labs.protection.four;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MessageEncryption {
    public static void main(String[] args) {
        String message = "Володимир Младьонов";
        String imageFilePath = "encrypted_image.png";

        try {
            // створюємо зображення розміром 1хN, де N - довжина рядка
            BufferedImage image = new BufferedImage(message.length(), 1, BufferedImage.TYPE_INT_ARGB);

            // перетворюємо кожен символ рядка в колір і присвоюємо його пікселю
            for (int i = 0; i < message.length(); i++) {
                Color color = new Color((int) message.charAt(i));
                image.setRGB(i, 0, color.getRGB());
            }

            // записуємо зображення в файл
            File outputFile = new File(imageFilePath);
            ImageIO.write(image, "png", outputFile);
            System.out.println("Зашифрований рядок успішно записано в файл " + imageFilePath);
        } catch (IOException e) {
            System.out.println("Сталася помилка під час запису зашифрованого рядка в файл " + imageFilePath + ": " + e.getMessage());
        }
    }
}