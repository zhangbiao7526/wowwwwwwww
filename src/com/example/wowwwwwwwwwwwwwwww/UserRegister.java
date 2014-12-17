package com.example.wowwwwwwwwwwwwwwww;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

//import eyt.AjaxCallBack;
//import eyt.AjaxParams;
//import eyt.FinalHttp;






import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserRegister extends Activity {
	
	EditText e1,e2,e3,e4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registeruser);
	 Button b1= (Button) findViewById(R.id.sign);
	 b1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent it1=new Intent();
			startActivity(it1);
		}
	});
	 
	 
	   Button b2=(Button) findViewById(R.id.gobacklogin);
	   b2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		     e1=(EditText) findViewById(R.id.fname);
		     e2=(EditText) findViewById(R.id.Last);
		     e3 =(EditText) findViewById(R.id.pass01);
		     e4=(EditText) findViewById(R.id.Addre);
		     
		     String username=e1.getText().toString();
		     String password=e2.getText().toString();
		     String uesrquestion=e3.getText().toString();
		     String useranswer=e4.getText().toString();
		     
		     if("".equals(username)||username==null){
					Toast.makeText(UserRegister.this, "用户名为空", Toast.LENGTH_LONG).show();
					
				}else if("".equals(password)||password==null){
					Toast.makeText(UserRegister.this, "密码为空", Toast.LENGTH_LONG).show();
				}else if("".equals(uesrquestion)||uesrquestion==null){  
					Toast.makeText(UserRegister.this, "密码找回问题为空", Toast.LENGTH_LONG).show();
				}else if("".equals(useranswer)||useranswer==null){  
					Toast.makeText(UserRegister.this, "密码找回答案为空", Toast.LENGTH_LONG).show();
				}else{
                FinalHttp fh=new FinalHttp();
					
					AjaxParams param=new AjaxParams();
						param.put("method", "userRegister");
						try {
							param.put("newuser", URLEncoder.encode(username, "utf-8"));
							param.put("newpassword", URLEncoder.encode(password, "utf-8"));
							param.put("newquestion", URLEncoder.encode(uesrquestion, "utf-8"));
							param.put("newresult", URLEncoder.encode(useranswer, "utf-8"));
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						// TODO Auto-generated catch block
					
					fh.post("http://10.30.6.92:8080/togoProjectDemo/servlet/user_Login",param, new AjaxCallBack<Object>(){
						@Override
						public void onStart() {
							// TODO Auto-generated method stub
							super.onStart();
							System.out.println("开始请求FinalServlet");
						}
			           //成功返回
						@Override
						public void onSuccess(Object t) {
							// TODO Auto-generated method stub
							super.onSuccess(t);
							//System.out.println("请求FinalServlet成功"+t);
							//tv.setText(t.toString());//接收反馈回来的数据
							Toast.makeText(UserRegister.this, t.toString(), Toast.LENGTH_SHORT).show();
//							Intent in=new Intent(Register.this,Login.class);
//							startActivity(in);
						}
						@SuppressWarnings("unused")
						public void onFailure(Throwable t, int errorNo,
								String strMsg) {
							// TODO Auto-generated method stub
							super.onFailure(t, strMsg);
							Toast.makeText(UserRegister.this, strMsg, Toast.LENGTH_SHORT).show();
//							System.out.println("请求失败"+strMsg);
							//tv.setText(strMsg );//接收反馈回来的数据
						}
						@Override
						public void onLoading(long count, long current) {
							// TODO Auto-generated method stub
							super.onLoading(count, current);
							System.out.println("1秒钟被回调一次");
						}
					});
					Toast.makeText(UserRegister.this, "注册成功", Toast.LENGTH_LONG).show();
					
				}
			
				

		}
		});
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
