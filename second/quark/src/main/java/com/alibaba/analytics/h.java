package com.alibaba.analytics;

import android.os.IInterface;
import android.os.RemoteException;
import com.alibaba.mtl.appmonitor.Transaction;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.Map;

/* compiled from: ProGuard */
public interface h extends IInterface {
    void a() throws RemoteException;

    void a(int i) throws RemoteException;

    void a(int i, int i2) throws RemoteException;

    void a(Transaction transaction, String str) throws RemoteException;

    void a(String str) throws RemoteException;

    void a(String str, String str2) throws RemoteException;

    void a(String str, String str2, double d) throws RemoteException;

    void a(String str, String str2, DimensionValueSet dimensionValueSet, double d) throws RemoteException;

    void a(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) throws RemoteException;

    void a(String str, String str2, MeasureSet measureSet) throws RemoteException;

    void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException;

    void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException;

    void a(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException;

    void a(String str, String str2, String str3) throws RemoteException;

    void a(String str, String str2, String str3, double d) throws RemoteException;

    void a(String str, String str2, String str3, double d, double d2, double d3) throws RemoteException;

    void a(String str, String str2, String str3, String str4) throws RemoteException;

    void a(String str, String str2, String str3, String str4, String str5) throws RemoteException;

    void a(Map map) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void a(boolean z, boolean z2, String str, String str2) throws RemoteException;

    void b() throws RemoteException;

    void b(int i) throws RemoteException;

    void b(Transaction transaction, String str) throws RemoteException;

    void b(String str) throws RemoteException;

    void b(String str, String str2, double d) throws RemoteException;

    void b(String str, String str2, String str3) throws RemoteException;

    void b(Map map) throws RemoteException;

    boolean b(String str, String str2) throws RemoteException;

    String c(String str) throws RemoteException;

    void c() throws RemoteException;

    void c(int i) throws RemoteException;

    void c(String str, String str2, double d) throws RemoteException;

    void c(String str, String str2, String str3) throws RemoteException;

    void c(Map map) throws RemoteException;

    boolean c(String str, String str2) throws RemoteException;

    String d(String str) throws RemoteException;

    void d() throws RemoteException;

    void d(int i) throws RemoteException;

    void d(Map map) throws RemoteException;

    boolean d(String str, String str2) throws RemoteException;

    void e() throws RemoteException;

    void e(int i) throws RemoteException;

    void e(String str, String str2) throws RemoteException;

    void f() throws RemoteException;

    void f(int i) throws RemoteException;

    boolean f(String str, String str2) throws RemoteException;

    void g() throws RemoteException;

    void g(int i) throws RemoteException;

    void h() throws RemoteException;

    void h(int i) throws RemoteException;

    void i(int i) throws RemoteException;

    void j(int i) throws RemoteException;
}
