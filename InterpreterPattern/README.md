# 介绍

-----------------

解释器模式是一种行为型设计模式，该模式主要目的是**解析一串固定模式的表达式。**解释器模式与命令模式比较相似，通常利用该模式解析语法树。下面先来看一下它的定义：

> Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.<br/>
> 给定一门语言，定义它的文法的一种表示，并定义一个解释器，该解释器使用该表示来解释语言中的句子。

简单地说，解释器就相当于翻译器一样，将一种语言转换成另一种语言。该模式使用的场景比较少，一般而言，由于已经有很多现成的“解释器”了，因此，就算使用，也是直接使用这些已经写好的来使用。

解释器模式主要有四种角色：

* AbstractExpression——抽象解释器。
定义终结符解释器和非终结解释器的行为，该抽象类（或接口）不实现具体方法。

* TerminalExpresion——终结符表达式。
实现抽象解释器的行为，解析语言中的终结符。

* NonterminalExpression——非终结符表达式。
实现抽象解释器的行为，解析语言中的非终结符。

* Context——环境角色。
构件环境类，包含解释器之外的一些全局信息，一般是 HashMap

# 通用代码

------------------

首先要有抽象解释器：

	public abstract class Expression {
		//每个表达式必须有一个解析任务。
		public abstract Object interpreter(Context context);
	}

* 注：这里的环境角色暂时设为一个空类，方便解释器的使用。

然后是我们的终结符解释器和非终结符解释器：

终结符解释器：

	public class TerminalExpression extends Expression {
		//通常终结符表达式只有一个，但是有多个对象。
		@Override
		public Object interpreter(Context context) {
			return null;
		}
	}

非终结符解释器：

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

最后是我们的客户端调用：

	public static void main(String[] args) {
		Context cont = new Context();
		Stack<Expression> stack = null;
		while (true) {
			//进行语法树判断，并产生递归调用。
		}
		Expression expre = stack.pop();
		expre.interpreter(cont);
	}

通常，客户端解释一个标准的语法输入，最后计算出一个结果并返回。

# 总结

------------------

解释器模式比较类似于命令模式，但二者处理的问题并不一样。由于笔者并没有写过解释器模式的项目，理解有限，这里就不多介绍了，如有任何错误，欢迎各位指出，谢谢。