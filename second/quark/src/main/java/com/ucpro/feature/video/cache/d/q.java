package com.ucpro.feature.video.cache.d;

import com.alibaba.wireless.security.SecExceptionCode;

/* compiled from: ProGuard */
public enum q implements g {
    SWITCH_PROTOCOL(101, "Switching Protocols"),
    OK(200, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NO_CONTENT(SecExceptionCode.SEC_ERROR_STA_STORE_INCORRECT_DATA_FILE, "No Content"),
    PARTIAL_CONTENT(SecExceptionCode.SEC_ERROR_STA_STORE_KEY_NOT_EXSITED, "Partial Content"),
    REDIRECT(SecExceptionCode.SEC_ERROR_STA_INVALID_PARAM, "Moved Permanently"),
    NOT_MODIFIED(SecExceptionCode.SEC_ERROR_STA_INCORRECT_DATA_FILE, "Not Modified"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(SecExceptionCode.SEC_ERROR_DYN_ENC_GET_SYS_PROPERTIES_FAILED, "Forbidden"),
    NOT_FOUND(SecExceptionCode.SEC_ERROR_DYN_ENC_GET_DATA_FILE_KEY_FAILED, "Not Found"),
    METHOD_NOT_ALLOWED(SecExceptionCode.SEC_ERROR_DYN_ENC_GET_ENCRYPT_KEY_FAILED, "Method Not Allowed"),
    RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
    INTERNAL_ERROR(SecExceptionCode.SEC_ERROR_DYN_STORE, "Internal Server Error");
    
    private final int p;
    private final String q;

    private q(int i, String str) {
        this.p = i;
        this.q = str;
    }

    public final String a() {
        return this.p + " " + this.q;
    }
}
