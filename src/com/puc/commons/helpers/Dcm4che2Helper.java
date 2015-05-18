package com.puc.commons.helpers;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.dcm4che2.imageio.plugins.dcm.DicomImageReadParam;

import com.puc.commons.globals.Globals;

public class Dcm4che2Helper {

	/**
	 * Método responsável por converter uma imagem DCM(Dicom) para Jpeg
	 * @param filePath
	 * @param fileName
	 */
	public static void convertDcmToJpeg(String filePath, String fileName) {
		
    	BufferedImage myJpegImage = null;

        File file = new File(filePath + Globals.FILE_SEPARATOR + fileName);
        Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("DICOM");
        
        while (iterator.hasNext()) {
        	
            ImageReader imageReader = (ImageReader) iterator.next();
            DicomImageReadParam dicomImageReadParam = (DicomImageReadParam) imageReader.getDefaultReadParam();
            
            try {
                ImageInputStream iis = ImageIO.createImageInputStream(file);
                imageReader.setInput(iis,false);
                myJpegImage = imageReader.read(0, dicomImageReadParam);
                iis.close();
                if(myJpegImage == null){
                    System.out.println("Could not read image!!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            File file2 = new File("/test.jpg");
            
            try {
            	
                OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file2));
                ImageIO.write(myJpegImage, "jpeg", outputStream);
                
                outputStream.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            System.out.println("Completed");
        }
	}
	
	public static void main(String[] args) {
		
		convertDcmToJpeg(Globals.PATIENT_FILE_DIR + Globals.FILE_SEPARATOR + 1, "test.dcm");
	}
}