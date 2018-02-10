package com.tencent.tinker.loader;

/* compiled from: ProGuard */
public class TinkerRuntimeException extends RuntimeException {
    private static final String TINKER_RUNTIME_EXCEPTION_PREFIX = "Tinker Exception:";
    private static final long serialVersionUID = 1;

    public TinkerRuntimeException(String str) {
        super(new StringBuilder(TINKER_RUNTIME_EXCEPTION_PREFIX).append(str).toString());
    }

    public TinkerRuntimeException(String str, Throwable th) {
        super(new StringBuilder(TINKER_RUNTIME_EXCEPTION_PREFIX).append(str).toString(), th);
    }
}
