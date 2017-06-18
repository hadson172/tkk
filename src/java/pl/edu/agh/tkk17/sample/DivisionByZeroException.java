package pl.edu.agh.tkk17.sample;

public class DivisionByZeroException extends OutputableException {

    public DivisionByZeroException() {
        super("Division by 0.");
    }
}
