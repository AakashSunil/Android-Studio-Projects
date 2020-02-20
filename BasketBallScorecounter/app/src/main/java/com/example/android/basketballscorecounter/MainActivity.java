package com.example.android.basketballscorecounter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    int n=0;
    int m=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void Three(View view) {
    n = n + 3;
        displayForTeamA(n);
    }
    public void Two(View view) {
        n = n + 2;
        displayForTeamA(n);
    }public void Free(View view) {
        n = n + 1;
        displayForTeamA(n);
    }
    public void Reset(View view) {
        m = 0;
        n = 0;
        displayForTeamA(n);
        displayForTeamB(m);
    }
    public void Three1(View view) {
        m = m + 3;
        displayForTeamB(m);
    }
    public void Two1(View view) {
        m = m + 2;
        displayForTeamB(m);
    }public void Free1(View view) {
        m = m + 1;
        displayForTeamB(m);
    }
    /**
         * Displays the given score for Team A.
         */
        public void displayForTeamA(int score) {
            TextView scoreView = (TextView) findViewById(R.id.team_a_score);
            scoreView.setText(String.valueOf(score));
        }
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }


}
