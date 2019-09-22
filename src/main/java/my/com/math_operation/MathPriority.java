package my.com.math_operation;

public enum MathPriority {
    ADD_AND_SUB (1),
    MUL_AND_DIV (2);

    private final int mathPriority;

    MathPriority(int mathPriority) {
        this.mathPriority = mathPriority;
    }
    public int getMathPriority(){
        return this.mathPriority;
    }
}
