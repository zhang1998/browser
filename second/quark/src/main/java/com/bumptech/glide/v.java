package com.bumptech.glide;

import com.bumptech.glide.f.b.b;
import com.bumptech.glide.f.b.d;

/* compiled from: ProGuard */
public abstract class v<CHILD extends v<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    d<? super TranscodeType> a = b.a();

    protected /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    protected final CHILD a() {
        try {
            return (v) super.clone();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
