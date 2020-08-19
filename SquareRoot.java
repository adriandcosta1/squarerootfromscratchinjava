

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SquareRoot {
public static double[] findClosestSquareRoot(double input){
	double[] squareNum = new double[2];
	long tmpInput = (long)input;
	boolean isFound = false;
	long i = (long) Math.ceil(tmpInput/2);
	long index = 1;
	while((tmpInput > 0) & (!isFound)){
		for(i = (long) Math.ceil(tmpInput/2); i > 0;--i){
			if( (i * i) == tmpInput){
				isFound = true;
				index =i;
				//System.out.println(i + " " + (tmpInput));
			}
		}
		--tmpInput;
	}
	squareNum[0] = index;
	squareNum[1] = (double)(tmpInput + 1);
	return squareNum;
}

public static double divide(double dividend, double divisor){
double result = dividend / divisor;
return result;
}
public static double average(double result, double closestSquareRoot){
double tmpResult = (result + closestSquareRoot)/2;
return tmpResult;
}
public static double howCloseFindRoot(double resultInput, int count){
	double[] closeSquareRoot = new double[2];
	double dividend = 0;
	double average = 0;
	closeSquareRoot = SquareRoot.findClosestSquareRoot(resultInput);
	dividend = closeSquareRoot[1];
	average = closeSquareRoot[0];

	int i = 0;
	while(i < count){
		dividend = SquareRoot.divide(resultInput, average);
		average = SquareRoot.average(dividend, average);
		++i;
	}
	return average;
}

public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub
	BufferedReader stdin = new BufferedReader(new InputStreamReader(
			System.in));
	System.out.print("Enter a number above 0: ");
	String response = stdin.readLine();
	double resultInput = Double.parseDouble(response);
	System.out.println("Square root of " + response + " is: " +
			SquareRoot.howCloseFindRoot(resultInput,5));
}
}