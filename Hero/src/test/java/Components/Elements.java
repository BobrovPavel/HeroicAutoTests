package Components;

public class Elements {
    private String name;
    private String element;
    private String renderWrapper;
    private String wrapper;
    private String elementIcon;


    public Elements(String name, String element, String renderWrapper, String wrapper, String elementIcon) {
        this.name = name;
        this.element = element;
        this.renderWrapper = renderWrapper;
        this.wrapper = wrapper;
        this.elementIcon = elementIcon;
    }

    public Elements() {
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public String getRenderWrapper() {
        return renderWrapper;
    }

    public String getWrapper() {
        return wrapper;
    }

    public String getElementIcon() {
        return elementIcon;
    }
}
