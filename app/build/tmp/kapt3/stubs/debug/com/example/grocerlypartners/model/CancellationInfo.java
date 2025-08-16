package com.example.grocerlypartners.model;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u00c6\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u001aH\u00d6\u0001J\t\u0010 \u001a\u00020\tH\u00d6\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006&"}, d2 = {"Lcom/example/grocerlypartners/model/CancellationInfo;", "Landroid/os/Parcelable;", "cancellationStatus", "Lcom/example/grocerlypartners/utils/CancellationStatus;", "cancelledBy", "Lcom/example/grocerlypartners/utils/CancelledBy;", "cancelledAt", "", "reason", "", "<init>", "(Lcom/example/grocerlypartners/utils/CancellationStatus;Lcom/example/grocerlypartners/utils/CancelledBy;JLjava/lang/String;)V", "getCancellationStatus", "()Lcom/example/grocerlypartners/utils/CancellationStatus;", "getCancelledBy", "()Lcom/example/grocerlypartners/utils/CancelledBy;", "getCancelledAt", "()J", "getReason", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "app_debug"})
@kotlinx.parcelize.Parcelize()
public final class CancellationInfo implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private final com.example.grocerlypartners.utils.CancellationStatus cancellationStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.grocerlypartners.utils.CancelledBy cancelledBy = null;
    private final long cancelledAt = 0L;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String reason = null;
    
    @java.lang.Override()
    public final int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public final void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel dest, int flags) {
    }
    
    public CancellationInfo(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.utils.CancellationStatus cancellationStatus, @org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.utils.CancelledBy cancelledBy, long cancelledAt, @org.jetbrains.annotations.Nullable()
    java.lang.String reason) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.grocerlypartners.utils.CancellationStatus getCancellationStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.grocerlypartners.utils.CancelledBy getCancelledBy() {
        return null;
    }
    
    public final long getCancelledAt() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getReason() {
        return null;
    }
    
    public CancellationInfo() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.grocerlypartners.utils.CancellationStatus component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.grocerlypartners.utils.CancelledBy component2() {
        return null;
    }
    
    public final long component3() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.grocerlypartners.model.CancellationInfo copy(@org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.utils.CancellationStatus cancellationStatus, @org.jetbrains.annotations.NotNull()
    com.example.grocerlypartners.utils.CancelledBy cancelledBy, long cancelledAt, @org.jetbrains.annotations.Nullable()
    java.lang.String reason) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}