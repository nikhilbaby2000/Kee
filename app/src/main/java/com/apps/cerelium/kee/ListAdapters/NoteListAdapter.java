package com.apps.cerelium.kee.ListAdapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.apps.cerelium.kee.DataManager.FileManager;
import com.apps.cerelium.kee.R;

/**
 * Created by Nikhil on 25-02-2016.
 */
public class NoteListAdapter extends BaseAdapter {

    Context context;
    private  static LayoutInflater layoutInflater;
    String[][][] sections_main = new String[10][][];

    public NoteListAdapter(Context recContext) {
        context = recContext;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        FileManager fileManager = new FileManager();
        sections_main = fileManager.getSections();

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView = null;

        rowView = layoutInflater.inflate(R.layout.single_section_item,parent,false);

        final TextView TextViewTitle = (TextView) rowView.findViewById(R.id.noteTittle);
        final TextView createdDate = (TextView) rowView.findViewById(R.id.createdDate);
        final TextView modifiedDate = (TextView) rowView.findViewById(R.id.modifiedDate);
        final HorizontalScrollView sectionSubItemHList = (HorizontalScrollView) rowView.findViewById(R.id.sectionSubItemHList);
        final LinearLayout sectionSubItemHListLayout = (LinearLayout) rowView.findViewById(R.id.sectionSubItemHListLayout);

        try {
            TextViewTitle.setText(""+sections_main[position][0][0]);
            createdDate.setText(""+ sections_main[position][1][0]);
            modifiedDate.setText(""+ sections_main[position][2][0]);

            for (int i = 1; i <= Integer.parseInt(sections_main[position][3][0]) ; i++ )
            {
                TextView section_item = new TextView(sectionSubItemHList.getContext());
                section_item.setTextColor(Color.parseColor("#FF3E4B54"));
                section_item.setPadding(3,3,10,3);
                section_item.setTextSize(10);
                section_item.setText("✓ "+sections_main[position][3][i]);
                sectionSubItemHListLayout.addView(section_item);
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Total count_"+position+": " + sections_main[position][3][0]);
        }

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Clicked on item " + position, Toast.LENGTH_SHORT).show();
            }
        });



        return rowView;
    }



    @Override
    public int getCount() {

        FileManager fileManager = new FileManager();
        return fileManager.getSectionsCount() ;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
