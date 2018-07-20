package github.chapter1;
/**
 * 遇到多个构造器参数考虑用构建器(Builder)
 * Builder模式十分灵活，可以利用单个builder构建多个对象。builder的参数可以在创建对象期间进行调整，也可以随着不同的对象而改变。
 */
public class BuilderModel {

}

class NutritionFacts {

    /**
     * 这里必须使用静态方法，否则在没有外部类的情况下无法新建内部类
     */
     private final int servingSize;
     private final int servings;
     private final int calories;
     private final int fat;
     private final int sodium;
     private final int carbohydrate;

    //nested builder
    public static class Builder {
        //required parameters
        private final int servingSize;
        private final int servings;

        // optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }
        //内部类可以访外部类的私有成员
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    /**
     * 外部类可以访问内部类的私有属性
     * @param builder
     */
    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new Builder(5,10).calories(1).
                fat(2).carbohydrate(3).build();
        System.out.println(nutritionFacts);
    }
}
