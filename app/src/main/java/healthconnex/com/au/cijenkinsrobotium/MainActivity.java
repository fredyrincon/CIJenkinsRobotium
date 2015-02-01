package healthconnex.com.au.cijenkinsrobotium;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

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

    //change the label of the text
    public  void onClickChangeLabel(View v) {
        TextView results = (TextView) findViewById(R.id.textView);
        results.setText("Testing Android Rocks!");
    }

    //Show next Activity
    public void onClickNextButton(View v) {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    //Show second next Activity
    public void onClickSecondNextButton(View v) {
        Intent intent = new Intent(this, SecondDetailActivity.class);
        startActivity(intent);
    }
}
