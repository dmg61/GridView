package com.example.mygrid;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

public class MainActivity extends ActionBarActivity {
	
	GridView gridView;
	ArrayList<Item> gridArray = new ArrayList<Item>();
	CustomGridViewAdapter customGridAdapter;
	int IDPictures[] = {R.drawable.cat0, R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4,
				R.drawable.cat5, R.drawable.cat6, R.drawable.cat7, R.drawable.cat8, 
				R.drawable.cat9, R.drawable.cat10, R.drawable.cat11, R.drawable.cat12};
	String namePictures[] = {"Вася", "Петя", "Женя", "Мурзик", "Джуля", "Клаша", "Игорек", "Фигаро", "Ленивец", "Пух", "Тимоша", "Кузя", "Изя"};
	int sizeMass = 11;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Установка данных в GridView
		Bitmap picture;
		
		for (int i = 0; i < sizeMass; i++)
		{
			picture = BitmapFactory.decodeResource(this.getResources(), IDPictures[i]);
			
			gridArray.add(new Item(picture, namePictures[i]));
		}

		gridView = (GridView) findViewById(R.id.gridView1);
		customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
		gridView.setAdapter(customGridAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
