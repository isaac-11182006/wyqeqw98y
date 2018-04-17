package com.ivant.games.avalon.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.manager.SettingsManager;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Switch minionBlindMerlinSwitch = (Switch) findViewById(R.id.minionblindmerlin);
        minionBlindMerlinSwitch.setChecked(SettingsManager.isMinionBlindMerlin());
        minionBlindMerlinSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SettingsManager.setMinionBlindMerlin(isChecked);
            }
        });

        Switch roleBlindMinionSwitch = (Switch) findViewById(R.id.roleblindminion);
        roleBlindMinionSwitch.setChecked(SettingsManager.isRoleBlindMinion());
        roleBlindMinionSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SettingsManager.setRoleBlindMinion(isChecked);
            }
        });
    }
}
