package xyz.kkt.mmexchange.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import xyz.kkt.mmexchange.MMExchangeApp;
import xyz.kkt.mmexchange.events.CurrencyLoadedEvent;
import xyz.kkt.mmexchange.events.CurrencyUnloadedEvent;
import xyz.kkt.mmexchange.utils.CurrencyConstants;
import xyz.kkt.mmexchange.response.ResponseCurrencyList;
import xyz.kkt.mmexchange.data.VO.CurrencyVO;

/**
 * Created by Lenovo on 8/13/2017.
 */

public class OkHttpDataAgent implements CurrencyDataAgent {

    private static OkHttpDataAgent objInstance;

    private OkHttpClient mHttpClient;

    private OkHttpDataAgent() {
        mHttpClient = new OkHttpClient.Builder() //1.   //Builder pattern
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new OkHttpDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadCurrency() {
        new AsyncTask<Void, Void, CurrencyVO>() {//generic type in java(to define the dynamic type)
            //1 para->at the start of the process 2->during the process(intermediate state) 3->at the end of the process
            @Override
            protected CurrencyVO doInBackground(Void... voids) {//the parameter in this method is the same as the first one in AsyncTask
                //the return type in this method is the same as the third parameter in AsyncTask
                Request request = new Request.Builder() //3
                        .url(CurrencyConstants.ATTRACTION_BASE_URL + CurrencyConstants.API_GET_ATTRACTION_LIST)
                        .get()//.get null can be used if there is no parameter
                        .build();
                //post and get (http request method)
                try {
                    Response response = mHttpClient.newCall(request).execute(); //4.
                    if (response.isSuccessful()) {
                        String responseString = response.body().string();

                        ResponseCurrencyList responseCurrencyList = new Gson().fromJson(responseString, ResponseCurrencyList.class);
                        CurrencyVO currencyList = responseCurrencyList.getCurrencyList();
                        return currencyList;
                    } else {
                        //TODO notifyErrorInLoadingAttractions(response.message());
                        Log.e(MMExchangeApp.LOG_TAG, "Something wrong");
                    }
                } catch (IOException e) {
                    Log.e(MMExchangeApp.LOG_TAG, e.getMessage());
                    //TODO notifyErrorInLoadingAttractions(e.getMessage());
                }

                return null;
            }

            @Override
            protected void onPostExecute(CurrencyVO currencyList) {
                super.onPostExecute(currencyList);
                if (currencyList != null) {
                    //TODO notifyAttractionsLoaded(attractionList);
                    CurrencyLoadedEvent event = new CurrencyLoadedEvent(currencyList);
                    EventBus.getDefault().post(event);
                } else {
                    CurrencyUnloadedEvent attractionListUnloadedEvent = new CurrencyUnloadedEvent("CurrencyList is empty");
                    EventBus.getDefault().post(attractionListUnloadedEvent);
                }
            }
        }.execute();
    }
}