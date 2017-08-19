package com.example.handa.fjunction2;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Singup extends AppCompatActivity {


    private static final String REGISTER_URL= "http://handa.16mb.com/FJregister.php";


    public  static final String KEY_USERNAME="user_name";
    public  static final String KEY_EMAIL="e_mail";
    public  static final String KEY_MOBILENUMBER="phone_no";
    public  static final String KEY_GENDER ="gender";
    public  static final String KEY_DATEOFBIRTH ="dob";
    public  static final String KEY_PASSWORD="password";


    String  Susername,Sgmail,Sphonenumber,Sgender,Sdob,Spassword;

    EditText Eusername,Egmail,Ephonenumber,Egender,Edob,Epassword;

    Button accept;
    TextView textView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);



        Eusername = (EditText)findViewById(R.id.username);
        Egmail = (EditText)findViewById(R.id.gmail);
        Ephonenumber = (EditText)findViewById(R.id.phoneNumber);
        Egender = (EditText)findViewById(R.id.gender);
        Edob = (EditText) findViewById(R.id.dob);
        Epassword = (EditText) findViewById(R.id.password);

        accept = (Button)findViewById(R.id.accept);
        textView = (TextView)findViewById(R.id.singin);


        Egender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                CharSequence colors[] = new CharSequence[]{"Male","Female"};

                AlertDialog.Builder builder = new AlertDialog.Builder(Singup.this);
                builder.setTitle("Gender");
                builder.setItems(colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        switch (which) {
                            case 0:
                                Egender.setText("Male");
                                break;
                            case 1:
                                Egender.setText("Female");
                                break;

                        }
                    }
                });
                builder.show();
            }
        });


        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == accept) {
                    register_user();

                }}});


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Singup.this, MainActivity.class);
                startActivity(i);

            }
        });



 /*       Edob.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                DateDialog dialog = new DateDialog(v);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                dialog.show(ft, "DatePicker");


            }
        });
*/
        Edob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DateDialog dialog = new DateDialog(v);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                dialog.show(ft, "DatePicker");


            }
        });




    }
    @Override
    public boolean onTouchEvent (MotionEvent event){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }


    private void register_user(){

        Susername=Eusername.getText().toString().trim();
        Sgmail=Egmail.getText().toString().trim();
        Sphonenumber=Ephonenumber.getText().toString().trim();
        Sgender=Egender.getText().toString().trim();
        Sdob=Edob.getText().toString().trim();
        Spassword=Epassword.getText().toString().trim();

    /*    if (Eusername.getText().toString().length() == 0) {
            Eusername.setError("name not entered");
            Eusername.requestFocus();
        }
        if (Egmail.getText().toString().length() == 0) {
            Egmail.setError(" enter valid email");
            Egmail.requestFocus();
        }

        if (Ephonenumber.getText().toString().length() == 0) {
            Ephonenumber.setError("enter valid Phone number");
            Ephonenumber.requestFocus();
        }
        if (Egender.getText().toString().length() == 0) {
            Egender.setError("enter Male/Female");
            Egender.requestFocus();
        }
        if (Edob.getText().toString().length() == 0) {
            Edob.setError("enter Date of Birth");
            Edob.requestFocus();
        }
       *//* if (!Epassword.getText().toString().equals(rcpassword.getText().toString())) {
            rcpassword.setError("Password Not matched");
            rcpassword.requestFocus();*//*
        if (Epassword.getText().toString().length() == 0) {
            Epassword.setError("Please enter password");
            Epassword.requestFocus();
        }


        if (!isValidUsername(Susername)) {
            Eusername.setError("must be long than two char");
        }

        if (!isValidEmail(Sgmail)) {
            Egmail.setError("enter valid email");
        }


        if (!isValidMobilenumber(Sphonenumber)) {
            Ephonenumber.setError("Invalid number");
        }

        if (!isValidPassword(Sgender)) {
            Egender.setError("Password should be atlleast 8 digit");
        }

        if (!isValidPassword(Sdob)) {
            Edob.setError("Password should be atlleast 8 digit");
       *//* if (!isValidConformPassword(cpassword)) {
            rcpassword.setError("Password not matched");*//*
        }
        if (!isValidPassword(Sgender)) {
            Egender.setError("Password should be atlleast 8 digit");
        }
        else {
*/

            StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(Singup.this, response, Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(getApplicationContext(), Tabselect.class);
                    startActivity(i);
                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Singup.this, error.toString(), Toast.LENGTH_SHORT).show();
                            //Toast.makeText(Signup.this, "Make Your Internet Connection", Toast.LENGTH_SHORT).show();
                        }

                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();

                    params.put(KEY_USERNAME, Susername);
                    params.put(KEY_EMAIL, Sgmail);
                    params.put(KEY_MOBILENUMBER, Sphonenumber);
                    params.put(KEY_GENDER, Sgender);
                    params.put(KEY_DATEOFBIRTH, Sdob);
                    params.put(KEY_PASSWORD, Spassword);
                    return params;
                }
            };

            RequestQueue requestqueue = Volley.newRequestQueue(this);
            requestqueue.add(stringRequest);
        }
    }
//*
//close keybroad

/*

    private boolean isValidUsername(String username) {
        if (username != null && username.length() >= 3) {
            return true;
        }
        return false;
    }

    private boolean isValidEmail(String email) {

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidMobilenumber(String mobilenumber) {
        if (mobilenumber != null && mobilenumber.length() == 10) {
            return true;
        }
        return false;
    }

    private boolean isValidPassword(String password) {
        if (password != null && password.length() > 6) {
            return true;
        }
        return false;
    }

    private boolean isValidConformPassword(String cpassword) {
        if (cpassword != null && cpassword.length() > 8 && cpassword.equals(password)) {
            return true;
        }
        return false;
*/
/*
   }

}
*/
