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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import java.util.Timer;
import java.util.TimerTask;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.widget.AdapterView;
import com.google.gson.Gson;
import android.graphics.Typeface;
import com.google.gson.reflect.TypeToken;
import com.bumptech.glide.Glide;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class VideoplayerActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String str = "";
	private String url = "";
	private String check = "";
	private String namekey = "";
	private String pass = "";
	private boolean connected = false;
	private double nu = 0;
	private double a = 0;
	private double exit = 0;
	private String key_title = "";
	private String key_imageurl = "";
	private String key_videourl = "";
	private HashMap<String, Object> simple_map = new HashMap<>();
	private String keyimageurl = "";
	private String pos = "";
	private String pass1 = "";
	private String pass2 = "";
	private String pass3 = "";
	private String sha = "";
	private String v = "";
	private double number = 0;
	private String stroage = "";
	private String position = "";
	private String position_shared = "";
	private String nameKey = "";
	private double a2 = 0;
	private double exit2 = 0;
	private String check_2 = "";
	private HashMap<String, Object> map2 = new HashMap<>();
	private HashMap<String, Object> simple_map2 = new HashMap<>();
	private String pass4 = "";
	private HashMap<String, Object> map_push = new HashMap<>();
	private HashMap<String, Object> map_shared = new HashMap<>();
	private String key_save_value = "";
	private String position_shared2 = "";
	private String check_position = "";
	private String key_language = "";
	private String key_category = "";
	private String likes = "";
	private String pass5 = "";
	private String pass6 = "";
	private String key_position = "";
	private String otp = "";
	private String check2 = "";
	private String views = "";
	private HashMap<String, Object> likemap = new HashMap<>();
	private double limit = 0;
	private String pick = "";
	private double posi = 0;
	private String varb = "";
	private double position1 = 0;
	private double hl = 0;
	private String abc = "";
	private double stopPosition = 0;
	private HashMap<String, Object> map_request = new HashMap<>();
	private String req = "";
	private String pick_m = "";
	private double n2 = 0;
	private double len2 = 0;
	
	private ArrayList<HashMap<String, Object>> list_map_save_online = new ArrayList<>();
	private ArrayList<String> string = new ArrayList<>();
	private ArrayList<String> save = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> list_map_2 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap_shared = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> map1 = new ArrayList<>();
	private ArrayList<String> st = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout space2;
	private LinearLayout linear7;
	private LinearLayout space;
	private LinearLayout linear5;
	private LinearLayout linear4;
	private ProgressBar progressbar2;
	private TextView textview1;
	private ImageView imageview1;
	private LinearLayout like;
	private LinearLayout unlike;
	private LinearLayout downloaded;
	private LinearLayout download;
	private LinearLayout share;
	private LinearLayout add;
	private LinearLayout already;
	private LinearLayout moree;
	private ImageView imageview7;
	private TextView textview3;
	private ImageView imageview8;
	private TextView textview2;
	private ImageView imageview6;
	private ImageView imageview2;
	private ImageView imageview3;
	private TextView textview4;
	private ImageView imageview4;
	private ImageView imageview5;
	private ImageView imageview9;
	private ListView listview1;
	
	private AlertDialog.Builder pDialog;
	private RequestNetwork n;
	private RequestNetwork.RequestListener _n_request_listener;
	private Intent i = new Intent();
	private SharedPreferences data;
	private TimerTask t;
	private SharedPreferences shared2;
	private DatabaseReference db2 = _firebase.getReference("firebase2");
	private ChildEventListener _db2_child_listener;
	private SharedPreferences data2;
	private Vibrator vib;
	private AlertDialog.Builder dia;
	private DatabaseReference bb = _firebase.getReference("firebase2");
	private ChildEventListener _bb_child_listener;
	private AlertDialog.Builder d_copy;
	private DatabaseReference db3 = _firebase.getReference("request");
	private ChildEventListener _db3_child_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.videoplayer);
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
		space = (LinearLayout) findViewById(R.id.space);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		progressbar2 = (ProgressBar) findViewById(R.id.progressbar2);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		like = (LinearLayout) findViewById(R.id.like);
		unlike = (LinearLayout) findViewById(R.id.unlike);
		downloaded = (LinearLayout) findViewById(R.id.downloaded);
		download = (LinearLayout) findViewById(R.id.download);
		share = (LinearLayout) findViewById(R.id.share);
		add = (LinearLayout) findViewById(R.id.add);
		already = (LinearLayout) findViewById(R.id.already);
		moree = (LinearLayout) findViewById(R.id.moree);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		textview3 = (TextView) findViewById(R.id.textview3);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		imageview9 = (ImageView) findViewById(R.id.imageview9);
		listview1 = (ListView) findViewById(R.id.listview1);
		pDialog = new AlertDialog.Builder(this);
		n = new RequestNetwork(this);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		shared2 = getSharedPreferences("data2", Activity.MODE_PRIVATE);
		data2 = getSharedPreferences("d2", Activity.MODE_PRIVATE);
		vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		dia = new AlertDialog.Builder(this);
		d_copy = new AlertDialog.Builder(this);
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				nu = 1;
				getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
				
				 int width = getResources().getDisplayMetrics().widthPixels/1;
				
				
				
				int hei=getResources().getDisplayMetrics().heightPixels/1;  linear2.setLayoutParams(new LinearLayout.LayoutParams(width, hei));
				
				
				
			}
		});
		
		like.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				abc = "No";
				check = String.valueOf((long)(Double.parseDouble(textview2.getText().toString()) + Double.parseDouble("1")));
				map_push = new HashMap<>();
				map_push.put("likes", check);
				db2.child(pass6).updateChildren(map_push);
				map_push.clear();
				simple_map = new HashMap<>();
				simple_map.put(key_save_value, getIntent().getStringExtra("key_offline_videourl"));
				listmap_shared.add((int)0, simple_map);
				data2.edit().putString("data2", new Gson().toJson(listmap_shared)).commit();
				simple_map.clear();
				like.setVisibility(View.GONE);
				unlike.setVisibility(View.VISIBLE);
				otp = "0";
			}
		});
		
		unlike.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				abc = "No";
				if (otp.equals("0")) {
					listmap_shared.remove((int)(Double.parseDouble(otp)));
					data2.edit().putString("data2", new Gson().toJson(listmap_shared)).commit();
					check = String.valueOf((long)(Double.parseDouble(textview2.getText().toString()) - Double.parseDouble("1")));
					map_push = new HashMap<>();
					map_push.put("likes", check);
					db2.child(getIntent().getStringExtra("position")).updateChildren(map_push);
					map_push.clear();
					unlike.setVisibility(View.GONE);
					like.setVisibility(View.VISIBLE);
				}
				else {
					listmap_shared.remove((int)(Double.parseDouble(position_shared2)));
					data2.edit().putString("data2", new Gson().toJson(listmap_shared)).commit();
					check = String.valueOf((long)(Double.parseDouble(textview2.getText().toString()) - Double.parseDouble("1")));
					map_push = new HashMap<>();
					map_push.put("likes", check);
					db2.child(getIntent().getStringExtra("position")).updateChildren(map_push);
					map_push.clear();
					unlike.setVisibility(View.GONE);
					like.setVisibility(View.VISIBLE);
				}
			}
		});
		
		downloaded.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Video Successfully Downloaded to Storage Path  /storage/emulated/0/ViV Videos");
			}
		});
		
		download.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				//Needs RequestNetwork to work!
				ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
				NetworkInfo netInfo = cm.getActiveNetworkInfo();
				connected = (netInfo != null && netInfo.isConnectedOrConnecting());
				if (connected) {
					url = getIntent().getStringExtra("key_offline_videourl");
					new DownloadFileFromURL().execute(url);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Connection error");
				}
			}
		});
		
		share.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				simple_map = new HashMap<>();
				simple_map.put(key_title, pass1);
				simple_map.put(key_imageurl, pass2);
				simple_map.put(key_videourl, pass3);
				simple_map.put(key_category, pass4);
				simple_map.put(key_language, pass5);
				simple_map.put(key_position, pass6);
				list_map_save_online.add((int)0, simple_map);
				data.edit().putString("data", new Gson().toJson(list_map_save_online)).commit();
				add.setVisibility(View.GONE);
				already.setVisibility(View.VISIBLE);
				_check_sharedonline();
				_snackbar("Added To Favourites List");
			}
		});
		
		already.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				list_map_save_online.remove((int)(Double.parseDouble(position_shared)));
				data.edit().putString("data", new Gson().toJson(list_map_save_online)).commit();
				already.setVisibility(View.GONE);
				add.setVisibility(View.VISIBLE);
				_snackbar("Remove From Favourites List");
			}
		});
		
		moree.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_bottomsheet_version();
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				i.putExtra("key_offline_imageurl", map1.get((int)_position).get("imageurl").toString());
				i.putExtra("key_offline_videourl", map1.get((int)_position).get("videourl").toString());
				i.putExtra("key_offline_name", map1.get((int)_position).get("name").toString());
				i.putExtra("key_offline_language", map1.get((int)_position).get("language").toString());
				i.putExtra("key_offline_category", map1.get((int)_position).get("categories").toString());
				i.putExtra("position", map1.get((int)_position).get("childkey").toString());
				i.setClass(getApplicationContext(), VideoplayerActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		_n_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _response = _param2;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_db2_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("position"))) {
					likes = _childValue.get("likes").toString();
					textview3.setText(likes);
					textview2.setText(likes);
					views = _childValue.get("views").toString();
					textview4.setText(views);
				}
				else {
					
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(getIntent().getStringExtra("position"))) {
					likes = _childValue.get("likes").toString();
					textview3.setText(likes);
					textview2.setText(likes);
					views = _childValue.get("views").toString();
					textview4.setText(views);
				}
				else {
					
				}
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
		
		_bb_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				st.add(_childKey);
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
		bb.addChildEventListener(_bb_child_listener);
		
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
	}
	private void initializeLogic() {
		 int width = getResources().getDisplayMetrics().widthPixels/1;
		
		
		
		int hei=getResources().getDisplayMetrics().heightPixels/3;  linear2.setLayoutParams(new LinearLayout.LayoutParams(width, hei));
		
		
		
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor("#FFFFFF"));
		gd.setCornerRadius(50); 
		progressbar2.setBackground(gd); 
		_networkConnected();
		
		
		like.setEnabled(false);
		downloaded.setVisibility(View.GONE);
		imageview1.setVisibility(View.GONE);
		pass1 = getIntent().getStringExtra("key_offline_name");
		pass2 = getIntent().getStringExtra("key_offline_imageurl");
		pass3 = getIntent().getStringExtra("key_offline_videourl");
		pass4 = getIntent().getStringExtra("key_offline_category");
		pass5 = getIntent().getStringExtra("key_offline_language");
		pass6 = getIntent().getStringExtra("position");
		_font();
		_more();
		_download_share();
		_check_download();
		_repple_all();
		_createChannel();
		_more_data();
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
	
	@Override
	public void onStart() {
		super.onStart();
		_more2();
		_check_sharedonline();
		_checked_offline();
	}
	
	@Override
	public void onStop() {
		super.onStop();
		vidview.stopPlayback();
		
	}
	private void _extra () {
	}
	VideoView vidview;
	MediaController mediaControls;  
	MediaPlayer mp;
	
	
	{
	}
	
	
	private void _networkConnected () {
		//Needs RequestNetwork to work!
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		connected = (netInfo != null && netInfo.isConnectedOrConnecting());
		if (connected) {
			
		}
		else {
			SketchwareUtil.showMessage(getApplicationContext(), "Connection error");
		}
	}
	
	
	private void _customToast (final String _text) {
		LayoutInflater inflater = getLayoutInflater(); View toastLayout = inflater.inflate(R.layout.custom1, null);
		
		TextView textview1 = (TextView) toastLayout.findViewById(R.id.textview1);
		textview1.setText(_text);
		LinearLayout linear1 = (LinearLayout) toastLayout.findViewById(R.id.linear1);
		
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor("#FFFFFF"));
		gd.setCornerRadius(60);
		gd.setStroke(2, Color.parseColor("#FFFFFF"));
		linear1.setBackground(gd);
		
		Toast toast = new Toast(getApplicationContext()); toast.setDuration(Toast.LENGTH_SHORT);
		toast.setView(toastLayout);
		toast.show();
	}
	
	
	private void _more () {
		textview1.setText(pass1);
		vidview = new VideoView(this);   
		
		
		
		
		vidview.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)); 
		vidview.setBackgroundColor(Color.TRANSPARENT);
		
		linear4.addView(vidview);
		
		mediaControls = new MediaController(this); mediaControls.setAnchorView(vidview); vidview.setMediaController(mediaControls);
		str = pass3;
		vidview.setVideoURI(Uri.parse(str)); 
		
		vidview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer mp) {
				
				mp.setLooping(true);
				imageview1.setVisibility(View.VISIBLE);
				progressbar2.setVisibility(View.GONE);
				like.setEnabled(true);
				_viewscounter();
				vidview.start(); 
			}  
			
		});
		vidview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				
				
				
				
			} });
		
		vidview.setOnErrorListener(new MediaPlayer.OnErrorListener() {
			@Override
			public boolean onError(MediaPlayer mp, int what, int extra) {
				showMessage("Oops An Error Occured While Playing Video!!");
				return false; } });
		_download_all();
	}
	
	
	private void _more2 () {
		key_title = "title";
		key_imageurl = "image";
		key_videourl = "video";
		key_language = "language";
		key_category = "category";
		key_position = "position";
		if (!data.getString("data", "").equals("")) {
			list_map_save_online = new Gson().fromJson(data.getString("data", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
		key_save_value = "name_value_key12";
		if (!data2.getString("data2", "").equals("")) {
			listmap_shared = new Gson().fromJson(data2.getString("data2", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
	}
	
	
	private void _snackbar (final String _text) {
		android.support.design.widget.Snackbar sb = android.support.design.widget.Snackbar.make(linear1, _text, android.support.design.widget.Snackbar.LENGTH_SHORT);
		
		 
		
		sb.show();
	}
	
	
	private void _Ripple_Effect (final View _v) {
		
		android.graphics.drawable.RippleDrawable ripdr1 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#cfd8dc")}), new android.graphics.drawable.ColorDrawable(Color.parseColor("#FFFFFF")), null);
		_v.setBackground(ripdr1);
		
		
		
		
	}
	
	
	private void _share_video () {
		v = FileUtil.getExternalStorageDir().concat("/ViV_Videos/".concat(textview1.getText().toString().concat(".mp4")));
		try { 
			
			Uri uri = Uri.parse(v);
			Intent videoshare = new Intent(Intent.ACTION_SEND); videoshare.setType("video/mp4"); 
			 videoshare.putExtra(Intent.EXTRA_STREAM,uri); startActivity(videoshare);
			
			
		} catch (Exception e) {
			SketchwareUtil.showMessage(getApplicationContext(), "Error");
		} 
	}
	
	
	private void _download_share () {
	}
	class DownloadFromURL extends AsyncTask<String, String, String> {
					
		
		
					@Override
					protected void onPreExecute() {
							super.onPreExecute();
							
			
			mProgressDialog = new ProgressDialog(VideoplayerActivity.this); 
			 
			mProgressDialog.setMax(100);  
			mProgressDialog.setTitle("Please wait a moment"); 
			 mProgressDialog.setMessage("Saving video for sharing"); 
			 mProgressDialog.setIndeterminate(true); 
			  mProgressDialog.setCancelable(false);    
			
			
			mProgressDialog.setButton("Hide", (DialogInterface.OnClickListener) null);
			
			
			
			mProgressDialog.show();
		} 
					@Override
					protected String doInBackground(String... f_url) {
							int count;
							try {
									java.net.URL url = new java.net.URL(f_url[0]);
								java.net.	URLConnection conection = url.openConnection();
									conection.connect();
				
									// this will be useful so that you can show a tipical 0-100%
									// progress bar
									int lenghtOfFile = conection.getContentLength();
				
									// download the file
								java.io.	InputStream input = new java.io.BufferedInputStream(url.openStream(),
																				8192);
				
									// Output stream
									
									java.io.OutputStream output = new java.io.FileOutputStream(Environment
																			   .getExternalStorageDirectory().toString()
																							   + "/ViV_Videos/"+textview1.getText().toString()+".mp4");
				
									byte data[] = new byte[1024];
				
									long total = 0;
				
									while ((count = input.read(data)) != -1) {
											total += count;
											// publishing the progress....
											// After this onProgressUpdate will be called
											publishProgress("" + (int) ((total * 100) / lenghtOfFile));
					
											// writing data to file
											output.write(data, 0, count);
									}
				
									// flushing output
									output.flush();
				
									// closing streams
									output.close();
									input.close();
				
							} catch (Exception e) {
									
									
							}
			
							return null;
					}
		
		
		protected void onProgressUpdate(String... progress) { 
			
			
			
		} 
					@Override
					protected void onPostExecute(String file_url) { 
			
			
			if (pick_m.equals("share")) {
				_share_video();
			}
			else {
				_send_video();
			}
			mProgressDialog.dismiss();
			_check_download();
				}
		
			}
	
	{
	}
	
	
	private void _check_download () {
		FileUtil.listDir("/storage/emulated/0/ViV_Videos/", save);
		if (save.size() == 0) {
			
		}
		else {
			number = 0;
			for(int _repeat16 = 0; _repeat16 < (int)(save.size()); _repeat16++) {
				if (save.get((int)(number)).contains(FileUtil.getExternalStorageDir().concat("/ViV_Videos/".concat(textview1.getText().toString().concat(".mp4"))))) {
					stroage = FileUtil.getExternalStorageDir().concat("/ViV_Videos/".concat(textview1.getText().toString().concat(".mp4")));
					download.setVisibility(View.GONE);
					downloaded.setVisibility(View.VISIBLE);
				}
				else {
					
				}
				number++;
			}
		}
	}
	
	
	private void _download_all () {
		FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/ViV_Videos"));
	}
	class DownloadFileFromURL extends AsyncTask<String, String, String> {
					
		
		
					@Override
					protected void onPreExecute() {
							super.onPreExecute();
							
			
			_customToast("𝗗̤𝗼̤𝘄̤𝗻̤𝗹̤𝗼̤𝗮̤𝗱̤ 𝗦̤𝘁̤𝗮̤𝗿̤𝘁̤");
			_startChannel();
		} 
					@Override
					protected String doInBackground(String... f_url) {
							int count;
							try {
									java.net.URL url = new java.net.URL(f_url[0]);
								java.net.	URLConnection conection = url.openConnection();
									conection.connect();
				
									// this will be useful so that you can show a tipical 0-100%
									// progress bar
									int lenghtOfFile = conection.getContentLength();
				
									// download the file
								java.io.	InputStream input = new java.io.BufferedInputStream(url.openStream(),
																				8192);
				
									// Output stream
									
									java.io.OutputStream output = new java.io.FileOutputStream(Environment
																			   .getExternalStorageDirectory().toString()
																							   + "/ViV_Videos/"+textview1.getText().toString().concat(".mp4"));
				
									byte data[] = new byte[1024];
				
									long total = 0;
				
									while ((count = input.read(data)) != -1) {
											total += count;
											// publishing the progress....
											// After this onProgressUpdate will be called
											publishProgress("" + (int) ((total * 100) / lenghtOfFile));
					
											// writing data to file
											output.write(data, 0, count);
									}
				
									// flushing output
									output.flush();
				
									// closing streams
									output.close();
									input.close();
				
							} catch (Exception e) {
									
									
							}
			
							return null;
					}
		
		
		protected void onProgressUpdate(String... progress) { 
			
			
			
			
		} 
					@Override
					protected void onPostExecute(String file_url) { 
			
			
			_customToast("✤𝐃𝐨𝐰𝐧𝐥𝐨𝐚𝐝✤  ✤𝐂𝐨𝐦𝐩𝐥𝐞𝐭𝐞✤");
			_check_download();
			_finishChannel();
			vib.vibrate((long)(300));
				}
		
			}
	
	{
	}
	
	
	private void _font () {
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
	}
	
	
	private void _hide () {
	}
	ProgressDialog mProgressDialog;
	
	{
	}
	
	
	private void _createChannel () {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			CharSequence name = "Channel name 1";
			String description = "Notification channel";
			int importance = NotificationManager.IMPORTANCE_DEFAULT;
			NotificationChannel channel = new NotificationChannel("id 1", name, importance);
			channel.setDescription(description);
			
			NotificationManager notificationManager = getSystemService(NotificationManager.class);
			notificationManager.createNotificationChannel(channel);
			
		}
	}
	
	
	private void _startChannel () {
		 final int progressMax = 100;
		
		
		Intent intent = new Intent(VideoplayerActivity.this, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
		PendingIntent pendingIntent = PendingIntent.getActivity(VideoplayerActivity.this, 0, intent, 0);
		android.support.v4.app.NotificationCompat.Builder builder = new android.support.v4.app.NotificationCompat.Builder(VideoplayerActivity.this, "id 1")
		.setSmallIcon(R.drawable.ic_file_download_grey) 
		.setProgress(progressMax, 0, true)
		
		.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)) 
		
		.setContentTitle(textview1.getText().toString().concat(".mp4"))
		
		.setContentText("Download in progress")
		
		.setPriority(android.support.v4.app.NotificationCompat.PRIORITY_DEFAULT)
		.setContentIntent(pendingIntent)
		.setAutoCancel(false)
		
		.setOngoing(true);
		
		
		
		android.support.v4.app.NotificationManagerCompat notificationManager = android.support.v4.app.NotificationManagerCompat.from(VideoplayerActivity.this);
		notificationManager.notify(1, builder.build());
		
		
		
	}
	
	
	private void _finishChannel () {
		Intent intent = new Intent(VideoplayerActivity.this, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
		PendingIntent pendingIntent = PendingIntent.getActivity(VideoplayerActivity.this, 0, intent, 0);
		android.support.v4.app.NotificationCompat.Builder builder = new android.support.v4.app.NotificationCompat.Builder(VideoplayerActivity.this, "id 1")
		.setSmallIcon(R.drawable.ic_check_grey) 
		.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_check_circle_grey))
		
		.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)) 
		
		.setContentTitle(textview1.getText().toString().concat(".mp4"))
		 
		
		
		
		.setContentText("Download Complete") 
		
		
		.setPriority(android.support.v4.app.NotificationCompat.PRIORITY_DEFAULT)
		.setContentIntent(pendingIntent)
		.setAutoCancel(true);
		
		android.support.v4.app.NotificationManagerCompat notificationManager = android.support.v4.app.NotificationManagerCompat.from(VideoplayerActivity.this);
		notificationManager.notify(1, builder.build());
	}
	
	
	private void _repple (final View _v) {
		int[] attrs = new int[]{android.R.attr.selectableItemBackgroundBorderless};
				android.content.res.TypedArray typedArray = this.obtainStyledAttributes(attrs);
				int backgroundResource = typedArray.getResourceId(0, 0);
				_v.setBackgroundResource(backgroundResource);
		
		_v.setClickable(true);
	}
	
	
	private void _check_sharedonline () {
		a = 0;
		exit = 0;
		for(int _repeat12 = 0; _repeat12 < (int)(list_map_save_online.size()); _repeat12++) {
			if (list_map_save_online.get((int)a).get(key_videourl).toString().toLowerCase().equals(getIntent().getStringExtra("key_offline_videourl").toLowerCase())) {
				exit = 1;
				position_shared = String.valueOf((long)(a));
				add.setVisibility(View.GONE);
				already.setVisibility(View.VISIBLE);
			}
			a++;
		}
		if (exit == 0) {
			already.setVisibility(View.GONE);
			add.setVisibility(View.VISIBLE);
		}
	}
	
	
	private void _repple_all () {
		listview1.setDivider(null);
		listview1.setDividerHeight(0);
		_repple(linear3);
		_repple(download);
		_repple(add);
		_repple(already);
		_repple(downloaded);
		_repple(like);
		_repple(unlike);
		_repple(moree);
		_repple(imageview1);
	}
	
	
	private void _checked_offline () {
		a2 = 0;
		exit2 = 0;
		for(int _repeat12 = 0; _repeat12 < (int)(listmap_shared.size()); _repeat12++) {
			if (listmap_shared.get((int)a2).get(key_save_value).toString().toLowerCase().equals(pass3.toLowerCase())) {
				exit2 = 1;
				position_shared2 = String.valueOf((long)(a2));
				like.setVisibility(View.GONE);
				unlike.setVisibility(View.VISIBLE);
			}
			a2++;
		}
		if (exit2 == 0) {
			unlike.setVisibility(View.GONE);
			like.setVisibility(View.VISIBLE);
		}
	}
	
	
	private void _viewscounter () {
		check2 = String.valueOf((long)(Double.parseDouble(views) + Double.parseDouble("1")));
		likemap = new HashMap<>();
		likemap.put("views", check2);
		db2.child(pass6).updateChildren(likemap);
		likemap.clear();
	}
	
	
	private void _bottomsheet_version () {
		final android.support.design.widget.BottomSheetDialog bs_base = new android.support.design.widget.BottomSheetDialog(VideoplayerActivity.this); 
		
		bs_base.setCancelable(true);
		View layBase = getLayoutInflater().inflate(R.layout.more, null);
		
		bs_base.setContentView(layBase);
		
		bs_base.show();
		
		
		LinearLayout l1 = (LinearLayout)layBase.findViewById(R.id.copy);
		
		LinearLayout l2 = (LinearLayout)layBase.findViewById(R.id.share);
		
		
		LinearLayout l3 = (LinearLayout)layBase.findViewById(R.id.report);
		
		
		LinearLayout l4 = (LinearLayout)layBase.findViewById(R.id.send);
		
		
		_Ripple_Effect(l1);
		_Ripple_Effect(l2);
		_Ripple_Effect(l3);
		_Ripple_Effect(l4);
		
		TextView t1 = (TextView)layBase.findViewById(R.id.textview1);
		
		TextView t2 = (TextView)layBase.findViewById(R.id.textview2);
		
		TextView t3 = (TextView)layBase.findViewById(R.id.textview3);
		
		TextView t4 = (TextView)layBase.findViewById(R.id.textview4);
		
		TextView t5 = (TextView)layBase.findViewById(R.id.textview5);
		
		t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		
		
		t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		
		
		t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		
		t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		
		
		t5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		
		
		
		
		
		
		
		
		
		l1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) { 
				
				_copy_vid();
				
				bs_base.dismiss();
				
			}
		});
		
		
		l2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) { 
				
				_share_vid();
				
				bs_base.dismiss();
				
			}
		});
		
		
		l3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) { 
				
				_report_vid();
				
				bs_base.dismiss();
				
			}
		});
		
		l4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) { 
				
				
				_whatsapp_img();
				bs_base.dismiss();
				
			}
		});
		
		
		
		
	}
	
	
	private void _share_vid () {
		//Needs RequestNetwork to work!
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		connected = (netInfo != null && netInfo.isConnectedOrConnecting());
		if (connected) {
			_check_download();
			if (stroage.contains(textview1.getText().toString())) {
				_share_video();
			}
			else {
				pick_m = "share";
				url = getIntent().getStringExtra("key_offline_videourl");
				new DownloadFromURL().execute(url);
			}
		}
		else {
			SketchwareUtil.showMessage(getApplicationContext(), "Connection error");
		}
	}
	
	
	private void _whatsapp_img () {
		//Needs RequestNetwork to work!
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		connected = (netInfo != null && netInfo.isConnectedOrConnecting());
		if (connected) {
			_check_download();
			if (stroage.contains(textview1.getText().toString())) {
				_send_video();
			}
			else {
				pick_m = "send";
				url = getIntent().getStringExtra("key_offline_videourl");
				new DownloadFromURL().execute(url);
			}
		}
		else {
			SketchwareUtil.showMessage(getApplicationContext(), "Connection error");
		}
	}
	
	
	private void _copy_vid () {
		d_copy.setTitle("Direct Video Downloading link");
		d_copy.setMessage(pass1.concat("   \n\n".concat(pass3)));
		d_copy.setPositiveButton("Copy", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", pass3));
				SketchwareUtil.showMessage(getApplicationContext(), "Copied Successfully");
			}
		});
		d_copy.setNegativeButton("Close", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		d_copy.create().show();
	}
	
	
	private void _report_vid () {
		final android.support.design.widget.BottomSheetDialog bs_base2 = new android.support.design.widget.BottomSheetDialog(VideoplayerActivity.this); 
		
		bs_base2.setCancelable(true);
		View layBase2 = getLayoutInflater().inflate(R.layout.report, null);
		
		bs_base2.setContentView(layBase2);
		
		bs_base2.show();
		
		
		Button l1 = (Button)layBase2.findViewById(R.id.button1);
		
		LinearLayout edit = (LinearLayout)layBase2.findViewById(R.id.edit_linear);
		
		
		TextView t1 = (TextView)layBase2.findViewById(R.id.textview1);
		
		TextView t2 = (TextView)layBase2.findViewById(R.id.textview2);
		
		
		t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		
		
		t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
		
		
		
		
		
		
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor("#FF2C5B"));
		gd.setCornerRadius(25); 
		l1.setBackground(gd); 
		
		
		
		
		
		final EditText edittext1= new EditText(VideoplayerActivity.this);
		
		LinearLayout.LayoutParams lpar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		
		edittext1.setLayoutParams(lpar);
		
		edit.addView(edittext1);
		
		
		
		
		
		
		l1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) { 
				
				
				
				
				req = edittext1.getText().toString();
				map_request = new HashMap<>();
				map_request.put("Request", req);
				db3.push().updateChildren(map_request);
				map_request.clear();
				SketchwareUtil.showMessage(getApplicationContext(), "Thank for your feedback");
				bs_base2.dismiss();
				
			}
		});
		
		
	}
	
	
	private void _send_video () {
		v = FileUtil.getExternalStorageDir().concat("/ViV_Videos/".concat(textview1.getText().toString().concat(".mp4")));
		try { 
			
			Uri uri = Uri.parse(v);
			Intent videoshare = new Intent(Intent.ACTION_SEND); videoshare.setType("video/mp4"); 
			
			videoshare.setPackage("com.whatsapp"); videoshare.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); 
			 videoshare.putExtra(Intent.EXTRA_STREAM,uri); startActivity(videoshare);
			
			
		} catch (Exception e) {
			SketchwareUtil.showMessage(getApplicationContext(), "Error");
		} 
	}
	
	
	private void _more_data () {
		bb.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot _dataSnapshot) {
				map1 = new ArrayList<>();
				try {
					GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
					for (DataSnapshot _data : _dataSnapshot.getChildren()) {
						HashMap<String, Object> _map = _data.getValue(_ind);
						map1.add(_map);
					}
				}
				catch (Exception _e) {
					_e.printStackTrace();
				}
				n2 = map1.size() - 1;
				len2 = map1.size();
				for(int _repeat16 = 0; _repeat16 < (int)(len2); _repeat16++) {
					if (map1.get((int)n2).get("categories").toString().equals(pass4) && !map1.get((int)n2).get("categories").toString().equals(pass3)) {
						
					}
					else {
						map1.remove((int)(n2));
					}
					n2--;
				}
				Collections.shuffle(map1);
				listview1.setAdapter(new Listview1Adapter(map1));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
		});
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
				_v = _inflater.inflate(R.layout.custom_more, null);
			}
			
			final LinearLayout linear6 = (LinearLayout) _v.findViewById(R.id.linear6);
			final LinearLayout space = (LinearLayout) _v.findViewById(R.id.space);
			final LinearLayout linear1 = (LinearLayout) _v.findViewById(R.id.linear1);
			final ImageView imageview4 = (ImageView) _v.findViewById(R.id.imageview4);
			final TextView textview9 = (TextView) _v.findViewById(R.id.textview9);
			final LinearLayout linear2 = (LinearLayout) _v.findViewById(R.id.linear2);
			final LinearLayout linear3 = (LinearLayout) _v.findViewById(R.id.linear3);
			final ImageView imageview1 = (ImageView) _v.findViewById(R.id.imageview1);
			final TextView textview1 = (TextView) _v.findViewById(R.id.textview1);
			final LinearLayout linear4 = (LinearLayout) _v.findViewById(R.id.linear4);
			final LinearLayout linear5 = (LinearLayout) _v.findViewById(R.id.linear5);
			final TextView textview3 = (TextView) _v.findViewById(R.id.textview3);
			final TextView textview4 = (TextView) _v.findViewById(R.id.textview4);
			final ImageView imageview2 = (ImageView) _v.findViewById(R.id.imageview2);
			final TextView textview6 = (TextView) _v.findViewById(R.id.textview6);
			final ImageView imageview3 = (ImageView) _v.findViewById(R.id.imageview3);
			final TextView textview8 = (TextView) _v.findViewById(R.id.textview8);
			
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothambold.ttf"), 0);
			textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothammedium1.ttf"), 0);
			textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gothammedium1.ttf"), 0);
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor("#e8ebeb"));
			gd.setCornerRadius(30); 
			textview4.setBackground(gd); 
			
			
			android.graphics.drawable.GradientDrawable gd2 = new android.graphics.drawable.GradientDrawable();
			gd2.setColor(Color.parseColor("#e8ebeb"));
			gd2.setCornerRadius(30); 
			textview3.setBackground(gd2); 
			
			
			
			
			
			
			
			if (_position == 0) {
				linear6.setVisibility(View.VISIBLE);
				space.setVisibility(View.VISIBLE);
			}
			else {
				space.setVisibility(View.GONE);
				linear6.setVisibility(View.GONE);
			}
			if (map1.get((int)_position).get("categories").toString().contains(pass4) && !map1.get((int)_position).get("videourl").toString().contains(pass3)) {
				linear1.setVisibility(View.VISIBLE);
				textview1.setText(map1.get((int)_position).get("name").toString());
				Glide.with(getApplicationContext()).load(Uri.parse(map1.get((int)_position).get("imageurl").toString())).into(imageview1);
				textview3.setText(map1.get((int)_position).get("categories").toString());
				textview4.setText(map1.get((int)_position).get("language").toString());
				textview8.setText(map1.get((int)_position).get("likes").toString());
				textview6.setText(map1.get((int)_position).get("views").toString());
			}
			else {
				linear1.setVisibility(View.GONE);
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
