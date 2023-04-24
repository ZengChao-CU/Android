package com.example.listview_simpleadapter2;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;


public class MainActivity extends AppCompatActivity {
    private Cursor cursor;
    ListView listView;
    private Map<String,Object> listItem;
    private List<Map<String,Object>> listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbUtil dbUtil = new DbUtil(this);
        SQLiteDatabase db = dbUtil.getWritableDatabase();
        cursor = dbUtil.allQuery(db);
        listView=(ListView)findViewById(R.id.list_item);
        listData=new ArrayList<Map<String,Object>>();
        while(cursor.moveToNext()){
            long id = cursor.getInt(0);
            String name = cursor.getString(1);
            int no = cursor.getInt(2);
            listItem = new HashMap<String,Object>();
            listItem.put("_id", id);
            listItem.put("name", name);
            listItem.put("no", no);
            listData.add(listItem);
        }
        SimpleAdapter listAdapter = new SimpleAdapter(this,listData,
                R.layout.list_item,
                new String[]{"_id","name","no"},
                new int[]{R.id.id,R.id.name,R.id.no});
        listView.setAdapter(listAdapter);
    }
}