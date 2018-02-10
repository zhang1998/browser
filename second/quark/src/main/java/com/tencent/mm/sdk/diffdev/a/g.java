package com.tencent.mm.sdk.diffdev.a;

import com.alibaba.wireless.security.SecExceptionCode;

public enum g {
    UUID_EXPIRED(SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY),
    UUID_CANCELED(SecExceptionCode.SEC_ERROR_DYN_ENC_GET_SYS_PROPERTIES_FAILED),
    UUID_SCANED(SecExceptionCode.SEC_ERROR_DYN_ENC_GET_DATA_FILE_KEY_FAILED),
    UUID_CONFIRM(SecExceptionCode.SEC_ERROR_DYN_ENC_GET_ENCRYPT_KEY_FAILED),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(SecExceptionCode.SEC_ERROR_DYN_STORE);
    
    private int code;

    private g(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    public final String toString() {
        return "UUIDStatusCode:" + this.code;
    }
}
