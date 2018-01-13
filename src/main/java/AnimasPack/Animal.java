package AnimasPack;

/**
 * Created by 1 on 20.12.2017.
 */
public interface Animal {

    public String getBreed();//

    public String getName();

    public Integer getCost();

    public String getCharacter();

    public String getType();

    public String information();

    public void setDegreeOfPollution(int value);

    public Integer getDegreeOfPollution();

}
