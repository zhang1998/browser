package com.uc.pictureviewer.interfaces;

import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public interface PictureViewerListener {

    @Api
    /* compiled from: ProGuard */
    public enum DisplayType {
        Unkown,
        Navigation,
        MainPicture,
        AllPicture,
        Cover,
        Exited
    }

    @Api
    /* compiled from: ProGuard */
    public enum Orientation {
        Unkown,
        Left,
        Top,
        Right,
        Bottom
    }

    void onPictureViewerClosed();

    void onPictureViewerDisplayTypeChanged(DisplayType displayType, DisplayType displayType2);

    void onPopOutPictureViewerWindowFinish(boolean z);

    void onPopOutPictureViewerWindowStart();

    boolean onRecommendItemClicked(PictureInfo pictureInfo);

    void onTabChanged(int i, int i2);

    void onTabCountChanged(int i);

    boolean onViewMovedOut(Orientation orientation);

    boolean onWindowClicked();
}
