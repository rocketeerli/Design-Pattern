package client;

import java.util.Stack;

import context.Context;
import expression.Expression;

public class Client {

	public static void main(String[] args) {
		Context cont = new Context();
		Stack<Expression> stack = null;
		while (true) {
			//进行语法树判断，并产生递归调用。
			if (true) {
				break;
			}
		}
		Expression expre = stack.pop();
		expre.interpreter(cont);
	}

}
