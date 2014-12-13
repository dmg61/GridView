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
  * Конструктор класса
  * \param [in] context - Контекст
  * \param [in] layoutRecourseId - Лейаут для элемента GridView
  * \param [in] data - Массив данных для отображения
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
  View row = convertView; // Ячейка отображения
  RecordHolder holder = null; // Вспомогательный класс

  if (row == null) {
   LayoutInflater inflater = ((Activity) context).getLayoutInflater(); // Получаем LayoutInflater
   row = inflater.inflate(layoutResourceId, parent, false); // Делаем из layout - файла View - элемент

   // Установка данных отображения в элемент GridView
   holder = new RecordHolder();
   holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
   holder.imageItem = (ImageView) row.findViewById(R.id.item_image);
   row.setTag(holder);
  } else {
   holder = (RecordHolder) row.getTag(); // Если запись уже есть, то получаем её структуру
  }

  Item item = data.get(position);
  holder.txtTitle.setText(item.getTitle());
  holder.imageItem.setImageBitmap(item.getImage());
  return row;

 }

 // Структура для оторбажения полей GridView
 static class RecordHolder {
  TextView txtTitle;
  ImageView imageItem;

 }
}
