package com.kosmo.a26listview03;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//LinearLayout 을 상속한 커스텀 뷰 선언
public class IdolView extends LinearLayout {

    TextView textView1; //그룹명
    TextView textView2; //인원수
    ImageView imageView1; // 프로필이미지

    //생성자
    public IdolView(Context context){
        super(context);

        //레이아웃을 전개하기위해 Inflater 객체를 생성함
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflate()메소드를 통해 idol_view.xml을 전개한다.
        inflater.inflate(R.layout.idol_view, this, true);

        //데이터를 출력할 위젯을 가져온다.
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        imageView1 = findViewById(R.id.imageView1);
    }

    //각 항목의 값을 설정 할 setter 메소드 선언
    public void setName(String name) {
        textView1.setText(name);
    }

    public void setPerson(String pCount) {
        textView2.setText(pCount);
    }

    public void setImage(int imgNum) {
        imageView1.setImageResource(imgNum);
    }

}
