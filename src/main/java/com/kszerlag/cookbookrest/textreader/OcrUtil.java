package com.kszerlag.cookbookrest.textreader;

import com.asprise.ocr.Ocr;
import net.sourceforge.tess4j.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.io.File;

@Component
public class OcrUtil {

    protected static final Logger logger = LoggerFactory.getLogger(OcrUtil.class);

    private static final OcrUtil INSTANCE = new OcrUtil();

    private static String defaultLanguage;

    private Ocr ocr;

    private ITesseract ocrTess;

    private OcrUtil() {
        Ocr.setUp();
    }

    public static OcrUtil getINSTANCE() {
        defaultLanguage = Ocr.LANGUAGE_ENG;
        return INSTANCE;
    }

    public String recognizeTextAsprise(File[] file) {
        ocr = new Ocr();
        ocr.startEngine(Ocr.LANGUAGE_ENG, Ocr.SPEED_SLOW);
        String text = ocr.recognize(file, Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
        ocr.stopEngine();
        return text;
    }

    public String recognizeTextTessFromBufferedImage(File file) {
        ocrTess = new Tesseract1();
        ocrTess.setLanguage("pol");
        try {
            return ocrTess.doOCR(file);
        } catch (TesseractException e) {
            logger.debug(e.getMessage());
        }
        return null;
    }

    public String recognizeTextTessFromBufferedImage(BufferedImage bufferedImage) {
        ocrTess = new Tesseract1();
        ocrTess.setLanguage("pol");
        try {
            return ocrTess.doOCR(bufferedImage);
        } catch (TesseractException e) {
            logger.debug(e.getMessage());
        }
        return null;
    }


}
