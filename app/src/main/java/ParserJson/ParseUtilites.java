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
import com.av.thegroup.AllStockData;
import com.google.gson.JsonParser;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

public static ArrayList<AllStockData> ParseStockDate(int type){
    ArrayList<AllStockData>  allStockDataArrayList=new ArrayList<>();
    try {
    JSONParser jsonParser=new JSONParser(); // TODO: use JSONParser to get data and cast as Json to make easy used .
    String StockData=jsonParser.getStringFromUrl(CommonVars.URL_StockData + type); // TODO: had to use getStringFromUrl because data is string
// 1 : Preferred  2:Active 3:Gainers  4:Losers
        //TODO: First create My Arraylist with same size from url and give name in same size size is  14
        //ToDO: and split ";" from my arrray and put in anthore array to be ["Symbol",.......]"
    String keyList = "Symbol;NameEn;NameAr;SellPrice;BuyPrice;CurrentPrice;NoOfTrades;TradeValue;TradeVolume;HighPrice;LowPrice;ChangePercentage;ChangeValue;ChangeSign";
    String [] KeyArrayList=keyList.split(";");
      //TODO : To Divide array by line by line split with \n to became array of lines "ex : 45" Lines
    String [] StockDataArray=StockData.split("\n");

     JSONArray  array_stock=new JSONArray(); // ToDO: to add my array in JsonArrat=y
    for(int i=1;i<StockDataArray.length;i++){
        //should be here to add all data put outside that loop will show just last array size
        JSONObject JParse_Data=new JSONObject(); //ToDo :Parse Data line by line and put with string in same size of My Array create
        String [] get_StockDataArray=StockDataArray[i].split(";"); //get
            if(KeyArrayList.length==get_StockDataArray.length){

                for(int j=0;j<get_StockDataArray.length;j++){


                JParse_Data.put(KeyArrayList[j],get_StockDataArray[j]);
            }

        }

        array_stock.put(JParse_Data);

    }
        JSONObject Stock_Data=new JSONObject();

        Stock_Data.put("Stocks",array_stock);


        if(Stock_Data!=null){
	    Log.d("stocks: ", "---------------" + Stock_Data);
         JSONArray Stocks =Stock_Data.getJSONArray("Stocks");
            for(int k=0;k<Stocks.length();k++){
                 JSONObject stocks=Stocks.getJSONObject(k);
                AllStockData map_allStockData=new AllStockData();

         /* //1 */     map_allStockData.setCompanySymbol(stocks.getString("Symbol"));
         /* //2 */     map_allStockData.setCompanyEn(stocks.getString("NameEn"));
         /* //3 */     map_allStockData.setCompanyAr(stocks.getString("NameAr"));
         /* //4 */     map_allStockData.setSellPrice(stocks.getString("SellPrice"));
         /* //5 */     map_allStockData.setBuyPrice(stocks.getString("BuyPrice"));
         /* //6 */     map_allStockData.setCurrentPrice(stocks.getString("CurrentPrice"));
         /* //7 */     map_allStockData.setNoOfTrades(stocks.getString("NoOfTrades"));
         /* //8 */     map_allStockData.setTradeValue(stocks.getString("TradeValue"));
         /* //9 */     map_allStockData.setTradeVolume(stocks.getString("TradeVolume"));
         /* //10 */    map_allStockData.setHighPrice(stocks.getString("HighPrice"));
         /* //11 */    map_allStockData.setLowPrice(stocks.getString("LowPrice"));
         /* //12 */    map_allStockData.setChangePercentage(stocks.getString("ChangePercentage"));
         /* //13 */    map_allStockData.setChangeValue(stocks.getString("ChangeValue"));
         /* //14 */    map_allStockData.setChangeSign(stocks.getString("ChangeSign"));

                       allStockDataArrayList.add(map_allStockData);

            }



        }









    } catch (JSONException e) {
        e.printStackTrace();
    }




    return allStockDataArrayList ;
}



    private static void setTimeouts(HttpParams params) {
        params.setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, timeoutConnection);
        params.setIntParameter(CoreConnectionPNames.SO_TIMEOUT, timeoutConnection);
        params.setLongParameter(ConnManagerPNames.TIMEOUT, timeoutConnection);
    }
}
