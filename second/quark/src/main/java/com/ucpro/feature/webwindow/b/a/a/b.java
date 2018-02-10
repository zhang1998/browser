package com.ucpro.feature.webwindow.b.a.a;

import android.webkit.ValueCallback;
import com.uc.pictureviewer.interfaces.PictureInfo;
import com.uc.pictureviewer.interfaces.PictureInfoLoader;
import com.ucpro.feature.webwindow.b.a.c;
import com.ucpro.feature.webwindow.b.a.d;
import com.ucpro.feature.webwindow.e.k;

/* compiled from: ProGuard */
public final class b extends PictureInfoLoader {
    private d a;

    public b(d dVar) {
        this.a = dVar;
    }

    public final boolean startLoadPictureInfo() {
        boolean z = (this.a == null || this.a.a == null || this.a.a.isEmpty()) ? false : true;
        if (z) {
            for (c cVar : this.a.a) {
                PictureInfo pictureInfo = new PictureInfo(cVar.a, cVar.b, null, null);
                pictureInfo.setPictureDataLoader(new a());
                onReceivePictureInfo(pictureInfo);
            }
        }
        return z;
    }

    public final void saveAllPicture(String str, ValueCallback<Integer> valueCallback) {
        if (this.a != null && this.a.a != null && !this.a.a.isEmpty()) {
            for (c cVar : this.a.a) {
                k.a(cVar.b, null, null);
            }
        }
    }
}
