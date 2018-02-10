package com.ucpro.feature.webwindow.b.a.a;

import com.uc.pictureviewer.interfaces.PictureInfo;
import com.uc.pictureviewer.interfaces.PictureInfoLoader;
import com.uc.pictureviewer.interfaces.PictureViewer.LoaderDelegate;

/* compiled from: ProGuard */
public final class d implements LoaderDelegate {
    private PictureInfoLoader a;
    private PictureInfoLoader b;
    private PictureInfoLoader c;

    public d(PictureInfoLoader pictureInfoLoader) {
        this(pictureInfoLoader, (byte) 0);
    }

    private d(PictureInfoLoader pictureInfoLoader, byte b) {
        this.a = pictureInfoLoader;
        this.b = null;
        this.c = null;
    }

    public final PictureInfoLoader createPictureInfoLoader(PictureInfo pictureInfo) {
        return this.a;
    }

    public final PictureInfoLoader createRecommendInfoLoader() {
        return this.b;
    }

    public final PictureInfoLoader createCoverInfoLoader() {
        return this.c;
    }
}
