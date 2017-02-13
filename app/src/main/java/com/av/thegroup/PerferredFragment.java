package com.av.thegroup;

import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Adapter.PerferredStockDataAdapter;
import Models.AllStockData;
import ParserJson.ParseUtilites;

/**
 * Created by Lobna on 2/1/2017.
 */
public class PerferredFragment extends Fragment {
    ArrayList<AllStockData> get_allstockdata=new ArrayList<>();
    ListView list_perferred;
     public PerferredStockDataAdapter perferredStockDataAdapter;
     static TextView Company,percentage_value,Bid,offer,Current;
    public static int tag_valuepercentage = 0;
    public static int tag_companysymbol = 0;
    public static int tag_CuHiLo = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.activity_perferred,container,false);
        list_perferred = (ListView) rootView.findViewById(R.id.list_perferred);
        new PerferredStockData().execute(1);
        Company=(TextView)rootView.findViewById(R.id.txt_company);
        percentage_value=(TextView)rootView.findViewById(R.id.txt_valuepercentage);
        Current=(TextView)rootView.findViewById(R.id.txt_current);

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
                if(tag_valuepercentage==0){
                    percentage_value.setText("Value");
                    tag_valuepercentage=1;
                }else{
                    percentage_value.setText("%");

                    tag_valuepercentage=0;

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
                    if(tag_CuHiLo==1){
                        Current.setText("High");
                        tag_CuHiLo = 2;
                    }else{
                        if(tag_CuHiLo==2){
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

    public  class PerferredStockData extends AsyncTask<Integer,Void,ArrayList<AllStockData>>{

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
    }

}
