package com.av.thegroup;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.renderscript.Sampler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Adapter.PerferredStockDataAdapter;
import ParserJson.ParseUtilites;

/**
 * Created by Lobna on 2/1/2017.
 */
public class PerferredFragment extends Fragment {
   public static  ArrayList<AllStockData> get_allstockdata;
    ListView list_perferred;
     public PerferredStockDataAdapter perferredStockDataAdapter;
     static TextView Company,percentage_value,Bid,offer,Current,Market_Index;
    public static int tag_valuepercentage = 0;
    public static int tag_companysymbol = 0;
    public static int tag_CuHiLo = 0;
    DatabaseReference myRef,myRef2;
    AllStockData allStockData;

   public static DataSnapshot pardedataSnapshot;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.activity_perferred, container, false);
        list_perferred = (ListView) rootView.findViewById(R.id.list_perferred);
        get_allstockdata=new ArrayList<>();

       // new PerferredStockData().execute(1);
        Company=(TextView)rootView.findViewById(R.id.txt_company);
        percentage_value=(TextView)rootView.findViewById(R.id.txt_valuepercentage);
        Current=(TextView)rootView.findViewById(R.id.txt_current);
        Market_Index=(TextView)rootView.findViewById(R.id.txt_valuemarket);


        perferredStockDataAdapter = new PerferredStockDataAdapter(getActivity());


        final FirebaseDatabase database= FirebaseDatabase.getInstance();
        myRef = database.getReference();
        myRef2= database.getReference();
        //myRef = myRef.child("Market_Data");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataSnapshot = dataSnapshot.child("Stocks_Data");
                pardedataSnapshot=dataSnapshot;
               /* for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {

                    DataSnapshot dataSnap = dataSnapshot.child(String.valueOf(i));
                    allStockData = new AllStockData();

                    allStockData.setCompanySymbol(dataSnap.child("Symbol").getValue().toString());
                    allStockData.setCompanyEn(dataSnap.child("NameEn").getValue().toString());
                    allStockData.setCompanyAr(dataSnap.child("NameAr").getValue().toString());
                    allStockData.setHighPrice(dataSnap.child("HighPrice").getValue().toString());
                    allStockData.setLowPrice(dataSnap.child("LowPrice").getValue().toString());
                    allStockData.setChangeSign(dataSnap.child("ChangeSign").getValue().toString());
                    allStockData.setChangeValue(dataSnap.child("ChangeValue").getValue().toString());
                    allStockData.setBuyPrice(dataSnap.child("BuyPrice").getValue().toString());
                    allStockData.setSellPrice(dataSnap.child("SellPrice").getValue().toString());
                    allStockData.setTradeVolume(dataSnap.child("TradeVolume").getValue().toString());
                    allStockData.setTradeValue(dataSnap.child("TradeValue").getValue().toString());
                    allStockData.setNoOfTrades(dataSnap.child("NoOfTrades").getValue().toString());
                    allStockData.setCurrentPrice(dataSnap.child("CurrentPrice").getValue().toString());
                    allStockData.setChangePercentage(dataSnap.child("ChangePercentage").getValue().toString());

                    get_allstockdata.add(allStockData);
                    //  j.setText( s);

                }
*/

                list_perferred.setAdapter(perferredStockDataAdapter);
             //   perferredStockDataAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });

        list_perferred.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                /*String info = ((TextView) view).getText().toString();
                Toast.makeText(PerferredFragment.this.getActivity(), "Item "+info, Toast.LENGTH_LONG).show();*/
            }
        });


        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
              final  DataSnapshot  data = dataSnapshot.child("Market_Data").child("CurrentMarketIndex");
                Market_Index.setText(data.getValue().toString());

           /*    Market_Index.addTextChangedListener(new TextWatcher() {

                    String x=Market_Index.getText().toString();

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

                            Market_Index.setBackgroundResource(R.color.sign_plus);

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Market_Index.setBackgroundResource(R.color.text_black);
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


               );
                */
           /*     try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
          //     Market_Index.setBackgroundResource(R.color.text_black);


              /*  Market_Index.addTextChangedListener(new TextWatcher() {

                    private boolean mWasEdited = false;
                    String x=data.getValue().toString();
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                          //  Market_Index.setBackgroundResource(R.color.color_itemtext);
                        *//*  x= s.toString();
                         Market_Index.setBackgroundResource(R.color.color_itemtext);*//*

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count,int after) {
                      //  Market_Index.setBackgroundResource(R.color.color_itemtext);

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                       // Market_Index.setText(x);
                        if (mWasEdited){

                            mWasEdited = false;
                            Market_Index.setBackgroundResource(R.color.color_itemtext);

                            return;
                        }

                        // get entered value (if required)
                        String enteredValue  = s.toString();

                        String newValue =data.getValue().toString();

                        // don't get trap into infinite loop
                        mWasEdited = true;
                        // just replace entered value with whatever you want
                        s.replace(0, s.length(), newValue);
                        Market_Index.setBackgroundResource(R.color.sign_plus);

                    }
                });*/
             /*   Market_Index.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        Market_Index.setText(s.getValue().toString());
                        Market_Index.setBackgroundResource(R.color.sign_plus);

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });*/
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        Company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag_companysymbol==0){
                    Company.setText("Company");

                    tag_companysymbol=1;
                }else{
                    Company.setText("Symbol");

                    tag_companysymbol=0;

                }
                perferredStockDataAdapter.notifyDataSetChanged();
            }
        });


        percentage_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tag_valuepercentage == 0) {
                    percentage_value.setText("Value");
                    tag_valuepercentage = 1;
                } else {
                    percentage_value.setText("%");

                    tag_valuepercentage = 0;

                }
                perferredStockDataAdapter.notifyDataSetChanged();

            }

        });

        Current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tag_CuHiLo == 0) {
                    Current.setText("Current");
                    tag_CuHiLo = 1;
                } else {
                    if (tag_CuHiLo == 1) {
                        Current.setText("High");
                        tag_CuHiLo = 2;
                    } else {
                        if (tag_CuHiLo == 2) {
                            Current.setText("Low");
                            tag_CuHiLo = 0;

                        }

                    }


                }
                perferredStockDataAdapter.notifyDataSetChanged();

            }

        });







        return rootView;

    }

/*   public  class PerferredStockData extends AsyncTask<Integer,Void,ArrayList<AllStockData>>{

        @Override
        protected ArrayList<AllStockData> doInBackground(Integer... params) {

            return ParseUtilites.ParseStockDate(params[0]);
        }

        @Override
        protected void onPostExecute(ArrayList<AllStockData> allStockDatas) {

            get_allstockdata=allStockDatas;
            perferredStockDataAdapter=new PerferredStockDataAdapter(getActivity(),get_allstockdata);
            list_perferred.setAdapter(perferredStockDataAdapter);
            perferredStockDataAdapter.notifyDataSetChanged();


        }
    }*/

}
