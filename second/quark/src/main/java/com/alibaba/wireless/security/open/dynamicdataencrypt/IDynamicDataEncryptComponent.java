package com.alibaba.wireless.security.open.dynamicdataencrypt;

import com.alibaba.wireless.security.open.IComponent;
import com.alibaba.wireless.security.open.SecException;

public interface IDynamicDataEncryptComponent extends IComponent {
    String dynamicDecrypt(String str) throws SecException;

    byte[] dynamicDecryptByteArray(byte[] bArr) throws SecException;

    String dynamicEncrypt(String str) throws SecException;

    byte[] dynamicEncryptByteArray(byte[] bArr) throws SecException;
}
