package com.uc.pictureviewer.interfaces;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.uc.pictureviewer.interfaces.PictureTabView.OnScaleChangedListener;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public abstract class PictureViewer extends FrameLayout {

    @Api
    /* compiled from: ProGuard */
    public interface LoaderDelegate {
        PictureInfoLoader createCoverInfoLoader();

        PictureInfoLoader createPictureInfoLoader(PictureInfo pictureInfo);

        PictureInfoLoader createRecommendInfoLoader();
    }

    public abstract void addAdRuler(String str, PictureViewerAdRuler pictureViewerAdRuler);

    public abstract void addPictureItemViewFactory(String str, IPictureItemViewFactory iPictureItemViewFactory);

    public abstract void addPictureTabViewFactory(String str, IPictureTabViewFactory iPictureTabViewFactory);

    public abstract int getCountOfPictureBeViewed();

    public abstract int getCurrentPictureDataSize();

    public abstract int getCurrentPictureHeight();

    public abstract PictureInfo getCurrentPictureInfo();

    public abstract String getCurrentPictureUrl();

    public abstract int getCurrentPictureWidth();

    public abstract int getCurrentTabIndex();

    public abstract int getPictureCount();

    public abstract int getPictureCountOfCurrentWindow();

    public abstract boolean handleBackKeyPressed();

    public abstract void hideTopAndBottomBarView(boolean z);

    public abstract void onPause();

    public abstract void onResume();

    public abstract void pauseAutoPlay();

    public abstract void releaseResources();

    public abstract void resumeAutoPlay();

    public abstract void saveAllPicture(String str, ValueCallback<Integer> valueCallback);

    public abstract void saveCurrentPicture(String str, String str2, boolean z, ValueCallback<Bundle> valueCallback);

    public abstract void setAutoPlayListener(PictureAutoPlayListener pictureAutoPlayListener);

    public abstract void setBackgroundShadowColor(int i);

    public abstract void setBottomBarView(View view, LayoutParams layoutParams);

    public abstract void setLoaderDelegate(LoaderDelegate loaderDelegate);

    public abstract void setNewConfig(PictureViewerConfig pictureViewerConfig);

    public abstract void setOnScaleChangedListener(OnScaleChangedListener onScaleChangedListener);

    public abstract void setShareRecommend(boolean z);

    public abstract void setStatDelegate(PictureViewerStat pictureViewerStat);

    public abstract void setTopBarView(View view, LayoutParams layoutParams);

    public abstract void setTopBottomBarListener(TopBottomBarListener topBottomBarListener);

    public abstract void showAllPictures();

    public abstract void showTopAndBottomBarView(boolean z);

    public abstract boolean updateCurrentFocusTapIndex(int i);

    public PictureViewer(Context context) {
        super(context);
    }
}
