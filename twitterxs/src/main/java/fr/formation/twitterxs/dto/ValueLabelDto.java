package fr.formation.twitterxs.dto;

/**
 * A DTO that represents a value-label pair of data.
 * <p>
 * Typically for list of elements to be displayed to the end-user.
 */
public class ValueLabelDto implements Dto {

    private static final long serialVersionUID = 1273071586018268596L;

    private Object value;

    private String label;

    public ValueLabelDto() {
	// Default no-arg constructor
    }

    public ValueLabelDto(Object value, String label) {
	setValue(value);
	setLabel(label);
    }

    public Object getValue() {
	return value;
    }

    public void setValue(Object value) {
	this.value = value;
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    /**
     * Returns a string representation of this {@code dto}.
     *
     * @return a string representation of this {@code dto}
     */
    @Override
    public String toString() {
	return "{value=" + value + ", label=" + label + "}";
    }
}
