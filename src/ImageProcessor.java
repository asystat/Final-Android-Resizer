/*
 *
 
 Copyright (c) 2014, Sebastian Breit
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.

3. Neither the name of the <ORGANIZATION> nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 
 
 * 
 * */


import com.mortennobel.imagescaling.AdvancedResizeOp;
import com.mortennobel.imagescaling.ResampleFilters;
import com.mortennobel.imagescaling.ResampleOp;
import com.sun.istack.internal.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessor {

    private static final float LDPI_RATIO = 3;
    private static final float MDPI_RATIO = 4;
    private static final float TVDPI_RATIO = 5.33333333f;
    private static final float HDPI_RATIO = 6;
    private static final float XHDPI_RATIO = 8;
    private static final float XXHDPI_RATIO = 12;
    private static final float XXXHDPI_RATIO = 16;
    private static final float X1_RATIO = 4;
    private static final float X15_RATIO = 6;
    private static final float X2_RATIO = 8;
    private static final float X3_RATIO = 12;
    private static final float X4_RATIO = 16;
    private static final float WINDOWS_RATIO = 12;


    public static void processImage(File f, File resDirectory, String originalSize, String drawableDirectory, boolean overwrite,
                                    String resFolder, @NotNull DrawableType type) throws FileAlreadyExistsException, IOException, NullPointerException {

        String finalPath = "";

        switch (type) {
            case ANDROID:
                if (drawableDirectory.equalsIgnoreCase("mipmap")) {
                    finalPath = resDirectory.getAbsolutePath() + "/mipmap-" + resFolder + "/" + f.getName();
                } else {
                    finalPath = resDirectory.getAbsolutePath() + "/drawable-" + resFolder + "/" + f.getName();
                }
                break;
            case IOS:
                finalPath = resDirectory.getAbsolutePath() + "/" + stripExtension(f.getName()) + resFolder + "." + getExtension(f.getName());
                break;
            case WINDOWS:
                finalPath = resDirectory.getAbsolutePath() + "/" + f.getName();
                break;
        }


        File destFile = new File(finalPath);
        if (!overwrite) {
            if (destFile.exists())
                throw new FileAlreadyExistsException();
        }

        destFile.getParentFile().mkdirs();

        BufferedImage image = ImageIO.read(f);

        int size = getRequiredSize(originalSize, resFolder, image.getWidth());

        ResampleOp resampleOp = new ResampleOp(size, (size * image.getHeight())
                / image.getWidth());
        resampleOp.setFilter(ResampleFilters.getLanczos3Filter());
        resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.None);
        image = resampleOp.filter(image, null);

        ImageIO.write(image, getExtension(f.getName()), destFile);
    }

    private static int getRequiredSize(String originalSize, String resFolder,
                                       int width) {
        float destRatio = 1;
        destRatio = getRatio(resFolder);

        float origRatio = 1;
        origRatio = getRatio(originalSize);

        return Math.round(((float) width) * destRatio / origRatio);
    }

    private static float getRatio(String ratioString) {
        if (ratioString.equalsIgnoreCase("ldpi")) {
            return LDPI_RATIO;
        } else if (ratioString.equalsIgnoreCase("mdpi")) {
            return MDPI_RATIO;
        } else if (ratioString.equalsIgnoreCase("tvdpi")) {
            return TVDPI_RATIO;
        } else if (ratioString.equalsIgnoreCase("hdpi")) {
            return HDPI_RATIO;
        } else if (ratioString.equalsIgnoreCase("xhdpi")) {
            return XHDPI_RATIO;
        } else if (ratioString.equalsIgnoreCase("xxhdpi")) {
            return XXHDPI_RATIO;
        } else if (ratioString.equalsIgnoreCase("xxxhdpi")) {
            return XXXHDPI_RATIO;
        } else if (ratioString.equalsIgnoreCase("@1x")) {
            return X1_RATIO;
        } else if (ratioString.equalsIgnoreCase("@1.5x")) {
            return X15_RATIO;
        } else if (ratioString.equalsIgnoreCase("@2x")) {
            return X2_RATIO;
        } else if (ratioString.equalsIgnoreCase("@3x")) {
            return X3_RATIO;
        } else if (ratioString.equalsIgnoreCase("@4x")) {
            return X4_RATIO;
        } else if (ratioString.equalsIgnoreCase("windows")) {
            return WINDOWS_RATIO;
        }
        return 1;
    }

    private static String getExtension(String f) {
        String extension = "";

        int i = f.lastIndexOf('.');
        if (i > 0) {
            extension = f.substring(i + 1);
        }
        return extension;
    }

    public enum DrawableType {
        ANDROID,
        IOS,
        WINDOWS
    }

    static String stripExtension(String str) {
        // Handle null case specially.

        if (str == null) return null;

        // Get position of last '.'.

        int pos = str.lastIndexOf(".");

        // If there wasn't any '.' just return the string as is.

        if (pos == -1) return str;

        // Otherwise return the string, up to the dot.

        return str.substring(0, pos);
    }
}
