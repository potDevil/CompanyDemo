package example.hulk.com.companydemo.get_apk_info;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import example.hulk.com.companydemo.R;

/**
 * @author: hulk
 * Version:  V1.0
 * Date:     2019-08-13
 * Description:
 * Modification History:
 */
public class GetApkInfoActivity extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_apk_info);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        try {
            tv1.setText(getVersionName(this, "com.hexun.stockspread"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            tv2.setText(getVersionCode(this, "com.hexun.stockspread") + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取指定包名的版本号
     *
     * @param context     本应用程序上下文
     * @param packageName 你想知道版本信息的应用程序的包名
     * @return
     * @throws Exception
     */
    public String getVersionName(Context context, String packageName) throws Exception {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packInfo = packageManager.getPackageInfo(packageName, 0);
        String version = packInfo.versionName;
        return version;
    }

    public int getVersionCode(Context context, String packageName) throws Exception {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packInfo = packageManager.getPackageInfo(packageName, 0);
        int version = packInfo.versionCode;
        return version;
    }
}
