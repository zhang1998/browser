package com.taobao.weex.ui.view.a;

/* compiled from: ProGuard */
public enum d implements f {
    SWIPE("swipe"),
    LONG_PRESS("longpress"),
    PAN_START("panstart"),
    PAN_MOVE("panmove"),
    PAN_END("panend"),
    HORIZONTALPAN("horizontalpan"),
    VERTICALPAN("verticalpan");
    
    private String h;

    private d(String str) {
        this.h = str;
    }

    public final String toString() {
        return this.h;
    }
}
