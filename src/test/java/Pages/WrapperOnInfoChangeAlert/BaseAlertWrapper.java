package Pages.WrapperOnInfoChangeAlert;

public abstract class BaseAlertWrapper {

    //all wrapper constructor must check main element on visibility and presented
    public BaseAlertWrapper() {
        check();
    }

    //check visible elements
    protected abstract void check();
}