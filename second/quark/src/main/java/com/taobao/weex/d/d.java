package com.taobao.weex.d;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class d {
    private static Map<String, String> a;

    static {
        Map hashMap = new HashMap();
        a = hashMap;
        hashMap.put("100", "Continue");
        a.put("101", "Switching Protocol");
        a.put("200", "OK");
        a.put("201", "Created");
        a.put("202", "Accepted");
        a.put("203", "Non-Authoritative Information");
        a.put("204", "No Content");
        a.put("205", "Reset Content");
        a.put("206", "Partial Content");
        a.put("300", "Multiple Choice");
        a.put("301", "Moved Permanently");
        a.put("302", "Found");
        a.put("303", "See Other");
        a.put("304", "Not Modified");
        a.put("305", "Use Proxy");
        a.put("306", "unused");
        a.put("307", "Temporary Redirect");
        a.put("308", "Permanent Redirect");
        a.put("400", "Bad Request");
        a.put("401", "Unauthorized");
        a.put("402", "Payment Required");
        a.put("403", "Forbidden");
        a.put("404", "Not Found");
        a.put("405", "Method Not Allowed");
        a.put("406", "Not Acceptable");
        a.put("407", "Proxy Authentication Required");
        a.put("408", "Request Timeout");
        a.put("409", "Conflict");
        a.put("410", "Gone");
        a.put("411", "Length Required");
        a.put("412", "Precondition Failed");
        a.put("413", "Payload Too Large");
        a.put("414", "URI Too Long");
        a.put("415", "Unsupported Media Type");
        a.put("416", "Requested Range Not Satisfiable");
        a.put("417", "Expectation Failed");
        a.put("418", "I'm a teapot");
        a.put("421", "Misdirected Request");
        a.put("426", "Upgrade Required");
        a.put("428", "Precondition Required");
        a.put("429", "Too Many Requests");
        a.put("431", "Request Header Fields Too Large");
        a.put("500", "Internal Server Error");
        a.put("501", "Not Implemented");
        a.put("502", "Bad Gateway");
        a.put("503", "Service Unavailable");
        a.put("504", "Gateway Timeout");
        a.put("505", "HTTP Version Not Supported");
        a.put("506", "Variant Also Negotiates");
        a.put("507", "Variant Also Negotiates");
        a.put("511", "Network Authentication Required");
    }

    public static String a(String str) {
        if (a.containsKey(str)) {
            return (String) a.get(str);
        }
        return "unknown status";
    }
}
