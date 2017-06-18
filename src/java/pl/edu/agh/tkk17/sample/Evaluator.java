package pl.edu.agh.tkk17.sample;

public class Evaluator
{
    public static double evaluate(Node tree)
    {
        return evaluateRpn(tree);
    }

    private static double evaluateRpn(Node node)
    {
        RpnEvaluatorVisitor visitor = new RpnEvaluatorVisitor();
        node.accept(visitor);
        return visitor.getValue();
    }

}
