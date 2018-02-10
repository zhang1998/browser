package com.uc.base.b.c;

import java.util.Stack;

/* compiled from: ProGuard */
final class n {
    static void a(m mVar, StringBuffer stringBuffer, String str, boolean z) {
        if (mVar != null) {
            Stack stack;
            String str2 = "Struct:";
            if (mVar instanceof l) {
                str2 = "RepeatedStruct:";
            }
            if (!z && mVar.g != null) {
                stack = new Stack();
                stack.push(mVar);
                m mVar2 = mVar;
                while (true) {
                    mVar2 = mVar2.g;
                    if (mVar2 == null) {
                        break;
                    }
                    stack.push(mVar2);
                }
            } else {
                stack = null;
            }
            if (stack != null) {
                stringBuffer.append(str).append(str2 + mVar.b + ":" + mVar.a()).append("{\r\n");
                while (!stack.empty()) {
                    a((m) stack.pop(), stringBuffer, str + "    ", true);
                }
                stringBuffer.append(str).append("}\r\n");
                return;
            }
            String str3;
            StringBuffer append = stringBuffer.append(str);
            StringBuilder stringBuilder = new StringBuilder();
            if (z) {
                str3 = "Class:";
            } else {
                str3 = str2;
            }
            append.append(stringBuilder.append(str3).append(mVar.b).append(":").append(mVar.a()).toString()).append("{\r\n");
            int q = mVar.q();
            for (int i = 0; i < q; i++) {
                e h = mVar.h(i);
                if (h != null) {
                    if (h instanceof m) {
                        a((m) h, stringBuffer, str + "    ", false);
                    } else {
                        h = mVar.h(i);
                        String str4 = str + "    ";
                        if (h != null) {
                            stringBuffer.append(str4).append("Field:").append(h.a).append("=").append(h.toString()).append("\r\n");
                        }
                    }
                }
            }
            stringBuffer.append(str).append("}\r\n");
        }
    }
}
