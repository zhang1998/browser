package com.bumptech.glide;

import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public enum f {
    LOW(0.5f),
    NORMAL(IPictureView.DEFAULT_MIN_SCALE),
    HIGH(1.5f);
    
    private float d;

    private f(float f) {
        this.d = f;
    }
}
