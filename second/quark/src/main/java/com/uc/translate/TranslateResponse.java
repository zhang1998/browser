package com.uc.translate;

import android.support.annotation.Keep;
import com.alibaba.fastjson.annotation.JSONField;

/* compiled from: ProGuard */
class TranslateResponse {
    @Keep
    @JSONField(name = "error_response")
    public TranslateError mTranslateError;
    @Keep
    @JSONField(name = "alibaba_intl_translationplatform_translate_response")
    public TranslateText mTranslateText;

    /* compiled from: ProGuard */
    public class TranslateError {
        @Keep
        @JSONField(name = "code")
        public int mCode;
        @Keep
        @JSONField(name = "msg")
        public String mErrorMsg;
        @Keep
        @JSONField(name = "request_id")
        public String mRequestId;
    }

    /* compiled from: ProGuard */
    public class TranslateText {
        @Keep
        @JSONField(name = "request_id")
        public String mRequestId;
        @Keep
        @JSONField(name = "translated_text")
        public String mTranslated;
    }

    TranslateResponse() {
    }
}
