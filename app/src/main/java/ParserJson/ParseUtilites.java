package ParserJson;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonParser;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnManagerPNames;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import StoreData.StoreData;

/**
 * Created by Lobna on 1/23/2017.
 */
public class ParseUtilites  {

    static int timeoutConnection = 10000;
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    static String date = sdf.format(new Date());

    public static JSONObject parseLogin(String InverstorNo,String Password) {
        InputStream inputStream = null;
        JSONObject map = new JSONObject();
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpParams httpParameters = new BasicHttpParams();
            setTimeouts(httpParameters);
            HttpPost httpPost = new HttpPost(CommonVars.URL_Login);
            String json = "";

            JSONObject login_data = new JSONObject();
            login_data.put("UserName", InverstorNo);


            login_data.put("Password", Password);

            login_data.put("Lang", "EN");

            JSONObject login_obj1 = new JSONObject();
            login_obj1.put("Login", login_data);

            JSONObject LoginObj = new JSONObject();

            LoginObj.put("Message", login_obj1);
            LoginObj.put("AppId", "WEB_MOB");
            LoginObj.put("Srv", "Login");
            LoginObj.put("Version", "1");
            LoginObj.put("LstLogin", date);

            json = LoginObj.toString();
            StringEntity se = new StringEntity(json);

            httpPost.setEntity(se);

            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            HttpResponse httpResponse = httpclient.execute(httpPost);
            Log.d("json object", httpResponse.getStatusLine().getReasonPhrase());
            String result = "";

            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                Log.d("json object", httpResponse.getStatusLine().getStatusCode() + "");
                HttpEntity resEntity = httpResponse.getEntity();
                result = EntityUtils.toString(resEntity);

            }
            JSONObject jsonresult = new JSONObject(result);

            if (jsonresult == null)
                return null;
            else
                map = jsonresult;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return map;

    }

public static JSONObject ParseStockDate(int type){

  //  type =1;
    try {
    JSONParser jsonParser=new JSONParser();
    String StockData=jsonParser.getStringFromUrl(CommonVars.URL_StockData+ type);

    String keyList = "Symbol;NameEn;NameAr;SellPrice;BuyPrice;CurrentPrice;NoOfTrades;TradeValue;TradeVolume;HighPrice;LowPrice;ChangePercentage;ChangeValue;ChangeSign";
    String [] KeyArrayList=keyList.split(";");

    String [] StockDataArray=StockData.split("\n");

     JSONObject JParse_Data=new JSONObject();
     JSONArray  array_stock=new JSONArray();
     JSONObject Stock_Data=new JSONObject();


    for(int i=1;i<StockDataArray.length;i++){

        String [] get_StockDataArray=StockDataArray[i].split(";");
        if(KeyArrayList.length==get_StockDataArray.length){
                JParse_Data.put(KeyArrayList[i],get_StockDataArray[i]);
        }
    }

        array_stock.put(JParse_Data);
        Stock_Data.put("Stocks",array_stock);

        if(Stock_Data!=null){


        }









    } catch (JSONException e) {
        e.printStackTrace();
    }




    return  null;
}



    private static void setTimeouts(HttpParams params) {
        params.setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, timeoutConnection);
        params.setIntParameter(CoreConnectionPNames.SO_TIMEOUT, timeoutConnection);
        params.setLongParameter(ConnManagerPNames.TIMEOUT, timeoutConnection);
    }
}
