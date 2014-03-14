package com.example.testservice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button startServiceButton;// ��������ť
	Button shutDownServiceButton;// �رշ���ť
	Button startBindServiceButton;// �����󶨷���ť
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getWidget();
		regiestListener();
	}

	/** ������ */
	public void getWidget() {
		startServiceButton = (Button) findViewById(R.id.startServerButton);
		startBindServiceButton = (Button) findViewById(R.id.startBindServerButton);
		shutDownServiceButton = (Button) findViewById(R.id.sutdownServerButton);
	}

	/** Ϊ��ť��Ӽ��� */
	public void regiestListener() {
		startServiceButton.setOnClickListener(startService);
		shutDownServiceButton.setOnClickListener(shutdownService);
		startBindServiceButton.setOnClickListener(startBinderService);
	}
	
	
	/** ����������¼����� */
	public Button.OnClickListener startService = new Button.OnClickListener() {
		public void onClick(View view) {
			/** ������ťʱ�������� */
			Intent intent = new Intent(MainActivity.this,
					CountService.class);
			startService(intent);
			
			Log.v("MainStadyServics", "start Service");
		}
	};
	/** �رշ��� */
	public Button.OnClickListener shutdownService = new Button.OnClickListener() {
		public void onClick(View view) {
			/** ������ťʱ�������� */
			Intent intent = new Intent(MainActivity.this,
					CountService.class);
			/** �˳�Activity�ǣ�ֹͣ���� */
			stopService(intent);
			Log.v("MainStadyServics", "shutDown serveice");
		}
	};
	/** �򿪰󶨷����Activity */
	public Button.OnClickListener startBinderService = new Button.OnClickListener() {
		public void onClick(View view) {
			/** ������ťʱ�������� */
			Intent intent = new Intent(MainActivity.this, UseBrider.class);
			startActivity(intent);
			Log.v("MainStadyServics", "start Binder Service");
		}
	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
