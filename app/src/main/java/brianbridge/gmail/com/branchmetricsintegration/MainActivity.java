package brianbridge.gmail.com.branchmetricsintegration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import io.branch.referral.Branch;
import io.branch.referral.BranchError;

public class MainActivity extends AppCompatActivity {
	public static final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public void onStart() {
		super.onStart();

		Branch branch = Branch.getInstance();
		branch.initSession(new Branch.BranchReferralInitListener(){
			@Override
			public void onInitFinished(JSONObject referringParams, BranchError error) {
				Log.d(TAG, referringParams.toString());
			}
		}, this.getIntent().getData(), this);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
	}
}
