package com.baiting.test;

import com.baiting.bean.Song;
import com.baiting.http.lyric.DownloadLyricBaidu;

public class BaiduLrcTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Song songTmp = new Song();
		songTmp.setName("�����ҵ�ʱ��������");
		songTmp.setSinger("����");
		DownloadLyricBaidu lrc = new DownloadLyricBaidu(songTmp);
		lrc.startDownload();
	}

}
