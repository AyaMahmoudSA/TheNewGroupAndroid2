package StoreData;

import android.content.Context;
import android.content.SharedPreferences;

import com.av.thegroup.LoginActivity;

import ParserJson.App;

/**
 * Created by Aya on 2/1/2017.
 */

// that class store data of the group
public class StoreData  {
    SharedPreferences sharedPreferences=null;
    private SharedPreferences.Editor editor;
    private Context context;
    String DATABASE_NAME = "com.av.thegroup";

    public StoreData() {
        super();
        this.context= App.context;
        sharedPreferences = context.getSharedPreferences(DATABASE_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    public void SaveInverstorNumber(String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("InverstorNo", value);
        editor.commit();
    }

    public String LoadInverstorNumber() {
        String strSavedMem1 = sharedPreferences.getString("InverstorNo","");
        return strSavedMem1;

    }


    public void SavePassword(String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Password", value);
        editor.commit();
    }

    public String LoadPassword() {

        String strSavedMem1 = sharedPreferences.getString("Password","");
        return strSavedMem1;

    }

    public void Save_LoginState(int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Login_State", value);
        editor.commit();
    }

    public int Load_LoginState() {

        int strSavedMem1 = sharedPreferences.getInt("Login_State",0);
        return strSavedMem1;

    }

}
