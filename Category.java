import java.util.ArrayList;
import java.util.Scanner;
public class Category
{
    private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
    private double gradeWeight; //grades weight as a decimal
    private double average = -1.0; //sum of points/the sum of potential points
    private boolean weighted; //are the individual assigments weighted? are they point-based or % (n/100) based?
    private double credit = -1.0;
    private String categoryName;
    
    public Category()
    {
        gradeWeight = 0.0;
        weighted = true;
        categoryName = "default";
    }
    public Category(double weight, boolean isWeighted, String name)
    {
        gradeWeight = weight;
        weighted = isWeighted;
        categoryName = name;
    }
    public void setCategoryName(String name)
    {
        categoryName = name;
    }
    public void setCategoryGradeWeight(double weight)
    {
        gradeWeight = weight;
    }
    public void setCategoryWeighted(boolean isWeighted)
    {
        weighted = isWeighted;
    }
    
    public void addAssignment(double earned, double potential)//a manual method for me to test with
    {
        if(weighted)
        {
            assignments.add(new Assignment(earned, potential));
        }
        else
        {
            assignments.add(new Assignment(earned, 100.0));
        }
        getAverage();
    }
    public void getAverage()
    {
        double totalEarned = 0;
        double totalPossible = 0;
        for(int i = 0; i < assignments.size();i++)
        {
            totalEarned+=assignments.get(i).pointsEarned;
            totalPossible+=assignments.get(i).pointsPossible;
        }
        average = totalEarned/totalPossible;
        credit = average * gradeWeight*100;
    }
    public double getCredit()//credit is the average * the weight; the part that is added to your final grade
    {
        return credit;
    }
    public double getWeight()
    {
        return gradeWeight;
    }
}
