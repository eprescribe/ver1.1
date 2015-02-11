package eprescription.eprescription.Login;

/**
 * Created by Administrator on 02/02/2015.
 */

        import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//import com.hope.hopeuni.R;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LogIn extends Activity {
    // declaring variables

    private Button bLogIn;
    private EditText userName, password;
    private String usrname, pass;
    HttpClient httpClient;
    HttpPost httpPost;
    HttpResponse response;
    List<NameValuePair> nameValuePair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        // Creating HTTP client reference
        httpClient = new DefaultHttpClient();
        // Creating HTTP post reference
        httpPost = new HttpPost("https://www.facebook.com/simerpreet.anand");

        checkDetails();

    }
    private void checkDetails() {
        bLogIn = (Button) findViewById(R.id.bLogIn);
        bLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //set up username and password to send them to the
                //web-application for authentication

            userName=(EditText)findViewById(R.id.etUsername);
            password=(EditText)findViewById(R.id.Password);

                //fetch values from above and substitute them to below variables

            usrname = userName.getText().toString();
            pass = password.getText().toString();

             /*  // Authenticate the app untill we have our web-app

                if(usrname.equals("admin") &&
                        pass.equals("admin")){
                //correct password
                }else{
               //wrong password
                }
             */

                // Building http post parameters
                nameValuePair = new ArrayList<NameValuePair>(2);
                nameValuePair.add(new BasicNameValuePair("user", usrname));
                nameValuePair.add(new BasicNameValuePair("password",pass));

                // Url Encoding the POST parameters
                /*try {
                    String base64EncodedCredentials = "Basic " + Base64.encodeToString(
                            (userName + ":" + password).getBytes(),
                            Base64.NO_WRAP);


                    httppost.setHeader("Authorization", base64EncodedCredentials);
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
                } catch (UnsupportedEncodingException e) {
                    // writing error to Log
                    e.printStackTrace();
                }*/

                // Making HTTP Request
                try {
                    response = httpClient.execute(httpPost);
                    } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
}
        });
    }
}
