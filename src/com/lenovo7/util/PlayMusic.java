package com.lenovo7.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.example.lenovo7.R;

public class PlayMusic {
	private SoundPool sp ;
	private int id;
	
	public PlayMusic(Context context){
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		id = sp.load(context, R.raw.music, 0);
	}
	
	public void play(){
		sp.play(id, 1, 10, 10, 0, 1);
	}
}
