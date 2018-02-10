package com.uc.pictureviewer.interfaces;

import com.uc.pictureviewer.interfaces.PictureDataLoader.Listener;
import com.uc.pictureviewer.interfaces.PictureInfo.LoadStatus;

/* compiled from: ProGuard */
final class a implements Listener {
    final /* synthetic */ PictureInfo a;

    private a(PictureInfo pictureInfo) {
        this.a = pictureInfo;
    }

    public final void didFinishLoadingPictureData(boolean z, int i, byte[] bArr) {
        if (!z || bArr == null) {
            this.a.setLoadStatus(LoadStatus.FAILED);
        } else {
            this.a.j = i;
        }
    }
}
