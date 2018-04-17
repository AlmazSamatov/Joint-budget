package joint_budget.joint_budget.Model;

public class ShoplistModel {

    private static volatile ShoplistModel instance;

    public static ShoplistModel getInstance() {
        ShoplistModel localInstance = instance;
        if (localInstance == null) {
            synchronized (ShoplistModel.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ShoplistModel();
                }
            }
        }
        return localInstance;
    }

    private ShoplistModel(){}
}
