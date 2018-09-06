package sendan.sharif.sendan.system;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;




public class G extends Application {

  public static Context context;
  public static final String MAIN_URL = "http://192.168.10.83/izi-bazi.ud/api";
  public static final String SALT = "7c3d596ed03ab9116c547b0eb678b247";


  private static final String AES = "AES";

  public static boolean isLoggedIn;


  @Override
  public void onCreate() {
    super.onCreate();
    context = getApplicationContext();
  }


  public static Context getActivityContext(AppCompatActivity activity) {
    return activity.getApplicationContext();
  }


}