package com.uc.quark.filedownloader.c;

import android.app.Notification;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.uc.quark.filedownloader.model.FileDownloadHeader;

/* compiled from: ProGuard */
public interface b extends IInterface {
    void a() throws RemoteException;

    void a(int i, Notification notification) throws RemoteException;

    void a(Bundle bundle) throws RemoteException;

    void a(Bundle bundle, boolean z) throws RemoteException;

    void a(c cVar) throws RemoteException;

    void a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, FileDownloadHeader fileDownloadHeader, boolean z3, String str3, int i4, long j, String str4) throws RemoteException;

    void a(boolean z) throws RemoteException;

    boolean a(int i) throws RemoteException;

    boolean a(String str, String str2) throws RemoteException;

    void b(c cVar) throws RemoteException;

    boolean b() throws RemoteException;

    boolean b(int i) throws RemoteException;

    long c(int i) throws RemoteException;

    void c() throws RemoteException;

    long d(int i) throws RemoteException;

    void d() throws RemoteException;

    byte e(int i) throws RemoteException;

    byte[] e() throws RemoteException;

    boolean f(int i) throws RemoteException;

    String g(int i) throws RemoteException;

    boolean h(int i) throws RemoteException;
}
