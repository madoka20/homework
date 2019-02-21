package cs240sp19;

import java.awt.image.*;
import java.awt.Color;
import java.io.*;
import javax.imageio.*;
/*
 * CS240-Lab02-1.5.38-Gray Author: Clare, Jianxiang, 2/2/19 
 * This program is a image generator which use nested loop to slightly change the RGB value to generate gray images and save it as .jpg file into our computer.
 */
public class ImageGen01 {
	public static void main(String args[]) throws IOException {
		String fileOut = "C:\\Users\\Administrator\\Desktop\\javaimage\\003.jpg";//destination file
		final int SIDE = 1024;//the maximum pixel in each side
		final int TYPE = BufferedImage.TYPE_INT_RGB;
		BufferedImage image = new BufferedImage(SIDE, SIDE, TYPE);//create a image object
		final int LIMIT = 255;//limit of RGB values
		int c;//specific value for R G and B
		Color color;
		for (int i = 0; i < SIDE; i++) {
			for (int j = 0; j < SIDE; j++) {
				c = (i*i+j*j)%LIMIT;
				color = new Color(c, c, c);//create 'gray' values
				image.setRGB(i, j, color.getRGB());//saves pixel
			}

		}
		File outputfile = new File(fileOut);
		ImageIO.write(image, "jpg", outputfile);// output the image into designed folder
	}
}
