package Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.av.thegroup.AllStockData;
import com.av.thegroup.PerferredFragment;
import com.av.thegroup.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.math.BigDecimal;
import java.util.ArrayList;

import static com.av.thegroup.PerferredFragment.get_allstockdata;


/**
 * Created by Lobna on 2/8/2017.
 */
public class PerferredStockDataAdapter extends BaseAdapter {
    ArrayList<AllStockData> get_allstockdataadapter=PerferredFragment.get_allstockdata;
    private static LayoutInflater inflater = null;
    private Activity activity;
    MyViewHoldwer holder = null;
    AllStockData allStockData;
    boolean ignoreChange = false;
    DatabaseReference myRef,myRef2;
    DataSnapshot dataSnap;
    private final int[] colors = new int[] { Color.parseColor("#f9f9f9"), Color.parseColor("#ededed") };

    public PerferredStockDataAdapter(Activity a) {
  //      get_allstockdataadapter=get_allstockdata;
        activity=a;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getCount() {
        return (int) PerferredFragment.pardedataSnapshot.getChildrenCount();
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


        /*allStockData = new AllStockData();
        allStockData = PerferredFragment.get_allstockdata.get(position);*/

         dataSnap = PerferredFragment.pardedataSnapshot.child(String.valueOf(position));



        if (PerferredFragment.tag_companysymbol == 0) {
            holder.Company.setText(dataSnap.child("Symbol").getValue().toString());
        } else {
            holder.Company.setText(dataSnap.child("NameEn").getValue().toString());

        }

        if (PerferredFragment.tag_valuepercentage == 0) {
            BigDecimal a = new BigDecimal(dataSnap.child("ChangePercentage").getValue().toString());
            BigDecimal roundOff = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            holder.Value.setText(roundOff.toString());
        } else {
            BigDecimal a = new BigDecimal(dataSnap.child("ChangeValue").getValue().toString());
            BigDecimal roundOff = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            holder.Value.setText(roundOff.toString());
        }

        BigDecimal a = new BigDecimal(dataSnap.child("BuyPrice").getValue().toString());
        BigDecimal roundOff = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);

        holder.Bid.setText(roundOff.toString());
       /* holder.Bid.addTextChangedListener(new TextWatcher() {

                                                String x=  holder.Bid.getText().toString();

                                                // the user's changes are saved here
                                                public void onTextChanged(CharSequence c, int start, int before, int count) {
                     *//*   Market_Index.setText(c.toString());
                        Market_Index.setBackgroundResource(R.color.sign_plus);*//*

                                                }

                                                public void beforeTextChanged(CharSequence c, int start, int count, int after) {
                                                    x=c.toString();

                                                }

                                                public void afterTextChanged(Editable c) {
                                                    // this one too
                                                    if(!x.matches(c.toString())){

                                                        holder.Bid.setBackgroundResource(R.color.sign_plus);

                                                        new Handler().postDelayed(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                holder.Bid.setBackgroundResource(R.color.text_black);
                                                            }
                                                        }, 500);





*//*
                            try {
                                wait(1000);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }*//*
                                                        //    Market_Index.setBackgroundResource(R.color.color_itemtext);

                                                    }
                                                }
                                            }


        );*/



        BigDecimal b = new BigDecimal(dataSnap.child("SellPrice").getValue().toString());
        BigDecimal roundOff1 = b.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        holder.Offer.setText(roundOff1.toString());

        if (PerferredFragment.tag_CuHiLo == 0) {
            BigDecimal c= new BigDecimal(dataSnap.child("CurrentPrice").getValue().toString());
            BigDecimal roundOff2 = c.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            holder.Current.setText(roundOff2.toString());
        } else {
            if (PerferredFragment.tag_CuHiLo == 1) {
                BigDecimal c= new BigDecimal(dataSnap.child("HighPrice").getValue().toString());
                BigDecimal roundOff2 = c.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                holder.Current.setText(roundOff2.toString());
            } else {
                if (PerferredFragment.tag_CuHiLo == 2) {
                    BigDecimal c= new BigDecimal(dataSnap.child("LowPrice").getValue().toString());
                    BigDecimal roundOff2 = c.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    holder.Current.setText(roundOff2.toString());
                }


            }
        }
        return convertView;


    }}