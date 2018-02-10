package com.uc.pictureviewer.interfaces;

import com.uc.webview.export.annotations.Api;
import java.util.Map;

@Api
/* compiled from: ProGuard */
public interface PictureViewerStat {
    void updateStat(String str, Map<String, Integer> map, Map<String, String> map2);
}
