package com.taobao.weex.ui.view.a;

/* compiled from: ProGuard */
public enum e implements f {
    ACTION_DOWN("touchstart"),
    ACTION_MOVE("touchmove"),
    ACTION_UP("touchend"),
    ACTION_CANCEL("touchcancel");
    
    private String e;

    private e(String str) {
        this.e = str;
    }

    public final String toString() {
        return this.e;
    }
}
