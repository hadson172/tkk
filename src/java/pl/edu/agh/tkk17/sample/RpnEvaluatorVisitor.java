package pl.edu.agh.tkk17.sample;

import java.util.Stack;

public class RpnEvaluatorVisitor implements NodeVisitor
{
    private Stack<Double> stack;

    public RpnEvaluatorVisitor()
    {
        this.stack = new Stack<>();
    }

    public double getValue()
    {
        return this.stack.peek();
    }

    public void visit(NodeAdd node)
    {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        double a = this.stack.pop();
        double b = this.stack.pop();
        double c = b + a;
        this.stack.push(c);
    }

    public void visit(NodeMul node)
    {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        double a = this.stack.pop();
        double b = this.stack.pop();
        double c = b * a;
        this.stack.push(c);
    }

    public void visit(NodeNumber node)
    {
        String value = node.getValue();
        double numericValue = Double.parseDouble(value);
        this.stack.push(numericValue);
    }

    public void visit(NodeDiv node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        double a = this.stack.pop();
        double b = this.stack.pop();
        if (a == 0) throw new DivisionByZeroException(); //thrown because double/0 == DOUBLE.NaN
        double c = b / a;
        this.stack.push(c);
    }

    public void visit(NodeSub node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        double a = this.stack.pop();
        double b = this.stack.pop();
        double c = b - a;
        this.stack.push(c);
    }
}
