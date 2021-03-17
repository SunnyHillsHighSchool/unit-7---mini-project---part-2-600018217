//Programmers: Johnathan Mitri, Julian Matuszewski
import java.util.ArrayList;

public class Loan 
{
  private int ID;
  private double loanAmount;
  private String country;
  private int daysToFund;
  private int numLenders;

  public Loan(int ID, double loanAmount, String country, int daysToFund, int numLenders) 
  {
    this.ID = ID;
    this.loanAmount = loanAmount;
    this.country = country;
    this.daysToFund = daysToFund;
    this.numLenders = numLenders;
  }

	public int getID() 
  {
		return this.ID;
	}

	public void setID(int ID) 
  {
		this.ID = ID;
	}

	public double getLoanAmount() 
  {
		return this.loanAmount;
	}

	public void setLoanAmount(double loanAmount) 
  {
		this.loanAmount = loanAmount;
	}

	public String getCountry() 
  {
		return this.country;
	}

	public void setCountry(String country) 
  {
		this.country = country;
	}

	public int getDaysToFund() 
  {
		return this.daysToFund;
	}

	public void setDaysToFund(int daysToFund) 
  {
		this.daysToFund = daysToFund;
	}

	public int getNumLenders() 
  {
		return this.numLenders;
	}

	public void setNumLenders(int numLenders) 
  {
		this.numLenders = numLenders;
	}

  public String toString()
  {
    return String.format("ID: %d loan amount: %.1f country: %s days to fund: %d num lenders: %d", ID, loanAmount, country, daysToFund, numLenders);
  }
}