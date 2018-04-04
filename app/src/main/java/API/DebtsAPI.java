package API;

import java.util.LinkedList;

import DataTypes.DebtPage;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 *
 * @generated
 */

public abstract class DebtsAPI {
    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     */
    public DebtsAPI() {

    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     * @ordered
     */

    public LinkedList<DebtPage> getAllDebts() {
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

    public void sendInvoice(String debtID) {
        // TODO implement me
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     * @ordered
     */

    public void markAsReturned(String debtID) {
        // TODO implement me
    }

    /**
     * <!-- begin-user-doc -->
     * <!--  end-user-doc  -->
     *
     * @generated
     * @ordered
     */

    public void subscribeToDebtsUpdates() {
        // TODO implement me
    }

}

