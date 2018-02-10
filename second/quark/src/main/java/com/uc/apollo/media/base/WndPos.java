package com.uc.apollo.media.base;

import com.uc.apollo.annotation.KeepForRuntime;

@KeepForRuntime
/* compiled from: ProGuard */
public class WndPos implements Cloneable {
    public int h;
    public int screenX;
    public int screenY;
    public int w;
    public int x;
    public int y;

    public WndPos(WndPos wndPos) {
        if (wndPos != null) {
            this.screenX = wndPos.screenX;
            this.screenY = wndPos.screenY;
            this.x = wndPos.x;
            this.y = wndPos.y;
            this.w = wndPos.w;
            this.h = wndPos.h;
        }
    }

    public int getStatusBarHeight() {
        return this.screenY - this.y;
    }

    public WndPos clone() {
        return new WndPos(this);
    }

    public String toString() {
        return "sx/sy/x/y/w/h: " + this.screenX + "/" + this.screenY + "/" + this.x + "/" + this.y + "/" + this.w + "/" + this.h;
    }
}
