public class Calculator {
    private float total;
    private float goal;

   public Calculator(float goal) {
        this.total = 0;
        this.goal = goal;
    }

    public float getGoal() {
        return goal;
    }

    public float getTotal() {
        return total;
    }

    public void addExpense(float expense) {
       this.total -= expense;
    }

    public void addAllowance(float allowance) {
       this.total += allowance;
    }

    public String distanceFromGoal() {
       if (this.total < this.goal) {
           return "$" + String.format("%.2f", (this.goal - this.total)) + " away from goal of $" + String.format("%.2f", this.goal);
       }
       else{
           return "You met your goal!";
       }
    }
}
