package com.uc.webview.browser.interfaces;

import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.FrameLayout.LayoutParams;
import com.uc.webview.export.annotations.Interface;
import java.util.HashMap;

@Interface
/* compiled from: ProGuard */
public interface PictureViewer {
    public static final int PAUSE_AUTOPLAY_ITEM = 2;
    public static final int RESUME_AUTOPLAY_ITEM = 1;

    @Interface
    /* compiled from: ProGuard */
    public enum ClickType {
        Unknown,
        NavItem
    }

    @Interface
    /* compiled from: ProGuard */
    public enum DisplayMode {
        Unknown,
        Normal,
        HD,
        AutoPlay
    }

    @Interface
    /* compiled from: ProGuard */
    public enum DisplayType {
        Unkown,
        Navigation,
        MainPicture,
        AllPicture,
        Cover,
        Exited
    }

    @Interface
    /* compiled from: ProGuard */
    public enum ExitType {
        Unknown,
        SlideDown,
        SlideRight,
        TopButton,
        Click,
        BackPress
    }

    @Interface
    /* compiled from: ProGuard */
    public interface Listener {
        void onOpenImageDoc(String str);

        void onPictureViewerClosed(PictureViewer pictureViewer);

        void onPictureViewerEnable(boolean z, int i);

        void onPictureViewerInitConfig(HashMap<String, Boolean> hashMap);

        void onPictureViewerOpened(PictureViewer pictureViewer);
    }

    @Interface
    /* compiled from: ProGuard */
    public interface OnAutoPlayListener {
        void onAutoPlayStateChanged(boolean z);
    }

    @Interface
    /* compiled from: ProGuard */
    public interface OnClickListener {
        boolean onClick(ClickType clickType, String str);
    }

    @Interface
    /* compiled from: ProGuard */
    public interface OnDataPolicyRequestListener {
        boolean onRequestHDImageFetchingPolicy(ValueCallback<Boolean> valueCallback);
    }

    @Interface
    /* compiled from: ProGuard */
    public interface OnDisplayModeChangedListener {
        void onDisplayModeChanged(DisplayMode displayMode);
    }

    @Interface
    /* compiled from: ProGuard */
    public interface OnDisplayTypeChangedListener {
        void onDisplayTypeChanged(DisplayType displayType, DisplayType displayType2);
    }

    @Interface
    /* compiled from: ProGuard */
    public interface OnTabChangeListener {
        void onTabChanged(int i, int i2);

        void onTabCountChanged(int i);
    }

    @Interface
    /* compiled from: ProGuard */
    public interface ResourceFetchDelegate {
        void downloadResource(String str, boolean z, ValueCallback<byte[]> valueCallback);
    }

    View asView();

    void enableExitOnClick();

    int getCountOfPictureBeViewed();

    int getCurrentCustomPicturesId();

    ExitType getCurrentExitType();

    int getCurrentPictureDataSize();

    int getCurrentPictureHeight();

    String getCurrentPictureUrl();

    int getCurrentPictureWidth();

    DisplayMode getDisplayMode();

    int getPictureCount();

    int getPictureCountOfCurrentWindow();

    boolean isCustomDisplayMode();

    void onBottomTopBarItemClick(int i);

    void saveAllPicture(String str, ValueCallback<Integer> valueCallback);

    void saveCurrentPicture(String str, String str2, boolean z, ValueCallback<Bundle> valueCallback);

    boolean setBottomBarView(View view, LayoutParams layoutParams);

    void setOnDisplayTypeChangedListener(OnDisplayTypeChangedListener onDisplayTypeChangedListener);

    void setPictureViewerOnAutoPlayListener(OnAutoPlayListener onAutoPlayListener);

    void setPictureViewerOnClickListener(OnClickListener onClickListener);

    void setPictureViewerOnDataPolicyRequestListener(OnDataPolicyRequestListener onDataPolicyRequestListener);

    void setPictureViewerOnDisplayModeChangedListener(OnDisplayModeChangedListener onDisplayModeChangedListener);

    void setPictureViewerOnTabChangeListener(OnTabChangeListener onTabChangeListener);

    boolean setTopBarView(View view, LayoutParams layoutParams);

    boolean updateCurrentFocusIndex(int i);

    boolean updateCurrentFocusTapIndex(int i);
}
