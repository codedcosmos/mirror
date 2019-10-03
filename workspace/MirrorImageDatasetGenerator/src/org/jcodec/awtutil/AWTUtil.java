package org.jcodec.awtutil;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.ColorUtil;
import org.jcodec.scale.RgbToBgr;
import org.jcodec.scale.Transform;

/**
 * This class is part of JCodec ( www.jcodec.org ) This software is distributed
 * under FreeBSD License
 * 
 * @author The JCodec project
 * 
 */

/*
 * This code has been derived from the jcodec file AWTUtil. Not in it's entirety but in smaller parts. 
 * All of this code was written and developed by contributors working on the jcodec project.
 * None of this was written by codedcosmos.
 */

public class AWTUtil {

    public static BufferedImage toBufferedImage(Picture src) {
		if (src.getColor() != ColorSpace.BGR) {
			Picture bgr = Picture.createCropped(src.getWidth(), src.getHeight(), ColorSpace.BGR, src.getCrop());
			if (src.getColor() == ColorSpace.RGB) {
				new RgbToBgr().transform(src, bgr);
			} else {
				Transform transform = ColorUtil.getTransform(src.getColor(), ColorSpace.RGB);
				transform.transform(src, bgr);
				new RgbToBgr().transform(bgr, bgr);				
			}
			src = bgr;
		}

        BufferedImage dst = new BufferedImage(src.getCroppedWidth(), src.getCroppedHeight(),
                BufferedImage.TYPE_3BYTE_BGR);

        if (src.getCrop() == null)
            toBufferedImage(src, dst);
        else
            toBufferedImageCropped(src, dst);

        return dst;
    }
    
    private static void toBufferedImageCropped(Picture src, BufferedImage dst) {
        byte[] data = ((DataBufferByte) dst.getRaster().getDataBuffer()).getData();
        byte[] srcData = src.getPlaneData(0);
        int dstStride = dst.getWidth() * 3;
        int srcStride = src.getWidth() * 3;
        for (int line = 0, srcOff = 0, dstOff = 0; line < dst.getHeight(); line++) {
            for (int id = dstOff, is = srcOff; id < dstOff + dstStride; id += 3, is += 3) {
                // Unshifting, since JCodec stores [0..255] -> [-128, 127]
                data[id] = (byte) (srcData[is] + 128);
                data[id + 1] = (byte) (srcData[is + 1] + 128);
                data[id + 2] = (byte) (srcData[is + 2] + 128);
            }
            srcOff += srcStride;
            dstOff += dstStride;
        }
    }

    public static void toBufferedImage(Picture src, BufferedImage dst) {
        byte[] data = ((DataBufferByte) dst.getRaster().getDataBuffer()).getData();
        byte[] srcData = src.getPlaneData(0);
        for (int i = 0; i < data.length; i++) {
            // Unshifting, since JCodec stores [0..255] -> [-128, 127]
            data[i] = (byte) (srcData[i] + 128);
        }
    }
}
