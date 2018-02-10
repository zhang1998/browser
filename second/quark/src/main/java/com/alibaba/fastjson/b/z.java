package com.alibaba.fastjson.b;

/* compiled from: ProGuard */
public enum z {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    BrowserCompatible,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    DisableCheckSpecialChar,
    BeanToArray,
    WriteNonStringKeyAsString,
    NotWriteDefaultValue;
    
    public static final z[] y = null;
    public final int x;

    static {
        y = new z[0];
    }

    public static int a(z[] zVarArr) {
        int i = 0;
        if (zVarArr != null) {
            int i2 = 0;
            while (i2 < zVarArr.length) {
                int i3 = zVarArr[i2].x | i;
                i2++;
                i = i3;
            }
        }
        return i;
    }
}
