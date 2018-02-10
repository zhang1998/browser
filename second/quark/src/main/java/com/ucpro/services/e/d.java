package com.ucpro.services.e;

import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.Context;

/* compiled from: ProGuard */
final class d implements OnPrimaryClipChangedListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void onPrimaryClipChanged() {
        a aVar = this.a;
        if (aVar.d != null && aVar.d.get() != null) {
            ClipboardManager clipboardManager = (ClipboardManager) ((Context) aVar.d.get()).getApplicationContext().getSystemService("clipboard");
            if (clipboardManager != null) {
                try {
                    if (clipboardManager.hasText()) {
                        CharSequence text = clipboardManager.getText();
                        if (text != null) {
                            aVar.g = text.toString();
                            aVar.a = System.currentTimeMillis();
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
    }
}
