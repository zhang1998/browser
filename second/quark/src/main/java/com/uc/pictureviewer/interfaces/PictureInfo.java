package com.uc.pictureviewer.interfaces;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.uc.pictureviewer.interfaces.PictureDataLoader.Listener;
import com.uc.webview.export.annotations.Api;
import java.util.HashMap;

@Api
/* compiled from: ProGuard */
public class PictureInfo {
    public static final String Type = "Picture";
    HashMap<String, Object> a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private LoadStatus g;
    private int h;
    private int i;
    private int j;
    private String k;
    private int l;
    private int m;
    private PictureDataLoader n;
    private a o;
    private boolean p;
    private long q;

    @Api
    /* compiled from: ProGuard */
    public enum LoadStatus {
        UNLOAD,
        LOADING,
        SUCCESS,
        FAILED
    }

    public void addExternalProperty(String str, Object obj) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, obj);
    }

    public Object getExternalProperty(String str) {
        if (this.a == null) {
            return null;
        }
        return this.a.get(str);
    }

    public void setInitFocus(int i, int i2) {
        if (i >= 0 && i <= 100 && i2 >= 0 && i2 <= 100) {
            this.l = i;
            this.m = i2;
        }
    }

    public String getType() {
        return this.k;
    }

    public void setType(String str) {
        this.k = str;
    }

    public PictureInfo(String str, String str2, String str3, String str4) {
        this.k = Type;
        this.l = 0;
        this.m = 0;
        this.p = false;
        this.a = null;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.g = LoadStatus.UNLOAD;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.o = new a();
    }

    public PictureInfo(String str, String str2, LoadStatus loadStatus, int i, int i2, int i3) {
        this.k = Type;
        this.l = 0;
        this.m = 0;
        this.p = false;
        this.a = null;
        this.b = null;
        this.c = str;
        this.d = str2;
        this.e = null;
        this.g = loadStatus;
        this.h = i;
        this.i = i2;
        this.j = i3;
        this.o = new a();
    }

    public boolean equals(String str) {
        if (this.c == str) {
            return true;
        }
        if (this.c == null || str == null || !this.c.equals(str)) {
            return false;
        }
        return true;
    }

    public void setPictureDataLoader(PictureDataLoader pictureDataLoader) {
        removePictureDataLoaderListener(this.o);
        this.n = pictureDataLoader;
        addPictureDataLoaderListener(this.o);
    }

    public void addPictureDataLoaderListener(Listener listener) {
        if (this.n != null) {
            this.n.addListener(listener);
        }
    }

    public void removePictureDataLoaderListener(Listener listener) {
        if (this.n != null) {
            this.n.removerListener(listener);
        }
    }

    public void disableLoadPicture() {
        if (this.n != null) {
            this.n.disableLoadPicture();
        }
    }

    public void enableLoadPicture() {
        if (this.n != null) {
            this.n.enableLoadPicture();
        }
    }

    public boolean startLoadPictureData() {
        return startLoadPictureData(-1, -1);
    }

    public boolean startLoadPictureData(int i, int i2) {
        if (this.n == null || !this.n.canLoadPictureData()) {
            return false;
        }
        this.n.loadPictureData(this.c, i, i2);
        return true;
    }

    public void savePicture(String str, String str2, boolean z, ValueCallback<Bundle> valueCallback) {
        if (this.n != null && str != null && str2 != null) {
            this.n.savePicture(str, str2, this.c, z, valueCallback);
        } else if (valueCallback != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("succeed", false);
            valueCallback.onReceiveValue(bundle);
        }
    }

    public void setHref(String str) {
        this.e = str;
    }

    public String getHref() {
        return this.e;
    }

    public void setPictureTitle(String str) {
        this.b = str;
    }

    public String getPictureTitle() {
        return this.b;
    }

    public void setPictureUrl(String str) {
        this.c = str;
    }

    public String getPictureUrl() {
        return this.c;
    }

    public void setPrePictureUrl(String str) {
        this.d = str;
    }

    public String getPrePictureUrl() {
        return this.d;
    }

    public void setLoadStatus(LoadStatus loadStatus) {
        this.g = loadStatus;
    }

    public LoadStatus getLoadStatus() {
        return this.g;
    }

    public void setPictureSize(int i, int i2) {
        this.h = i;
        this.i = i2;
    }

    public void setUseOpt(boolean z) {
        this.p = z;
    }

    public boolean getUseOpt() {
        return this.p;
    }

    public void setReceivedJsonTime(long j) {
        this.q = j;
    }

    public long getReceivedJsonTime() {
        return this.q;
    }

    public void setPictureWidth(int i) {
        this.h = i;
    }

    public void setPictureHeight(int i) {
        this.i = i;
    }

    public int getPictureWidth() {
        return this.h;
    }

    public int getPictureHeight() {
        return this.i;
    }

    public void setPictureDataSize(int i) {
        this.j = i;
    }

    public int getPictureDataSize() {
        return this.j;
    }

    public int getInitFocusX() {
        return this.l;
    }

    public int getInitFocusY() {
        return this.m;
    }

    public String getDescription() {
        return this.f;
    }

    public void setDescription(String str) {
        this.f = str;
    }
}
