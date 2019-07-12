package com.app.multiitembasequickadapterdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private RecyclerView recyclerView;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcy_recyclerview);
        mainAdapter = new MainAdapter(getMultiItemDatas());
        mainAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                getMoreMultiItemDatas();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainAdapter.loadMoreComplete();
                mainAdapter.notifyDataSetChanged();
            }
        },recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainAdapter);
    }
    public static List<MyMultiItemEntity> getMultiItemDatas() {
        List<MyMultiItemEntity> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MyMultiItemEntity multiItem = new MyMultiItemEntity();
            if (i % 2 == 0) {
                multiItem.setItemType( MyMultiItemEntity.SEND);
                multiItem.setContent("海，你好");
            } else {
                multiItem.setItemType(MyMultiItemEntity.FROM);
                multiItem.setContent("大哥，你别怕");
            }
            list.add(multiItem);
        }
        return list;
    }
    public static List<MyMultiItemEntity> getMoreMultiItemDatas() {
        List<MyMultiItemEntity> list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            MyMultiItemEntity multiItem = new MyMultiItemEntity();
            if (i % 2 == 0) {
                multiItem.setItemType( MyMultiItemEntity.SEND);
                multiItem.setContent("海，你好");
            } else {
                multiItem.setItemType(MyMultiItemEntity.FROM);
                multiItem.setContent("大哥，你别怕");
            }
            list.add(multiItem);
        }
        return list;
    }
}
