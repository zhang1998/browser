package com.ucweb.materialedittext.validation;

import android.support.annotation.NonNull;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public class RegexpValidator extends METValidator {
    private Pattern pattern;

    public RegexpValidator(@NonNull String str, @NonNull String str2) {
        super(str);
        this.pattern = Pattern.compile(str2);
    }

    public RegexpValidator(@NonNull String str, @NonNull Pattern pattern) {
        super(str);
        this.pattern = pattern;
    }

    public boolean isValid(@NonNull CharSequence charSequence, boolean z) {
        return this.pattern.matcher(charSequence).matches();
    }
}
