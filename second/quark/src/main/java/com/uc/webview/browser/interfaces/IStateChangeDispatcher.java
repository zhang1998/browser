package com.uc.webview.browser.interfaces;

import com.uc.webview.export.annotations.Interface;

@Deprecated
@Interface
/* compiled from: ProGuard */
public interface IStateChangeDispatcher {
    public static final int STATE_ACTIVE_ADDRESS_BAR = 5;
    public static final int STATE_FORE_BACK_GROUND = 2;
    public static final int STATE_JUMP_HOME_PAGE = 4;
    public static final int STATE_NETWORK_CHANGED = 1;
    public static final int STATE_OPEN_BOOKMARK = 3;
    public static final int STATE_OPEN_NEW_WIN = 6;
    public static final int STATE_SHELL_IS_DOWNLOADING = 7;
    public static final boolean VIEW_STATE_BACKGROUND = false;
    public static final boolean VIEW_STATE_FOREGROUND = true;

    @Deprecated
    void notifyStateChanged(int i, Object obj);
}
