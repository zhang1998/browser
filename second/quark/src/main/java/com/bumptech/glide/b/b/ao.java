package com.bumptech.glide.b.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.IOException;

/* compiled from: ProGuard */
final class ao implements Appendable {
    private final Appendable a;
    private boolean b = true;

    ao(Appendable appendable) {
        this.a = appendable;
    }

    public final Appendable append(char c) throws IOException {
        boolean z = false;
        if (this.b) {
            this.b = false;
            this.a.append("  ");
        }
        if (c == '\n') {
            z = true;
        }
        this.b = z;
        this.a.append(c);
        return this;
    }

    public final Appendable append(@Nullable CharSequence charSequence) throws IOException {
        CharSequence a = a(charSequence);
        return append(a, 0, a.length());
    }

    public final Appendable append(@Nullable CharSequence charSequence, int i, int i2) throws IOException {
        boolean z = false;
        CharSequence a = a(charSequence);
        if (this.b) {
            this.b = false;
            this.a.append("  ");
        }
        if (a.length() > 0 && a.charAt(i2 - 1) == '\n') {
            z = true;
        }
        this.b = z;
        this.a.append(a, i, i2);
        return this;
    }

    @NonNull
    private static CharSequence a(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return "";
        }
        return charSequence;
    }
}
