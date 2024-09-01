package com.NBNSTIC.AmitJadhav.Raksha.Resources.ME;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.NBNSTIC.AmitJadhav.Raksha.Resources.CourseClass;
import com.NBNSTIC.AmitJadhav.Raksha.R;

import java.util.ArrayList;
import java.util.List;


public class MECourseAdapter extends BaseAdapter {


    private final Context mContext;
    private final List<CourseClass> courseList;


     MECourseAdapter(Context context, ArrayList<CourseClass> arrayList) {
        this.mContext = context;
        this.courseList = arrayList;
    }



    public int getCount() {
        return courseList.size();
    }

    public Object getItem(int pos) {
        return courseList.get(pos);
    }


    public long getItemId(int i) {
        return i;
    }


    public View getView(final int i, View view, ViewGroup viewGroup) {


        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.course_me_cell, viewGroup, false);
        }

        TextView courseNo=view.findViewById(R.id.course_me_name);
        TextView courseName=view.findViewById(R.id.course_me_no);

        final CourseClass course = courseList.get(i);

        courseNo.setText(course.getCourseNo());
        courseName.setText(course.getCourseName());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent=new Intent(mContext,MEResourceDocs.class);
               intent.putExtra("meCourseName",course.getCourseName());
               intent.putExtra("meCourseNo",course.getCourseNo());
               mContext.startActivity(intent);

            }
        });
        return view;
    }
}
