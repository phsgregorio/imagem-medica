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
	 * @return tmpFile(É de responsabilidade do Desenvolvedor excluir essa imagem ao final de seu uso)
	 */
	public static File convertDcmToJpeg(String filePath, String fileName) {

    	BufferedImage myJpegImage = null;

        File file = new File(filePath + Globals.FILE_SEPARATOR + fileName);
        File tmpFile = null;

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
            
            tmpFile = new File(filePath + Globals.FILE_SEPARATOR + fileName + Globals.TMP_IMAGE);
            
            try {
            	
                OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(tmpFile));
                ImageIO.write(myJpegImage, "jpeg", outputStream);
                
                outputStream.close();
                
            } catch (IOException e) {
            	tmpFile = null;
                e.printStackTrace();
            }
        }

        return tmpFile;
	}
	
	/**
	 * Método responsável por informar se um arquivo é do tipo DICOM
	 * @param file
	 * @return
	 */
	public static Boolean isDcmFile(File file) {
		return file !=null && file.getName()!=null && file.getName().indexOf(Globals.DCM_EXTENSION)!=-1;
	}
	
//	public static void main(String[] args) {	
//		convertDcmToJpeg(Globals.PATIENT_FILE_DIR + Globals.FILE_SEPARATOR + 1, "anonimized.dcm");
//	}
}