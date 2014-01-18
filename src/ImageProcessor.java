import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.mortennobel.imagescaling.AdvancedResizeOp;
import com.mortennobel.imagescaling.ResampleFilters;
import com.mortennobel.imagescaling.ResampleOp;

public class ImageProcessor {
	
	private static final float LDPI_RATIO=3;
	private static final float MDPI_RATIO=4;
	private static final float TVDPI_RATIO=5.33333333f;
	private static final float HDPI_RATIO=6;
	private static final float XHDPI_RATIO=8;
	private static final float XXHDPI_RATIO=12;
	private static final float XXXHDPI_RATIO=16;
	

	public static void processImage(File f, File resDirectory, String originalSize,
			String resFolder) throws FileAlreadyExistsException, IOException, NullPointerException {

		String finalPath=resDirectory.getAbsolutePath() + "/drawable-"	+ resFolder + "/" + f.getName();
		
		File destFile=new File(finalPath);
		if(destFile.exists())
			throw new FileAlreadyExistsException();
		
		destFile.getParentFile().mkdirs();
		
		BufferedImage image = ImageIO.read(f);
		
		int size=getRequiredSize(originalSize,resFolder,image.getWidth());

		ResampleOp resampleOp = new ResampleOp(size, (size * image.getHeight())
				/ image.getWidth());
		resampleOp.setFilter(ResampleFilters.getLanczos3Filter());
		resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.Normal);
		image = resampleOp.filter(image, null);

		ImageIO.write(image, getExtension(f.getName()), destFile);
	}

	private static int getRequiredSize(String originalSize, String resFolder,
			int width) {
		float destRatio=1;
		if(resFolder.equalsIgnoreCase("ldpi"))
			destRatio=LDPI_RATIO;
		else if(resFolder.equalsIgnoreCase("mdpi"))
			destRatio=MDPI_RATIO;
		else if(resFolder.equalsIgnoreCase("tvdpi"))
			destRatio=TVDPI_RATIO;
		else if(resFolder.equalsIgnoreCase("hdpi"))
			destRatio=HDPI_RATIO;
		else if(resFolder.equalsIgnoreCase("xhdpi"))
			destRatio=XHDPI_RATIO;
		else if(resFolder.equalsIgnoreCase("xxhdpi"))
			destRatio=XXHDPI_RATIO;
		else if(resFolder.equalsIgnoreCase("xxxhdpi"))
			destRatio=XXXHDPI_RATIO;
		
		float origRatio=1;
		if(originalSize.equalsIgnoreCase("ldpi"))
			origRatio=LDPI_RATIO;
		else if(originalSize.equalsIgnoreCase("mdpi"))
			origRatio=MDPI_RATIO;
		else if(originalSize.equalsIgnoreCase("tvdpi"))
			origRatio=TVDPI_RATIO;
		else if(originalSize.equalsIgnoreCase("hdpi"))
			origRatio=HDPI_RATIO;
		else if(originalSize.equalsIgnoreCase("xhdpi"))
			origRatio=XHDPI_RATIO;
		else if(originalSize.equalsIgnoreCase("xxhdpi"))
			origRatio=XXHDPI_RATIO;
		else if(originalSize.equalsIgnoreCase("xxxhdpi"))
			origRatio=XXXHDPI_RATIO;

		return Math.round(((float)width)*destRatio/origRatio);
	}

	private static String getExtension(String f) {
		String extension = "";

		int i = f.lastIndexOf('.');
		if (i > 0) {
		    extension = f.substring(i+1);
		}
		return extension;
	}

}
