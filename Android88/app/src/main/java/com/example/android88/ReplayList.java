package com.example.android88;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ReplayList extends AppCompatActivity {

//    private AppBarConfiguration appBarConfiguration;
//    private ActivityReplayListBinding binding;

    private ListView listView;
    private String[] replaysDate = {"1", "2", "3"};
    private String[] replaysName;

    public static final String REPLAY_NAME = "replay_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_replay_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, R.layout.replay, replaysDate);

        listView = findViewById(R.id.replays_list);
        listView.setAdapter(adapter);


        //for scanning in replays.txt (later)
//        InputStream is = getResources().openRawResource(R.raw.replays);
//        Scanner sc = new Scanner(new InputStreamReader(is));
//
//        routeDetails = new String[routeNames.length];
//
//        for (int i = 0; i < routeNames.length; i++) {
//            StringBuilder sb = new StringBuilder();
//            String line = sc.nextLine();
//            while (!line.startsWith("*")) {
//                sb.append(line);
//                sb.append("\n");
//                line = sc.nextLine();
//            }
//            routeDetails[i] = sb.toString();
//        }

        listView.setOnItemClickListener((parent, view, position, id) -> showReplay(position));
    }

    private void showReplay(int pos){
        Bundle bundle = new Bundle();
        bundle.putString(REPLAY_NAME, replaysDate[pos]);
        //replay list of moves? v
        //bundle.putString(ROUTE_DETAIL, routeDetails[pos]);
        Intent intent = new Intent(this, com.example.android88.PlayReplay.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}