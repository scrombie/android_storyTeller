package com.max.storyteller;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class StoryActivity extends ActionBarActivity {
	StoryManager sm = new StoryManager();
	Button bSwitch;
	TextView story;
	TextView title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_story);
		
		story = (TextView)findViewById(R.id.story);
	    title = (TextView)findViewById(R.id.title);
	    bSwitch = (Button)findViewById(R.id.bSwitch);
	    
	    ActionBar bar  = getSupportActionBar();
	    bar.hide();
	    
	    title.setText(sm.getCurrentTitle());
	    story.setText(sm.getCurrentStory());
	    
	    bSwitch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sm.generateStory();
				title.setText(sm.getCurrentTitle());
			    story.setText(sm.getCurrentStory());
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.story, menu);
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
