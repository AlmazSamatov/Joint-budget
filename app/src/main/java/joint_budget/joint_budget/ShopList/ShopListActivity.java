package joint_budget.joint_budget.ShopList;

public class ShopListActivity implements ShopListView {

    ShopListPresenterInterface presenter;

    ShopListActivity(){
        presenter = new ShopListPresenter();
    }
}
