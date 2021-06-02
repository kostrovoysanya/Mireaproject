package ru.mirea.kudriashov.mireaproject.ui.calculator;

import ru.mirea.kudriashov.mireaproject.R;

public class CalculatorModel {
    private StringBuilder firsNumber = new StringBuilder(), secondNumber = new StringBuilder(), in = new StringBuilder();
    private boolean isAction, isEquals = false;
    private Double result;
    private String action;
    private enum Condition {
        firstNumber,
        secondNumber
    }
    private Condition condition;

    public CalculatorModel() {
        condition = Condition.firstNumber;
    }

    public String getIn(){
        return in.toString();
    }

    void clickedNumber(int buttonID) {
        if (condition == Condition.firstNumber) {
            switch (buttonID) {
                case R.id.b0:
                    if (firsNumber.length() != 0) {
                        firsNumber.append("0");
                        in.append("0");
                    }
                    break;
                case R.id.b1:
                    firsNumber.append("1");
                    in.append("1");
                    isAction = true;
                    break;
                case R.id.b2:
                    firsNumber.append("2");
                    in.append("2");
                    isAction = true;
                    break;
                case R.id.b3:
                    firsNumber.append("3");
                    in.append("3");
                    isAction = true;
                    break;
                case R.id.b4:
                    firsNumber.append("4");
                    in.append("4");
                    isAction = true;
                    break;
                case R.id.b5:
                    firsNumber.append("5");
                    in.append("5");
                    isAction = true;
                    break;
                case R.id.b6:
                    firsNumber.append("6");
                    in.append("6");
                    isAction = true;
                    break;
                case R.id.b7:
                    firsNumber.append("7");
                    in.append("7");
                    isAction = true;
                    break;
                case R.id.b8:
                    firsNumber.append("8");
                    in.append("8");
                    isAction = true;
                    break;
                case R.id.b9:
                    firsNumber.append("9");
                    in.append("9");
                    isAction = true;
                    break;

            }

        } else {
            isAction = false;
            switch (buttonID) {
                case R.id.b0:
                    if (secondNumber.length() != 0) {
                        secondNumber.append("0");
                        in.append("0");
                    }
                    break;
                case R.id.b1:
                    secondNumber.append("1");
                    in.append("1");
                    isEquals = true;
                    break;
                case R.id.b2:
                    secondNumber.append("2");
                    in.append("2");
                    isEquals = true;
                    break;
                case R.id.b3:
                    secondNumber.append("3");
                    in.append("3");
                    isEquals = true;
                    break;
                case R.id.b4:
                    secondNumber.append("4");
                    in.append("4");
                    isEquals = true;
                    break;
                case R.id.b5:
                    secondNumber.append("5");
                    in.append("5");
                    isEquals = true;
                    break;
                case R.id.b6:
                    secondNumber.append("6");
                    in.append("6");
                    isEquals = true;
                    break;
                case R.id.b7:
                    secondNumber.append("7");
                    in.append("7");
                    isEquals = true;
                    break;
                case R.id.b8:
                    secondNumber.append("8");
                    in.append("8");
                    isEquals = true;
                    break;
                case R.id.b9:
                    secondNumber.append("9");
                    in.append("9");
                    isEquals = true;
                    break;
            }
        }
    }

    void clickedAction(int buttonID) {
        if (isAction || isEquals || buttonID == R.id.C) {
            switch (buttonID) {
                case R.id.plus:
                    action = "+";
                    in.append("+");
                    isAction = false;
                    condition = Condition.secondNumber;
                    break;
                case R.id.minus:
                    action = "-";
                    in.append("-");
                    isAction = false;
                    condition = Condition.secondNumber;
                    break;
                case R.id.multiply:
                    action = "*";
                    in.append("*");
                    isAction = false;
                    condition = Condition.secondNumber;
                    break;
                case R.id.divide:
                    action = "/";
                    in.append("/");
                    isAction = false;
                    condition = Condition.secondNumber;
                    break;
                case R.id.C:
                    firsNumber.delete(0, firsNumber.length());
                    secondNumber.delete(0, secondNumber.length());
                    in.delete(0, in.length());
                    isAction = false;
                    isEquals = false;
                    condition = Condition.firstNumber;
                    break;
                case R.id.equals:
                    if (!isEquals)
                        break;
                    in.delete(0, in.length());
                    switch (action) {
                        case "+":
                            result = Double.parseDouble(firsNumber.toString()) + Double.parseDouble(secondNumber.toString());
                            if (result % 1 == 0) {
                                in.append(Math.round(result));
                            } else
                                in.append(result);
                            break;
                        case "-":
                            result = Double.parseDouble(firsNumber.toString()) - Double.parseDouble(secondNumber.toString());
                            if (result % 1 == 0) {
                                in.append(Math.round(result));
                            } else
                                in.append(result);
                            break;
                        case "*":
                            result = Double.parseDouble(firsNumber.toString()) * Double.parseDouble(secondNumber.toString());
                            if (result % 1 == 0) {
                                in.append(Math.round(result));
                            } else
                                in.append(result);
                            break;
                        case "/":
                            result = Double.parseDouble(firsNumber.toString()) / Double.parseDouble(secondNumber.toString());
                            if (result % 1 == 0) {
                                in.append(Math.round(result));
                            } else
                                in.append(result);
                            break;
                    }
                    firsNumber.delete(0, firsNumber.length());
                    if (result != 0) {
                        firsNumber.append(in);
                        isAction = true;
                    }
                    isEquals = false;
                    secondNumber.delete(0, secondNumber.length());
                    condition = Condition.firstNumber;
                    break;
            }
        }
    }
}
