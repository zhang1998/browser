package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.support.v7.app.ap;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;

/* compiled from: ProGuard */
final class w implements OnClickListener, OnDismissListener, OnKeyListener, m {
    u a;
    ap b;
    b c;
    private m d;

    public w(u uVar) {
        this.a = uVar;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.b.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.b.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.a.a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.a.performShortcut(i, keyEvent, 0);
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.c.a(this.a, true);
    }

    public final void a(u uVar, boolean z) {
        if ((z || uVar == this.a) && this.b != null) {
            this.b.dismiss();
        }
        if (this.d != null) {
            this.d.a(uVar, z);
        }
    }

    public final boolean a(u uVar) {
        if (this.d != null) {
            return this.d.a(uVar);
        }
        return false;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a((i) this.c.a().getItem(i), null, 0);
    }
}
