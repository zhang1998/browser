package com.uc.pictureviewer.interfaces;

import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public class PictureSetInfo extends PictureInfo {
    public static int INVALID_COLOR = 11184810;
    public static final String Type = "PictureSet";
    private int b = 0;
    private int c = INVALID_COLOR;

    public PictureSetInfo(String str, String str2, String str3, int i) {
        super(str, str2, null, str3);
        setType(Type);
        setPicturesCount(i);
    }

    public PictureSetInfo(String str, String str2, String str3, String str4, int i) {
        super(str, str2, str3, str4);
        setType(Type);
        setPicturesCount(i);
    }

    public int getPicturesCount() {
        return this.b;
    }

    public void setPicturesCount(int i) {
        this.b = i;
    }

    public int getTextColor() {
        return this.c;
    }

    public void setTextColor(int i) {
        this.c = i;
    }
}
