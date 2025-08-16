package com.example.grocerlypartners.utils;

@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/grocerlypartners/utils/RegisterValidation;", "", "<init>", "()V", "Success", "Failure", "Lcom/example/grocerlypartners/utils/RegisterValidation$Failure;", "Lcom/example/grocerlypartners/utils/RegisterValidation$Success;", "app_debug"})
public abstract class RegisterValidation {
    
    private RegisterValidation() {
        super();
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/grocerlypartners/utils/RegisterValidation$Failure;", "Lcom/example/grocerlypartners/utils/RegisterValidation;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "app_debug"})
    public static final class Failure extends com.example.grocerlypartners.utils.RegisterValidation {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String message = null;
        
        public Failure(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/grocerlypartners/utils/RegisterValidation$Success;", "Lcom/example/grocerlypartners/utils/RegisterValidation;", "<init>", "()V", "app_debug"})
    public static final class Success extends com.example.grocerlypartners.utils.RegisterValidation {
        
        public Success() {
        }
    }
}