package com.uc.pictureviewer.interfaces;

import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public class PictureViewerConfig {
    public boolean enableAutoPlay = false;
    public boolean enableSensor = false;
    public boolean enableShowArticle = false;
    public boolean enableShowGallery = false;
    public PictureViewerGalleryStyle galleryStyle = new PictureViewerGalleryStyle();
    public boolean initialShowTopAndBottomView = true;
    public RecommendConfig recommendConfig = new RecommendConfig();
    public TapSwitchAnimation tapSwitchAnimation = TapSwitchAnimation.Cross;

    @Api
    /* compiled from: ProGuard */
    public enum TapSwitchAnimation {
        None,
        Cross
    }
}
