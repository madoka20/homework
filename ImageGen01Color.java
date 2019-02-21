package cs240sp19;

import java.awt.image.*;
import java.awt.Color;
import java.io.*;
import javax.imageio.*;

/*
 * CS240-Lab02-1.5.38-Colored Author: Clare, Jianxiang, 2/2/19 
 * This program is a image generator which use nested loop to slightly change the rgb value to generate colored images and save it as .jpg file into our computer.
 */
public class ImageGen01Color {
	public static void main(String args[]) throws IOException {
		String fileOut = "C:\\Users\\Administrator\\Desktop\\javaimage\\008.jpg";// destination file
		final int SIDE = 1024;// the maximum pixel in each side
		final int TYPE = BufferedImage.TYPE_INT_RGB;
		BufferedImage image = new BufferedImage(SIDE, SIDE, TYPE);// create a image object
		final int LIMIT = 255;// limit of RGB values
		int r, g, b;// specific value for R G and B
		Color color;
		for (int i = 0; i < SIDE; i++) {
			for (int j = 0; j < SIDE; j++) {
				r = (Math.max(i, j)) % LIMIT;
				g = (Math.min(i, j)) % LIMIT;
				b = (int) ((Math.log(i) * Math.log(j)) % LIMIT);

				color = new Color(r, g, b);// create 'colored' values
				image.setRGB(i, j, color.getRGB());// saves pixel
			}

		}
		File outputfile = new File(fileOut);
		ImageIO.write(image, "jpg", outputfile);// output the image into designed folder
	}
}
