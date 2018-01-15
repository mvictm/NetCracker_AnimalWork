package AnimasPack;

import Utils.Util;

/**
 * Created by 1 on 20.12.2017.
 */
public class Cat extends Pet {

    public Cat() {
        super.name = Util.randomName();
        super.breed = Util.randomName();
        super.character = Util.randomName();
        super.cost = Util.randomCost();
        Cat.Fleas c = new Cat.Fleas();
        c.haveFleas(Util.randomNumb());
    }

    public Cat(String name, String breed, Integer cost, String character) {
        super.name = name;
        super.breed = breed;
        super.cost = cost;
        super.character = character;
        Cat.Fleas c = new Cat.Fleas();
        c.haveFleas(Util.randomNumb());
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
        return "Cat";
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

    private class Fleas {
        private void haveFleas(int i) {
            if (i == 1) {
                degreeOfPollution = 10;
            } else {
                degreeOfPollution = 0;
            }
        }
    }
}
