package Main.building;

import button.LandButton;

public class House extends Building {

    private static final int BASE_PRICE = 20;
    private static final int BASE_AMOUNT = 1000;
    private static final String RESOURCE_IMAGE = "MONOPOLY_game_OOP-main/res/House/House/";

    public House(LandButton land, String name, int level, Direction direction) {
        super(land, name, level, direction);
    }

    public House(LandButton land, String name, int width, int height, int level, Direction direction) {
        super(land, name, width, height, level, direction);
    }

    @Override
    protected String getImagePath() {
        // example house_left_1.png
        return RESOURCE_IMAGE + name + "_" + direction.toString().toLowerCase() + "_" + level + ".png";
    }

    @Override
    public int getPriceToBuild() {
        return getPriceByLevelAndLand(this.land, this.level);
    }

    @Override
    public int getPriceToUpdateFrom(int oldLevel) {
        return getPriceToBuild() - (int) getPriceByLevelAndLand(this.land, oldLevel)/2;
    }

    @Override
    public int getPurchaseAmount() {
        // money to pay = price to build / 3
        return (int) getPriceToBuild()/3;
    }
    
    private static int getPriceByLevelAndLand(LandButton land, int level){
        if (level == 0) {
            // this is a land
            return (int) (BASE_PRICE + land.getBufferPrice())/2;
        }
        return (BASE_PRICE + land.getBufferPrice()) * level;
    }
    
}
