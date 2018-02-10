package com.ucpro.feature.webwindow.e;

import android.graphics.Point;
import android.graphics.Rect;
import com.uc.webview.browser.interfaces.BrowserExtension.TextSelectionClient;
import com.ucpro.feature.u.a;
import com.ucpro.feature.webwindow.bo;
import com.ucpro.feature.webwindow.l.a.f;

/* compiled from: ProGuard */
public final class s extends TextSelectionClient {
    private final bo a;

    public s(bo boVar) {
        this.a = boVar;
        a.a("TextSelectionClientImpl", this);
    }

    public final void showSelectionMenu(boolean z) {
        f freeCopyMenu;
        if (z) {
            freeCopyMenu = this.a.getFreeCopyMenu();
            if (freeCopyMenu != null && !freeCopyMenu.a()) {
                freeCopyMenu.c();
                return;
            }
            return;
        }
        freeCopyMenu = this.a.getFreeCopyMenu();
        if (freeCopyMenu != null && freeCopyMenu.a()) {
            freeCopyMenu.b();
        }
    }

    public final void onUpdateMenuPosition(Point point, Point point2, Rect rect, Rect rect2) {
        this.a.a(point, point2, rect, rect2);
    }

    public final boolean needCustomMenu() {
        return true;
    }

    public final boolean shouldShowShareItem() {
        return false;
    }

    public final boolean onSearchClicked(String str) {
        return true;
    }

    public final boolean onShareClicked(String str) {
        return true;
    }
}
