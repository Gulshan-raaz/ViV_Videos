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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.BaseAdapter;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.widget.AdapterView;
import android.view.View;
import android.graphics.Typeface;
import com.bumptech.glide.Glide;

public class CategoryActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String key_title = "";
	private String key_imageurl = "";
	private String key_videourl = "";
	private String val = "";
	private double n = 0;
	private double len = 0;
	private double intent = 0;
	private String image = "";
	private String videourl = "";
	private double a = 0;
	private double exit = 0;
	private double messageTime = 0;
	private double difference = 0;
	private HashMap<String, Object> simple_map = new HashMap<>();
	private double limit = 0;
	private String pick = "";
	private double newcheck = 0;
	private String random2 = "";
	private String spin = "";
	
	private ArrayList<HashMap<String, Object>> list_map_save_online = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> map1 = new ArrayList<>();
	private ArrayList<String> liststring_map1 = new ArrayList<>();
	private ArrayList<String> push_likes = new ArrayList<>();
	private ArrayList<String> st = new ArrayList<>();
	private ArrayList<String> sp = new ArrayList<>();
	
	private LinearLayout linear3;
	private LinearLayout linear5;
	private ImageView imageview1;
	private TextView textview2;
	private LinearLayout linear6;
	private Spinner spinner1;
	private ListView listview1;
	
	private DatabaseReference db = _firebase.getReference("firebase2");
	private ChildEventListener _db_child_listener;
	private Intent i = new Intent();
	private SharedPreferences data;
	private Calendar c = Calendar.getInstance();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.category);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		listview1 = (ListView) findViewById(R.id.listview1);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				spin = sp.get((int)(_position));
				limit = 10000;
				query = db.limitToLast((int)limit);
				
				query.addValueEventListener(valueEventListener1);
			}
			com.google.firebase.database.Query query;
			
			ValueEventListener valueEventListener1 = new ValueEventListener() {
				@Override public void onDataChange(DataSnapshot _param1) {
					try {
						st.clear();
						map1.clear();
						GenericTypeIndicator < HashMap< String, Object>> _ind = new GenericTypeIndicator<HashMap< String, Object>>() {};
						
						for (DataSnapshot _data : _param1.getChildren()) {
							st.add(_data.getKey());
							HashMap <String, Object> _map= _data.getValue(_ind);
							map1.add(_map); }
						n = map1.size() - 1;
						len = map1.size();
						for(int _repeat25 = 0; _repeat25 < (int)(len); _repeat25++) {
							if (map1.get((int)n).get("categories").toString().toLowerCase().equals(val.toLowerCase()) && map1.get((int)n).get("language").toString().equals(spin)) {
								
							}
							else {
								map1.remove((int)(n));
							}
							n--;
						}
						if (random2.equals("database2")) {
							listview1.setAdapter(new Listview1Adapter(map1));
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
							random2 = "Nodatabase2";
						}
						else {
							try {
								((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
							} catch(Exception e) {
								
								
								 
								
								
								
								 } 
						}
					} catch (Exception e) {
						
						
						 
						
						
						
						 } } 
				
				
				@Override public void onCancelled(DatabaseError databaseError) { } }; {
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				newcheck = _position;
				i.putExtra("key_offline_imageurl", map1.get((int)(map1.size() - 1) - _position).get("imageurl").toString());
				i.putExtra("key_offline_videourl", map1.get((int)(map1.size() - 1) - _position).get("videourl").toString());
				i.putExtra("key_offline_name", map1.get((int)(map1.size() - 1) - _position).get("name").toString());
				i.putExtra("key_offline_language", map1.get((int)(map1.size() - 1) - _position).get("language").toString());
				i.putExtra("key_offline_category", map1.get((int)(map1.size() - 1) - _position).get("categories").toString());
				i.putExtra("position", map1.get((int)(map1.size() - 1) - _position).get("childkey").toString());
				i.setClass(getApplicationContext(), VideoplayerActivity.class);
				startActivity(i);
			}
		});
		
		_db_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		db.addChildEventListener(_db_child_listener);
	}
	private void initializeLogic() {
		val = getIntent().getStringExtra("pass_key");
		sp.add("Hindi");
		sp.add("English");
		sp.add("Panjabi");
		sp.add("Hariyanvi");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, sp));
		((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
		random2 = "database2";
		pick = String.valueOf((long)(SketchwareUtil.getRandom((int)(0), (int)(1))));
		_repple(imageview1);
		linear3.setElevation(5f);
		textview2.setText(val);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	private void _repple (final View _v) {
		int[] attrs = new int[]{android.R.attr.selectableItemBackgroundBorderless};
				android.content.res.TypedArray typedArray = this.obtainStyledAttributes(attrs);
				int backgroundResource = typedArray.getResourceId(0, 0);
				_v.setBackgroundResource(backgroundResource);
		
		_v.setClickable(true);
	}
	
	
	private void _sipnner () {
		sp.add("Hindi");
		sp.add("English");
		sp.add("Panjabi");
		sp.add("Hariyanvi");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, sp));
		((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
	}
	
	
	private void _listview () {
		limit = 10000;
		query = db.limitToLast((int)limit);
		
		query.addValueEventListener(valueEventListener1);
	}
	com.google.firebase.database.Query query;
	
	ValueEventListener valueEventListener1 = new ValueEventListener() {
		@Override public void onDataChange(DataSnapshot _param1) {
			try {
				st.clear();
				map1.clear();
				GenericTypeIndicator < HashMap< String, Object>> _ind = new GenericTypeIndicator<HashMap< String, Object>>() {};
				
				for (DataSnapshot _data : _param1.getChildren()) {
					st.add(_data.getKey());
					HashMap <String, Object> _map= _data.getValue(_ind);
					map1.add(_map); }
				if (random2.equals("database2")) {
					listview1.setAdapter(new Listview1Adapter(map1));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					random2 = "Nodatabase2";
				}
				else {
					
				}
			} catch (Exception e) {
				
				
				 
				
				
				
				 } } 
		
		
		@Override public void onCancelled(DatabaseError databaseError) { } }; {
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
				_v = _inflater.inflate(R.layout.custom, null);
			}
			
			final LinearLayout linear2 = (LinearLayout) _v.findViewById(R.id.linear2);
			final LinearLayout linear1 = (LinearLayout) _v.findViewById(R.id.linear1);
			final LinearLayout linear3 = (LinearLayout) _v.findViewById(R.id.linear3);
			final LinearLayout linear5 = (LinearLayout) _v.findViewById(R.id.linear5);
			final TextView textview1 = (TextView) _v.findViewById(R.id.textview1);
			final TextView textview4 = (TextView) _v.findViewById(R.id.textview4);
			final ImageView imageview4 = (ImageView) _v.findViewById(R.id.imageview4);
			final LinearLayout linear_4 = (LinearLayout) _v.findViewById(R.id.linear_4);
			final ImageView imageview5 = (ImageView) _v.findViewById(R.id.imageview5);
			final TextView textview2 = (TextView) _v.findViewById(R.id.textview2);
			final LinearLayout linear6 = (LinearLayout) _v.findViewById(R.id.linear6);
			final TextView textview3 = (TextView) _v.findViewById(R.id.textview3);
			final LinearLayout linear7 = (LinearLayout) _v.findViewById(R.id.linear7);
			final ImageView imageview6 = (ImageView) _v.findViewById(R.id.imageview6);
			final TextView textview5 = (TextView) _v.findViewById(R.id.textview5);
			
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
			textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothammedium1.ttf"), 0);
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothammedium1.ttf"), 0);
			textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothammedium1.ttf"), 0);
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor("#e8ebeb"));
			gd.setCornerRadius(30); 
			textview4.setBackground(gd); 
			
			
			android.graphics.drawable.GradientDrawable gd2 = new android.graphics.drawable.GradientDrawable();
			gd2.setColor(Color.parseColor("#e8ebeb"));
			gd2.setCornerRadius(30); 
			textview3.setBackground(gd2); 
			
			
			Glide.with(getApplicationContext()).load(Uri.parse(map1.get((int)(map1.size() - 1) - _position).get("imageurl").toString())).into(imageview4);
			textview1.setText(map1.get((int)(map1.size() - 1) - _position).get("name").toString());
			textview3.setText(map1.get((int)(map1.size() - 1) - _position).get("categories").toString());
			textview4.setText(map1.get((int)(map1.size() - 1) - _position).get("language").toString());
			textview2.setText(map1.get((int)(map1.size() - 1) - _position).get("likes").toString());
			textview5.setText(map1.get((int)(map1.size() - 1) - _position).get("views").toString());
			
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
