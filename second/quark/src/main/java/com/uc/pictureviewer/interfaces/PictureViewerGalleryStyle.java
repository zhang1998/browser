package com.uc.pictureviewer.interfaces;

import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public class PictureViewerGalleryStyle {
    public int borderColor;
    public double borderWidth;
    public int focusHeight;
    public int focusWidth;
    public int[] hasBorder;
    public int height;
    public double[] padding;
    public ShowMode showMode;
    public boolean switchPictureOnDrag;
    public int width;

    @Api
    /* compiled from: ProGuard */
    public enum ShowMode {
        Default,
        StrechAndSmoothScroll
    }

    public PictureViewerGalleryStyle(int i, int i2, double[] dArr, int[] iArr, int i3, int i4, boolean z) {
        this.width = 60;
        this.height = 60;
        this.padding = new double[]{2.5d, 2.5d, 2.5d, 2.5d};
        this.hasBorder = new int[]{1, 1, 1, 1};
        this.borderWidth = 1.0d;
        this.borderColor = -1;
        this.switchPictureOnDrag = true;
        this.showMode = ShowMode.Default;
        this.focusWidth = this.width;
        this.focusHeight = this.height;
        this.width = i;
        this.height = i2;
        this.padding = dArr;
        this.hasBorder = iArr;
        this.borderWidth = (double) i3;
        this.borderColor = i4;
        this.switchPictureOnDrag = z;
        this.focusWidth = this.width;
        this.focusHeight = this.height;
    }

    public PictureViewerGalleryStyle() {
        this.width = 60;
        this.height = 60;
        this.padding = new double[]{2.5d, 2.5d, 2.5d, 2.5d};
        this.hasBorder = new int[]{1, 1, 1, 1};
        this.borderWidth = 1.0d;
        this.borderColor = -1;
        this.switchPictureOnDrag = true;
        this.showMode = ShowMode.Default;
        this.focusWidth = this.width;
        this.focusHeight = this.height;
        this.focusWidth = this.width;
        this.focusHeight = this.height;
    }

    public void setShowMode(ShowMode showMode) {
        if (showMode != null) {
            this.showMode = showMode;
        }
    }

    public void setFocusRect(int i, int i2) {
        if (i > this.width) {
            this.focusWidth = i;
        }
        if (i2 > this.height) {
            this.focusHeight = i2;
        }
    }
}
