package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zze;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public class zzw extends zzaa {
    /* access modifiers changed from: private */
    public static final AtomicLong zzbeq = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */
    public zzd zzbeh;
    /* access modifiers changed from: private */
    public zzd zzbei;
    private final PriorityBlockingQueue<FutureTask<?>> zzbej = new PriorityBlockingQueue<>();
    private final BlockingQueue<FutureTask<?>> zzbek = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler zzbel = new zzb("Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler zzbem = new zzb("Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */
    public final Object zzben = new Object();
    /* access modifiers changed from: private */
    public final Semaphore zzbeo = new Semaphore(2);
    /* access modifiers changed from: private */
    public volatile boolean zzbep;

    static class zza extends RuntimeException {
    }

    private final class zzb implements Thread.UncaughtExceptionHandler {
        private final String zzber;

        public zzb(String str) {
            zzaa.zzz(str);
            this.zzber = str;
        }

        public synchronized void uncaughtException(Thread thread, Throwable th) {
            zzw.this.zzFm().zzFE().zzj(this.zzber, th);
        }
    }

    private final class zzc<V> extends FutureTask<V> implements Comparable<zzc> {
        private final String zzber;
        private final long zzbet = zzw.zzbeq.getAndIncrement();
        private final boolean zzbeu;

        zzc(Runnable runnable, boolean z, String str) {
            super(runnable, (Object) null);
            zzaa.zzz(str);
            this.zzber = str;
            this.zzbeu = z;
            if (this.zzbet == Long.MAX_VALUE) {
                zzw.this.zzFm().zzFE().log("Tasks index overflow");
            }
        }

        zzc(Callable<V> callable, boolean z, String str) {
            super(callable);
            zzaa.zzz(str);
            this.zzber = str;
            this.zzbeu = z;
            if (this.zzbet == Long.MAX_VALUE) {
                zzw.this.zzFm().zzFE().log("Tasks index overflow");
            }
        }

        /* access modifiers changed from: protected */
        public void setException(Throwable th) {
            zzw.this.zzFm().zzFE().zzj(this.zzber, th);
            if (th instanceof zza) {
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
            }
            super.setException(th);
        }

        /* renamed from: zzb */
        public int compareTo(zzc zzc) {
            if (this.zzbeu != zzc.zzbeu) {
                return this.zzbeu ? -1 : 1;
            }
            if (this.zzbet < zzc.zzbet) {
                return -1;
            }
            if (this.zzbet > zzc.zzbet) {
                return 1;
            }
            zzw.this.zzFm().zzFF().zzj("Two tasks share the same index. index", Long.valueOf(this.zzbet));
            return 0;
        }
    }

    private final class zzd extends Thread {
        private final Object zzbev = new Object();
        private final BlockingQueue<FutureTask<?>> zzbew;

        public zzd(String str, BlockingQueue<FutureTask<?>> blockingQueue) {
            zzaa.zzz(str);
            zzaa.zzz(blockingQueue);
            this.zzbew = blockingQueue;
            setName(str);
        }

        private void zza(InterruptedException interruptedException) {
            zzw.this.zzFm().zzFG().zzj(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0078, code lost:
            r1 = com.google.android.gms.measurement.internal.zzw.zzc(r4.zzbes);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x007e, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            com.google.android.gms.measurement.internal.zzw.zza(r4.zzbes).release();
            com.google.android.gms.measurement.internal.zzw.zzc(r4.zzbes).notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0097, code lost:
            if (r4 != com.google.android.gms.measurement.internal.zzw.zzd(r4.zzbes)) goto L_0x00a9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0099, code lost:
            com.google.android.gms.measurement.internal.zzw.zza(r4.zzbes, (com.google.android.gms.measurement.internal.zzw.zzd) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x009f, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a0, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00af, code lost:
            if (r4 != com.google.android.gms.measurement.internal.zzw.zze(r4.zzbes)) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b1, code lost:
            com.google.android.gms.measurement.internal.zzw.zzb(r4.zzbes, (com.google.android.gms.measurement.internal.zzw.zzd) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            r4.zzbes.zzFm().zzFE().log("Current scheduler thread is neither worker nor network");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                r0 = 0
                r1 = r0
            L_0x0002:
                if (r1 != 0) goto L_0x0015
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ InterruptedException -> 0x0010 }
                java.util.concurrent.Semaphore r0 = r0.zzbeo     // Catch:{ InterruptedException -> 0x0010 }
                r0.acquire()     // Catch:{ InterruptedException -> 0x0010 }
                r0 = 1
                r1 = r0
                goto L_0x0002
            L_0x0010:
                r0 = move-exception
                r4.zza(r0)
                goto L_0x0002
            L_0x0015:
                java.util.concurrent.BlockingQueue<java.util.concurrent.FutureTask<?>> r0 = r4.zzbew     // Catch:{ all -> 0x0023 }
                java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0023 }
                java.util.concurrent.FutureTask r0 = (java.util.concurrent.FutureTask) r0     // Catch:{ all -> 0x0023 }
                if (r0 == 0) goto L_0x004d
                r0.run()     // Catch:{ all -> 0x0023 }
                goto L_0x0015
            L_0x0023:
                r0 = move-exception
                com.google.android.gms.measurement.internal.zzw r1 = com.google.android.gms.measurement.internal.zzw.this
                java.lang.Object r1 = r1.zzben
                monitor-enter(r1)
                com.google.android.gms.measurement.internal.zzw r2 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00e1 }
                java.util.concurrent.Semaphore r2 = r2.zzbeo     // Catch:{ all -> 0x00e1 }
                r2.release()     // Catch:{ all -> 0x00e1 }
                com.google.android.gms.measurement.internal.zzw r2 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00e1 }
                java.lang.Object r2 = r2.zzben     // Catch:{ all -> 0x00e1 }
                r2.notifyAll()     // Catch:{ all -> 0x00e1 }
                com.google.android.gms.measurement.internal.zzw r2 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00e1 }
                com.google.android.gms.measurement.internal.zzw$zzd r2 = r2.zzbeh     // Catch:{ all -> 0x00e1 }
                if (r4 != r2) goto L_0x00d1
                com.google.android.gms.measurement.internal.zzw r2 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00e1 }
                r3 = 0
                com.google.android.gms.measurement.internal.zzw.zzd unused = r2.zzbeh = r3     // Catch:{ all -> 0x00e1 }
            L_0x004b:
                monitor-exit(r1)     // Catch:{ all -> 0x00e1 }
                throw r0
            L_0x004d:
                java.lang.Object r1 = r4.zzbev     // Catch:{ all -> 0x0023 }
                monitor-enter(r1)     // Catch:{ all -> 0x0023 }
                java.util.concurrent.BlockingQueue<java.util.concurrent.FutureTask<?>> r0 = r4.zzbew     // Catch:{ all -> 0x00a6 }
                java.lang.Object r0 = r0.peek()     // Catch:{ all -> 0x00a6 }
                if (r0 != 0) goto L_0x0067
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00a6 }
                boolean r0 = r0.zzbep     // Catch:{ all -> 0x00a6 }
                if (r0 != 0) goto L_0x0067
                java.lang.Object r0 = r4.zzbev     // Catch:{ InterruptedException -> 0x00a1 }
                r2 = 30000(0x7530, double:1.4822E-319)
                r0.wait(r2)     // Catch:{ InterruptedException -> 0x00a1 }
            L_0x0067:
                monitor-exit(r1)     // Catch:{ all -> 0x00a6 }
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x0023 }
                java.lang.Object r1 = r0.zzben     // Catch:{ all -> 0x0023 }
                monitor-enter(r1)     // Catch:{ all -> 0x0023 }
                java.util.concurrent.BlockingQueue<java.util.concurrent.FutureTask<?>> r0 = r4.zzbew     // Catch:{ all -> 0x00ce }
                java.lang.Object r0 = r0.peek()     // Catch:{ all -> 0x00ce }
                if (r0 != 0) goto L_0x00cb
                monitor-exit(r1)     // Catch:{ all -> 0x00ce }
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this
                java.lang.Object r1 = r0.zzben
                monitor-enter(r1)
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00b8 }
                java.util.concurrent.Semaphore r0 = r0.zzbeo     // Catch:{ all -> 0x00b8 }
                r0.release()     // Catch:{ all -> 0x00b8 }
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00b8 }
                java.lang.Object r0 = r0.zzben     // Catch:{ all -> 0x00b8 }
                r0.notifyAll()     // Catch:{ all -> 0x00b8 }
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00b8 }
                com.google.android.gms.measurement.internal.zzw$zzd r0 = r0.zzbeh     // Catch:{ all -> 0x00b8 }
                if (r4 != r0) goto L_0x00a9
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00b8 }
                r2 = 0
                com.google.android.gms.measurement.internal.zzw.zzd unused = r0.zzbeh = r2     // Catch:{ all -> 0x00b8 }
            L_0x009f:
                monitor-exit(r1)     // Catch:{ all -> 0x00b8 }
                return
            L_0x00a1:
                r0 = move-exception
                r4.zza(r0)     // Catch:{ all -> 0x00a6 }
                goto L_0x0067
            L_0x00a6:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00a6 }
                throw r0     // Catch:{ all -> 0x0023 }
            L_0x00a9:
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00b8 }
                com.google.android.gms.measurement.internal.zzw$zzd r0 = r0.zzbei     // Catch:{ all -> 0x00b8 }
                if (r4 != r0) goto L_0x00bb
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00b8 }
                r2 = 0
                com.google.android.gms.measurement.internal.zzw.zzd unused = r0.zzbei = r2     // Catch:{ all -> 0x00b8 }
                goto L_0x009f
            L_0x00b8:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00b8 }
                throw r0
            L_0x00bb:
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00b8 }
                com.google.android.gms.measurement.internal.zzp r0 = r0.zzFm()     // Catch:{ all -> 0x00b8 }
                com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzFE()     // Catch:{ all -> 0x00b8 }
                java.lang.String r2 = "Current scheduler thread is neither worker nor network"
                r0.log(r2)     // Catch:{ all -> 0x00b8 }
                goto L_0x009f
            L_0x00cb:
                monitor-exit(r1)     // Catch:{ all -> 0x00ce }
                goto L_0x0015
            L_0x00ce:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00ce }
                throw r0     // Catch:{ all -> 0x0023 }
            L_0x00d1:
                com.google.android.gms.measurement.internal.zzw r2 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00e1 }
                com.google.android.gms.measurement.internal.zzw$zzd r2 = r2.zzbei     // Catch:{ all -> 0x00e1 }
                if (r4 != r2) goto L_0x00e4
                com.google.android.gms.measurement.internal.zzw r2 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00e1 }
                r3 = 0
                com.google.android.gms.measurement.internal.zzw.zzd unused = r2.zzbei = r3     // Catch:{ all -> 0x00e1 }
                goto L_0x004b
            L_0x00e1:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00e1 }
                throw r0
            L_0x00e4:
                com.google.android.gms.measurement.internal.zzw r2 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00e1 }
                com.google.android.gms.measurement.internal.zzp r2 = r2.zzFm()     // Catch:{ all -> 0x00e1 }
                com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzFE()     // Catch:{ all -> 0x00e1 }
                java.lang.String r3 = "Current scheduler thread is neither worker nor network"
                r2.log(r3)     // Catch:{ all -> 0x00e1 }
                goto L_0x004b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzw.zzd.run():void");
        }

        public void zzge() {
            synchronized (this.zzbev) {
                this.zzbev.notifyAll();
            }
        }
    }

    zzw(zzx zzx) {
        super(zzx);
    }

    private void zza(zzc<?> zzc2) {
        synchronized (this.zzben) {
            this.zzbej.add(zzc2);
            if (this.zzbeh == null) {
                this.zzbeh = new zzd("Measurement Worker", this.zzbej);
                this.zzbeh.setUncaughtExceptionHandler(this.zzbel);
                this.zzbeh.start();
            } else {
                this.zzbeh.zzge();
            }
        }
    }

    private void zza(FutureTask<?> futureTask) {
        synchronized (this.zzben) {
            this.zzbek.add(futureTask);
            if (this.zzbei == null) {
                this.zzbei = new zzd("Measurement Network", this.zzbek);
                this.zzbei.setUncaughtExceptionHandler(this.zzbem);
                this.zzbei.start();
            } else {
                this.zzbei.zzge();
            }
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void zzFb() {
        if (Thread.currentThread() != this.zzbei) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public /* bridge */ /* synthetic */ zzc zzFc() {
        return super.zzFc();
    }

    public /* bridge */ /* synthetic */ zzac zzFd() {
        return super.zzFd();
    }

    public /* bridge */ /* synthetic */ zzn zzFe() {
        return super.zzFe();
    }

    public /* bridge */ /* synthetic */ zzg zzFf() {
        return super.zzFf();
    }

    public /* bridge */ /* synthetic */ zzad zzFg() {
        return super.zzFg();
    }

    public /* bridge */ /* synthetic */ zze zzFh() {
        return super.zzFh();
    }

    public /* bridge */ /* synthetic */ zzal zzFi() {
        return super.zzFi();
    }

    public /* bridge */ /* synthetic */ zzv zzFj() {
        return super.zzFj();
    }

    public /* bridge */ /* synthetic */ zzaf zzFk() {
        return super.zzFk();
    }

    public /* bridge */ /* synthetic */ zzw zzFl() {
        return super.zzFl();
    }

    public /* bridge */ /* synthetic */ zzp zzFm() {
        return super.zzFm();
    }

    public /* bridge */ /* synthetic */ zzt zzFn() {
        return super.zzFn();
    }

    public /* bridge */ /* synthetic */ zzd zzFo() {
        return super.zzFo();
    }

    public <V> Future<V> zzd(Callable<V> callable) throws IllegalStateException {
        zzma();
        zzaa.zzz(callable);
        zzc zzc2 = new zzc(callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzbeh) {
            zzc2.run();
        } else {
            zza((zzc<?>) zzc2);
        }
        return zzc2;
    }

    public <V> Future<V> zze(Callable<V> callable) throws IllegalStateException {
        zzma();
        zzaa.zzz(callable);
        zzc zzc2 = new zzc(callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zzbeh) {
            zzc2.run();
        } else {
            zza((zzc<?>) zzc2);
        }
        return zzc2;
    }

    public void zzg(Runnable runnable) throws IllegalStateException {
        zzma();
        zzaa.zzz(runnable);
        zza((zzc<?>) new zzc(runnable, false, "Task exception on worker thread"));
    }

    public void zzh(Runnable runnable) throws IllegalStateException {
        zzma();
        zzaa.zzz(runnable);
        zza((FutureTask<?>) new zzc(runnable, false, "Task exception on network thread"));
    }

    public void zzkN() {
        if (Thread.currentThread() != this.zzbeh) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    /* access modifiers changed from: protected */
    public void zzkO() {
    }

    public /* bridge */ /* synthetic */ void zzlP() {
        super.zzlP();
    }

    public /* bridge */ /* synthetic */ zze zzlQ() {
        return super.zzlQ();
    }
}
