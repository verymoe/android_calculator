package org.moesoft.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_result;

    private String firstNum = "";
    private String secondNum = "";
    private String operator = "";
    private String result = "";
    private String showText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_result = findViewById(R.id.tv_result);

        findViewById(R.id.btn_cancel).setOnClickListener(this);
        findViewById(R.id.btn_division).setOnClickListener(this);
        findViewById(R.id.btn_multiplication).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);

        findViewById(R.id.btn_7).setOnClickListener(this);
        findViewById(R.id.btn_8).setOnClickListener(this);
        findViewById(R.id.btn_9).setOnClickListener(this);
        findViewById(R.id.btn_add).setOnClickListener(this);

        findViewById(R.id.btn_4).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_reduce).setOnClickListener(this);

        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_sqrt).setOnClickListener(this);

        findViewById(R.id.btn_reciprocal).setOnClickListener(this);
        findViewById(R.id.btn_0).setOnClickListener(this);
        findViewById(R.id.btn_dot).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String inputText;

        if (view.getId() == R.id.btn_sqrt) {
            inputText = "√";
        } else {
            inputText = ((TextView) view).getText().toString();
        }

        System.out.println(inputText);

        switch (inputText) {
            case "CE":

                break;
            case "C":
                clear();
                break;
            case "=":
                double calculate_result = calculateFour();
                refreshOperator(String.valueOf(calculate_result));
                refreshText(showText + "=" + result);
                break;
            case "+":
                operator = inputText;
                refreshText(showText + operator);
                break;
            case "-":
                operator = inputText;
                refreshText(showText + operator);
                break;
            case "×":
                operator = inputText;
                refreshText(showText + operator);
                break;
            case "÷":
                operator = inputText;
                refreshText(showText + operator);
                break;
            case "√":
                double sqrt_result = Math.sqrt(Double.parseDouble(firstNum));
                refreshOperator(String.valueOf(sqrt_result));
                refreshText(showText + "√=" + result);
                break;
            case "1/x":
                double reciprocal_result = 1.0 / Double.parseDouble(firstNum);
                refreshOperator(String.valueOf(reciprocal_result));
                refreshText(showText + "/=" + result);
                break;
            default:
                if (result.length() > 0 && operator.equals("")) {
                    clear();
                }

                if (operator.equals("")) {
                    firstNum = firstNum + inputText;
                } else {
                    secondNum = secondNum + inputText;
                }
                if (showText.equals("0") && inputText.equals(("."))) {
                    refreshText(inputText);
                } else {
                    refreshText(showText + inputText);
                }
                break;

        }

    }

    private double calculateFour() {
        switch (operator) {
            case "+":
                return Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
            case "-":
                return Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
            case "×":
                return Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
            default:
                return Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
        }
    }

    private void clear() {
        refreshOperator("");
        refreshText("");
    }

    private void refreshOperator(String new_result) {
        result = new_result;
        firstNum = result;
        secondNum = "";
        operator = "";
    }

    private void refreshText(String text) {
        showText = text;
        tv_result.setText(showText);
    }
}