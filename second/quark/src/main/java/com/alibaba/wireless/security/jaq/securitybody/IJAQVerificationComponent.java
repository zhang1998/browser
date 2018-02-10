package com.alibaba.wireless.security.jaq.securitybody;

import com.alibaba.wireless.security.jaq.JAQException;
import com.alibaba.wireless.security.open.IComponent;
import java.util.HashMap;

/* compiled from: ProGuard */
public interface IJAQVerificationComponent extends IComponent {
    String doJAQVerfificationSync(HashMap<String, String> hashMap, int i) throws JAQException;
}
