/*package com.example.selfreportcovid19;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    private EditText temp; //tempInput
    private TextView check;
    private Button hospital;
    private Button yes; //yesButton
    private Button no; //noButton
    private String word; //这是啥
    private TextView text; //micInstruction
    private ImageButton voice; //micButton

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp = (EditText) findViewById(R.id.tempInput);
        speak();
        temp.setText(word, TextView.BufferType.EDITABLE);
        check = (TextView) findViewById(R.id.check);
        hospital = (Button) findViewById(R.id.mapButton);
        yes = (Button) findViewById(R.id.yesButton);
        no = (Button) findViewById(R.id.noButton);
        hospital.setVisibility(View.INVISIBLE);
        text = findViewById(R.id.micInstruction);
        voice = findViewById(R.id.micbutton);
        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMapActivity();
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hospital.setVisibility(View.VISIBLE);
            }
        });
    }

    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi please enter your current body temperature");
        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
        }
        catch (Exception e) {
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        PackageManager pm = getPackageManager();
        List activities = pm.queryIntentActivities(new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        if (activities.size() == 0) {
            Toast.makeText(this, "Voice recognizer is not available", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "OK. Voice recognizer is available.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case REQUEST_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    text.setText(result.get(0));
                    word = result.get(0);
                }
                break;
            }
        }
    }
    public void checkValidity(View vi) {
        String s = temp.getText().toString();
        if (s != null && !"".equals(s)) {
            float valueOfTemp = Float.parseFloat(s);
            categorize(valueOfTemp);
        }
    }
    private void categorize(float temperature) {
        String result = "";
        hospital = (Button) findViewById(R.id.mapButton);
        if (Float.compare(temperature, 80f) < 0) {
            result = "Invalid body temperature";
            /*if(no.callOnClick() == true) {
                hospital.setVisibility(View.INVISIBLE);
            } else if (yes.callOnClick() == true) {
                hospital.setVisibility(View.VISIBLE);
            }
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hospital.setVisibility(View.INVISIBLE);
                }
            });
        }
        if (Float.compare(temperature, 95f) <= 0 && Float.compare(temperature, 80f) >= 0) {
            result = "Hypothermia";
            /*if(no.callOnClick() == true) {
                hospital.setVisibility(View.INVISIBLE);
            } else if (yes.callOnClick() == true) {
                hospital.setVisibility(View.VISIBLE);
            }
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hospital.setVisibility(View.INVISIBLE);
                }
            });
        } else if (Float.compare(temperature, 95f) > 0
                && Float.compare(temperature, 99.14f) < 0) {
            result = "Normal";
            /*if(no.callOnClick() == true) {
                hospital.setVisibility(View.INVISIBLE);
            } else if (yes.callOnClick() == true) {
                hospital.setVisibility(View.VISIBLE);
            }
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hospital.setVisibility(View.INVISIBLE);
                }
            });
        } else if (Float.compare(temperature, 99.14f) >= 0 && Float.compare(temperature, 111f) <= 0) {
            result = "Suspected COVID-19";
            /*if(no.callOnClick() == true) {
                hospital.setVisibility(View.INVISIBLE);
            } else if (yes.callOnClick() == true) {
                hospital.setVisibility(View.VISIBLE);
            }
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hospital.setVisibility(View.INVISIBLE);
                }
            });
        } else if (Float.compare(temperature, 111f) > 0) {
            result = "Invalid body temperature";
            /*if(no.callOnClick() == true) {
                hospital.setVisibility(View.INVISIBLE);
            } else if (yes.callOnClick() == true) {
                hospital.setVisibility(View.VISIBLE);
            }
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hospital.setVisibility(View.INVISIBLE);
                }
            });
        }
        result = temperature + "°F " + result;
        check.setText(result);
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMapActivity();
            }
        });
    }
    public void startMapActivity() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}*/

package com.example.selfreportcovid19;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.selfreportcovid19.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    private EditText temp;
    private TextView check;
    private Button hospital;
    private Button yes;
    private Button no;
    private String word;
    TextView myText;
    ImageButton myVoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp = (EditText) findViewById(R.id.tempInput);
        speak();
        temp.setText(word,TextView.BufferType.EDITABLE);
        check = (TextView) findViewById(R.id.check);
        hospital = (Button) findViewById(R.id.mapButton);
        yes = (Button) findViewById(R.id.yesButton);
        no = (Button) findViewById(R.id.noButton);
        hospital.setVisibility(View.INVISIBLE);
        myText = findViewById(R.id.micInstruction);
        myVoice = findViewById(R.id.micbutton);
        myVoice.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                speak();
            }
        });
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMapActivity();
            }
        });
        yes.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                hospital.setVisibility(View.VISIBLE);
            }
        });
    }

    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent .putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi please enter your current body temperature");
        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
        }
        catch (Exception e) {
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        PackageManager pm = getPackageManager();
        List activities = pm.queryIntentActivities(new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        if (activities.size() == 0) {
            Toast.makeText(this, "Voice recognizer is not available", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "OK. Voice recognizer is available.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case REQUEST_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    myText.setText(result.get(0));
                    word = result.get(0);
                }
                break;
            }
        }
    }
    public void checkValidity(View a) {
        String t = temp.getText().toString();
        if (t != null && !"".equals(t)) {
            float valueOfTemp= Float.parseFloat(t);
            categorize(valueOfTemp);
        }
    }

    private void categorize(float temperature) {
        String result = "";
        hospital = (Button) findViewById(R.id.mapButton); //need to fix
        if (Float.compare(temperature, 80f) < 0) {
            result = "Invalid body temperature";
            no.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    hospital.setVisibility(View.INVISIBLE);
                }
            });
        }
        if (Float.compare(temperature, 95f) <= 0 && Float.compare(temperature, 80f) >= 0) {
            result = "Hypothermia";
            no.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    hospital.setVisibility(View.INVISIBLE);
                }
            });
        } else if (Float.compare(temperature, 95f) > 0
                && Float.compare(temperature, 99.14f) < 0) {
            result = "Normal";
            no.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    hospital.setVisibility(View.INVISIBLE);
                }
            });
        } else if (Float.compare(temperature, 99.14f) >= 0 && Float.compare(temperature, 111f) <= 0) {
            result = "Suspected COVID-19";
            no.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    hospital.setVisibility(View.VISIBLE);
                }
            });
        } else if (Float.compare(temperature, 111f) > 0) {
            result = "Invalid body temperature";
            no.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    hospital.setVisibility(View.INVISIBLE);
                }
            });
        }
        result = temperature + "°F " + result;

        check.setText(result);
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMapActivity();
            }
        });
    }



    public void startMapActivity() {
        Intent i = new Intent(this,  MapsActivity.class);
        startActivity(i);
    }
}