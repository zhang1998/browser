package com.uc.webview.browser.interfaces;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.annotations.Interface;
import java.util.HashMap;

@Interface
/* compiled from: ProGuard */
public class HCAdAdapterClient {
    public static final int DEFAULT_ROUNDED = 16;
    public static final int ICON_ANGLE = 2;
    public static final int ICON_ROUND = 1;

    @Api
    /* compiled from: ProGuard */
    public class AdConfigs {
        public String mActionButtonText;
        public Drawable mCloseButtonDrawable = null;
        public int mCloseHeight;
        public int mCloseWidth;
        public int mIconHeight;
        public int mIconHorizontalPadding = 16;
        public int mIconWidth;
        public boolean mIsActionButtonEnable = false;
        public boolean mIsCloseButtonEnable = false;
        public boolean mIsShowTagFrame = true;
        public boolean mIsTagEnable = true;
        public int mTextVerticalPadding = 12;
    }

    @Api
    /* compiled from: ProGuard */
    public class AdLoadConfigs {
        public int mAdHeight = -1;
        public long mAdValidTime = 0;
        public int mAdWidth = -1;
        public boolean mIsIgnoreDisplayInterval = false;
        public boolean mIsOnlyStaticRes = true;
        public DataLevel mLoadLevel = DataLevel.NETWORK_SERVER;
        public boolean mPreloadImage = false;
        public DataLevel mRefreshLevel = DataLevel.MEMORY_HEAP;
    }

    @Api
    /* compiled from: ProGuard */
    public class AdTheme {
        public int mBgColor = -1;
        public int mCornerMarkBgColor = -1;
        public int mCornerMarkTextColor = -16777216;
        public float mCornerMarkTextSize = 14.0f;
        public int mIconStyle = 1;
        public int mImageMaskColor = 0;
        public int mImageRadius = 16;
        public ScaleType mImageScaleType = ScaleType.FIT_XY;
        public int mSubTitleColor = -16777216;
        public float mSubTitleTextSize = 14.0f;
        public int mTagTextColor = 4699048;
        public int mTagTextSize = 11;
        public int mTitleColor = -16777216;
        public float mTitleTextSize = 16.0f;
    }

    @Api
    /* compiled from: ProGuard */
    public enum DataLevel {
        MEMORY_HEAP(1),
        PERSISTENCE(2),
        NETWORK_SERVER(3);
        
        private int a;

        private DataLevel(int i) {
            this.a = i;
        }

        public final int value() {
            return this.a;
        }
    }

    @Api
    /* compiled from: ProGuard */
    public interface IAdLoadListener {
        void onAdError(String str, int i);

        void onAdLoadSuccess(String str, HashMap<String, String> hashMap);

        void onAdLoading(String str);
    }

    @Api
    /* compiled from: ProGuard */
    public interface IAdViewActionListener {
        void onAdActionClick(View view, String str);

        void onAdBeforeShow(View view, String str, HashMap<String, String> hashMap);

        void onAdClicked(View view, String str);

        void onAdClosed(View view, String str, int i);

        void onAdShowError(View view, String str, int i);

        void onAdShowed(View view, String str);
    }

    public String getSlotId(String str, int i, int[] iArr) {
        return "";
    }

    public String getSlotId() {
        return "";
    }

    public void dismiss() {
    }

    public void dismissDelay(long j) {
    }

    public void showAd(String str, ViewGroup viewGroup, LayoutParams layoutParams, AdConfigs adConfigs, AdTheme adTheme, IAdViewActionListener iAdViewActionListener) {
    }

    public void loadAd(String str, AdLoadConfigs adLoadConfigs, IAdLoadListener iAdLoadListener) {
    }

    public void releaseAd(String str) {
    }
}
