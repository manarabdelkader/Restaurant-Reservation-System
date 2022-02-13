package Resturant;

public  class Manager extends User {
  public Manager(String name, String role, String username, String password) {
  super(name, role, username, password);}

public double totalIncome;
public double getTotalIncome () {
        return totalIncome;
        }
public void setTotalIncome ( double totalIncome){
        this.totalIncome = this.totalIncome + totalIncome;
        }
}