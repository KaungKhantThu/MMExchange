package xyz.kkt.mmexchange.events;

import java.util.List;

import xyz.kkt.mmexchange.data.VO.CurrencyVO;

/**
 * Created by Lenovo on 8/16/2017.
 */

public class CurrencyLoadedEvent {
    private CurrencyVO currencyVOList;

    public CurrencyLoadedEvent(CurrencyVO currencyVOList) {
        this.currencyVOList = currencyVOList;
    }

    public CurrencyVO getCurrencyVOList() {
        return currencyVOList;
    }
}
