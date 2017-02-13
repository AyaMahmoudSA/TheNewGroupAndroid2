package Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.av.thegroup.PerferredFragment;
import com.av.thegroup.R;

import java.util.ArrayList;

import Models.AllStockData;

/**
 * Created by Lobna on 2/8/2017.
 */
public class PerferredStockDataAdapter extends BaseAdapter {
    ArrayList<AllStockData> get_allstockdataadapter;
    private static LayoutInflater inflater = null;
    private Activity activity;
    MyViewHoldwer holder = null;
    AllStockData allStockData;
    private final int[] colors = new int[] { Color.parseColor("#f9f9f9"), Color.parseColor("#ededed") };

    public PerferredStockDataAdapter(Activity a,ArrayList<AllStockData> get_allstockdata) {
        get_allstockdataadapter=get_allstockdata;
        activity=a;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getCount() {
        return get_allstockdataadapter.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static  class MyViewHoldwer{
        TextView Company,Value,Bid,Offer,Current;
        public  MyViewHoldwer(View v){
          Company = (TextView) v.findViewById(R.id.txt_company);
          Value   = (TextView) v.findViewById(R.id.txt_valuepercentage);
          Bid     = (TextView) v.findViewById(R.id.txt_bid);
          Offer   = (TextView) v.findViewById(R.id.txt_offer);
          Current = (TextView) v.findViewById(R.id.txt_current);
            v.setTag(this);


        }
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)

        {
            convertView = inflater.inflate(R.layout.pricescreen_holder, null);
            holder = new MyViewHoldwer(convertView);
            convertView.setTag(holder);
            Log.d("row", "Creating row");



        } else {
            holder = (MyViewHoldwer) convertView.getTag();
            Log.d("row", "Recycling use");
        }
           holder = (MyViewHoldwer) convertView.getTag();
           int colorPos = position % colors.length;
           convertView.setBackgroundColor(colors[colorPos]);
           allStockData=new AllStockData();
           allStockData=get_allstockdataadapter.get(position);

        if(PerferredFragment.tag_companysymbol==0){
            holder.Company.setText(allStockData.getCompanySymbol());

        }else{
            holder.Company.setText(allStockData.getCompanyEn());

        }

        if(PerferredFragment.tag_valuepercentage==0){
            holder.Value.setText(allStockData.getChangePercentage());
        }else{
            holder.Value.setText(allStockData.getChangeValue());
        }

           holder.Bid.setText(allStockData.getBuyPrice());
           holder.Offer.setText(allStockData.getSellPrice());

if(PerferredFragment.tag_CuHiLo==0)
    holder.Current.setText(allStockData.getCurrentPrice());
  else
    if(PerferredFragment.tag_CuHiLo==1)
        holder.Current.setText(allStockData.getHighPrice());
     else
        if(PerferredFragment.tag_CuHiLo ==2)
            holder.Current.setText(allStockData.getLowPrice());





            return convertView;
    }
}
