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
import android.support.design.widget.FloatingActionButton;
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ProgressBar;
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
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.graphics.Typeface;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.support.v4.content.ContextCompat;
import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private FloatingActionButton _fab;
	private String image = "";
	private String videourl = "";
	private double limit = 0;
	private String checkpos = "";
	private double newcheck = 0;
	private double n = 0;
	private double exit = 0;
	private double a = 0;
	private HashMap<String, Object> simple_map = new HashMap<>();
	private String key_title = "";
	private String key_imageurl = "";
	private String key_videourl = "";
	private String late = "";
	private double intent = 0;
	private double transLayersNum = 0;
	private double messageTime = 0;
	private double difference = 0;
	private String share = "";
	private boolean connected = false;
	private double pos = 0;
	private String your_version = "";
	private String latest_version = "";
	private String package_name = "";
	private HashMap<String, Object> map = new HashMap<>();
	private HashMap<String, Object> post_likes = new HashMap<>();
	private double fans = 0;
	private HashMap<String, Object> map_new = new HashMap<>();
	private double no = 0;
	private String string = "";
	private HashMap<String, Object> map_request = new HashMap<>();
	private String req = "";
	private double fresh = 0;
	private String fres = "";
	private double newcheck2 = 0;
	private String posi = "";
	private String str = "";
	private String random = "";
	private HashMap<String, Object> map2 = new HashMap<>();
	private double number = 0;
	private String file2 = "";
	private String v = "";
	private String value = "";
	private String t2 = "";
	private String key_position = "";
	private String key_category = "";
	private String key_language = "";
	private String onStart = "";
	
	private ArrayList<HashMap<String, Object>> map1 = new ArrayList<>();
	private ArrayList<String> st = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> map_1 = new ArrayList<>();
	private ArrayList<String> push_likes = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> gridmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap2 = new ArrayList<>();
	private ArrayList<String> save = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> file = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> list_map_save_online = new ArrayList<>();
	
	private LinearLayout main_linear;
	private LinearLayout linear_ads;
	private LinearLayout retry_layout;
	private LinearLayout linear2;
	private LinearLayout screen3;
	private LinearLayout screen4;
	private ListView listview1;
	private LinearLayout screen2_cato;
	private LinearLayout linear3;
	private LinearLayout ad;
	private LinearLayout linear8;
	private ImageView imageview2;
	private TextView textview2;
	private LinearLayout linear9;
	private LinearLayout linear13;
	private LinearLayout item;
	private ImageView imageview13;
	private ImageView imageview7;
	private ImageView imageview12;
	private ImageView imageview1;
	private TextView textview1;
	private ProgressBar progressbar1;
	private LinearLayout linear12;
	private ListView listview3;
	private TextView textview6;
	private LinearLayout linear11;
	private ListView listview4;
	private TextView textview5;
	private ListView listview2;
	private LinearLayout grid_layout;
	private LinearLayout latest_;
	private LinearLayout category_;
	private LinearLayout favorite_;
	private LinearLayout download_;
	private ImageView imageview8;
	private ImageView imageview9;
	private ImageView imageview10;
	private ImageView imageview11;
	
	private DatabaseReference db = _firebase.getReference("firebase2");
	private ChildEventListener _db_child_listener;
	private Intent i = new Intent();
	private SharedPreferences shared;
	private RequestNetwork in;
	private RequestNetwork.RequestListener _in_request_listener;
	private AlertDialog.Builder d;
	private Intent i2 = new Intent();
	private AlertDialog.Builder d2;
	private TimerTask t;
	private SharedPreferences data;
	private Calendar c = Calendar.getInstance();
	private Intent i3 = new Intent();
	private DatabaseReference db2 = _firebase.getReference("menu");
	private ChildEventListener _db2_child_listener;
	private DatabaseReference var = _firebase.getReference("version");
	private ChildEventListener _var_child_listener;
	private DatabaseReference db3 = _firebase.getReference("request");
	private ChildEventListener _db3_child_listener;
	private Intent is = new Intent();
	private Intent is2 = new Intent();
	private Intent is3 = new Intent();
	private Intent is4 = new Intent();
	private Intent is5 = new Intent();
	private Intent is6 = new Intent();
	private DatabaseReference db4 = _firebase.getReference("language");
	private ChildEventListener _db4_child_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
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
		
		_fab = (FloatingActionButton) findViewById(R.id._fab);
		
		main_linear = (LinearLayout) findViewById(R.id.main_linear);
		linear_ads = (LinearLayout) findViewById(R.id.linear_ads);
		retry_layout = (LinearLayout) findViewById(R.id.retry_layout);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		screen3 = (LinearLayout) findViewById(R.id.screen3);
		screen4 = (LinearLayout) findViewById(R.id.screen4);
		listview1 = (ListView) findViewById(R.id.listview1);
		screen2_cato = (LinearLayout) findViewById(R.id.screen2_cato);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		ad = (LinearLayout) findViewById(R.id.ad);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview2 = (TextView) findViewById(R.id.textview2);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		item = (LinearLayout) findViewById(R.id.item);
		imageview13 = (ImageView) findViewById(R.id.imageview13);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		imageview12 = (ImageView) findViewById(R.id.imageview12);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		progressbar1 = (ProgressBar) findViewById(R.id.progressbar1);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		listview3 = (ListView) findViewById(R.id.listview3);
		textview6 = (TextView) findViewById(R.id.textview6);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		listview4 = (ListView) findViewById(R.id.listview4);
		textview5 = (TextView) findViewById(R.id.textview5);
		listview2 = (ListView) findViewById(R.id.listview2);
		grid_layout = (LinearLayout) findViewById(R.id.grid_layout);
		latest_ = (LinearLayout) findViewById(R.id.latest_);
		category_ = (LinearLayout) findViewById(R.id.category_);
		favorite_ = (LinearLayout) findViewById(R.id.favorite_);
		download_ = (LinearLayout) findViewById(R.id.download_);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		imageview9 = (ImageView) findViewById(R.id.imageview9);
		imageview10 = (ImageView) findViewById(R.id.imageview10);
		imageview11 = (ImageView) findViewById(R.id.imageview11);
		shared = getSharedPreferences("s", Activity.MODE_PRIVATE);
		in = new RequestNetwork(this);
		d = new AlertDialog.Builder(this);
		d2 = new AlertDialog.Builder(this);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				newcheck2 = _position;
				i.putExtra("key_offline_imageurl", map1.get((int)(map1.size() - 1) - _position).get("imageurl").toString());
				i.putExtra("key_offline_videourl", map1.get((int)(map1.size() - 1) - _position).get("videourl").toString());
				i.putExtra("key_offline_name", map1.get((int)(map1.size() - 1) - _position).get("name").toString());
				i.putExtra("key_offline_language", map1.get((int)(map1.size() - 1) - _position).get("language").toString());
				i.putExtra("key_offline_category", map1.get((int)(map1.size() - 1) - _position).get("categories").toString());
				i.putExtra("position", st.get((int)((st.size() - 1) - _position)));
				i.setClass(getApplicationContext(), VideoplayerActivity.class);
				startActivity(i);
			}
		});
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
		});
		
		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					((BaseAdapter)listview3.getAdapter()).notifyDataSetChanged();
				} catch(Exception e) {
					
					
					 
					
					
					
					 } 
			}
		});
		
		imageview13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				save.clear();
				file.clear();
				FileUtil.listDir("/storage/emulated/0/ViV_Videos/", save);
				if (save.size() == 0) {
					listview4.setVisibility(View.GONE);
					linear11.setVisibility(View.VISIBLE);
				}
				else {
					listview4.setVisibility(View.VISIBLE);
					linear11.setVisibility(View.GONE);
					number = 0;
					for(int _repeat22 = 0; _repeat22 < (int)(save.size()); _repeat22++) {
						map2 = new HashMap<>();
						map2.put("key_value", save.get((int)(number)));
						file.add(map2);
						listview4.setAdapter(new Listview4Adapter(file));
						((BaseAdapter)listview4.getAdapter()).notifyDataSetChanged();
						number++;
					}
				}
				_snackbar("Refreshing");
			}
		});
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				is5.setClass(getApplicationContext(), SearchActivity.class);
				startActivity(is5);
			}
		});
		
		imageview12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_bottom_menu_nav();
			}
		});
		
		listview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				simple_map = list_map_save_online.get((int)_position);
				i.putExtra("key_offline_videourl", simple_map.get(key_videourl).toString());
				i.putExtra("key_offline_name", simple_map.get(key_title).toString());
				i.putExtra("key_offline_imageurl", simple_map.get(key_imageurl).toString());
				i.putExtra("key_offline_language", simple_map.get(key_language).toString());
				i.putExtra("key_offline_category", simple_map.get(key_category).toString());
				i.putExtra("position", simple_map.get(key_position).toString());
				i.setClass(getApplicationContext(), VideoplayerActivity.class);
				startActivity(i);
			}
		});
		
		listview4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				map2 = file.get((int)_position);
				i.putExtra("next", map2.get("key_value").toString());
				i.putExtra("next_title", map2.get("key_value").toString());
				i.setClass(getApplicationContext(), VideoplayerofflineActivity.class);
				startActivity(i);
			}
		});
		
		latest_.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				listview1.setVisibility(View.VISIBLE);
				screen2_cato.setVisibility(View.GONE);
				screen3.setVisibility(View.GONE);
				screen4.setVisibility(View.GONE);
				item.setVisibility(View.VISIBLE);
				imageview13.setVisibility(View.GONE);
				textview2.setText("Latest");
				imageview8.getDrawable().setColorFilter(Color.parseColor("#FF2C5B"), PorterDuff.Mode.SRC_IN);
				
				imageview9.getDrawable().setColorFilter(Color.parseColor("#CCCCCC"), PorterDuff.Mode.SRC_IN);
				
				imageview10.getDrawable().setColorFilter(Color.parseColor("#CCCCCC"), PorterDuff.Mode.SRC_IN);
				
				imageview11.getDrawable().setColorFilter(Color.parseColor("#CCCCCC"), PorterDuff.Mode.SRC_IN);
			}
		});
		
		category_.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview9.getDrawable().setColorFilter(Color.parseColor("#FF2C5B"), PorterDuff.Mode.SRC_IN);
				
				imageview10.getDrawable().setColorFilter(Color.parseColor("#CCCCCC"), PorterDuff.Mode.SRC_IN);
				
				imageview8.getDrawable().setColorFilter(Color.parseColor("#CCCCCC"), PorterDuff.Mode.SRC_IN);
				
				imageview11.getDrawable().setColorFilter(Color.parseColor("#CCCCCC"), PorterDuff.Mode.SRC_IN);
				_fab.setVisibility(View.INVISIBLE);
				screen2_cato.setVisibility(View.VISIBLE);
				listview1.setVisibility(View.GONE);
				screen3.setVisibility(View.GONE);
				screen4.setVisibility(View.GONE);
				textview2.setText("Category");
				item.setVisibility(View.VISIBLE);
				imageview13.setVisibility(View.GONE);
			}
		});
		
		favorite_.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview10.getDrawable().setColorFilter(Color.parseColor("#FF2C5B"), PorterDuff.Mode.SRC_IN);
				
				imageview9.getDrawable().setColorFilter(Color.parseColor("#CCCCCC"), PorterDuff.Mode.SRC_IN);
				
				imageview8.getDrawable().setColorFilter(Color.parseColor("#CCCCCC"), PorterDuff.Mode.SRC_IN);
				
				imageview11.getDrawable().setColorFilter(Color.parseColor("#CCCCCC"), PorterDuff.Mode.SRC_IN);
				
				_fab.setVisibility(View.INVISIBLE);
				listview1.setVisibility(View.GONE);
				screen2_cato.setVisibility(View.GONE);
				screen3.setVisibility(View.VISIBLE);
				screen4.setVisibility(View.GONE);
				textview2.setText("Favorite");
				linear2.setVisibility(View.GONE);
				item.setVisibility(View.VISIBLE);
				imageview13.setVisibility(View.GONE);
			}
		});
		
		download_.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview11.getDrawable().setColorFilter(Color.parseColor("#FF2C5B"), PorterDuff.Mode.SRC_IN);
				
				imageview9.getDrawable().setColorFilter(Color.parseColor("#CCCCCC"), PorterDuff.Mode.SRC_IN);
				
				imageview10.getDrawable().setColorFilter(Color.parseColor("#CCCCCC"), PorterDuff.Mode.SRC_IN);
				
				imageview8.getDrawable().setColorFilter(Color.parseColor("#CCCCCC"), PorterDuff.Mode.SRC_IN);
				_fab.setVisibility(View.INVISIBLE);
				listview1.setVisibility(View.GONE);
				screen2_cato.setVisibility(View.GONE);
				screen3.setVisibility(View.GONE);
				screen4.setVisibility(View.VISIBLE);
				textview2.setText("Downloads");
				linear2.setVisibility(View.GONE);
				item.setVisibility(View.GONE);
				imageview13.setVisibility(View.VISIBLE);
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_fab.setVisibility(View.INVISIBLE);
				_firebaseadded();
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
		
		_in_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _response = _param2;
				retry_layout.setVisibility(View.GONE);
				_networkConnected();
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				retry_layout.setVisibility(View.VISIBLE);
				_fab.setVisibility(View.INVISIBLE);
				_networkConnected();
			}
		};
		
		_db2_child_listener = new ChildEventListener() {
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
		db2.addChildEventListener(_db2_child_listener);
		
		_var_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				var.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						map_1 = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								map_1.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						latest_version = map_1.get((int)0).get("v").toString();
						if (Double.parseDouble(latest_version) > Double.parseDouble(your_version)) {
							_bottomsheet_version();
						}
						else {
							if (Double.parseDouble(your_version) > Double.parseDouble(latest_version)) {
								var.child("app").child("v").setValue(your_version);
							}
							else {
								
							}
						}
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
		var.addChildEventListener(_var_child_listener);
		
		_db3_child_listener = new ChildEventListener() {
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
		db3.addChildEventListener(_db3_child_listener);
		
		_db4_child_listener = new ChildEventListener() {
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
		db4.addChildEventListener(_db4_child_listener);
	}
	private void initializeLogic() {
		_gd(imageview2, "#FFFF00", "#FFFF00", 30);
		random = "database";
		onStart = "value on start";
		_repple(imageview12);
		_repple(imageview7);
		_repple(imageview13);
		_oncreate();
		_networkConnected();
		_version();
		_more();
		_listview();
		_onscroll();
		db2.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot _dataSnapshot) {
				listmap = new ArrayList<>();
				try {
					GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
					for (DataSnapshot _data : _dataSnapshot.getChildren()) {
						HashMap<String, Object> _map = _data.getValue(_ind);
						listmap.add(_map);
					}
				}
				catch (Exception _e) {
					_e.printStackTrace();
				}
				_grid_view(listmap);
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
		});
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
	public void onStart() {
		super.onStart();
		_data_();
		if (onStart.contains("value on start")) {
			onStart = "on end value";
		}
		else {
			try {
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			} catch(Exception e) {
				
				
				 
				
				
				
				 } 
		}
		save.clear();
		file.clear();
		FileUtil.listDir("/storage/emulated/0/ViV_Videos/", save);
		if (save.size() == 0) {
			listview4.setVisibility(View.GONE);
			linear11.setVisibility(View.VISIBLE);
		}
		else {
			listview4.setVisibility(View.VISIBLE);
			linear11.setVisibility(View.GONE);
			number = 0;
			for(int _repeat28 = 0; _repeat28 < (int)(save.size()); _repeat28++) {
				map2 = new HashMap<>();
				map2.put("key_value", save.get((int)(number)));
				file.add(map2);
				listview4.setAdapter(new Listview4Adapter(file));
				((BaseAdapter)listview4.getAdapter()).notifyDataSetChanged();
				number++;
			}
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		_data_();
	}
	
	@Override
	public void onPause() {
		super.onPause();
		
	}
	private void _snackbar (final String _text) {
		android.support.design.widget.Snackbar sb = android.support.design.widget.Snackbar.make(main_linear, _text, android.support.design.widget.Snackbar.LENGTH_SHORT);
		
		 
		
		sb.show();
	}
	
	
	private void _networkConnected () {
		in.startRequestNetwork(RequestNetworkController.GET, "https://google.com", "A", _in_request_listener);
	}
	
	
	private void _grid_view (final ArrayList<HashMap<String, Object>> _listmap) {
		GridView gridView = new GridView(this);
		gridView.setLayoutParams(new GridView.LayoutParams(GridLayout.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.WRAP_CONTENT));
		
		///gridView.setBackgroundColor(Color.WHITE);
		
		gridView.setNumColumns(2);
		gridView.setColumnWidth(GridView.AUTO_FIT);
		
		gridView.setVerticalSpacing(20);
		
		gridView.setHorizontalSpacing(20);
		
		gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
		
		gridView.setAdapter(new Listview2Adapter(listmap));
		
		((BaseAdapter)gridView.getAdapter()).notifyDataSetChanged();
		
		
		
		grid_layout.addView(gridView);
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
						  @Override
						  public void onItemClick(AdapterView parent, View view, int _position, long id) {
								pos = _position;
				i.putExtra("pass_key", listmap.get((int)pos).get("string_value").toString());
				i.setClass(getApplicationContext(), CategoryActivity.class);
				startActivity(i);
			} 
				});
	}
	
	
	private void _version () {
		package_name = "com.viv.videos.st";
		try {
			android.content.pm.PackageInfo pinfo = getPackageManager().getPackageInfo( package_name, android.content.pm.PackageManager.GET_ACTIVITIES);
			your_version = pinfo.versionName;  
		}
		catch (Exception e){ showMessage(e.toString()); }
		DatabaseReference rootRef = _firebase.getReference(); rootRef.child("version").addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				if (snapshot.exists()) { } else {
					map = new HashMap<>();
					map.put("v", your_version);
					var.child("app").updateChildren(map);
					map.clear();
				} }
			@Override
			public void onCancelled(DatabaseError _error) { } });
	}
	
	
	private void _bottomsheet_version () {
		final android.support.design.widget.BottomSheetDialog bs_base = new android.support.design.widget.BottomSheetDialog(MainActivity.this); 
		
		bs_base.setCancelable(false);
		View layBase = getLayoutInflater().inflate(R.layout.version, null);
		
		bs_base.setContentView(layBase);
		
		bs_base.show();
		
		
		
		Button pay_bss = (Button)layBase.findViewById(R.id.button2);
		
		ImageView img = (ImageView)layBase.findViewById(R.id.imageview2);
		
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor("#FF2C5B"));
		gd.setCornerRadius(25); 
		pay_bss.setBackground(gd); 
		
		pay_bss.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) { 
				
				
				
				
				
				
				
				is6.setAction(Intent.ACTION_VIEW);
				is6.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.viv.videos.st"));
				startActivity(is6);
				
			} 
		});
		
		img.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) { 
				bs_base.dismiss();
				
			} 
		});
		
	}
	
	
	private void _repple (final View _v) {
		int[] attrs = new int[]{android.R.attr.selectableItemBackgroundBorderless};
				android.content.res.TypedArray typedArray = this.obtainStyledAttributes(attrs);
				int backgroundResource = typedArray.getResourceId(0, 0);
				_v.setBackgroundResource(backgroundResource);
		
		_v.setClickable(true);
	}
	
	
	private void _listview () {
		limit = 10;
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
				if (random.equals("database")) {
					listview1.setAdapter(new Listview1Adapter(map1));
					linear2.setVisibility(View.GONE);
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					random = "Nodatabase";
				}
				else {
					
				}
			} catch (Exception e) {
				
				
				 showMessage("data1");
				
				
				
				 } } 
		
		
		@Override public void onCancelled(DatabaseError databaseError) { 
			
			showMessage("data2");
		} }; {
	}
	
	
	private void _firebaseadded () {
		limit = limit + 10;
		newcheck = limit - 11;
		_coreprogressloading(true);
		listview1.setVisibility(View.INVISIBLE);
		query = db.limitToLast((int)limit); 
		
		query.addValueEventListener(valueEventListener1);
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						listview1.setVisibility(View.VISIBLE);
						_coreprogressloading(false);
						listview1.setSelection((int)(newcheck));
					}
				});
			}
		};
		_timer.schedule(t, (int)(500));
	}
	
	
	private void _coreprogressloading (final boolean _ifShow) {
		if (_ifShow) {
			if (coreprog == null){ coreprog = new ProgressDialog(this); coreprog.setCancelable(false); coreprog.setCanceledOnTouchOutside(false); coreprog.requestWindowFeature(Window.FEATURE_NO_TITLE); coreprog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT)); } coreprog.setMessage(null); coreprog.show(); coreprog.setContentView(R.layout.custom_dialog);
		}
		else {
			if (coreprog !=null) { coreprog.dismiss();} 
		}
	}
	
	private ProgressDialog coreprog; {
	}
	
	
	private void _dialog () {
		final AlertDialog dialog2 = new AlertDialog.Builder(MainActivity.this).create();
		View dialog_view = getLayoutInflater().inflate(R.layout.request_layout, null);
		dialog2.setView(dialog_view);
		dialog2.getWindow().setGravity(Gravity.CENTER);
		Button img1 = (Button) dialog_view.findViewById(R.id.button1);
		
		LinearLayout l1 = (LinearLayout) dialog_view.findViewById(R.id.edit_linear);
		
		
		LinearLayout l2 = (LinearLayout) dialog_view.findViewById(R.id.main);
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor("#e8ebeb"));
		gd.setCornerRadius(30); 
		l2.setBackground(gd); 
		
		
		
		
		final EditText edittext1= new EditText(MainActivity.this);
		
		LinearLayout.LayoutParams lpar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		
		edittext1.setLayoutParams(lpar);
		
		l1.addView(edittext1);
		
		
		img1.setOnClickListener(new View.OnClickListener() { 
			@Override
			public void onClick(View v) { 
				
				
				
				req = edittext1.getText().toString();
				map_request = new HashMap<>();
				map_request.put("Request", req);
				db3.push().updateChildren(map_request);
				map_request.clear();
				dialog2.dismiss();
			} });
		dialog2.show();
	}
	
	
	private void _onscroll () {
		_fab.setVisibility(View.INVISIBLE);
		listview1.setOnScrollListener(new AbsListView.OnScrollListener(){
			
			private int mLastFirstVisibleItem;
							@Override
							public void onScrollStateChanged(AbsListView view, int scrollState) {
									if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE 
										&& (listview1.getLastVisiblePosition() - listview1.getHeaderViewsCount() -
										listview1.getFooterViewsCount()) >= (listview1.getAdapter().getCount() - 1)) {
					
					
											// Now your listview has hit the bottom
					
					
					
					
								
					_fab.setVisibility(View.VISIBLE);
						}
							}
							@Override
							public void onScroll(AbsListView lw, final int firstVisibleItem, 
			
												 final int visibleItemCount, final int totalItemCount) 
			
			
							{ 
				
				if(mLastFirstVisibleItem<firstVisibleItem)
				            {
					                Log.i("SCROLLING DOWN","TRUE"); 
					
					           _fab.setVisibility(View.INVISIBLE);
					            
					 }
				            if(mLastFirstVisibleItem>firstVisibleItem)
				            {
					                Log.i("SCROLLING UP","TRUE"); 
					
					            _fab.setVisibility(View.INVISIBLE);
					           
					 }
				            mLastFirstVisibleItem=firstVisibleItem;
				
				
				
				
				
							}
					});
	}
	
	
	private void _oncreate () {
		if (FileUtil.isExistFile("/storage/emulated/0/ViV_Videos")) {
			
		}
		else {
			FileUtil.makeDir("/storage/emulated/0/ViV_Videos");
		}
	}
	
	
	private void _more () {
		linear3.setElevation(5f);
		linear8.setElevation(5f);
		linear_ads.setElevation(5f);
		linear3.setElevation(25);
		
		
		imageview8.getDrawable().setColorFilter(Color.parseColor("#FF2C5B"), PorterDuff.Mode.SRC_IN);
		
		imageview9.getDrawable().setColorFilter(Color.parseColor("#CCCCCC"), PorterDuff.Mode.SRC_IN);
		
		imageview10.getDrawable().setColorFilter(Color.parseColor("#CCCCCC"), PorterDuff.Mode.SRC_IN);
		
		imageview11.getDrawable().setColorFilter(Color.parseColor("#CCCCCC"), PorterDuff.Mode.SRC_IN);
		
		imageview1.getDrawable().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_IN);
		
		
		retry_layout.setVisibility(View.GONE);
		screen2_cato.setVisibility(View.GONE);
		screen3.setVisibility(View.GONE);
		screen4.setVisibility(View.GONE);
		imageview13.setVisibility(View.GONE);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		textview2.setText("Latest");
	}
	
	
	private void _data_ () {
		list_map_save_online.clear();
		key_title = "title";
		key_imageurl = "image";
		key_videourl = "video";
		key_language = "language";
		key_category = "category";
		key_position = "position";
		if (!data.getString("data", "").equals("")) {
			list_map_save_online = new Gson().fromJson(data.getString("data", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
		listview3.setAdapter(new Listview3Adapter(list_map_save_online));
		((BaseAdapter)listview3.getAdapter()).notifyDataSetChanged();
		if (list_map_save_online.size() == 0) {
			linear12.setVisibility(View.VISIBLE);
			listview3.setVisibility(View.GONE);
		}
		else {
			linear12.setVisibility(View.GONE);
			listview3.setVisibility(View.VISIBLE);
		}
	}
	
	
	private void _bottom_menu_nav () {
		final android.support.design.widget.BottomSheetDialog bs_base3 = new android.support.design.widget.BottomSheetDialog(MainActivity.this); 
		
		bs_base3.setCancelable(true);
		View layBase3 = getLayoutInflater().inflate(R.layout.more_menu, null);
		
		bs_base3.setContentView(layBase3);
		
		bs_base3.show();
		
		
		
		LinearLayout l1 = (LinearLayout)layBase3.findViewById(R.id.request);
		
		LinearLayout l2 = (LinearLayout)layBase3.findViewById(R.id.privacy);
		
		LinearLayout l3 = (LinearLayout)layBase3.findViewById(R.id.rate);
		LinearLayout l4 = (LinearLayout)layBase3.findViewById(R.id.about);
		
		LinearLayout l5 = (LinearLayout)layBase3.findViewById(R.id.share);
		
		_Ripple_Effect(l1);
		_Ripple_Effect(l2);
		_Ripple_Effect(l3);
		_Ripple_Effect(l4);
		_Ripple_Effect(l5); 
		
		
		TextView t1 = (TextView)layBase3.findViewById(R.id.textview1);
		
		TextView t2 = (TextView)layBase3.findViewById(R.id.textview2);
		
		TextView t3 = (TextView)layBase3.findViewById(R.id.textview3);
		
		TextView t4 = (TextView)layBase3.findViewById(R.id.textview4);
		
		TextView t5 = (TextView)layBase3.findViewById(R.id.textview5);
		
		t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		
		
		t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		
		
		t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		
		t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		
		
		t5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		
		l1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) { 
				_botton_request();
				bs_base3.dismiss();
				
			} 
		});
		
		l2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) { 
				d2.setTitle("Privacy Policy ");
				d2.setMessage("STdeveloper built the [ViV Videos] app as a Free app. This SERVICE is provided by STdeveloper at no cost and is intended for use as is.\n\n\nThis page is used to inform visitors regarding my policies with the collection, use, and disclosure of Personal Information if anyone decided to use my Service.\n\n\nIf you choose to use my Service, then you agree to the collection and use of information in relation to this policy. The Personal Information that I collect is used for providing and improving the Service. I will not use or share your information with anyone except as described in this Privacy Policy.\n\n\nThe terms used in this Privacy Policy have the same meanings as in our Terms and Conditions, which is accessible at Status Saver unless otherwise defined in this Privacy Policy.\n\n\nInformation Collection and Use\n\n\nFor a better experience, while using our Service, I may require you to provide us with certain personally identifiable information, including but not limited to Storage . The information that I request will be retained on your device and is not collected by me in any way.\n\n\nThe app does use third party services that may collect information used to identify you.\n\n\nLink to privacy policy of third party service providers used by the app\n\n\nGoogle Play Services\n\nAdMob\n\nLog Data\n\n\nI want to inform you that whenever you use my Service, in a case of an error in the app I collect data and information (through third party products) on your phone called Log Data. This Log Data may include information such as your device Internet Protocol (“IP”) address, device name, operating system version, the configuration of the app when utilizing my Service, the time and date of your use of the Service, and other statistics.\n\n\nCookies\n\n\nCookies are files with a small amount of data that are commonly used as anonymous unique identifiers. These are sent to your browser from the websites that you visit and are stored on your device's internal memory.\n\n\nThis Service does not use these “cookies” explicitly. However, the app may use third party code and libraries that use “cookies” to collect information and improve their services. You have the option to either accept or refuse these cookies and know when a cookie is being sent to your device. If you choose to refuse our cookies, you may not be able to use some portions of this Service.\n\n\nService Providers\n\n\nI may employ third-party companies and individuals due to the following reasons:\n\n\nTo facilitate our Service;\n\nTo provide the Service on our behalf;\n\nTo perform Service-related services; or\n\nTo assist us in analyzing how our Service is used.\n\nI want to inform users of this Service that these third parties have access to your Personal Information. The reason is to perform the tasks assigned to them on our behalf. However, they are obligated not to disclose or use the information for any other purpose.\n\n\nSecurity\n\n\nI value your trust in providing us your Personal Information, thus we are striving to use commercially acceptable means of protecting it. But remember that no method of transmission over the internet, or method of electronic storage is 100% secure and reliable, and I cannot guarantee its absolute security.\n\n\nLinks to Other Sites\n\n\nThis Service may contain links to other sites. If you click on a third-party link, you will be directed to that site. Note that these external sites are not operated by me. Therefore, I strongly advise you to review the Privacy Policy of these websites. I have no control over and assume no responsibility for the content, privacy policies, or practices of any third-party sites or services.\n\n\nChildren’s Privacy\n\n\nThese Services do not address anyone under the age of 13. I do not knowingly collect personally identifiable information from children under 13. In the case I discover that a child under 13 has provided me with personal information, I immediately delete this from our servers. If you are a parent or guardian and you are aware that your child has provided us with personal information, please contact me so that I will be able to do necessary actions.\n\n\nChanges to This Privacy Policy\n\n\nI may update our Privacy Policy from time to time. Thus, you are advised to review this page periodically for any changes. I will notify you of any changes by posting the new Privacy Policy on this page. These changes are effective immediately after they are posted on this page.\n\n\nContact Us\n\n\nIf you have any questions or suggestions about my Privacy Policy, do not hesitate to contact me at alltimr240@gmail.com. \n\n\n");
				d2.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d2.setNegativeButton("Close", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d2.create().show();
				bs_base3.dismiss();
				
			} 
		});
		
		l3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) { 
				is4.setAction(Intent.ACTION_VIEW);
				is4.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.viv.videos.st"));
				startActivity(is4);
				bs_base3.dismiss();
				
			} 
		});
		
		l4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) { 
				d.setTitle("About Us");
				d.setMessage("This app is created by STdeveloper\n      Email - alltime240@gmail.com\n             ♥️ Made in Bangladesh ♥️");
				d.setNegativeButton("Close", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
				bs_base3.dismiss();
				
			} 
		});
		
		l5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) { 
				share = "Download Everyday New Videos for Entertainment\n \n\nDownload the app from here \nhttps://play.google.com/store/apps/details?id=com.viv.videos.st";
				Intent ie = new Intent(android.content.Intent.ACTION_SEND); 
				ie.setType("text/plain"); ie.putExtra(android.content.Intent.EXTRA_TEXT,share); startActivity(Intent.createChooser(ie,"share using"));
				bs_base3.dismiss();
				
			} 
		});
		
	}
	
	
	private void _botton_request () {
		final android.support.design.widget.BottomSheetDialog bs_base4 = new android.support.design.widget.BottomSheetDialog(MainActivity.this); 
		
		bs_base4.setCancelable(true);
		View layBase4 = getLayoutInflater().inflate(R.layout.request, null);
		
		bs_base4.setContentView(layBase4);
		
		bs_base4.show();
		
		
		
		LinearLayout l1 = (LinearLayout)layBase4.findViewById(R.id.edit_linear);
		
		
		Button btn1 = (Button)layBase4.findViewById (R.id.button1);
		
		TextView t1 = (TextView)layBase4.findViewById(R.id.textview1);
		
		TextView t2 = (TextView)layBase4.findViewById(R.id.textview2);
		
		
		t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		
		
		t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor("#FF2C5B"));
		gd.setCornerRadius(25); 
		btn1.setBackground(gd); 
		
		
		
		
		
		
		
		
		
		final EditText edittext1= new EditText(MainActivity.this);
		
		LinearLayout.LayoutParams lpar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		
		edittext1.setLayoutParams(lpar);
		
		l1.addView(edittext1);
		
		
		btn1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) { 
				req = edittext1.getText().toString();
				map_request = new HashMap<>();
				map_request.put("Request", req);
				db3.push().updateChildren(map_request);
				map_request.clear();
				SketchwareUtil.showMessage(getApplicationContext(), "Request Submitted");
				bs_base4.dismiss();
			} 
		});
		
	}
	
	
	private void _Ripple_Effect (final View _v) {
		
		android.graphics.drawable.RippleDrawable ripdr1 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#DBDEE3")}), new android.graphics.drawable.ColorDrawable(Color.parseColor("#FFFFFF")), null);
		_v.setBackground(ripdr1);
		
	}
	
	
	private void _GradientDrawable (final View _view, final String _color1, final String _color2) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		int clr[] = new int[]{ Color.parseColor(_color1), Color.parseColor(_color2) };
		gd.setColors(clr);
		gd.setCornerRadius(0);
		_view.setBackground(gd);
	}
	
	
	private void _gd (final View _view, final String _c, final String _sc, final double _r) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_c));
		gd.setCornerRadius((float)_r);
		gd.setStroke(2, Color.parseColor(_sc));
		
		_view.setBackground(gd);
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
			
			_Elevation(linear_4, 15);
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
			textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothammedium1.ttf"), 0);
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothammedium1.ttf"), 0);
			textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothammedium1.ttf"), 0);
			textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothammedium1.ttf"), 0);
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor("#e8ebeb"));
			gd.setCornerRadius(30); 
			textview4.setBackground(gd); 
			
			
			android.graphics.drawable.GradientDrawable gd2 = new android.graphics.drawable.GradientDrawable();
			gd2.setColor(Color.parseColor("#e8ebeb"));
			gd2.setCornerRadius(30); 
			textview3.setBackground(gd2); 
			
			
			
			
			
			
			
			textview1.setText(map1.get((int)(map1.size() - 1) - _position).get("name").toString());
			Glide.with(getApplicationContext()).load(Uri.parse(map1.get((int)(map1.size() - 1) - _position).get("imageurl").toString())).into(imageview4);
			textview3.setText(map1.get((int)(map1.size() - 1) - _position).get("categories").toString());
			textview4.setText(map1.get((int)(map1.size() - 1) - _position).get("language").toString());
			textview2.setText(map1.get((int)(map1.size() - 1) - _position).get("likes").toString());
			textview5.setText(map1.get((int)(map1.size() - 1) - _position).get("views").toString());
			
			return _v;
		}
	}
	
	public class Listview3Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview3Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_v = _inflater.inflate(R.layout.savefavourite_custom, null);
			}
			
			final LinearLayout linear3 = (LinearLayout) _v.findViewById(R.id.linear3);
			final LinearLayout linear1 = (LinearLayout) _v.findViewById(R.id.linear1);
			final LinearLayout linear2 = (LinearLayout) _v.findViewById(R.id.linear2);
			final TextView textview1 = (TextView) _v.findViewById(R.id.textview1);
			final TextView textview2 = (TextView) _v.findViewById(R.id.textview2);
			final ImageView imageview2 = (ImageView) _v.findViewById(R.id.imageview2);
			final ImageView imageview1 = (ImageView) _v.findViewById(R.id.imageview1);
			final TextView nonetext = (TextView) _v.findViewById(R.id.nonetext);
			final TextView textview3 = (TextView) _v.findViewById(R.id.textview3);
			
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothammedium1.ttf"), 0);
			textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothammedium1.ttf"), 0);
			simple_map = list_map_save_online.get((int)_position);
			textview1.setText(simple_map.get(key_title).toString());
			Glide.with(getApplicationContext()).load(Uri.parse(simple_map.get(key_imageurl).toString())).into(imageview2);
			imageview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					list_map_save_online.remove((int)(_position));
					notifyDataSetChanged();
					data.edit().putString("data", new Gson().toJson(list_map_save_online)).commit();
					_snackbar("Remove Successfully");
				}
			});
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor("#e8ebeb"));
			gd.setCornerRadius(30); 
			textview2.setBackground(gd); 
			
			
			android.graphics.drawable.GradientDrawable gd2 = new android.graphics.drawable.GradientDrawable();
			gd2.setColor(Color.parseColor("#e8ebeb"));
			gd2.setCornerRadius(30); 
			textview3.setBackground(gd2); 
			
			
			
			
			
			if (simple_map.containsKey(key_language)) {
				textview2.setText(simple_map.get(key_language).toString());
			}
			else {
				
			}
			if (simple_map.containsKey(key_category)) {
				textview3.setText(simple_map.get(key_category).toString());
			}
			else {
				
			}
			if (simple_map.containsKey(key_position)) {
				
			}
			else {
				SketchwareUtil.showMessage(getApplicationContext(), "Please Clear all Favourites list or Clear data of this app ");
			}
			
			return _v;
		}
	}
	
	public class Listview4Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview4Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_v = _inflater.inflate(R.layout.savecustoms, null);
			}
			
			final LinearLayout linear4 = (LinearLayout) _v.findViewById(R.id.linear4);
			final LinearLayout linear2 = (LinearLayout) _v.findViewById(R.id.linear2);
			final LinearLayout linear3 = (LinearLayout) _v.findViewById(R.id.linear3);
			final TextView textview1 = (TextView) _v.findViewById(R.id.textview1);
			final TextView textview2 = (TextView) _v.findViewById(R.id.textview2);
			final ImageView imageview1 = (ImageView) _v.findViewById(R.id.imageview1);
			final LinearLayout share = (LinearLayout) _v.findViewById(R.id.share);
			final LinearLayout send = (LinearLayout) _v.findViewById(R.id.send);
			final LinearLayout delete = (LinearLayout) _v.findViewById(R.id.delete);
			final ImageView imageview4 = (ImageView) _v.findViewById(R.id.imageview4);
			final ImageView imageview3 = (ImageView) _v.findViewById(R.id.imageview3);
			final ImageView imageview2 = (ImageView) _v.findViewById(R.id.imageview2);
			
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
			map2 = file.get((int)_position);
			textview1.setVisibility(View.GONE);
			textview1.setText(map2.get("key_value").toString());
			t2 = map2.get("key_value").toString().replace("/storage/emulated/0/ViV_Videos/", "");
			textview2.setText(t2.replace(".mp4", ""));
			file2 = map2.get("key_value").toString();
			
			Glide.with(getApplicationContext()).load(Uri.fromFile(new java.io.File(file2))).into(imageview1);
			delete.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					d.setTitle("Delete");
					d.setMessage("Note: This video will be deleted from \nSD Card.\n\nAre you sure want to delete? ");
					d.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							value = textview1.getText().toString();
							FileUtil.deleteFile(value);
							file.remove((int)(_position));
							notifyDataSetChanged();
							_snackbar("Deleted Successfully");
						}
					});
					d.setNegativeButton("No", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					d.create().show();
				}
			});
			send.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					v = textview1.getText().toString();
					try {
						
						Uri uri = Uri.parse(v);
						Intent videoshare = new Intent(Intent.ACTION_SEND); videoshare.setType("video/mp4"); 
						videoshare.setPackage("com.whatsapp"); videoshare.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); videoshare.putExtra(Intent.EXTRA_STREAM,uri); startActivity(videoshare);
						
					} catch (Exception e) {
						SketchwareUtil.showMessage(getApplicationContext(), "Error");
					} 
				}
			});
			share.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					v = textview1.getText().toString();
					try { 
						
						Uri uri = Uri.parse(v);
						Intent videoshare = new Intent(Intent.ACTION_SEND); videoshare.setType("video/mp4"); 
						 videoshare.putExtra(Intent.EXTRA_STREAM,uri); startActivity(videoshare);
						
						
					} catch (Exception e) {
						SketchwareUtil.showMessage(getApplicationContext(), "Error");
					} 
				}
			});
			
			return _v;
		}
	}
	
	public class Listview2Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_v = _inflater.inflate(R.layout.item, null);
			}
			
			final LinearLayout linear2 = (LinearLayout) _v.findViewById(R.id.linear2);
			final LinearLayout linear1 = (LinearLayout) _v.findViewById(R.id.linear1);
			final ImageView imageview1 = (ImageView) _v.findViewById(R.id.imageview1);
			final TextView textview1 = (TextView) _v.findViewById(R.id.textview1);
			
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor("#ffffff"));
			gd.setCornerRadius(20);
			linear2.setBackground(gd);
			
			textview1.setText(listmap.get((int)_position).get("string_value").toString());
			Glide.with(getApplicationContext()).load(Uri.parse(listmap.get((int)_position).get("title_imageurl").toString())).into(imageview1);
			
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
