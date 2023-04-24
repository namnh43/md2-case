package menu;

public abstract class State {
    protected MenuManager menuManager;
    protected IState previousState;

    public State(MenuManager menuManager, IState previousState) {
        this.menuManager = menuManager;
        this.previousState = previousState;
    }

    public IState getPreviousState() {
        return previousState;
    }
}
