package xyz.kkt.mmexchange.data.Model;

import xyz.kkt.mmexchange.network.CurrencyDataAgent;
import xyz.kkt.mmexchange.network.OkHttpDataAgent;

/**
 * Created by Lenovo on 8/15/2017.
 */

public class CurrencyModel {
    private static CurrencyModel obj;

    private CurrencyDataAgent mDataAgent;

    private CurrencyModel() {
        mDataAgent = OkHttpDataAgent.getInstance();
    }

    public static CurrencyModel getInstance() {
        if (obj == null) {
            obj = new CurrencyModel();
        }
        return obj;
    }

    public void loadCurrency() {
        mDataAgent.loadCurrency();
    }
}
