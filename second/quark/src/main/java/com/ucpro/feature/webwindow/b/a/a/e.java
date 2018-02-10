package com.ucpro.feature.webwindow.b.a.a;

import com.uc.pictureviewer.interfaces.PictureInfo;
import com.uc.pictureviewer.interfaces.PictureViewerListener;
import com.uc.pictureviewer.interfaces.PictureViewerListener.DisplayType;

/* compiled from: ProGuard */
public abstract class e implements PictureViewerListener {
    public boolean onRecommendItemClicked(PictureInfo pictureInfo) {
        return false;
    }

    public boolean onWindowClicked() {
        return false;
    }

    public void onPictureViewerClosed() {
    }

    public void onPopOutPictureViewerWindowStart() {
    }

    public void onPopOutPictureViewerWindowFinish(boolean z) {
    }

    public void onPictureViewerDisplayTypeChanged(DisplayType displayType, DisplayType displayType2) {
    }
}
