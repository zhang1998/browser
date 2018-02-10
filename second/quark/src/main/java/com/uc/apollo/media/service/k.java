package com.uc.apollo.media.service;

import com.uc.apollo.media.LittleWindowController;
import com.uc.apollo.media.base.WndPos;

/* compiled from: ProGuard */
final class k implements LittleWindowController {
    final /* synthetic */ j a;
    private WndPos b = new WndPos();

    k(j jVar) {
        this.a = jVar;
    }

    public final WndPos getWinPosition() {
        int[] iArr = new int[2];
        this.a.getLocationOnScreen(iArr);
        this.b.screenX = iArr[0];
        this.b.screenY = iArr[1];
        this.b.x = this.a.f.x;
        this.b.y = this.a.f.y;
        this.b.w = this.a.f.width;
        this.b.h = this.a.f.height;
        return this.b;
    }

    public final void pause() {
        if (this.a.m != null) {
            this.a.m.c();
        }
    }

    public final void play() {
        if (this.a.m != null) {
            this.a.m.b();
        }
    }

    public final void seekTo(int i) {
        if (this.a.m != null) {
            this.a.m.b(i);
        }
    }

    public final void moveTo(int i, int i2, int i3, int i4) {
        if (this.a.f != null) {
            this.a.f.x = i;
            this.a.f.y = i2;
            this.a.f.width = i3;
            this.a.f.height = i4;
            this.a.d.a(this.a.e, this.a, this.a.f, j.b);
        }
    }

    public final void maximize() {
        this.a.m.e();
    }

    public final void close() {
        if (this.a.m != null) {
            this.a.m.d();
        }
    }
}
