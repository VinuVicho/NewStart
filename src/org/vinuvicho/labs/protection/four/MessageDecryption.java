package org.vinuvicho.labs.protection.four;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MessageDecryption {
    public static void main(String[] args) {
        String imageFilePath = "encrypted_image.png"; // шлях до файлу з зашифрованим зображенням

        try {
            // завантажуємо зашифроване зображення з файлу
            File inputFile = new File(imageFilePath);
            BufferedImage image = ImageIO.read(inputFile);

            // створюємо рядок, який міститиме розшифрований текст
            StringBuilder messageBuilder = new StringBuilder();

            // отримуємо колір кожного пікселя і перетворюємо його в символ
            for (int i = 0; i < image.getWidth(); i++) {
                Color color = new Color(image.getRGB(i, 0));
                char character = (char) color.getRGB();
                messageBuilder.append(character);
            }

            String message = messageBuilder.toString();
            System.out.println("Розшифрований текст: " + message);
        } catch (IOException e) {
            System.out.println("Сталася помилка під час читання зашифрованого зображення з файлу " + imageFilePath + ": " + e.getMessage());
        }
    }
}
