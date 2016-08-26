package com.oc.rss.rollthedice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.SecureRandom;

/**
 * Created by rmollon on 25/08/16.
 */
public class RollActivity extends Activity implements View.OnClickListener {
    private TextView textResult;
    private int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll);

        max = getIntent().getIntExtra("max", 0);

        TextView textTitle = (TextView) findViewById(R.id.tXSidedDice);
        switch (max)
        {
            case 6:
                textTitle.setText(R.string.dice_6sided);
                break;
            case 20:
                textTitle.setText(R.string.dice_20sided);
                break;
            default:
                textTitle.setText(R.string.error);
        }

        textResult = (TextView) findViewById(R.id.tResult);
        textResult.setText("");

        Button buttonRoll = (Button) findViewById(R.id.bRoll);
        buttonRoll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SecureRandom random = new SecureRandom();
        int result = random.nextInt(max) + 1;
        textResult.setText(String.valueOf(result));
    }
}
