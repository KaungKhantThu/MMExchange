package xyz.kkt.mmexchange.events;

/**
 * Created by Lenovo on 8/16/2017.
 */

public class CurrencyUnloadedEvent {
    private String errorMessage;

    public CurrencyUnloadedEvent(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
