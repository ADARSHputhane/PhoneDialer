package com.example.phonedialer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import com.example.phonedialer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.button0.setOnClickListener(this);
        binding.button1.setOnClickListener(this);
        binding.button2.setOnClickListener(this);
        binding.button3.setOnClickListener(this);
        binding.button4.setOnClickListener(this);
        binding.button5.setOnClickListener(this);
        binding.button6.setOnClickListener(this);
        binding.button7.setOnClickListener(this);
        binding.button8.setOnClickListener(this);
        binding.button9.setOnClickListener(this);
        binding.buttonStar.setOnClickListener(this);
        binding.buttonPound.setOnClickListener(this);
        binding.clearButton.setOnClickListener(this);
        binding.callButton.setOnClickListener(this);
        binding.saveButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.equals(binding.button0)){
          binding.numberTextView.append("0");

        } else if(v.equals(binding.button1)){
            binding.numberTextView.append("1");

        }else if(v.equals(binding.button2)){
            binding.numberTextView.append("2");

        }else if(v.equals(binding.button3)){
            binding.numberTextView.append("3");

        }else if(v.equals(binding.button4)){
            binding.numberTextView.append("4");

        }else if(v.equals(binding.button5)){
            binding.numberTextView.append("5");

        }else if(v.equals(binding.button6)){
            binding.numberTextView.append("6");

        }else if(v.equals(binding.button7)){
            binding.numberTextView.append("7");

        }else if(v.equals(binding.button8)){
            binding.numberTextView.append("8");

        }else if(v.equals(binding.button9)){
            binding.numberTextView.append("9");

        }else if(v.equals(binding.buttonStar)){
            binding.numberTextView.append("*");

        }else if(v.equals(binding.buttonPound)){
            binding.numberTextView.append("#");

        }else if(v.equals(binding.saveButton)){
            Intent contactIntent= new Intent
                    (ContactsContract.Intents.Insert.ACTION); contactIntent.setType
                    (ContactsContract.RawContacts.CONTENT_TYPE);

            contactIntent
                    .putExtra(ContactsContract.Intents.Insert.NAME,"Unknown"); contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE, binding.numberTextView.getText().toString());

            startActivity(contactIntent);

        } else if(v.equals(binding.clearButton)){
            binding.numberTextView.setText(" ");
        }else if(v.equals(binding.callButton)){
            String data = binding.numberTextView.getText().toString();
            if(data.length() > 0){
                binding.numberTextView.setText(data.substring(0,data.length()-1));
                Intent intent=new Intent(Intent.ACTION_DIAL); intent.setData(Uri.parse("tel:"+ data)); startActivity(intent);

            }else binding.numberTextView.setText("");

        }
    }
}