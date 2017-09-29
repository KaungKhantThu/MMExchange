package xyz.kkt.mmexchange.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import xyz.kkt.mmexchange.R;
import xyz.kkt.mmexchange.data.VO.CurrencyVO;

/**
 * Created by Lenovo on 8/15/2017.
 */

public class CurencyViewHolder extends RecyclerView.ViewHolder {

    private TextView tvCurrencyValue;
    private TextView tvCurrencyName;

    public CurencyViewHolder(View itemView) {
        super(itemView);
        tvCurrencyValue = (TextView) itemView.findViewById(R.id.tv_currency_value);
        tvCurrencyName = (TextView) itemView.findViewById(R.id.tv_currency_name);
    }

    public void bindData(String CurrencyName, String CurrencyValue) {
        tvCurrencyName.setText(CurrencyName);
        tvCurrencyValue.setText(CurrencyValue);
    }
}
