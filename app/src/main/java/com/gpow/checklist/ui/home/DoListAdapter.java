package com.gpow.checklist.ui.home;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.gpow.checklist.R;

import java.util.ArrayList;
import java.util.Arrays;

public class DoListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList stuff;

    public DoListAdapter(Context context, DoListType listType) {

        this.context = context;
        if (listType == DoListType.TodoList) {
            fetchToDoInfo();
        }
        else if (listType == DoListType.NotTodoList) {
            fetchNotTodoInfo();
        }
    }

    private void fetchNotTodoInfo() {
        stuff = new ArrayList(Arrays.asList("No gaming until Friday evening", "No stock trading until 17:00"));
    }

    private void fetchToDoInfo() {
        stuff = new ArrayList(Arrays.asList("Publish ToDoList app", "Update Calendar"));
    }

    @Override
    public int getCount() {
        return stuff.size();
    }

    @Override
    public Object getItem(int i) {
        return stuff.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {

            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.do_item, null);

            TextView tv = (TextView) view.findViewById(R.id.doItemText);
            tv.setText((String) stuff.get(i));

//            // click listener for remove button  คลิกลบปุ่ม
//            rm_btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    modelList.remove(position);
//                    notifyDataSetChanged();
//                }
//            });
        }

        return view;
    }
}
