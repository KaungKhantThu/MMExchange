package xyz.kkt.mmexchange.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xyz.kkt.mmexchange.MMExchangeApp;
import xyz.kkt.mmexchange.R;
import xyz.kkt.mmexchange.adapters.CurrencyAdapter;
import xyz.kkt.mmexchange.data.Model.CurrencyModel;
import xyz.kkt.mmexchange.events.CurrencyLoadedEvent;
import xyz.kkt.mmexchange.events.CurrencyUnloadedEvent;

public class MainActivity extends AppCompatActivity {

    private CurrencyAdapter mcurrencyAdapter;
    private TextView tvUSD;
    private TextView tvEUR;
    private TextView tvGBP;
    private TextView tvCHF;
    private TextView tvJPY;
    private TextView tvAUD;
    private TextView tvINR;
    private TextView tvPHP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        tvUSD = (TextView) findViewById(R.id.tv_USD);
//        tvEUR = (TextView) findViewById(R.id.tv_EUR);
//        tvGBP = (TextView) findViewById(R.id.tv_GBP);
//        tvCHF = (TextView) findViewById(R.id.tv_CHF);
//        tvJPY = (TextView) findViewById(R.id.tv_JPY);
//        tvAUD = (TextView) findViewById(R.id.tv_AUD);
//        tvINR = (TextView) findViewById(R.id.tv_INR);
//        tvPHP = (TextView) findViewById(R.id.tv_PHP);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_currency);
        mcurrencyAdapter = new CurrencyAdapter(getApplicationContext());
        recyclerView.setAdapter(mcurrencyAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        CurrencyModel.getInstance().loadCurrency();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCurrencyLoadedEvent(CurrencyLoadedEvent event) {
        Log.d(MMExchangeApp.LOG_TAG, "onCurrencyLoadedEvent" + event.toString());

         mcurrencyAdapter.setNewData(event.getCurrencyVOList());
        /*tvUSD.setText(event.getCurrencyVOList().getUSD());
        tvEUR.setText(event.getCurrencyVOList().getEUR());
        tvGBP.setText(event.getCurrencyVOList().getGBP());
        tvCHF.setText(event.getCurrencyVOList().getCHF());
        tvJPY.setText(event.getCurrencyVOList().getJPY());
        tvAUD.setText(event.getCurrencyVOList().getAUD());
        tvINR.setText(event.getCurrencyVOList().getINR());
        tvPHP.setText(event.getCurrencyVOList().getPHP());*/

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAtrractionUnloaded(CurrencyUnloadedEvent event) {
        Toast.makeText(getApplicationContext(), event.getErrorMessage(), Toast.LENGTH_LONG).show();
    }

}
