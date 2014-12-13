package com.example.mygrid;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGridViewAdapter extends ArrayAdapter<Item> {
 Context context;
 int layoutResourceId;
 ArrayList<Item> data = new ArrayList<Item>();

 /*!
  * ����������� ������
  * \param [in] context - ��������
  * \param [in] layoutRecourseId - ������ ��� �������� GridView
  * \param [in] data - ������ ������ ��� �����������
  */
 public CustomGridViewAdapter(Context context, int layoutResourceId,
   ArrayList<Item> data) {
  super(context, layoutResourceId, data);
  this.layoutResourceId = layoutResourceId;
  this.context = context;
  this.data = data;
 }

 @Override
 public View getView(int position, View convertView, ViewGroup parent) {
  View row = convertView; // ������ �����������
  RecordHolder holder = null; // ��������������� �����

  if (row == null) {
   LayoutInflater inflater = ((Activity) context).getLayoutInflater(); // �������� LayoutInflater
   row = inflater.inflate(layoutResourceId, parent, false); // ������ �� layout - ����� View - �������

   // ��������� ������ ����������� � ������� GridView
   holder = new RecordHolder();
   holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
   holder.imageItem = (ImageView) row.findViewById(R.id.item_image);
   row.setTag(holder);
  } else {
   holder = (RecordHolder) row.getTag(); // ���� ������ ��� ����, �� �������� � ���������
  }

  Item item = data.get(position);
  holder.txtTitle.setText(item.getTitle());
  holder.imageItem.setImageBitmap(item.getImage());
  return row;

 }

 // ��������� ��� ����������� ����� GridView
 static class RecordHolder {
  TextView txtTitle;
  ImageView imageItem;

 }
}
