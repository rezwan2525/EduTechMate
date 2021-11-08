package com.rezwan2525.edutechmate.commons;


public class CodeEditorHelper {


    public static String getCodeLineCountText(int line) {
        String lineText = "";
        for (int i = 1;i<=line;i++){
            lineText += i+"\n";
        }
        return lineText;
    }



}
