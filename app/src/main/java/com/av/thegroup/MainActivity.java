package com.av.thegroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import vv.com.residemenu.ResideMenu;
import vv.com.residemenu.ResideMenuItem;

/**
 * Created by AyaS on 1/22/2017.
 */
public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private ResideMenu resideMenu;
    private MainActivity mContext;

    private ResideMenuItem itempricescreen;
    private ResideMenuItem itemmarketDetails;
    private ResideMenuItem itemorders;
    private ResideMenuItem itemportfoloio;
    private ResideMenuItem itemheatmap;
    private ResideMenuItem itemshal;
    private ResideMenuItem itemcalc;
    private ResideMenuItem itemwatchlist;
    private ResideMenuItem itemsettings;

    Button PERFERRED,ACTIVE,GAINERS,LOSERS;
    TextView Company,percentage_value,Bid,offer,Current;
    static int tag_valuepercentage = 0;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PERFERRED=(Button)findViewById(R.id.btn_preferred);

        changeFragmentForButton(new PerferredFragment() );
/*

        PERFERRED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
*/

      /*  PERFERRED=(Button)findViewById(R.id.btn_preferred);
        ACTIVE=(Button)findViewById(R.id.btn_active);
        GAINERS=(Button)findViewById(R.id.btn_gainers);
        LOSERS=(Button)findViewById(R.id.btn_losers);

        //PERFERRED.setSelected(true);
        PERFERRED.setBackgroundDrawable(getResources().getDrawable(R.drawable.leftside));
        PERFERRED.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

        PERFERRED.setOnClickListener(this);
        GAINERS.setOnClickListener(this);
        LOSERS.setOnClickListener(this);
        ACTIVE.setOnClickListener(this);*/

       // changeFragmentForButton(new PerferredFragment());

        //once Open that screen set checked2
        /*if( savedInstanceState == null ) {
           changeFragment(new PerferredFragment());
       }*/
/*

        PERFERRED.setOnClickListener(this);
        GAINERS.setOnClickListener(this);
        LOSERS.setOnClickListener(this);
        ACTIVE.setOnClickListener(this);
*/


        //  PERFERRED.setOnClickListener(this);


   /*     PERFERRED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PERFERRED.setBackgroundDrawable(getResources().getDrawable(R.drawable.leftside));
                PERFERRED.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                changeFragmentForButton(new PerferredFragment());

            }
        });

        ACTIVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTIVE.setBackgroundDrawable(getResources().getDrawable(R.drawable.center));
                ACTIVE.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                changeFragmentForButton(new PerferredFragment());


            }
        });

        GAINERS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GAINERS.setBackgroundDrawable(getResources().getDrawable(R.drawable.center));
                GAINERS.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                changeFragmentForButton(new PerferredFragment());


            }
        });

        LOSERS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LOSERS.setBackgroundDrawable(getResources().getDrawable(R.drawable.rightside));
                LOSERS.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                changeFragmentForButton(new PerferredFragment());
            }
        });*/


        mContext = this;
        setUpMenu();




    }

    /*@Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        setdefault();
                changeFragment(new PerferredFragment() );

        switch (v.getId()) {

            case R.id.btn_preferred:
                PERFERRED.setBackgroundDrawable(getResources().getDrawable(R.drawable.leftside));
                PERFERRED.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
             //   changeFragmentForButton(new PerferredFragment());
                break;

            case R.id.btn_active:
                ACTIVE.setBackgroundDrawable(getResources().getDrawable(R.drawable.center));
                ACTIVE.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case R.id.btn_gainers:
                GAINERS.setBackgroundDrawable(getResources().getDrawable(R.drawable.center));
                GAINERS.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
            case R.id.btn_losers:
                LOSERS.setBackgroundDrawable(getResources().getDrawable(R.drawable.rightside));
                LOSERS.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;


        }
    }
*/

    public  void setdefault(){

        PERFERRED.setBackgroundDrawable(getResources().getDrawable(R.color.colorPrimaryDark));
        PERFERRED.setTextColor(getResources().getColor(R.color.color_itemtext));

        ACTIVE.setBackgroundDrawable(getResources().getDrawable(R.color.colorPrimaryDark));
        ACTIVE.setTextColor(getResources().getColor(R.color.color_itemtext));


        GAINERS.setBackgroundDrawable(getResources().getDrawable(R.color.colorPrimaryDark));
        GAINERS.setTextColor(getResources().getColor(R.color.color_itemtext));


        LOSERS.setBackgroundDrawable(getResources().getDrawable(R.color.colorPrimaryDark));
        LOSERS.setTextColor(getResources().getColor(R.color.color_itemtext));

    }

    private void setUpMenu() {

        // attach to current activity;
        resideMenu = new ResideMenu(this);
        // back ground light green
        resideMenu.setBackground(R.drawable.back_background);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
        resideMenu.setScaleValue(0.6f);

        // create menu items;
    /*1*/  itempricescreen    = new ResideMenuItem(this, R.drawable.ic_menu_price, "Prices");
    /*2*/  itemmarketDetails = new ResideMenuItem(this, R.drawable.ic_menu_marketdetails, "MarketDetails");
    /*3*/  itemorders = new ResideMenuItem(this, R.drawable.ic_menu_orders, "Orders");
    /*4*/  itemportfoloio = new ResideMenuItem(this, R.drawable.ic_menu_portfolio, "Portfolio");
    /*5*/  itemheatmap = new ResideMenuItem(this, R.drawable.ic_menu_heatmap, "HeatMap");
    /*6*/  itemshal = new ResideMenuItem(this, R.drawable.ic_menu_sahl, "Sahl");
    /*7*/  itemcalc = new ResideMenuItem(this, R.drawable.ic_menu_clac, "Calculator");
    /*8*/  itemwatchlist = new ResideMenuItem(this, R.drawable.ic_menu_watchlist, "WatchList");
    /*9*/  itemsettings = new ResideMenuItem(this, R.drawable.ic_menu_setting, "Settings");

        itempricescreen.setOnClickListener(this);
        itemmarketDetails.setOnClickListener(this);
        itemorders.setOnClickListener(this);
        itemportfoloio.setOnClickListener(this);
        itemheatmap.setOnClickListener(this);
        itemshal.setOnClickListener(this);
        itemcalc.setOnClickListener(this);
        itemwatchlist.setOnClickListener(this);
        itemsettings.setOnClickListener(this);

        resideMenu.addMenuItem(itempricescreen, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemmarketDetails, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemorders, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemportfoloio, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemheatmap, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemshal, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemcalc, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemwatchlist, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemsettings, ResideMenu.DIRECTION_LEFT);

        // You can disable a direction by setting ->
        // resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);

        findViewById(R.id.title_bar_left_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View view) {

        if (view == itempricescreen){
            changeFragment(new PerferredFragment());
        }else if (view == itemmarketDetails){
            // changeFragment(new ProfileFragment());
        }else if (view == itemorders){
            // changeFragment(new CalendarFragment());
        }else if (view == itemportfoloio){
            // changeFragment(new SettingsFragment());
        }

        resideMenu.closeMenu();
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
           // Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            //Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };


    private void changeFragment(Fragment targetFragment){
     resideMenu.clearIgnoredViewList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();






    }

    // What good method is to access resideMenu？
    public ResideMenu getResideMenu(){
        return resideMenu;
    }


    public static class PageFragment extends Fragment {
        public static final String ARG_PAGE = "ARG_PAGE";

        private int mPage;

        public static PageFragment newInstance(int page) {
            Bundle args = new Bundle();
            args.putInt(ARG_PAGE, page);
            PageFragment fragment = new PageFragment();
            fragment.setArguments(args);
            return fragment;
        }



    }


    private void changeFragmentForButton(Fragment targetFragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }



}
