package com.as.fragmentexample;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ToolbarFragment extends Fragment implements OnSeekBarChangeListener{

	private static int seekValue = 10;
	private static EditText mEditText;
	
	ToolbarListener activityCallBack;
	
	public interface ToolbarListener {
		public void onButtonClick(int position, String text);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		activityCallBack = (ToolbarListener) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_first, container, false);
		
		mEditText = (EditText) view.findViewById(R.id.editText1);
		
		final SeekBar mSeekBar = (SeekBar) view.findViewById(R.id.seekBar1);
		mSeekBar.setOnSeekBarChangeListener(this);
		
		final Button mButton = (Button) view.findViewById(R.id.button1);
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				buttonClicked(v);
			}
		});
		return view;
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		seekValue = progress;
		
	}
	
	public void buttonClicked(View v) {
		activityCallBack.onButtonClick(seekValue, mEditText.getText().toString());
		
	}
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

}
