package com.uc.pictureviewer.interfaces;

import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.uc.webview.export.annotations.Api;
import java.util.HashMap;

@Api
/* compiled from: ProGuard */
public abstract class PictureViewerAdRuler {
    protected String mType = "PictureViewerAdRuler";

    @Api
    /* compiled from: ProGuard */
    public class AdLoadCallBack {
        public PictureInfo adInfo;
        public boolean sucess;

        public AdLoadCallBack(boolean z, PictureInfo pictureInfo) {
            this.sucess = z;
            this.adInfo = pictureInfo;
        }
    }

    @Api
    /* compiled from: ProGuard */
    public class AdMatchAdapter {
        HashMap<String, Object> a = null;

        public void addProperty(String str, Object obj) {
            if (this.a == null) {
                this.a = new HashMap();
            }
            this.a.put(str, obj);
        }

        public Object getProperty(String str) {
            if (this.a == null) {
                return null;
            }
            return this.a.get(str);
        }

        public int match(int i, int i2, int i3, int i4) {
            return -1;
        }
    }

    public abstract boolean isAdShownInNewTabView();

    public abstract boolean isRecommendPageAd();

    public abstract void load(ValueCallback<AdLoadCallBack> valueCallback);

    public abstract int match(int i, int i2, int i3, int i4);

    public abstract void show(FrameLayout frameLayout, PictureInfo pictureInfo, ValueCallback<Boolean> valueCallback);

    public String getAdType() {
        return this.mType;
    }

    public void setAdType(String str) {
        this.mType = str;
    }

    public void setMatchAdapter(AdMatchAdapter adMatchAdapter) {
    }
}
