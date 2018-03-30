package jiyun.com.xiongmao.http;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import jiyun.com.xiongmao.greendao.DaoMaster;
import jiyun.com.xiongmao.greendao.PingLunDao;

public class GreenDaoUtils {

    public static PingLunDao getInstance(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "pinglun");
        SQLiteDatabase writableDatabase = helper.getWritableDatabase();
        DaoMaster master = new DaoMaster(writableDatabase);
        PingLunDao pingLunDao = master.newSession().getPingLunDao();
        return pingLunDao;
    }
}
