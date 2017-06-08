package bwie.com.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
int init=0;
    int num=20;
    private List<Bean> list;
    private MyAdapter adapter;
     int mFirstVisibleItem ; int mVisibleItemCount; int mFotalItemCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        addData();
        adapter = new MyAdapter(getApplication(),list);
        lv.setAdapter(adapter);
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if(scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE ){

                    //滚动停止
                    if(mFotalItemCount - mVisibleItemCount - mFirstVisibleItem <= 5){
                            init+=num;
                        for(int i=init;i<init+num;i++){

                            list.add(new Bean(i+"",false));
                        }
                        adapter.notifyDataSetChanged();

                    }

                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                mFirstVisibleItem = firstVisibleItem;
                mVisibleItemCount = visibleItemCount;
                mFotalItemCount = totalItemCount;
            }
        });
    }

    private void addData() {
        list = new ArrayList<>();
        for (int i=init;i<init+num;i++){
            list.add(new Bean(i+"",false));
        }
    }
}
