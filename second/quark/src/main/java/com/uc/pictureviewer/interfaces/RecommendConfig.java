package com.uc.pictureviewer.interfaces;

import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public class RecommendConfig {
    public int bottomMargin = 0;
    public boolean enablePullToRefresh = false;
    public LayoutStyle layoutStyle = LayoutStyle.FlatLayout;
    public int leftMargin = 0;
    public int rightMargin = 0;
    public int topMargin = 12;

    @Api
    /* compiled from: ProGuard */
    public enum LayoutStyle {
        FlatLayout,
        FullLayout
    }
}
