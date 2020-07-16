package com.kosmo.a26listview03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "KOSMO61";

    String[] idolGroup = { "엑소", "방탄소년단", "워너원", "뉴이스트", "갓세븐", "비투비", "빅스" };
    int[] teamCount = { 9, 7, 11, 5, 7, 7, 6 };
    int[] images = { R.drawable.idol1, R.drawable.idol2, R.drawable.idol3, R.drawable.idol4, R.drawable.idol5, R.drawable.idol6, R.drawable.idol7 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 리스트뷰의 데이터로 사용 할 커스텀 어댑터 객체생성
        final MyAdapter adapter = new MyAdapter();

        // 2. 리스트뷰 가져오기
        ListView listView1 = findViewById(R.id.listView1);

        // 3. 리스트뷰에 어뎁터 설정하기
        listView1.setAdapter(adapter);

        // 4. 리스너 부착하긴
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "선택한 그룹 : " + idolGroup[position],
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return idolGroup.length;
        }

        @Override
        public Object getItem(int position) {
            return idolGroup[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //XML리소스 파일로 정의한 레이아웃을 사용하는 IdolView클래스의 객체생성
            IdolView view = new IdolView(getApplicationContext());
            //setter()를 통해 각각의 값을 설정
            view.setName(idolGroup[position]);
            view.setPerson(new Integer(teamCount[position]).toString() + "명");
            view.setImage(images[position]);

            return view;
        }
    }

}
