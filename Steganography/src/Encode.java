import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Encode {
    public static void hideEncryptedText(String text, String imagePath, String outputImagePath) {
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\naniv\\OneDrive\\Documents\\Desktop\\encode\\encode.jpg"));
            int width = image.getWidth(), height = image.getHeight();

            text += "\0"; // End marker
            int charIndex = 0, bitIndex = 0;
            int textLength = text.length();

            for (int y = 0; y < height && charIndex < textLength; y++) {
                for (int x = 0; x < width && charIndex < textLength; x++) {
                    int pixel = image.getRGB(x, y);
                    int alpha = (pixel>> 24) & 0xff;
                    int red = (pixel >> 16) & 0xff;
                    int green = (pixel >> 8) & 0xff;
                    int blue = pixel & 0xff;

                    int charValue = text.charAt(charIndex);
                    int bit = (charValue >> (7 - bitIndex)) & 1;
                    blue = (blue & 0xFE) | bit; // Modify LSB of blue channel

                    bitIndex++;
                    if (bitIndex == 8) {
                        bitIndex = 0;
                        charIndex++;
                    }

                    int newPixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
                    image.setRGB(x, y, newPixel);
                }
            }

            ImageIO.write(image, "png", new File("C:\\\\Users\\\\naniv\\\\OneDrive\\\\Documents\\\\Desktop\\\\encode\\\\encode.jpg"));
            System.out.println("Encrypted message hidden successfully in " + "C:\\\\Users\\\\naniv\\\\OneDrive\\\\Documents\\\\Desktop\\\\encode\\\\encode.jpg");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

