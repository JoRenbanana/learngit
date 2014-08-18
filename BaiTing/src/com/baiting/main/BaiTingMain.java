package com.baiting.main;

import java.awt.EventQueue;

import org.apache.log4j.Logger;

import com.baiting.config.SettingConfig;
import com.baiting.layout.MusicWindowLayout;


public class BaiTingMain{

	private static final Logger log = Logger.getLogger(BaiTingMain.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//��ʼ������
		log.info("��ʼ������.....");
		//Fonts fonts = new Fonts();
		//fonts.init();
		log.info("���������ļ�.....");
		SettingConfig.getInstance();
		log.info("���������ļ�..[���]...");
		log.info("��ʼ���г���.....");
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				MusicWindowLayout music = new MusicWindowLayout();
				music.show();
			}
		});
	}

}
