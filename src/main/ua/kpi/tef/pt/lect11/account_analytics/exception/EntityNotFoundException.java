package ua.kpi.tef.pt.lect11.account_analytics.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
