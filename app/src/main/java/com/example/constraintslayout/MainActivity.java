package com.example.constraintslayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    private boolean isCaculate = false;
    private Button mButtonNegative, mButtonPercent, mButtonResult;
    private Button mButton7, mButton8, mButton9, mButtonDiv;
    private Button mButton4, mButton5, mButton6, mButtonMul;
    private Button mButton1, mButton2, mButton3, mButtonSub;
    private Button mButton0, mButtonPoint, mButtonAdd;
    private Button mButtonDel;

    private TextView mTextViewLine1, mTextViewLine2;

    private String mLine1="",mLine2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getView();
        setOnClick();
      //  mTextViewLine2.setText(mLine2);
        mTextViewLine1.setText(mLine1);

    }

    public void getView() {
        mButtonNegative = findViewById(R.id.btnP);
        mButtonPercent = findViewById(R.id.btnPercent);
        mButtonResult = findViewById(R.id.btnResult);
        mButton7 = findViewById(R.id.btn7);
        mButton8 = findViewById(R.id.btn8);
        mButton9 = findViewById(R.id.btn9);
        mButtonDiv = findViewById(R.id.btnDiv);
        mButton4 = findViewById(R.id.btn4);
        mButton5 = findViewById(R.id.btn5);
        mButton6 = findViewById(R.id.btn6);
        mButtonMul = findViewById(R.id.btnMul);
        mButton1 = findViewById(R.id.btn1);
        mButton2 = findViewById(R.id.btn2);
        mButton3 = findViewById(R.id.btn3);
        mButtonSub = findViewById(R.id.btnSub);
        mButton0 = findViewById(R.id.btn0);
        mButtonPoint = findViewById(R.id.btnPoint);
        mButtonAdd = findViewById(R.id.btnAdd);
        mButtonDel = findViewById(R.id.btnDel);

        mTextViewLine1 = findViewById(R.id.line1);
        mTextViewLine2 = findViewById(R.id.line2);
    }
    public void setOnClick(){
        mButtonDel.setOnClickListener(this);
        mButton0.setOnClickListener(this);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);
        mButton7.setOnClickListener(this);
        mButton8.setOnClickListener(this);
        mButton9.setOnClickListener(this);
        mButtonResult.setOnClickListener(this);
        mButtonPoint.setOnClickListener(this);
        mButtonAdd.setOnClickListener(this);
        mButtonMul.setOnClickListener(this);
        mButtonSub.setOnClickListener(this);
        mButtonDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDel:
                if(!mLine1.equals("")){
                    mLine1 = mLine1.substring(0,mLine1.length()-1);
                    mTextViewLine1.setText(mLine1);
                }
                break;
            case R.id.btn0:
                mLine1 = mLine1+"0";
                mTextViewLine1.setText(mLine1);
                break;
            case R.id.btn1:
                mLine1 = mLine1+"1";
                mTextViewLine1.setText(mLine1);
                break;
            case R.id.btn2:
                mLine1 = mLine1+"2";
                mTextViewLine1.setText(mLine1);
                break;
            case R.id.btn3:
                mLine1 = mLine1+"3";
                mTextViewLine1.setText(mLine1);
                break;
            case R.id.btn4:
                mLine1 = mLine1+"4";
                mTextViewLine1.setText(mLine1);
                break;
            case R.id.btn5:
                mLine1 = mLine1+"5";
                mTextViewLine1.setText(mLine1);
                break;
            case R.id.btn6:
                mLine1 = mLine1+"6";
                mTextViewLine1.setText(mLine1);
                break;
            case R.id.btn7:
                mLine1 = mLine1+"7";
                mTextViewLine1.setText(mLine1);
                break;
            case R.id.btn8:
                mLine1 = mLine1+"8";
                mTextViewLine1.setText(mLine1);
                break;
            case R.id.btn9:
                mLine1 = mLine1+"9";
                mTextViewLine1.setText(mLine1);
                break;
            case R.id.btnResult:
                mLine2 = calculate(mLine1);
                mTextViewLine2.setText(mLine2);
                break;
            case R.id.btnPoint:
                mLine2 = mLine2+".";
                mTextViewLine2.setText(mLine2);
                break;
            case R.id.btnAdd:
                mLine1 = mLine1+"+";
                mTextViewLine1.setText(mLine1);
                break;
            case R.id.btnSub:
                mLine1 = mLine1+"-";
                mTextViewLine1.setText(mLine1);
                break;
            case R.id.btnMul:
                mLine1 = mLine1+"*";
                mTextViewLine1.setText(mLine1);
                break;
            case R.id.btnDiv:
                mLine1 = mLine1+"/";
                mTextViewLine1.setText(mLine1);
                break;

        }

    }

    public int operate(String mLine2){
        if(mLine2.indexOf("+")>0) return 1;
        else if(mLine2.indexOf("-")>0) return 2;
        else if(mLine2.indexOf("*")>0) return 3;
        else if(mLine2.indexOf("/")>0) return 4;
        return -1;
    }

    public int findPoint(String mLine2){
        if(mLine2.indexOf(".")>0) return 1;
        return -1;
    }

    public String calculate(String mLine2){
        String result = "";

        if(mLine2!=null){
            String[] items =  mLine2.split("[+|\\-|*|/]");
            if(items.length>=2){
                isCaculate=true;
                if(findPoint(mLine2)>0){
                    Double x1 = Double.parseDouble(items[0]);
                    Double x2 = Double.parseDouble(items[1]);
                    switch (operate(mLine2)){
                        case 1:
                            result = x1+x2+"";
                            break;
                        case 2:
                            result = x1-x2+"";
                            break;
                        case 3:
                            result = x1*x2+"";
                            break;
                        case 4:
                            result = x1/x2+"";
                            break;
                    }
                }else {
                    int x1 = Integer.parseInt(items[0]);
                    int x2 = Integer.parseInt(items[1]);
                    switch (operate(mLine2)){
                        case 1:
                            result = x1+x2+"";
                            break;
                        case 2:
                            result = x1-x2+"";
                            break;
                        case 3:
                            result = x1*x2+"";
                            break;
                        case 4:
                            result = x1/x2+"";
                            break;
                    }
                }
            }
        }

        return result;
    }
}
