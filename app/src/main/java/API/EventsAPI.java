package API;

import java.util.LinkedList;

import DataTypes.EventPage;
import DataTypes.PurchasePage;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 *
 * @generated
 */

public abstract class EventsAPI {
    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     */
    public EventsAPI() {
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     * @ordered
     */

    public boolean createEvent(EventPage eventPage) {
        // TODO implement me
        return false;
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     * @ordered
     */

    public boolean deleteEvent(String eventID) {
        // TODO implement me
        return false;

    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     * @ordered
     */

    public boolean updateEvent(EventPage eventPage) {
        // TODO implement me
        return false;

    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     * @ordered
     */

    public boolean addPurchase(PurchasePage purchasePage) {
        // TODO implement me
        return false;

    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     * @ordered
     */

    public boolean editPurchase(PurchasePage purchasePage) {
        // TODO implement me
        return false;

    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     * @ordered
     */

    public boolean deletePurchase(String eventID, String purchaseID) {
        // TODO implement me
        return false;

    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     * @ordered
     */

    public boolean joinEvent(String EventID, String Password) {
        // TODO implement me
        return false;

    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     * @ordered
     */

    public LinkedList<EventPage> getAllEvents() {
        // TODO implement me
        return new LinkedList<>();

    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     * @ordered
     */

    public LinkedList<PurchasePage> getAllPurchases() {
        // TODO implement me
        return new LinkedList<>();
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     * @ordered
     */

    public void subscribeToEventsUpdates() {
        // TODO implement me
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     * @ordered
     */

    public void subscribeToPurchasesUpdates() {
        // TODO implement me
    }

}

