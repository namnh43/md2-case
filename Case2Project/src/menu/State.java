package menu;

public abstract class State {
    MenuManager menuManager;
    IState previousState;

    public State(MenuManager menuManager, IState previousState) {
        this.menuManager = menuManager;
        this.previousState = previousState;
    }

    public IState getPreviousState() {
        return previousState;
    }
}
