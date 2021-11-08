package com.rezwan2525.edutechmate.commons;

import com.google.mlkit.vision.text.Text;

public class CodeFromPicHelper {



    public static String getResultCodeFormated(Text visionText){
        String txt =  visionText.getText();
        String showText = "";
        for (Text.TextBlock block : visionText.getTextBlocks()) {
            String blockText = block.getText();
            showText += blockText+"\n";
        }
        return showText;
    }
}
