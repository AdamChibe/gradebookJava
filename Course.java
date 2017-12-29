import java.util.ArrayList;
public class Course
{
    private ArrayList<Category> categories = new ArrayList<Category>();
    private double average;
    boolean weighted;
    //double multiplier= 0.0;
    //other strings adn things for teachers name, class name, letter grade etc;
    
    public Course(boolean isWeighted ,int numCategories)
    {
        weighted = isWeighted;
        //categories.add(new Category());
    }
    public void addCateGory(double weight, boolean isWeighted, String name)
    {
        categories.add(new Category(weight, isWeighted, name));
    }
    public void addAssignment(int index, double earned, double possible)
    {
        categories.get(index).addAssignment(earned, possible);
    }
    public void getClassCredit()
    {
        double credit = 0.0;
        double multiplier = 0.0;
        for(int i = 0; i < categories.size();i++)
        {
            if(categories.get(i).getCredit()!=-1.0)
            {
                credit+=categories.get(i).getCredit();
                multiplier+=categories.get(i).getWeight();
            }
        }
        System.out.println(credit/=multiplier);
    }
}
