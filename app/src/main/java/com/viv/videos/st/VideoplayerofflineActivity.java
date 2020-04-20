package com.viv.videos.st;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.support.v7.app.AppCompatActivity;
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.graphics.Typeface;
import com.bumptech.glide.Glide;
import android.support.v4.content.ContextCompat;
import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class VideoplayerofflineActivity extends AppCompatActivity {
	
	
	private String pass = "";
	private String str = "";
	private String t = "";
	private String v = "";
	private double gone = 0;
	private double nu = 0;
	private double number = 0;
	private HashMap<String, Object> map = new HashMap<>();
	private String file2 = "";
	private String double_val = "";
	
	private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();
	private ArrayList<String> save = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> file = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout space2;
	private LinearLayout linear7;
	private LinearLayout space1;
	private LinearLayout linear5;
	private LinearLayout linear8;
	private TextView textview1;
	private LinearLayout full;
	private ImageView imageview1;
	private LinearLayout share;
	private LinearLayout send;
	private ImageView imageview2;
	private ImageView imageview3;
	private ListView listview1;
	
	private Intent i = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.videoplayeroffline);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		space2 = (LinearLayout) findViewById(R.id.space2);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		space1 = (LinearLayout) findViewById(R.id.space1);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		textview1 = (TextView) findViewById(R.id.textview1);
		full = (LinearLayout) findViewById(R.id.full);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		share = (LinearLayout) findViewById(R.id.share);
		send = (LinearLayout) findViewById(R.id.send);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		listview1 = (ListView) findViewById(R.id.listview1);
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		full.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				nu = 1;
				getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
				
				 int width = getResources().getDisplayMetrics().widthPixels/1;
				
				
				
				int hei=getResources().getDisplayMetrics().heightPixels/1;  linear2.setLayoutParams(new LinearLayout.LayoutParams(width, hei));
				
				
				
			}
		});
		
		share.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				v = getIntent().getStringExtra("next");
				try { 
					
					Uri uri = Uri.parse(v);
					Intent videoshare = new Intent(Intent.ACTION_SEND); videoshare.setType("video/mp4"); 
					 videoshare.putExtra(Intent.EXTRA_STREAM,uri); startActivity(videoshare);
					
					
				} catch (Exception e) {
					SketchwareUtil.showMessage(getApplicationContext(), "Error");
				} 
			}
		});
		
		send.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				v = getIntent().getStringExtra("next");
				try {
					
					Uri uri = Uri.parse(v);
					Intent videoshare = new Intent(Intent.ACTION_SEND); videoshare.setType("video/mp4"); 
					videoshare.setPackage("com.whatsapp"); videoshare.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); videoshare.putExtra(Intent.EXTRA_STREAM,uri); startActivity(videoshare);
					
				} catch (Exception e) {
					SketchwareUtil.showMessage(getApplicationContext(), "Error");
				} 
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				map = file.get((int)_position);
				i.putExtra("next", map.get("key_value").toString());
				i.putExtra("next_title", map.get("key_value").toString());
				i.setClass(getApplicationContext(), VideoplayerofflineActivity.class);
				startActivity(i);
				finish();
			}
		});
	}
	private void initializeLogic() {
		 int width = getResources().getDisplayMetrics().widthPixels/1;
		
		
		
		int hei=getResources().getDisplayMetrics().heightPixels/3;  linear2.setLayoutParams(new LinearLayout.LayoutParams(width, hei));
		
		
		
		_file_();
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		vidview = new VideoView(this);
		vidview.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		linear2.addView(vidview);
		mediaControls = new MediaController(this); mediaControls.setAnchorView(vidview); vidview.setMediaController(mediaControls);
		t = getIntent().getStringExtra("next_title").replace("/storage/emulated/0/ViV_Videos/", "");
		textview1.setText(t.replace(".mp4", ""));
		double_val = textview1.getText().toString();
		str = getIntent().getStringExtra("next");
		vidview.setVideoURI(Uri.parse(str));
		vidview.start();
		
		
		
		_repple(share);
		_repple(send);
		_repple(full);
		_repple(linear8);
		_Elevation(share, 7);
		_Elevation(send, 7);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		if ((nu == 0) || (nu == 3)) {
			finish();
		}
		else {
			getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
			 int width = getResources().getDisplayMetrics().widthPixels/1;
			
			
			
			int hei=getResources().getDisplayMetrics().heightPixels/3;  linear2.setLayoutParams(new LinearLayout.LayoutParams(width, hei));
			
			
			
			nu = 3;
		}
	}
	private void _extra () {
	}
	VideoView vidview;
	MediaController mediaControls;
	{
	}
	
	
	private void _repple (final View _v) {
		int[] attrs = new int[]{android.R.attr.selectableItemBackgroundBorderless};
				android.content.res.TypedArray typedArray = this.obtainStyledAttributes(attrs);
				int backgroundResource = typedArray.getResourceId(0, 0);
				_v.setBackgroundResource(backgroundResource);
		
		_v.setClickable(true);
	}
	
	
	private void _file_ () {
		if (FileUtil.isExistFile("/storage/emulated/0/ViV_Videos")) {
			
		}
		else {
			FileUtil.makeDir("/storage/emulated/0/ViV_Videos");
		}
		FileUtil.listDir("/storage/emulated/0/ViV_Videos/", save);
		if (save.size() == 0) {
			
		}
		else {
			number = 0;
			for(int _repeat19 = 0; _repeat19 < (int)(save.size()); _repeat19++) {
				map = new HashMap<>();
				map.put("key_value", save.get((int)(number)));
				file.add(map);
				listview1.setAdapter(new Listview1Adapter(file));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				number++;
			}
		}
	}
	
	
	private void _Elevation (final View _view, final double _number) {
		
		_view.setElevation((int)_number);
	}
	
	
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _view, ViewGroup _viewGroup) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _view;
			if (_v == null) {
				_v = _inflater.inflate(R.layout.header3, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _v.findViewById(R.id.linear1);
			final LinearLayout linear2 = (LinearLayout) _v.findViewById(R.id.linear2);
			final LinearLayout linear3 = (LinearLayout) _v.findViewById(R.id.linear3);
			final ImageView imageview1 = (ImageView) _v.findViewById(R.id.imageview1);
			final TextView textview2 = (TextView) _v.findViewById(R.id.textview2);
			final TextView textview1 = (TextView) _v.findViewById(R.id.textview1);
			
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
			map = file.get((int)_position);
			textview1.setVisibility(View.GONE);
			textview1.setText(map.get("key_value").toString());
			t = map.get("key_value").toString().replace("/storage/emulated/0/ViV_Videos/", "");
			textview2.setText(t.replace(".mp4", ""));
			file2 = map.get("key_value").toString();
			
			Glide.with(getApplicationContext()).load(Uri.fromFile(new java.io.File(file2))).into(imageview1);
			if (double_val.equals(textview2.getText().toString())) {
				linear1.setVisibility(View.GONE);
			}
			else {
				linear1.setVisibility(View.VISIBLE);
			}
			
			return _v;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
