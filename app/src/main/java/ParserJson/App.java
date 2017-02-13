package ParserJson;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

/**
 * Created by Lobna on 1/23/2017.
 */
public class App extends MultiDexApplication {
    public static String SessionID="";
    public static  int Tag_Login=0;
    public static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }
}
