package xyz.kkt.mmexchange.response;

import android.content.Context;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import xyz.kkt.mmexchange.data.VO.CurrencyVO;

/**
 * Created by Lenovo on 8/15/2017.
 */

public class ResponseCurrencyList {
    @SerializedName("info")
    private String info;
    @SerializedName("description")
    private String description;
    @SerializedName("rates")
    private CurrencyVO currencyList;


    public String getInfo() {
        return info;
    }

    public String getDescription() {
        return description;
    }

    public CurrencyVO getCurrencyList() {
        return currencyList;
    }


}
