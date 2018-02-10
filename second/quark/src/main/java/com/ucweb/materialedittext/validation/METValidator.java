package com.ucweb.materialedittext.validation;

import android.support.annotation.NonNull;

/* compiled from: ProGuard */
public abstract class METValidator {
    protected String errorMessage;

    public abstract boolean isValid(@NonNull CharSequence charSequence, boolean z);

    public METValidator(@NonNull String str) {
        this.errorMessage = str;
    }

    public void setErrorMessage(@NonNull String str) {
        this.errorMessage = str;
    }

    @NonNull
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
