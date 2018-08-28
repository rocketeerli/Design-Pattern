package expression;

import context.Context;

public class Noterminalxpression extends Expression {
	//每个非终结符表达式都会对其他表达式产生依赖。
	public Noterminalxpression(Expression expression) {
	}
	@Override
	public Object interpreter(Context context) {
		//进行文法处理。
		return null;
	}
}
