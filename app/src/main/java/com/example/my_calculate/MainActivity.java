package com.example.my_calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.lang.String;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 数字
     */
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    /**
     * 运算符
     */
    private Button plus_btn;
    private Button subtract_btn;
    private Button multiply_btn;
    private Button divide_btn;
    private Button equal_btn;
    /**
     * 其他
     */
    private Button dot_btn;
    private Button radical_btn;
    private Button delete_btn;
    private Button ac_btn;
    private Button shift_btn;
    /**
     * 结果
     */
    private EditText mResultText;
    /**
     * 已经输入的字符
     */
    private String existedText = new String();
    /**
     * 是否计算过
     */
    private StringBuilder b = new StringBuilder();
    private boolean isCounted = false;
    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }
    private void initView() {

        /**
         * 数字
         */
        num0 = (Button) findViewById(R.id.num_0);
        num1 = (Button) findViewById(R.id.num_1);
        num2 = (Button) findViewById(R.id.num_2);
        num3 = (Button) findViewById(R.id.num_3);
        num4 = (Button) findViewById(R.id.num_4);
        num5 = (Button) findViewById(R.id.num_5);
        num6 = (Button) findViewById(R.id.num_6);
        num7 = (Button) findViewById(R.id.num_7);
        num8 = (Button) findViewById(R.id.num_8);
        num9 = (Button) findViewById(R.id.num_9);

        /**
         * 运算符
         */
        plus_btn = (Button) findViewById(R.id.plus_btn);
        subtract_btn = (Button) findViewById(R.id.subtract_btn);
        multiply_btn = (Button) findViewById(R.id.multiply_btn);
        divide_btn = (Button) findViewById(R.id.divide_btn);
        equal_btn = (Button) findViewById(R.id.equal_btn);
        /**
         * 其他
         */
        dot_btn = (Button) findViewById(R.id.dot_btn);
        radical_btn = (Button) findViewById(R.id.radical_btn);
        delete_btn = (Button) findViewById(R.id.delete_btn);
        ac_btn = (Button) findViewById(R.id.ac_btn);
        shift_btn = (Button) findViewById(R.id.shift_btn);
        /**
         * 结果
         */
        mResultText = (EditText) findViewById(R.id.result_text);
        /**
         * 已经输入的字符
         */
        existedText = mResultText.getText().toString();

    }

    private void initEvent() {
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        plus_btn.setOnClickListener(this);
        subtract_btn.setOnClickListener(this);
        multiply_btn.setOnClickListener(this);
        divide_btn.setOnClickListener(this);
        equal_btn.setOnClickListener(this);
        dot_btn.setOnClickListener(this);
        radical_btn.setOnClickListener(this);
        delete_btn.setOnClickListener(this);
        ac_btn.setOnClickListener(this);
        shift_btn.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.num_0:
                existedText = addnum(existedText,"0");
                break;
            case R.id.num_1:
                existedText = addnum(existedText,"1");
                break;
            case R.id.num_2:
                existedText = addnum(existedText,"2");
                break;
            case R.id.num_3:
                existedText = addnum(existedText,"3");
                break;
            case R.id.num_4:
                existedText = addnum(existedText,"4");
                break;
            case R.id.num_5:
                existedText = addnum(existedText,"5");
                break;
            case R.id.num_6:
                existedText = addnum(existedText,"6");
                break;
            case R.id.num_7:
                existedText = addnum(existedText,"7");
                break;
            case R.id.num_8:
                existedText = addnum(existedText,"8");
                break;
            case R.id.num_9:
                existedText = addnum(existedText,"9");
                break;
            case R.id.plus_btn:
                existedText = addopr(existedText,"+");
                break;
            case R.id.subtract_btn:
                existedText = addopr(existedText,"-");
                break;
            case R.id.multiply_btn:
                existedText = addopr(existedText,"×");
                break;
            case R.id.divide_btn:
                existedText = addopr(existedText,"÷");
                break;
            case R.id.equal_btn:
                existedText = getResult();
                isCounted = true;
                break;
            case R.id.ac_btn:
                existedText = "0";
                break;
            case R.id.shift_btn:
                String[]exp = textSpilt(existedText);
                if(exp[2]==null){
                    System.out.println(exp[0].indexOf(0));
                    if ('-' == exp[0].charAt(0))
                        existedText = existedText.substring(1);
                    else
                        existedText="-"+existedText;
                }
                break;
            case R.id.delete_btn:
                /**
                 * 字符串长度大于 0 时才截取字符串
                 * 如果长度为 1，则直接把字符串设置为 0
                 */
                if (existedText.equals("error")) {
                    existedText = "0";
                } else if (existedText.length() > 0) {
                    if (existedText.length() == 1) {
                        existedText = "0";
                    } else {
                        existedText = existedText.substring(0, existedText.length() - 1);
                    }
                }
                break;
            case R.id.dot_btn:
                if(isCounted){
                    existedText = "0.";
                    isCounted = false;
                }
                else if(charLast(existedText) == '+'|| charLast(existedText) == '-'|| charLast(existedText) == '×'|| charLast(existedText) == '÷'){
                    existedText +="0.";
                }
                 else{
                     System.out.println("111");
                    String[] exps = textSpilt(existedText);
                    if(( exps[2]!=null && !exps[2].contains(".")) || (exps[2]==null && !exps[0].contains("."))){
                        existedText+=".";
                    }
                }
                 break;
            case R.id.radical_btn:
                String[] exps = textSpilt(existedText);

                if(exps[2]==null){
                    System.out.println("3:  "+Double.parseDouble(exps[0]));
                    if(Double.parseDouble(exps[0])<0){
                        existedText = "0";
                    }
                    else {
                        existedText = subZero(String.format("%f",java.lang.Math.sqrt(Double.parseDouble(exps[0]))));
                        isCounted = true;
                    }
                }
                break;
        }
        mResultText.setText(existedText);
    }
    private String addnum(String existedText,String s){
        if(isCounted && (charLast(existedText) == '.' ||
                charLast(existedText) == '+'||
                charLast(existedText) == '-'||
                charLast(existedText) == '×'||
                charLast(existedText) == '÷'))
        {
            isCounted = false;
            existedText += s;
        }
        else if(isCounted||existedText.equals("0")){
            existedText = s;
            isCounted = false;
        }
        else{
            if(existedText.length()<=20){
                existedText += s;
            }
        }
        return existedText;
    }
    private String addopr(String existedText,String s){
        if (!existedText.isEmpty()) {
            if (charLast(existedText) == '.' ||
                    charLast(existedText) == '+'||
                    charLast(existedText) == '-'||
                    charLast(existedText) == '×'||
                    charLast(existedText) == '÷') {
                b.append(existedText);
                b.setCharAt(b.length()-1,s.charAt(0));
                existedText = b.toString();
                b.delete(0,b.length());
            }
            else{
                if(containOpr(existedText)){
                    existedText=getResult()+s;

                }
                else {
                    existedText+=s;
                }
            }
        }
        return existedText;
    }

    private char charLast(String existedText){
        return existedText.charAt(existedText.length() - 1);
}

    private boolean containOpr(String existedText){
        return (existedText.contains("+") || existedText.contains("-") ||
                existedText.contains("×") || existedText.contains("÷"));
    }

    private String getResult(){
        String temp = null;
        double result = 0.;
        String []exps = textSpilt(existedText);
        System.out.println("  "+exps[2]);
        if(exps[2]==null){
            result = Double.parseDouble(exps[0]);
        }
        else {
            switch (exps[1]) {
                case "+":
                    result = Double.parseDouble(exps[0]) + Double.parseDouble(exps[2]);
                    break;
                case "-":
                    result = Double.parseDouble(exps[0]) - Double.parseDouble(exps[2]);
                    break;
                case "×":
                    result = Double.parseDouble(exps[0]) * Double.parseDouble(exps[2]);
                    break;
                case "÷":
                    if(exps[2].equals("0")){
                        result=0;
                        System.out.println("1");
                    } else {
                        result = Double.parseDouble(exps[0]) / Double.parseDouble(exps[2]);
                    }
                    break;
            }
        }
        temp = String.format("%f", result);
        temp = subZero(temp);
        return temp;
    }

    private String[] textSpilt(String existedText){
        int i = 0;
        String [] exps=new String[3];
        boolean minus = false;
        if(existedText.charAt(0)=='-'){
            existedText=existedText.substring(1,existedText.length());
            minus = true;
        }
        StringTokenizer expression = new StringTokenizer(existedText,"+,-,×,÷",true);
        while (expression.hasMoreTokens()){
            exps[i] = expression.nextToken();
            i++;
        }
        if (minus){
            exps[0] = "-" + exps[0];
        }
        return exps;
    }
    public String subZero(String s){
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

}
