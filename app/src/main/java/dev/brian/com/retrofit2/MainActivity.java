package dev.brian.com.retrofit2;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import dev.brian.com.retrofit2.api.ApiUtils;
import dev.brian.com.retrofit2.api.PostService;
import dev.brian.com.retrofit2.model.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView mResponse;
    private PostService mPostService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText titleText = (EditText) findViewById(R.id.et_title);
        final EditText bodyText = (EditText) findViewById(R.id.et_body);
        Button submitPost = (Button) findViewById(R.id.btn_submit);
        mResponse = (TextView)findViewById(R.id.tv_response);

        mPostService = ApiUtils.getApiService();

        submitPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "weeh", Toast.LENGTH_SHORT).show();
                String title = titleText.getText().toString().trim();
                String body = bodyText.getText().toString().trim();
                if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)){
                    sendPost(title,body);
                }
            }
        });
    }
    private void sendPost(String title,String body){
        mPostService.savePost(title,body,1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(@NonNull Call<Post> call,@NonNull Response<Post> response) {
                showResponse(response.body().toString());
                Log.i("Logs","Post Submmited to API" + response.body().toString());
                Toast.makeText(getApplicationContext(),"Post Submitted",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(),"Unable to Submit Post",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void showResponse(String response){
        if(mResponse.getVisibility() == View.GONE){
            mResponse.setVisibility(View.VISIBLE);
        }
        mResponse.setText(response);
    }

}
