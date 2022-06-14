package jihyepark.org;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView; //비디오를 실행할 수 있게 도와주는 뷰
    private MediaController mediaController; //재생이나 정지와같은 미디어 제어 버튼 부를 담당
    private Uri videoURL;
    //변수 선언
    ImageView imageView;
    ImageView imageView2;

    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //앱이 첫 실행됬을때 이곳을 수행한다
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framelayout_pr);
        videoURL = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vid);

        videoView = findViewById(R.id.videoView);
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController); // 미디어 제어 버튼부 세팅
        videoView.setVideoURI(videoURL); // 비디오 뷰의 주소를 설정
        videoView.start(); // 비디오 실행


        imageView = (ImageView) findViewById(R.id.imageView3); //ImageView(자료형) 변수이름 = (형 변환) findViewByID(R.id.찾을id)
        imageView2 = (ImageView) findViewById(R.id.imageView4);
    }

    public void onButton1Clicked(View view) {
        index += 1;
        if (index >2) {
            index=0;
        }
        if (index==0) {
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            videoView.setVisibility(View.INVISIBLE);
        } else if(index ==1){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            videoView.setVisibility(View.INVISIBLE);
        } else{
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            videoView.setVisibility(View.VISIBLE);
        }

    }
}