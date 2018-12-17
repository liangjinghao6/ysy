package com.orange.ysy.util;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jinghao.liang
 *
 */
public class ImageUtil {
	private static Logger log = LoggerFactory.getLogger(ImageUtil.class);
	
	public static BufferedImage readImage (String path) {
		
		BufferedImage bufImg = null;
		if(StringUtils.endsWith(path, ".jpg")) {
			Image src=Toolkit.getDefaultToolkit().getImage(path); 
			bufImg = toBufferedImage(src);
		} else {
			try {
				bufImg = ImageIO.read(new File(path));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(bufImg == null) {
			return null;
		}
		bufImg.flush();
		return bufImg;
	}
	
	/** * 改变图片大小 * * @param img * @param weight * @param height * @return */
	public static BufferedImage modifySize(BufferedImage img, int width, int height) {
		try {
			int w = img.getWidth();
			int h = img.getHeight();
			double wRation = (new Integer(width)).doubleValue() / w;
			double hRation = (new Integer(height)).doubleValue() / h;
			Image image = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(wRation, hRation), null);
			image = op.filter(img, null);
			img = (BufferedImage) image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public static void main (String args[]) {
			
		BufferedImage im = ImageUtil.readImage("d://logo.png");
		//BufferedImage im = ImageUtil.readImage("d://pp.jpg");
		ImageUtil.modifySize(im, 100, 100);
		try {
			FileOutputStream f = new FileOutputStream(new File("d://aa.jpg"));
			ImageIO.write(im, "png", f);
			f.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

		public static BufferedImage toBufferedImage(Image image) {
			if (image instanceof BufferedImage) {
				return (BufferedImage) image;
			}
			// This code ensures that all the pixels in the image are loaded
			image = new ImageIcon(image).getImage();
			BufferedImage bimage = null;
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			try {
				int transparency = Transparency.OPAQUE;
				GraphicsDevice gs = ge.getDefaultScreenDevice();
				GraphicsConfiguration gc = gs.getDefaultConfiguration();
				bimage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null), transparency);
			} catch (HeadlessException e) {
				// The system does not have a screen
			}
			if (bimage == null) {
				// Create a buffered image using the default color model
				int type = BufferedImage.TYPE_INT_RGB;
				bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
			}
			// Copy image to buffered image
			Graphics g = bimage.createGraphics();
			// Paint the image onto the buffered image
			g.drawImage(image, 0, 0, null);
			g.dispose();
			return bimage;
		} 
	
}
