package com.uc.pictureviewer.interfaces;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Api;
import java.util.ArrayList;
import java.util.Iterator;

@Api
/* compiled from: ProGuard */
public class PictureDataLoader {
    private ArrayList<Listener> a;
    private boolean b;

    @Api
    /* compiled from: ProGuard */
    public interface Listener {
        void didFinishLoadingPictureData(boolean z, int i, byte[] bArr);
    }

    public PictureDataLoader() {
        this.a = null;
        this.b = false;
        this.a = new ArrayList();
    }

    public void disableLoadPicture() {
        this.b = false;
    }

    public void enableLoadPicture() {
        this.b = true;
    }

    public void addListener(Listener listener) {
        if (this.a != null) {
            this.a.add(listener);
        }
    }

    public void removerListener(Listener listener) {
        if (this.a != null) {
            this.a.remove(listener);
        }
    }

    public void didFinishLoadingPictureData(boolean z, int i, byte[] bArr) {
        Iterator it = ((ArrayList) this.a.clone()).iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).didFinishLoadingPictureData(z, i, bArr);
        }
    }

    public boolean canLoadPictureData() {
        return this.a.size() > 0 && this.b;
    }

    public void loadPictureData(String str, int i, int i2) {
    }

    public void savePicture(String str, String str2, String str3, boolean z, ValueCallback<Bundle> valueCallback) {
    }
}
