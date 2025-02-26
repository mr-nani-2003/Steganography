import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Decode {
    public static String extractEncryptedText(String imagePath) {
        try {
            BufferedImage image = ImageIO.read(new File("C:\\\\Users\\\\naniv\\\\OneDrive\\\\Documents\\\\Desktop\\\\encode\\\\encode.jpg"));
            int width = image.getWidth(), height = image.getHeight();

            StringBuilder encryptedMessage = new StringBuilder();
            int charValue = 0, bitIndex = 0;

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int pixel = image.getRGB(x, y);
                    int blue = pixel & 0xff;
                    int bit = blue & 1;

                    charValue = (charValue << 1) | bit;
                    bitIndex++;

                    if (bitIndex == 8) {
                        if (charValue == 0) return encryptedMessage.toString(); // Stop at null terminator
                        encryptedMessage.append((char) charValue);
                        charValue = 0;
                        bitIndex = 0;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
