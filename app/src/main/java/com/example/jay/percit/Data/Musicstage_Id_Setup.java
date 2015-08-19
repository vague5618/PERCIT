package com.example.jay.percit.Data;

import android.content.Context;
import android.util.Log;

import com.example.jay.percit.Model.MusicStage_Id;
import com.example.jay.percit.Model.MusicStage_IdDAO;
import com.example.jay.percit.Model.Playlist_ImageDAO;
import com.example.jay.percit.R;

/**
 * Created by Jay on 2015-08-19.
 */
public class Musicstage_Id_Setup {

    MusicStage_IdDAO musicStageIdDAO;

    public Musicstage_Id_Setup(Context mContext) {

        try {
            musicStageIdDAO = MusicStage_IdDAO.open(mContext);
        } catch (Exception e) {
            Log.i("SQL SETUP ERROR", " ");

            e.printStackTrace();
        }

        setUp();
    }

    void setUp() {

        musicStageIdDAO.setMusicStage_Id(new
                        MusicStage_Id(R.id.playlist_image1, R.id.musicstage_information1,
                        R.id.musicstage_main1_progress1, R.id.musicstage_main1_progress2, R.id.musicstage_main1_progress3,
                        R.id.musicstage_main1_like_txt, R.id.musicstage_main1_like_img)
        );

        musicStageIdDAO.setMusicStage_Id(new

                        MusicStage_Id(R.id.musicstage_image2, R.id.musicstage_information2,
                        R.id.musicstage_main2_progress1, R.id.musicstage_main2_progress2, R.id.musicstage_main2_progress3,
                        R.id.musicstage_main2_like_txt, R.id.musicstage_main2_like_img)

        );

        musicStageIdDAO.setMusicStage_Id(new

                        MusicStage_Id(R.id.musicstage_image3, R.id.musicstage_information3,
                        R.id.musicstage_main3_progress1, R.id.musicstage_main3_progress2, R.id.musicstage_main3_progress3,
                        R.id.musicstage_main3_like_txt, R.id.musicstage_main3_like_img)

        );

        musicStageIdDAO.setMusicStage_Id(new

                        MusicStage_Id(R.id.musicstage_image4, R.id.musicstage_information4,
                        R.id.musicstage_main4_progress1, R.id.musicstage_main4_progress2, R.id.musicstage_main4_progress3,
                        R.id.musicstage_main4_like_txt, R.id.musicstage_main4_like_img)

        );

        musicStageIdDAO.setMusicStage_Id(new

                        MusicStage_Id(R.id.musicstage_image5, R.id.musicstage_information5,
                        R.id.musicstage_main5_progress1, R.id.musicstage_main5_progress2, R.id.musicstage_main5_progress3,
                        R.id.musicstage_main5_like_txt, R.id.musicstage_main5_like_img)

        );

        musicStageIdDAO.setMusicStage_Id(new

                        MusicStage_Id(R.id.musicstage_image6, R.id.musicstage_information6,
                        R.id.musicstage_main6_progress1, R.id.musicstage_main6_progress2, R.id.musicstage_main6_progress3,
                        R.id.musicstage_main6_like_txt, R.id.musicstage_main6_like_img)

        );

        musicStageIdDAO.setMusicStage_Id(new

                        MusicStage_Id(R.id.musicstage_image7, R.id.musicstage_information7,
                        R.id.musicstage_main7_progress1, R.id.musicstage_main7_progress2, R.id.musicstage_main7_progress3,
                        R.id.musicstage_main7_like_txt, R.id.musicstage_main7_like_img)

        );

        musicStageIdDAO.setMusicStage_Id(new

                        MusicStage_Id(R.id.musicstage_image8, R.id.musicstage_information8,
                        R.id.musicstage_main8_progress1, R.id.musicstage_main8_progress2, R.id.musicstage_main8_progress3,
                        R.id.musicstage_main8_like_txt, R.id.musicstage_main8_like_img)

        );
    }
}
