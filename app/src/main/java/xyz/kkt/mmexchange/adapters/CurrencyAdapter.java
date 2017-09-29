package xyz.kkt.mmexchange.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.kkt.mmexchange.R;
import xyz.kkt.mmexchange.data.VO.CurrencyVO;
import xyz.kkt.mmexchange.viewHolders.CurencyViewHolder;

/**
 * Created by Lenovo on 8/15/2017.
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurencyViewHolder> {
    private LayoutInflater mLayoutInflater;
    private CurrencyVO mData;
    private String[] CurrencyName = {"USD"  ,"CAD"  ,"NPR",
                                    "GBP"   ,"NOK"   ,"ZAR",
                                    "SEK"   ,"ILS"   ,"EGP",
                                    "DKK"   ,"AUD"   ,"IDR",
                                    "INR"   ,"RUB"   ,"NZD",
                                    "BND"   ,"KWD"   ,"CZK",
                                    "CNY"   ,"EUR"   ,"PHP",
                                    "CHF"   ,"THB"   ,"MYR",
                                    "PKR"   ,"SAR"   ,"KRW",
                                    "KES"   ,"SGD"   ,"RSD",
                                    "BDT"	,"LAK"   ,"HKD",
                                    "KHR"   ,"LKR"   ,"BRL",
                                    "JPY"   ,"VND"     };
    private String[] CurrencyValue;

    public CurrencyAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        CurrencyValue=new String[38];
    }

    @Override
    public CurencyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.view_item_exchange, parent, false);
        return new CurencyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CurencyViewHolder holder, int position) {
        holder.bindData(CurrencyName[position], CurrencyValue[position]);
    }

    @Override
    public int getItemCount() {
        return CurrencyName.length;
    }

    public void setNewData(CurrencyVO data) {
        mData = data;

        CurrencyValue[0] = mData.getUSD();
        CurrencyValue[1] = mData.getCAD();
        CurrencyValue[2] = mData.getNPR();
        CurrencyValue[3] = mData.getGBP();
        CurrencyValue[4] = mData.getNOK();
        CurrencyValue[5] = mData.getZAR();
        CurrencyValue[6] = mData.getSEK();
        CurrencyValue[7] = mData.getILS();
        CurrencyValue[8] = mData.getEGP();
        CurrencyValue[9] = mData.getDKK();
        CurrencyValue[10] = mData.getAUD();
        CurrencyValue[11] = mData.getIDR();
        CurrencyValue[12] = mData.getINR();
        CurrencyValue[13] = mData.getRUB();
        CurrencyValue[14] = mData.getNZD();
        CurrencyValue[15] = mData.getBND();
        CurrencyValue[16] = mData.getKWD();
        CurrencyValue[17] = mData.getCZK();
        CurrencyValue[18] = mData.getCNY();
        CurrencyValue[19] = mData.getEUR();
        CurrencyValue[20] = mData.getPHP();
        CurrencyValue[21] = mData.getCHF();
        CurrencyValue[22] = mData.getTHB();
        CurrencyValue[23] = mData.getMYR();
        CurrencyValue[24] = mData.getPKR();
        CurrencyValue[25] = mData.getSAR();
        CurrencyValue[26] = mData.getKRW();
        CurrencyValue[27] = mData.getKES();
        CurrencyValue[28] = mData.getSGD();
        CurrencyValue[29] = mData.getRSD();
        CurrencyValue[30] = mData.getBDT();
        CurrencyValue[31] = mData.getLAK();
        CurrencyValue[32] = mData.getHKD();
        CurrencyValue[33] = mData.getKHR();
        CurrencyValue[34] = mData.getLKR();
        CurrencyValue[35] = mData.getBRL();
        CurrencyValue[36] = mData.getJPY();
        CurrencyValue[37] = mData.getVND();
        notifyDataSetChanged();//for Adapter to know the changes
    }

}
