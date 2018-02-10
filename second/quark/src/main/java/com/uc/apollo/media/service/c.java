package com.uc.apollo.media.service;

import android.net.Uri;
import android.os.RemoteException;
import com.uc.apollo.Settings.Provider;

/* compiled from: ProGuard */
final class c implements Provider {
    final /* synthetic */ BnMediaPlayerService a;

    c(BnMediaPlayerService bnMediaPlayerService) {
        this.a = bnMediaPlayerService;
    }

    public final String getStringValue(String str) {
        String str2 = null;
        try {
            if (this.a.g != null) {
                str2 = this.a.g.a(str);
            }
        } catch (RemoteException e) {
        }
        return str2;
    }

    public final int getIntValue(String str) {
        try {
            return (this.a.g != null ? Integer.valueOf(this.a.g.b(str)) : null).intValue();
        } catch (RemoteException e) {
            return 0;
        }
    }

    public final float getFloatValue(String str) {
        try {
            return (this.a.g != null ? Float.valueOf(this.a.g.c(str)) : null).floatValue();
        } catch (RemoteException e) {
            return 0.0f;
        }
    }

    public final boolean getBoolValue(String str) {
        try {
            return (this.a.g != null ? Boolean.valueOf(this.a.g.d(str)) : null).booleanValue();
        } catch (RemoteException e) {
            return false;
        }
    }

    public final String getCookie(Uri uri) {
        try {
            if (this.a.g == null) {
                return null;
            }
            return this.a.g.e(uri != null ? uri.toString() : "");
        } catch (RemoteException e) {
            return "";
        }
    }

    public final String getUserAgent(Uri uri) {
        try {
            if (this.a.g == null) {
                return null;
            }
            return this.a.g.f(uri != null ? uri.toString() : "");
        } catch (RemoteException e) {
            return "";
        }
    }
}
