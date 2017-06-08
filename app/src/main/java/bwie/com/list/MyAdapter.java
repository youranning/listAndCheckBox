package bwie.com.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by $USER_NAME on 2017/6/8.
 */

public class MyAdapter extends BaseAdapter {
    Context context;

    List<Bean> list;

    public MyAdapter(Context context, List<Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=View.inflate(context,R.layout.item,null);
            viewHolder.textView= (TextView) convertView.findViewById(R.id.tv);
            viewHolder.cb= (CheckBox) convertView.findViewById(R.id.cb);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(list.get(position).getContent());
        viewHolder.cb.setChecked(list.get(position).isChecked());

        viewHolder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(position).isChecked()){
                    list.get(position).setChecked(false);
                    viewHolder.cb.setChecked(false);
                } else {
                    list.get(position).setChecked(true);
                    viewHolder.cb.setChecked(true);
                }

                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    class ViewHolder {
        TextView textView;
        CheckBox cb;
    }
}
