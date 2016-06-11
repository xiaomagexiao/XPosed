package com.example.hookdemo.ui;

import com.example.hookdemo.model.HKInfoData;
import com.example.hookdemo.util.HKDataUtil;
import com.hook.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends Activity implements OnClickListener {

    private ListView lv_operatelist;

    private QuickAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.lv_operatelist = (ListView) this.findViewById(R.id.lv_operatelist);

        initAdapter();

        this.lv_operatelist.setAdapter(mAdapter);


        List<HKInfoData> list = HKDataUtil.parseJsonData(this);


        this.mAdapter.addAll(list);
    }

    private void initAdapter() {
        mAdapter = new QuickAdapter(this, R.layout.hook_item) {
            @Override
            protected void convert(BaseAdapterHelper helper, Object objModel) {
                final HKInfoData model = (HKInfoData) objModel;
                helper.setText(R.id.tv_team, model.packageName);
            }
        };
    }

    @Override
    public void onClick(View v) {

    }
}
