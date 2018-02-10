package com.uc.pictureviewer.interfaces;

import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Api;
import java.util.ArrayList;
import java.util.Iterator;

@Api
/* compiled from: ProGuard */
public class PictureInfoLoader {
    private ArrayList<Listener> a;
    protected boolean mIsLoading;

    @Api
    /* compiled from: ProGuard */
    public interface Listener {
        void onLoadFinished(boolean z);

        void onLoadStarted();

        void onReceivePictureInfo(PictureInfo pictureInfo, int i);

        void onRemovePictureInfo(PictureInfo pictureInfo);

        void onUpdateFocusPictureInfo(PictureInfo pictureInfo);

        void onUpdatePictureInfo(PictureInfo pictureInfo);
    }

    public PictureInfoLoader() {
        this.a = null;
        this.mIsLoading = false;
        this.a = new ArrayList();
    }

    public void addListener(Listener listener) {
        if (this.a != null) {
            this.a.add(listener);
        }
    }

    public void removeListener(Listener listener) {
        if (this.a != null) {
            this.a.remove(listener);
        }
    }

    public void onLoadStarted() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onLoadStarted();
        }
    }

    public void onLoadFinished(boolean z) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onLoadFinished(z);
        }
    }

    public void onReceivePictureInfo(PictureInfo pictureInfo, int i) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onReceivePictureInfo(pictureInfo, i);
        }
    }

    public void onReceivePictureInfo(PictureInfo pictureInfo) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onReceivePictureInfo(pictureInfo, -1);
        }
    }

    public void onRemovePictureInfo(PictureInfo pictureInfo) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onRemovePictureInfo(pictureInfo);
        }
    }

    public void onUpdatePictureInfo(PictureInfo pictureInfo) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onUpdatePictureInfo(pictureInfo);
        }
    }

    public void onUpdateFocusPictureInfo(PictureInfo pictureInfo) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onUpdateFocusPictureInfo(pictureInfo);
        }
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    public boolean startLoadPictureInfo() {
        if (this.mIsLoading) {
            return false;
        }
        this.mIsLoading = true;
        onLoadStarted();
        return true;
    }

    public void destroy() {
        this.a = null;
    }

    public boolean canLoadMorePictureInfo(boolean z) {
        return true;
    }

    public boolean hasMoreToLoad(boolean z) {
        return true;
    }

    public boolean isSupportToLoadMore() {
        return false;
    }

    public boolean loadMorePictureInfo(boolean z, ValueCallback<Boolean> valueCallback) {
        if (canLoadMorePictureInfo(z)) {
            onLoadStarted();
            return true;
        }
        onLoadFinished(false);
        if (valueCallback == null) {
            return false;
        }
        valueCallback.onReceiveValue(Boolean.valueOf(false));
        return false;
    }

    public boolean stopLoadPictureInfo(boolean z) {
        if (!this.mIsLoading) {
            return false;
        }
        this.mIsLoading = false;
        onLoadFinished(z);
        return true;
    }

    public void saveAllPicture(String str, ValueCallback<Integer> valueCallback) {
        if (valueCallback != null) {
            valueCallback.onReceiveValue(Integer.valueOf(0));
        }
    }
}
