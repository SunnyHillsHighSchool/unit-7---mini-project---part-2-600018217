import java.util.ArrayList;

public class ComputingStatistics
{
	/**
	 * The ArrayList containing all of the loan data.
	 */
	private ArrayList<Loan> data;

	/**
	 * Creates a new ComputingStatistics object with an empty ArrayList
	 */
	public ComputingStatistics()
	{
		data = new ArrayList<Loan>();
	}

	/**
	 * Creates a new ComputingStatistics object with the data passed in
	 */
	public ComputingStatistics(ArrayList<Loan> d)
	{
		data = d;
	}

	public double avgLoan()
	{
		// declare sum = 0
		int sum = 0;
		// for each Loan in the list
		for (Loan l : data)
		{
			// add the loanAmount to sum
			sum += l.getLoanAmount();
		}
		// declare mean = sum / size of the arrayList
		return (double) sum / (double) data.size();
	}

	public double largestLoan()
	{
		// declare largestLoan = the first loan in the list
		double largestLoan = data.get(0).getLoanAmount();
		// for each Loan in the arrayList after 0
		for (int i = 1; i < data.size(); i++)
		{
			// if the loanAmount is greater than largestLoan’s loanAmount
			if (data.get(i).getLoanAmount() > largestLoan)
				// set largestLoan = current loan
				largestLoan = data.get(i).getLoanAmount();
		}
		// return largestLoan
		return largestLoan;
	}

	public double smallestLoan()
	{
		// declare smallestLoan = the first loan in the list
		double smallestLoan = data.get(0).getLoanAmount();
		// for each Loan in the arrayList after 0
		for (int i = 1; i < data.size(); i++)
		{
			// if the loanAmount is greater than smallestLoan’s loanAmount
			if (data.get(i).getLoanAmount() < smallestLoan)
				// set smallestLoan = current loan
				smallestLoan = data.get(i).getLoanAmount();
		}
		// return smallestLoan
		return smallestLoan;
	}

	public String largestLoanCountry()
	{
		// declare largestLoan = the first loan in the list
		Loan largestLoan = data.get(0);
		// for each Loan in the arrayList after 0
		for (int i = 1; i < data.size(); i++)
		{
			// if the loanAmount is greater than largestLoan’s loanAmount
			if (data.get(i).getLoanAmount() > largestLoan.getLoanAmount())
				// set largestLoan = current loan
				largestLoan = data.get(i);
		}
		// return largestLoan
		return largestLoan.getCountry();

	}

	public String smallestLoanCountry()
	{
		// declare smallestLoan = the first loan in the list
		Loan smallestLoan = data.get(0);
		// for each Loan in the arrayList after 0
		for (int i = 1; i < data.size(); i++)
		{
			// if the loanAmount is greater than smallestLoan’s loanAmount
			if (data.get(i).getLoanAmount() < smallestLoan.getLoanAmount())
				// set smallestLoan = current loan
				smallestLoan = data.get(i);
		}
		// return smallestLoan
		return smallestLoan.getCountry();
	}

	public double avgDaysToFund()
	{

		// declare sum = 0
		int sum = 0;
		// for each loan in the list
		for (Loan a : data)
		{
			// add the daysToFund to the sum
			sum += a.getDaysToFund();
		}
		// return the sum divided by the size of the arrayList
		return (double) sum / (double) data.size();
	}

	public double largestLoanKenya()
	{
		// declare largestLoanVal = 0
		double largestLoanVal = 0;

		// for each loan in the list
		for (Loan a : data)
		{
			// if the current loan’s country is Kenya && its loanAmount > largestLoanVal
			if (a.getCountry().equals("Kenya") && a.getLoanAmount() > largestLoanVal)
			{

				// set largestLoanVal = current loanAmount
				largestLoanVal = a.getLoanAmount();

			}
		}
		// return largestLoanVal
		return largestLoanVal;
	}

	public double avgLoanPhilippines()
	{
		// declare sum = 0
		double sum = 0;
		// declare count = 0;
		int count = 0;
		// for each loan in the list
		for (Loan a : data)
		{
			// if the Country is Philippines
			if (a.getCountry().equals("Philippines"))
			{
				// add the loanAmount to the sum
				sum += a.getLoanAmount();
				// increment count
				count++;
			}
		}
		// return the sum divided by the count
		return sum / (double) count;
	}

	public String longestToFundCountry()
	{
		Loan largest = data.get(0);
		for (int i = 0; i < data.size(); i++)
		{
			if (data.get(i).getDaysToFund() > largest.getDaysToFund())
			{
				largest = data.get(i);
			}
		}
		return largest.getCountry();
	}

	public double variance()
	{
		double mean = avgLoan();
		// declare diffSqSum = 0;
		double diffSqSum = 0;
		// for each Loan in the list
		for (Loan p : data)
		{
			// declare diff = mean - loanAmount
			double diff = mean - p.getLoanAmount();
			// add the square of diff to diffSqSum
			diffSqSum += diff * diff;
		}
		// return the diffSqSum divided by the arrayList size
		return (double) (diffSqSum / data.size());
	}

	public double standardDeviation()
	{

		return Math.sqrt(variance());
	}

	public boolean empiricalRule()
	{
    //declare count as 0
		int count = 0;
    //calculate average and save it as mean
		double mean = avgLoan();
    //calculate standard deviation and save it as stdDev
		double stdDev = standardDeviation();
    //calculate low value
		double low = mean - stdDev;
    //calulcate high value
		double high = mean + stdDev;
    //for every Loan
		for (Loan l : data)
		{
      //get loanAmount
			double loanAmount = l.getLoanAmount();
      //if the loanAmount is within bounds
			if (loanAmount > low && loanAmount < high)
				count++;
		}
		return count >= 0.68 * data.size();
	}

	/**
	 * Calclates the total amount funded from all of the loans in the file.
	 * 
	 * @return the total loan amount.
	 */
	public double totalAmount()
	{
		double amount = 0.0;
		for (int i = 0; i < data.size(); i++)
		{
			amount = amount + data.get(i).getLoanAmount();
		}
		return amount;
	}
}