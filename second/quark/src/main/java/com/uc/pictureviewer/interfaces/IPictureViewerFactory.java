package com.uc.pictureviewer.interfaces;

import android.content.Context;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public interface IPictureViewerFactory {
    PictureViewer create(Context context, PictureViewerSkinProvider pictureViewerSkinProvider, PictureViewerListener pictureViewerListener, PictureViewerConfig pictureViewerConfig);
}
