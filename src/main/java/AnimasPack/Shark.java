package AnimasPack;

import Utils.Util;

/**
 * Created by 1 on 23.12.2017.
 */
public class Shark extends Predator {

    public Shark() {
        super.name = Util.randomName();
        super.breed = Util.randomName();
        super.character = Util.randomName();
        super.cost = Util.randomCost();
        Shark.Disease s = new Shark.Disease();
        s.haveDisease(Util.randomNumb());
    }

    public Shark(String name, String breed, Integer cost, String character) {
        super.name = name;
        super.breed = breed;
        super.cost = cost;
        super.character = character;
        Shark.Disease s = new Shark.Disease();
        s.haveDisease(Util.randomNumb());
    }

    public String getName() {
        return super.name;
    }

    public String getBreed() {
        return super.breed;
    }

    public String getCharacter() {
        return super.character;
    }

    public Integer getCost() {
        return super.cost;
    }

    public String information() {
        StringBuilder info = new StringBuilder();
        return String.valueOf(info.append("Breed: ").append(getBreed()).append(" Name: ").append(getName()).append(" Character: ").append(getCharacter()).append(" Cost: ").append(getCost().toString()));
    }

    public String getType() {
        return "Shark";
    }

    public Integer getDegreeOfPollution() {
        return super.degreeOfPollution;
    }

    public void setDegreeOfPollution(int value) {
        super.degreeOfPollution += value;
        if (super.degreeOfPollution < 0) {
            super.degreeOfPollution = 0;
        }
    }

    private class Disease {
        private void haveDisease(int i) {
            if (i == 1) {
                degreeOfPollution = 10;
            } else {
                degreeOfPollution = 0;
            }
        }
    }
}
